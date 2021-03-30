package com.hajin.springboot.web;
import com.hajin.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello") // http get 요청을 받을 수 있는 API 만들어줌
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") //외부에서 API로 넘긴 파라미터를 가져오는 어노테이션
                                     String name,
                                     @RequestParam("amount")
                                     int amount){
        return new HelloResponseDto(name, amount);
    }
}
