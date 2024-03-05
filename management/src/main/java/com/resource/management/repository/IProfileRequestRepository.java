package com.resource.management.repository;

import com.resource.management.model.ProfileRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface IProfileRequestRepository extends JpaRepository<ProfileRequest, Long> {

    Collection<ProfileRequest> findAllByStatus(String status);
}
