package com.opossum.jiraworklogreporter.repository;

import com.opossum.jiraworklogreporter.entity.JiraIssueInfo;
import com.opossum.jiraworklogreporter.entity.JiraIssue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JiraIsssueRepository extends JpaRepository<JiraIssue, Long>{

    // @Query(value="SELECT * FROM APP_USER WHERE LOWER_USER_NAME = ':user'",
    //       nativeQuery = true)
    //jpa entity projection takes care of unwanted fields, just define the interface for data we need here
    JiraIssueInfo findInfoById(Long id);
}
