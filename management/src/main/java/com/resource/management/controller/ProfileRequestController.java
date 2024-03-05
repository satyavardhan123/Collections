package com.resource.management.controller;

import com.resource.management.model.ProfileRequest;
import com.resource.management.repository.IProfileRequestRepository;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/profile-requests")
@RequiredArgsConstructor
@CrossOrigin(originPatterns = "*")
public class ProfileRequestController {
    private final IProfileRequestRepository profileRequestRepository;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(profileRequestRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ProfileRequest profileRequest) {
        try {
            return ResponseEntity.ok(profileRequestRepository.save(profileRequest));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(Map.of("error", e.getMessage()));
        }
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<?> getByStatus(@PathVariable String status) {
        return ResponseEntity.ok(profileRequestRepository.findAllByStatus(status));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody ProfileRequest request, @PathVariable Long id) {
        ProfileRequest requestToUpdate = profileRequestRepository.findById(id).orElse(null);
        if (requestToUpdate == null) {
            return ResponseEntity.notFound().build();
        }
        requestToUpdate.setStatus(request.getStatus());
        return ResponseEntity.ok(profileRequestRepository.save(requestToUpdate));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        ProfileRequest requestToDelete = profileRequestRepository.findById(id).orElse(null);
        if (requestToDelete == null) {
            return ResponseEntity.notFound().build();
        }
        profileRequestRepository.delete(requestToDelete);
        return ResponseEntity.ok().build();
    }
}
