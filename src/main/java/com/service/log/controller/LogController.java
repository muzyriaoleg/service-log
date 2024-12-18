package com.service.log.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class LogController {

    @PostMapping("/log")
    public ResponseEntity<?> logRequest(@RequestBody List<Integer> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("Invalid number list received.");
        }
        System.out.println("Logged data: " + list);
        return ResponseEntity.ok().build();
    }
}
