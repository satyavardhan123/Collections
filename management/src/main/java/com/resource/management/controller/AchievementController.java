package com.resource.management.controller;

import com.resource.management.model.Achievement;
import com.resource.management.repository.IAchievementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/achievements")
@RequiredArgsConstructor
@CrossOrigin(originPatterns = "*")
public class AchievementController {

    private final IAchievementRepository achievementRepository;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(achievementRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Achievement achievement) {
        return ResponseEntity.ok(achievementRepository.save(achievement));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<?> getByName(@PathVariable String name) {
        return ResponseEntity.ok(achievementRepository.findAllByName(name));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Achievement achievement = achievementRepository.findById(id).orElse(null);
        if (achievement == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(achievement);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Achievement achievement, @PathVariable Long id) {
        Achievement achievementToUpdate = achievementRepository.findById(id).orElse(null);
        if (achievementToUpdate == null) {
            return ResponseEntity.notFound().build();
        }
        achievementToUpdate.setName(achievement.getName());
        achievementToUpdate.setDescription(achievement.getDescription());
        achievementToUpdate.setDate(achievement.getDate());
        return ResponseEntity.ok(achievementRepository.save(achievementToUpdate));
    }
}
