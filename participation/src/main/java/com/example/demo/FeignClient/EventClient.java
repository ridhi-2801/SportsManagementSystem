package com.example.demo.FeignClient;

import com.example.demo.Model.Events;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@FeignClient(url = "${feign.event}", name = "event")
public interface EventClient {

    @PostMapping("/viewEventByName")
    public Events viewEventByName(@RequestHeader(value = "Authorization", required = true)String token,@RequestBody String eventName);
}
