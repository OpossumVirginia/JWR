Write-Host "Congratulations! We start!"

$to = (Get-Date).ToString("yyyy-MM-dd")
$from = (Get-Date).AddDays(-6).ToString("yyyy-MM-dd")
$l = "$PSScriptRoot\$to"

New-Item -Path $PSScriptRoot -Name "$to" -ItemType "directory"
New-Item -Path "$l" -Name "config" -ItemType "directory"
Copy-item -Path "$PSScriptRoot\target\jiraworklogreporter-0.0.1-SNAPSHOT.jar" -Destination "$l"

$d = "logging.config=$l/logback-spring.xml".replace('\','/')
$s= "<property name=`"LOG_PATH`" value=`"$l`"/>".replace('\','/')
#the local development profile is being used here, so should be adapted to fit your env
(Get-Content "$PSScriptRoot\src\main\resources\application-dev.properties") -Replace 'logging.config=src/main/resources/logback-spring.xml', $d | Set-Content "$l\config\application-local.properties"
(Get-Content "$PSScriptRoot\src\main\resources\logback-spring.xml") -Replace '<property name="LOG_PATH" value="logs"/>', $s | Set-Content "$l\logback-spring.xml"

Start-Process "C:\java\jdk-17\bin\java.exe" "-jar $l\jiraworklogreporter-0.0.1-SNAPSHOT.jar --spring.profiles.active=prod --spring.config.location=$l\config\application-local.properties $from $to" | Out-Null

Write-Host "Execution done. Please check the result. Remove artifacts:"
$confirmation = Read-Host
if ($confirmation -eq 'y') {
    Remove-Item -Recurse -Force $l
    Write-Host 'Artifacts removed! Nothing to do.'
} else {
    Write-Host 'Artifacts not removed! Please have a look!'
}

Write-Host "Finished!"