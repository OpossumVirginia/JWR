package com.opossum.jiraworklogreporter.repository;

import com.opossum.jiraworklogreporter.entity.ApplicationUserMetadata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationUserMetadadaRepository extends JpaRepository<ApplicationUserMetadata, Long> {

    ApplicationUserMetadata findByUserName(String user);


    List<ApplicationUserMetadata> findByLowerUserName(String lowerUserName);
}
