package com.example.demo.Service;

import com.example.demo.Exception.FeignProxyException;
import com.example.demo.FeignClient.AuthClient;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl implements TokenService{

    @Autowired
    AuthClient authClient;

    @Override
    public boolean checkValidity(String token) {

        boolean isValid=authClient.getValidity(token);
        try{

           if(isValid==false) {
            System.out.println("token expired");
            throw new FeignProxyException();
           }else{
               System.out.println("Token valid");
               return true;
           }

        }catch(FeignProxyException e){
            return false;
        }

    }


}
