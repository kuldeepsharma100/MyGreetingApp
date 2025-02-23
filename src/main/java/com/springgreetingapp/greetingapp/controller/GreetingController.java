package com.springgreetingapp.greetingapp.controller;

import com.springgreetingapp.greetingapp.model.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.springgreetingapp.greetingapp.service.GreetingService;

import java.util.List;
import java.util.Optional;

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

    //uc3
    @GetMapping("/personalized")
    public String getPersonalizedGreeting(@RequestParam(required = false) String firstName,
                                          @RequestParam(required = false) String lastName) {
        return "{\"message\": \"" + greetingService.getPersonalizedGreeting(firstName, lastName) + "\"}";
    }


    // UC 4: Save Greeting Message
    @PostMapping("/save")
    public Greeting saveGreeting(@RequestBody Greeting greeting) {
        return greetingService.saveGreeting(greeting);
    }

    // uc5
    @GetMapping("/{id}")
    public Optional<Greeting> getGreetingById(@PathVariable Long id) {
        return greetingService.getGreetingById(id);
    }

    // UC 6: List all Greeting Messages
    @GetMapping("/all")
    public List<Greeting> getAllGreetings() {
        return greetingService.getAllGreetings();
    }

    // UC 7: Update a Greeting Message
    @PutMapping("/update/{id}")
    public Greeting updateGreeting(@PathVariable Long id, @RequestParam String message) {
        return greetingService.updateGreeting(id, message);
    }

    // UC 8: Delete a Greeting Message
    @DeleteMapping("/delete/{id}")
    public String deleteGreeting(@PathVariable Long id) {
        greetingService.deleteGreeting(id);
        return "Greeting deleted successfully!";
    }

}
