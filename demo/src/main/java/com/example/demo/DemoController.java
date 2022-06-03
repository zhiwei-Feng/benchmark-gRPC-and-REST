package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
public class DemoController {
    private final DemoService service;
    private final WebClient webClient;
    private final RestTemplate restTemplate;

    @Autowired
    public DemoController(DemoService service, RestTemplate restTemplate) {
        this.service = service;
        this.webClient = WebClient.create("http://localhost:8080");
        this.restTemplate = restTemplate;
    }

    @GetMapping("/hello/{id}")
    public User hello(@PathVariable("id") Long id) {
        return service.getUser(id);
    }

    @GetMapping("/hello1/{id}")
    public User hello1(@PathVariable("id") Long id) {
//        Mono<User> userMono = this.webClient.get().uri("/api/v1/user/{id}", id).retrieve().bodyToMono(User.class);
//        return userMono.block();
        return restTemplate.getForObject("http://localhost:8080/api/v1/user/{id}", User.class, id);
    }
}
