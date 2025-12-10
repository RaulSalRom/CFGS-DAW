[CmdletBinding()]
param (
    [Parameter(Mandatory=$true)]
    [string]$Source,

    [Parameter(Mandatory=$true)]
    [string]$Destination,

    [int]$Keep = 5 
)
if (-not (Test-Path -LiteralPath $Source -PathType Container)) {
    Write-Error "El directorio origen '$Source' no existe o no es un directorio."
    exit 2
}
if ($Keep -lt 1) {
    Write-Error "El valor de -Keep debe ser mayor que 0."
    exit 2
}
if (-not (Test-Path -LiteralPath $Destination)) {
    New-Item -Path $Destination -ItemType Directory -Force | Out-Null
    Write-Host "Directorio destino creado: $Destination"
}
$ts = Get-Date -Format 'yyyyMMdd_HHmmss'
$baseName = Split-Path -Leaf $Source
$zipName = "backup_${baseName}_${ts}.zip"
$outFile = Join-Path -Path $Destination -ChildPath $zipName
Write-Host "Creando backup en: $outFile ..."
Compress-Archive -Path (Join-Path $Source '*') -DestinationPath $outFile -Force
Write-Host "Verificando rotación (mantener últimos $Keep)..."
$patron = "backup_${baseName}_*.zip"
$backupsViejos = Get-ChildItem -Path $Destination -Filter $patron | 
                 Sort-Object LastWriteTime -Descending | 
                 Select-Object -Skip $Keep

if ($backupsViejos) {
    foreach ($f in $backupsViejos) {
        Write-Host "Borrando backup antiguo: $($f.Name)" -ForegroundColor Yellow
        Remove-Item -Path $f.FullName -Force 
    }
} else {
    Write-Host "No hay backups antiguos para borrar."
}