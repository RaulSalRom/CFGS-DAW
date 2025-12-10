Write-Host "Introduce un numero: "
[int]$n1 = Read-Host " "
    for($i = 1;$i -le 10; $i++){
        $m = "Resultado: " + ($n1 * $i)
        Write-Host "$m"
}