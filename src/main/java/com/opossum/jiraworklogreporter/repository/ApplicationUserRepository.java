package com.opossum.jiraworklogreporter.repository;

import com.opossum.jiraworklogreporter.entity.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long>{

   // @Query(value="SELECT * FROM APP_USER WHERE LOWER_USER_NAME = ':user'",
    //       nativeQuery = true)
    //ApplicationUser findByName(@Param("user") String user);

    ApplicationUser findByUsername(String user);

}
