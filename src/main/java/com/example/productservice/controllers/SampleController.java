package com.example.productservice.controllers;

import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/sample")
public class SampleController {
    @GetMapping("/hello")
    public String sayHello(@RequestParam("name") String str,@RequestParam("count") Integer number){
        StringBuilder sb = new StringBuilder(" ");
        for (int i = 0; i < number; i++) {
            sb.append(str).append(" ");
        }
        return sb.toString();
    }
    @GetMapping("/greetings")
    public String sayGreetings() {
        return "Greetings from springBoot";
    }
}
