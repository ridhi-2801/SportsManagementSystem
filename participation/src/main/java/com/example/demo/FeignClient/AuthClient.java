package com.example.demo.FeignClient;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(url="${feign.auth}", name = "auth")
public interface AuthClient {

    @PostMapping("/authorize")
    public boolean getValidity(@RequestHeader(value = "Authorization",required = true) String token);

}
