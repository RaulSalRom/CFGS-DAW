Write-Host "Como te llamas: "
$nombre = Read-Host " "
$nada = ""
if($nombre -eq $nada) {
    $nombre = "desconocido"
    Write-Host "Hola $nombre"
} else{
Write-Host "Hola $nombre"
}