package com.resource.management.repository;

import com.resource.management.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface IProfileRepository extends JpaRepository<Profile, Long> {

    Collection<Profile> findAllBySkillSetContaining(String skill);

    Collection<Profile> findAllByCurrentManagerName(String currentManagerName);

    Collection<Profile> findAllByCurrentManagerEmail(String currentManagerEmail);

    Profile findByEmail(String email);
}
