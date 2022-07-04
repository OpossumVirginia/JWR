package com.opossum.jiraworklogreporter.job;

import com.opossum.jiraworklogreporter.service.WorklogEntryRetreivalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
@Profile("!test")
public class RetrievalJob implements CommandLineRunner {
    //processing logic goes in here

    private static final Logger log = LoggerFactory.getLogger(RetrievalJob.class);
    private final WorklogEntryRetreivalService wrService;

    @Autowired
    public RetrievalJob(WorklogEntryRetreivalService service){
        this.wrService=service;
    }

    @Override
    public void run(String... args) throws Exception {
        args = filterOutSpringArgs(args);
        if (args.length !=2 ) throw new IllegalArgumentException("Please provide a correct argument number, those should be two, from and to dates");

        log.info("Starting reporting for the dates: from - "+args[0] + ", to - " + args[1]);
        wrService.retrieveWorklogsAndReportEmail(args[0], args[1]);

    }
    private String[] filterOutSpringArgs(String[] args) {
        return Stream.of(args).filter(a -> !a.startsWith("--spring")).toList().toArray(new String[0]);
    }

}
