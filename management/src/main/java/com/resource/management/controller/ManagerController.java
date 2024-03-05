package com.resource.management.controller;

import com.resource.management.model.Manager;
import com.resource.management.model.Profile;
import com.resource.management.repository.IManagerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/managers")
@RequiredArgsConstructor
@CrossOrigin(originPatterns = "*")
public class ManagerController {

    private final IManagerRepository managerRepository;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(managerRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Manager manager) {
        Manager existingManager = managerRepository.findByEmail(manager.getEmail());
        if (existingManager != null) {
            return ResponseEntity.badRequest().body(Map.of("msg", "Email already exists"));
        }
        return ResponseEntity.ok(managerRepository.save(manager));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<?> getByName(@PathVariable String name) {
        Manager manager = managerRepository.findByName(name);
        if (manager == null) {
            return new ResponseEntity<>(Map.of("msg", "Manager does not exist with this name"), HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(manager);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Manager manager = managerRepository.findById(id).orElse(null);
        if (manager == null) {
            return new ResponseEntity<>(Map.of("msg", "Manager does not exist with this id"), HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(manager);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<?> getByEmail(@PathVariable String email) {
        Manager manager = managerRepository.findByEmail(email);
        if (manager == null) {
            return new ResponseEntity<>(Map.of("msg", "Manager does not exist with this email"), HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(manager);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(String email, String password) {
        Manager manager = managerRepository.findByEmail(email);
        if (manager == null) {
            return ResponseEntity.badRequest().body(Map.of("msg", "User does not exist with this email"));
        }
        if (!manager.getPassword().equals(password)) {
            return ResponseEntity.badRequest().body(Map.of("msg", "Password is incorrect"));
        }
        return ResponseEntity.ok(manager);
    }
}
