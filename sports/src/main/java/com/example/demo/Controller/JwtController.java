package com.example.demo.Controller;

import com.example.demo.Exception.AuthorizationException;
import com.example.demo.Model.JwtRequest;
import com.example.demo.Config.JwtTokenUtil;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JwtController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @PostMapping("/authenticate")
    public String login(@RequestBody JwtRequest credentials)throws AuthorizationException{

        Authentication auth = authenticate(credentials.getUsername(),credentials.getPassword());
        System.out.println(credentials.getUsername());
        System.out.println(auth);
        final  UserDetails userDetails = userDetailsService.loadUserByUsername(credentials.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);
        return token;

    }
    private Authentication  authenticate(String userName, String password) throws AuthorizationException {
        try {
            System.out.println("Inside authenticate Method==================================");
            System.out.println(userName+" "+password);
            Authentication auth=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, password));
            System.out.println("Authentication Successful.....");
            System.out.println(auth.getCredentials()+"+++++++++++++++++++++++++++++++++");
            return auth;

        } catch (DisabledException e) {
            throw new AuthorizationException("USER_DISABLED");
        } catch (BadCredentialsException e) {
            e.printStackTrace();
            throw new AuthorizationException("INVALID_CREDENTIALS");
        }

    }
    @PostMapping(value = "/authorize")
    public boolean authorizeTheRequest(
            @RequestHeader(value = "Authorization", required = true) String requestTokenHeader) {
        System.out.println("Inside authorize =============="+requestTokenHeader);
        String jwtToken = null;
        String userName = null;
        if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
            jwtToken = requestTokenHeader.substring(7);
            System.out.println("JWT Tocken ======================="+jwtToken);
            try {
                userName = jwtTokenUtil.getUsernameFromToken(jwtToken);
            } catch (IllegalArgumentException | ExpiredJwtException e) {
                return false;
            }
        }
        return userName != null;
    }

}
