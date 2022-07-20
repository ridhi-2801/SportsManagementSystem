package com.example.demo.FeignClient;

import com.example.demo.Model.Player;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@FeignClient(url = "${feign.player}", name = "player")
public interface PlayerClient {

    @GetMapping("/players")
    public List<Player> players(@RequestHeader(value = "Authorization",required = true) String token);
}
