package com.resource.management.repository;

import com.resource.management.model.Manager;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface IManagerRepository extends JpaRepository<Manager, Long> {
    Manager findByEmail(String email);

    Manager findByName(String name);
}
