package com.opossum.jiraworklogreporter.service;

import com.opossum.jiraworklogreporter.dto.WorklogReportingDTO;
import com.opossum.jiraworklogreporter.entity.*;
import com.opossum.jiraworklogreporter.mail.EmailServiceImpl;
import com.opossum.jiraworklogreporter.repository.ApplicationUserRepository;
import com.opossum.jiraworklogreporter.repository.JiraIsssueRepository;
import com.opossum.jiraworklogreporter.repository.ProjectRepository;
import com.opossum.jiraworklogreporter.repository.WorklogRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Timestamp;
import java.util.*;

@Service
@Transactional
public class WorklogEntryRetreivalService {
    //this is a service - the business logic goes in here
    private static final Logger log = LoggerFactory.getLogger(WorklogEntryRetreivalService.class);
    private final WorklogRepository worklogRepository;
    private final JiraIsssueRepository jiraIsssueRepository;
    private final ProjectRepository projectRepository;
    private final ApplicationUserRepository applicationUserRepository;
    private final List<String> inputUsernamesList;
    private final String baseJiraURL;
    private final EmailServiceImpl emailService;

    public WorklogEntryRetreivalService(EmailServiceImpl emailService, WorklogRepository worklogRepository, JiraIsssueRepository jiraIsssueRepository, ProjectRepository projectRepository, ApplicationUserRepository applicationUserRepository,
                                        @Value("${jwr.inputUsernamesList}") String inputUsernamesList,@Value("${jwr.baseJiraURL}") String baseJiraURL){
        this.inputUsernamesList = Arrays.asList(inputUsernamesList.split(","));
        this.worklogRepository = worklogRepository;
        this.applicationUserRepository = applicationUserRepository;
        this.jiraIsssueRepository = jiraIsssueRepository;
        this.projectRepository = projectRepository;
        this.emailService = emailService;
        this.baseJiraURL = baseJiraURL;
    }

    /**
     * This method allows retrieval of the worklog information from across the jira Oracle DB.
     *
     * @author opossum virginia
     * @since 02.07.2022
     */
    @Transactional(readOnly = true)
    public void retrieveWorklogsAndReportEmail(String from, String to){
        try{
        for (String inputuser : inputUsernamesList) {
            ApplicationUser u = applicationUserRepository.findByUsername(inputuser);
            log.info("Retrieved jira user data: " + u.toString());

            List<Worklog> worklogs = worklogRepository.findByAuthorAndTimeframe(u.getUserkey(), from, to);

            List<WorklogReportingDTO> finalList = new ArrayList<>();
            for (Worklog w : worklogs) {
                JiraIssueInfo jiraIssueInfo = jiraIsssueRepository.findInfoById((long)w.getIssueid());
                ProjectInfo projectInfo = projectRepository.findInfoById((long)jiraIssueInfo.getProject());
                String ticket = projectInfo.getOriginalkey().concat("-").concat(String.valueOf((int)jiraIssueInfo.getIssuenum()));
                WorklogReportingDTO finalOne =
                        new WorklogReportingDTO(u.getUsername(), w.getTimeworked()/60/60, ticket,
                                w.getStartdate(),w.getCreated(),jiraIssueInfo.getSummary(),w.getWorklogbody(), baseJiraURL+ticket);
                finalList.add(finalOne);
            }
            //finalList.forEach((s) -> log.info("---------------Following worklogentry retrieved: " + s.toString()));

            Map<String, Object> templateModel = new HashMap<>();
            templateModel.put("jirauser", u.getUsername());
            templateModel.put("from", from);
            templateModel.put("to", to);

            templateModel.put("worklogAmount", finalList.size());
            templateModel.put("hoursCombined",finalList.stream().mapToDouble(WorklogReportingDTO::getHoursWorked).sum());
            templateModel.put("finalList",finalList);

            Date date = new Date();
            Timestamp timestampnow = new Timestamp(date.getTime());
            templateModel.put("timestampNow", timestampnow);
            emailService.sendMessageUsingThymeleafTemplate("Worklog Report for "+u.getUsername(), templateModel);
        }
        } catch (Exception e) {
            log.warn("An error during processing had happened! Sending Technical Email Notification");
            emailService.sendTechnicalErrorMessage("An Error with JWR", "Error happened on the host - " + getHost());
            throw new RuntimeException(e);
        }

    }

    private String getHost() {
        String computername= null;
        try {
            computername = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            log.warn("Unable to retrieve local host name: " + e.getMessage());
        }
        return computername;
    }


}
