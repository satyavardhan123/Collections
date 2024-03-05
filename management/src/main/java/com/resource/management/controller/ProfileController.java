package com.resource.management.controller;

import com.resource.management.model.Profile;
import com.resource.management.repository.IProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;

@RestController
@RequestMapping("/api/profiles")
@RequiredArgsConstructor
@CrossOrigin(originPatterns = "*")
public class ProfileController {
    private final IProfileRepository profileRepository; // injects the profile repository into the controller

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(profileRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<?> register(@RequestBody Profile profile) {
        try {
            Profile existingProfile = profileRepository.findByEmail(profile.getEmail());
            if (existingProfile != null) {
                return ResponseEntity.badRequest().body(Map.of("msg", "Email already exists"));
            }
            return ResponseEntity.ok(profileRepository.save(profile));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(Map.of("error", e.getMessage()));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable Long id) {
        Profile profile = profileRepository.findById(id).orElse(null);
        if (profile == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(profile);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<?> getByEmail(@PathVariable String email) {
        Profile profile = profileRepository.findByEmail(email);
        if (profile == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(profile);
    }

    @GetMapping("/skill/{skill}")
    public ResponseEntity<?> getBySkill(@PathVariable String skill) {
        Collection<Profile> profiles = profileRepository.findAllBySkillSetContaining(skill);
        if (profiles == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(profiles);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        profileRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(String email, String password) {
        Profile profile = profileRepository.findByEmail(email);
        if (profile == null) {
            return ResponseEntity.notFound().build();
        }
        if (profile.getPassword().equals(password)) {
            return ResponseEntity.ok(profile);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Profile profile, @PathVariable Long id) {
        return ResponseEntity.ok(profileRepository.save(profile));
    }

    @GetMapping("/assigned/{name}")
    public ResponseEntity<?> findByManagerName(@PathVariable String name) {
        Collection<Profile> profiles = profileRepository.findAllByCurrentManagerName(name);
        return ResponseEntity.ok(profiles);
    }
}
