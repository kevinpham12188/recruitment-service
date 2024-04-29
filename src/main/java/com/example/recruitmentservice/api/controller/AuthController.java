package com.example.recruitmentservice.api.controller;

import com.example.recruitmentservice.api.dto.dtoIn.AuthResponseDTO;
import com.example.recruitmentservice.api.dto.dtoIn.LoginDtoIn;
import com.example.recruitmentservice.api.dto.dtoIn.RegisterDtoIn;
import com.example.recruitmentservice.api.entities.Role;
import com.example.recruitmentservice.api.entities.UserEntity;
import com.example.recruitmentservice.api.repository.RoleRepository;
import com.example.recruitmentservice.api.repository.UserRepository;
import com.example.recruitmentservice.security.JWTGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    private JWTGenerator jwtGenerator;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, UserRepository userRepository,
                          RoleRepository roleRepository, PasswordEncoder passwordEncoder, JWTGenerator jwtGenerator) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtGenerator = jwtGenerator;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginDtoIn loginDtoIn) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDtoIn.getUsername(), loginDtoIn.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerator.generateToken(authentication);
        return new ResponseEntity<>(new AuthResponseDTO(token), HttpStatus.OK);
    }


    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterDtoIn registerDtoIn) {
        if(userRepository.existsByUsername(registerDtoIn.getUsername())) {
            return new ResponseEntity<>("Username is taken", HttpStatus.BAD_REQUEST);
        }
        UserEntity user = new UserEntity();
        user.setUsername(registerDtoIn.getUsername());
        user.setPassword(passwordEncoder.encode(registerDtoIn.getPassword()));

        Role roles = roleRepository.findByName("USER").get();
        user.setRole(Collections.singletonList(roles));
        userRepository.save(user);
        return new ResponseEntity<>("User registered success", HttpStatus.OK);

    }
}
