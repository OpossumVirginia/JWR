**JiraWorklogRetreival Project**

Application is developed with OpenJDK and can be fully operated under java 17.

**How to run**

By default, application is executed with a call like: 
`C:\java\jdk-17\bin\java -jar C:\application-0.0.1-SNAPSHOT.jar 2022-01-01 2022-01-15`
where the parameters stand for date range the query should be executed for. 

Call can be extended via additional parameters to switch between operational profiles:
`--spring.profiles.active=test`. This can be used in Production to test the infrastructure setup.

**Configuration**

Configuration file with production settings should be provided as spring properties. Active profile `prod` should be used.
All required data (URLs, passwords, etc.) must be added to the configuration before running.
Following are some extra configurations:
 - `jwr.inputUsernamesList` - comma separated list of jira names for which the report must be retrieved
 - `jwr.baseJiraURL` - base URL for the jira instance (used in email links)
 - `jwr.email.to` - comma separated list of Email addresses which will receive the reports
 - `jwr.email.cc` - comma separated list of Email addresses which will be on CC for the reports
 - `jwr.email.technical.to` - Email address which will receive email in the case of an error

Configuration file location can be changed, but will require an additional parameter in the jar call:
 `--spring.config.location=c:\config`

**Logging**
 
For application to work properly, a `logback-spring.xml` file's location must be changed in the active configuration profile.
Currently, a time-based log rotation is implemented. 

