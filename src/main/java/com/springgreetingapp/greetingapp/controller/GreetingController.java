package com.springgreetingapp.greetingapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.springgreetingapp.greetingapp.service.GreetingService;

@RestController
@RequestMapping("/greetings")
public class GreetingController {

    // GET request - returns a greeting message
    @GetMapping("/hello")
    public String getGreeting() {
        return "{\"message\": \"Hello, World!\"}";
    }

    // POST request - accepts a name and returns a personalized greeting
    @PostMapping("/hello")
    public String createGreeting(@RequestParam String name) {
        return "{\"message\": \"Hello, " + name + "!\"}";
    }

    // PUT request - updates a greeting message (simulated)
    @PutMapping("/hello")
    public String updateGreeting(@RequestParam String newMessage) {
        return "{\"message\": \"Updated greeting: " + newMessage + "\"}";
    }

    // DELETE request - deletes a greeting message (simulated)
    @DeleteMapping("/hello")
    public String deleteGreeting() {
        return "{\"message\": \"Greeting deleted successfully!\"}";
    }

    // UC2

    @Autowired
    private GreetingService greetingService;


    @GetMapping("/message")
    public String getGreeting1() {
        return "{\"message\": \"" + greetingService.getGreetingMessage() + "\"}";
    }

    //UC3

    @GetMapping("/personalized")
    public String getPersonalizedGreeting(@RequestParam(required = false) String firstName,
                                          @RequestParam(required = false) String lastName) {
        return "{\"message\": \"" + greetingService.getPersonalizedGreeting(firstName, lastName) + "\"}";
    }

}
