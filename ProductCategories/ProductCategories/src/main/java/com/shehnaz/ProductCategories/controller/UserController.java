package com.shehnaz.ProductCategories.controller;

import com.shehnaz.ProductCategories.dto.UserDTO;
import com.shehnaz.ProductCategories.security.jwtUtil;
import com.shehnaz.ProductCategories.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.shehnaz.ProductCategories.entity.User;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private jwtUtil jwtUtil;

     @Autowired
     private AuthenticationManager authenticationManager;
     @Autowired
     private MyUserDetailsService myUserDetailsService;

     @PostMapping("/register")
     public User register(@RequestBody User user){
       return  myUserDetailsService.createUser(user);

     }

     @PostMapping("/login")
     public String Login(@RequestBody UserDTO userDTO){
         Authentication authentication= authenticationManager.authenticate(new
                  UsernamePasswordAuthenticationToken(userDTO.getUsername(), userDTO.getPassword()));
          SecurityContextHolder.getContext().setAuthentication(authentication);
          List<String> roles=authentication.getAuthorities().stream()
                  .map(GrantedAuthority::getAuthority)
                  .toList();
         UserDetails userDetails = myUserDetailsService.loadUserByUsername(userDTO.getUsername());
         return jwtUtil.generateToken(userDetails.getUsername(),roles);

     }
}
