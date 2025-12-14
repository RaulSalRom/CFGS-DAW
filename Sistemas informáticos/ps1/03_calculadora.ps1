Write-Host "Introduce un numero: "
$n1 = Read-Host " "
Write-Host "Introduce el segundo número: "
$n2 = Read-Host " "
$suma = $n1 + $n2
$resta = $n1 - $n2
$multiplicacion = $n1 * $n2
$division = $n1 / $n2
 Write-Host "$suma"
  Write-Host "$resta"
   Write-Host "$multiplicacion"
  if ($n2 -eq 0){
     Write-Host "$n2 es 0 y no se puede dividir"
  }else{
      Write-Host "$division"
  }