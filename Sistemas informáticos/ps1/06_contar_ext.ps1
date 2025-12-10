do{
    $ruta = Read-Host "Introduce la ruta del directorio"
} while ($ruta -eq "")

$extension = Read-Host "Introduce la extensión a buscar (ej: txt)"
$existe = Test-Path -Path $ruta 

if ($existe -eq $false){
    Write-Host "Error: El directorio '$ruta' no existe."
    exit 
}

if ($extension.StartsWith(".") -eq $false) {
    $extension = "." + $extension
}

$busqueda = "*" + $extension

Write-Host "Buscando archivos $busqueda en $ruta..."
$archivos = Get-ChildItem -Path $ruta -Filter $busqueda -File -ErrorAction SilentlyContinue

$cantidad = 0
foreach ($elemento in $archivos) {
    $cantidad = $cantidad + 1
}

Write-Host "Resultado: Se encontraron $cantidad archivos con extensión $extension"