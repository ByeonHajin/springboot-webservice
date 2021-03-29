package com.hajin.springboot.web;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello") // http get 요청을 받을 수 있는 API 만들어줌
    public String hello() {
        return "hello";
    }
}
