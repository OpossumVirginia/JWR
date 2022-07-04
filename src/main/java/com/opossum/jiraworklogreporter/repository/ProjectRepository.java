package com.opossum.jiraworklogreporter.repository;

import com.opossum.jiraworklogreporter.entity.ProjectInfo;
import com.opossum.jiraworklogreporter.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>{


    ProjectInfo findInfoById(Long id);
}
