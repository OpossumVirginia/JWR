Write-Host "Congratulations! We start!"

$to = (Get-Date).ToString("yyyy-MM-dd")
$from = (Get-Date).AddDays(-6).ToString("yyyy-MM-dd")

Write-Host $from $to

Start-Process java "-jar C:\java\Own\jiraworklogreporter\target\jiraworklogreporter-0.0.1-SNAPSHOT.jar  -Dspring.profiles.active=dev $from $to"

Write-Host "Finished!"