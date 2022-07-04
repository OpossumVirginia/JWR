package com.opossum.jiraworklogreporter.repository;

import java.util.List;

import com.opossum.jiraworklogreporter.entity.Worklog;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WorklogRepository extends JpaRepository<Worklog, Long>{


	//@Query(value="SELECT new opossum.jiraworklogreporter.domain.WorklogEntryDTO(APP_USER.LOWER_USER_NAME AS AUTHOR, WORKLOG.STARTDATE as STARTDATE,WORKLOG.CREATED as CREATED, WORKLOG.timeworked/60/60 AS HOURS_WORKED, CONCAT(CONCAT(PROJECT.PKEY , '-'),JIRAISSUE.ISSUENUM) AS TICKET, JIRAISSUE.SUMMARY AS TICKET_SUMMARY, WORKLOG.WORKLOGBODY AS WORK_COMMENT) FROM WORKLOG" +
	//		" LEFT JOIN JIRAISSUE ON WORKLOG.ISSUEID = JIRAISSUE.ID"+
	//		" LEFT JOIN PROJECT ON JIRAISSUE.PROJECT = PROJECT.ID" +
	//		" LEFT JOIN APP_USER ON WORKLOG.AUTHOR = APP_USER.USER_KEY" +
	//		" WHERE APP_USER.LOWER_USER_NAME = '?1' " +
	//		" AND trunc(STARTDATE) BETWEEN TO_DATE('?2', 'yyyy-mm-dd') AND TO_DATE('?3', 'yyyy-mm-dd')" +
	//		" ORDER BY STARTDATE ASC",
	//			nativeQuery = true)
	//List<WorklogEntryDTO> findByDates(String author, String from, String to);


	List<Worklog> findByAuthor(String author);

	@Query(value="SELECT * FROM WORKLOG WHERE AUTHOR = :author AND trunc(STARTDATE) BETWEEN TO_DATE(:from, 'yyyy-mm-dd') AND TO_DATE(:to, 'yyyy-mm-dd')",
	       nativeQuery = true)
	List<Worklog> findByAuthorAndTimeframe(@Param("author") String author, @Param("from") String from, @Param("to") String to);
}
