package com.resource.management.repository;

import com.resource.management.model.Achievement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface IAchievementRepository extends JpaRepository<Achievement, Long> {
    Collection<Achievement> findAllByName(String name);
}
