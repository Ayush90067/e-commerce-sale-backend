package com.ecommerce.backend.service;

import com.ecommerce.backend.dto.LoginResponse;
import com.ecommerce.backend.entity.User;
import com.ecommerce.backend.repository.UserRepository;
import com.ecommerce.backend.auth.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    private final BCryptPasswordEncoder encoder =
            new BCryptPasswordEncoder();

    // REGISTER
    public User register(User user) {

        if (
                userRepository.findByEmail(
                        user.getEmail()
                ).isPresent()
        ) {

            throw new RuntimeException(
                    "Email already registered"
            );
        }

        user.setPassword(
                encoder.encode(
                        user.getPassword()
                )
        );

        user.setRole("USER");

        return userRepository.save(user);
    }

    // LOGIN
    public LoginResponse login(
            String email,
            String password
    ) {

        User user = userRepository
                .findByEmail(email)
                .orElseThrow(
                        () -> new RuntimeException(
                                "User not found"
                        )
                );

        if (!encoder.matches(
                password,
                user.getPassword()
        )) {

            throw new RuntimeException(
                    "Invalid Password"
            );
        }

        String token =
                jwtUtil.generateToken(
                        user.getEmail(),
                        user.getRole()
                );

        return new LoginResponse(
                token,
                user.getEmail(),
                user.getRole()
        );
    }
}