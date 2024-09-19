package com.example.cliente.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class LoadBalancerController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/test-balance")
    public String testLoadBalancing() {
        String response = restTemplate.getForObject("http://cliente-service/api/clientes/status", String.class);
        return "Resposta do serviço: " + response;
    }
}
