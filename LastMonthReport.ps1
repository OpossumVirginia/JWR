Write-Host "We start!"

$CURRENTDATE=GET-DATE -Hour 0 -Minute 0 -Second 0
$MonthAgo = $CURRENTDATE.AddMonths(-1)
$from=(GET-DATE $MonthAgo -Day 1)
$to=GET-DATE $from.AddMonths(1).AddSeconds(-1)
$from=$from.ToString("yyyy-MM-dd")
$to=$to.ToString("yyyy-MM-dd")

Write-Host $from $to

Start-Process java "-jar C:\java\Own\jiraworklogreporter\target\jiraworklogreporter-0.0.1-SNAPSHOT.jar  -Dspring.profiles.active=dev $from $to"

Write-Host "Finished!"