$texto = Read-Host "Hola, DAW"
Write-Host "$texto"
$anno = (Get-Date).Year
$mes = (Get-Date).Month
$dia = (Get-Date).Day
$hora = (Get-Date).Hour
$min = (Get-Date).Minute
$sec = (Get-Date).Second
Write-Host "$anno/$mes/$dia $hora : $min :$sec"
