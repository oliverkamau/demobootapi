package com.school.api.users.controllers;

import com.alibaba.fastjson.JSONObject;
import com.school.api.configs.JwtUtil;
import com.school.api.configs.SystemUserDetails;
import com.school.api.users.model.User;
import com.school.api.users.repo.UsersRepo;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/users")
public class UsersController {


    private JwtUtil jwtUtil;
    private AuthenticationProvider authenticationProvider;
    private SystemUserDetails mySystemUserDetails;
    private UsersRepo userRepo;

    public UsersController(JwtUtil jwtUtil, AuthenticationProvider authenticationProvider, SystemUserDetails mySystemUserDetails, UsersRepo userRepo) {
        this.jwtUtil = jwtUtil;
        this.authenticationProvider = authenticationProvider;
        this.mySystemUserDetails = mySystemUserDetails;
        this.userRepo = userRepo;
    }


    @PostMapping("/authenticate")
    @ResponseBody
    public JSONObject createAuthenticationToken(@RequestBody JSONObject authenticationRequest) throws Exception {
        try {
            authenticationProvider.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getString("username"),authenticationRequest.getString("password")));
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }
        UserDetails userDetails= mySystemUserDetails.loadUserByUsername(authenticationRequest.getString("username"));
        User user=userRepo.findByUsername(authenticationRequest.getString("username"));


        String realName=user.getFirstName().toUpperCase()+" "+user.getOtherNames().toUpperCase();

        final String jwt=jwtUtil.generateToken(userDetails);
        List<String> roles=userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
        JSONObject response = new JSONObject();
        response.put("roles",roles);
        response.put("user",realName);
        response.put("id",user.getId());
        response.put("username",user.getUsername());
        response.put("token",jwt);
        return response;

    }

}
