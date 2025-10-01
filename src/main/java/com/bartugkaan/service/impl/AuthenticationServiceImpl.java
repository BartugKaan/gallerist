package com.bartugkaan.service.impl;

import com.bartugkaan.dto.AuthRequest;
import com.bartugkaan.dto.AuthResponse;
import com.bartugkaan.dto.DtoUser;
import com.bartugkaan.dto.RefreshTokenRequest;
import com.bartugkaan.exception.BaseException;
import com.bartugkaan.exception.ErrorMessage;
import com.bartugkaan.exception.MessageType;
import com.bartugkaan.jwt.JwtService;
import com.bartugkaan.model.RefreshToken;
import com.bartugkaan.model.User;
import com.bartugkaan.repository.RefreshTokenRepository;
import com.bartugkaan.repository.UserRepository;
import com.bartugkaan.service.IAuthenticationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthenticationServiceImpl implements IAuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private RefreshTokenRepository refreshTokenRepository;

    private User createUser(AuthRequest input){
        User user = new User();
        user.setCreateTime(new Date());
        user.setUsername(input.getUsername());
        user.setPassword(passwordEncoder.encode(input.getPassword()));

        return user;
    }

    private RefreshToken createRefreshToken(User user){
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setUser(user);
        refreshToken.setCreateTime(new Date());
        refreshToken.setExpiredDate(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 4)); // 4 hours
        refreshToken.setRefreshToken(UUID.randomUUID().toString());

        return refreshToken;
    }

    @Override
    public DtoUser register(AuthRequest input) {
        DtoUser dtoUser = new DtoUser();

        User savedUser = userRepository.save(createUser(input));

        BeanUtils.copyProperties(savedUser, dtoUser);
        return dtoUser;

    }

    @Override
    public AuthResponse authenticate(AuthRequest input) {
        try {
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(input.getUsername(), input.getPassword());
            authenticationProvider.authenticate(authenticationToken);

            Optional<User> optionalUser = userRepository.findByUsername(input.getUsername());

            String accessToken = jwtService.generateToken(optionalUser.get());

            RefreshToken savedRefreshToken = refreshTokenRepository.save(createRefreshToken(optionalUser.get()));

            return new AuthResponse(accessToken, savedRefreshToken.getRefreshToken());

        } catch (Exception ex){
            throw new BaseException(new ErrorMessage(MessageType.USERNAME_OR_PASSWORD_INVALID, ex.getMessage()));
        }
    }

    public boolean isValidRefreshToken(Date expiredDate){
        return new Date().before(expiredDate);
    }

    @Override
    public AuthResponse refreshToken(RefreshTokenRequest input) {
       Optional<RefreshToken> optRefreshToken = refreshTokenRepository.findByRefreshToken(input.getRefreshToken());
       if(optRefreshToken.isEmpty()){
            throw new BaseException(new ErrorMessage(MessageType.REFRESH_TOKEN_NOT_FOUND, input.getRefreshToken()));
       }

       if(!isValidRefreshToken(optRefreshToken.get().getExpiredDate())){
           throw new BaseException(new ErrorMessage(MessageType.REFRESH_TOKEN_IS_EXPIRED, input.getRefreshToken()));
       }

       User user = optRefreshToken.get().getUser();
       String accessToken = jwtService.generateToken(user);
        RefreshToken savedRefreshToken = refreshTokenRepository.save(createRefreshToken(user));

        return new AuthResponse(accessToken, savedRefreshToken.getRefreshToken());
    }

}
