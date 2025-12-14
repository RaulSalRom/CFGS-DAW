arameter(Mandatory=$true)
    [string]$File

# Validación del fichero (comprobar que existe y es tipo hoja/fichero)
if (-not (Test-Path -LiteralPath $File -PathType Leaf)) {
    Write-Error "El fichero '$File' no existe o no es un archivo válido."
    exit 2 # Código de salida coherente con la guía
}

$contenido = Get-Content -Path $File
$cantidad = 0
$suma = 0.0
# Inicialización a null para manejar correctamente el primer valor
$min = $null
$max = $null

foreach ($linea in $contenido) {
    # Limpieza de datos: Trim y saltar líneas vacías
    $strNum = $linea.Trim()
    if ([string]::IsNullOrWhiteSpace($strNum)) { continue }

    # Parseo numérico seguro con TryParse
    $val = 0.0
    # Se usa NumberStyles.Float/Any implícito en el parseo double estándar de PS o .NET
    if ([double]::TryParse($strNum, [ref]$val)) {
        
        # Cálculo incremental
        $cantidad++
        $suma += $val

        # Lógica de Min/Max
        if ($null -eq $min -or $val -lt $min) { $min = $val }
        if ($null -eq $max -or $val -gt $max) { $max = $val }
    }
}

if ($cantidad -gt 0) {
    $media = $suma / $cantidad
    
    Write-Host "`n--- Estadísticas ---"
    Write-Host "Cantidad: $cantidad"
    Write-Host "Mínimo:   $min"
    Write-Host "Máximo:   $max"
    # Formato de cadena para 2 decimales
    Write-Host ("Media:    {0:N2}" -f $media)
} else {
    Write-Warning "No se encontraron números válidos en el fichero."
}