package com.example.demo.Service;

import com.example.demo.FeignClient.AuthClient;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TokenServiceImpl implements  TokenService{

    @Autowired
    AuthClient authClient;


    @Override
    public boolean checkValidity(String token) {

        boolean isValid=authClient.getValidity(token);

        try{

            if(isValid==false){
                throw new Exception();
            }

        }catch (Exception e){
            log.error("Invalid Token");
        }
        return isValid;
    }
}
