do {
    $rutaLog = Read-Host "Introduce la ruta del fichero access.log"
} while ($rutaLog -eq "")

if ((Test-Path $rutaLog) -eq $false) {
    Write-Host "Error: El fichero no existe."
    exit
}

$lineas = Get-Content -Path $rutaLog

$datosProcesados = foreach ($linea in $lineas) {

    if ($linea.Length -gt 10) {

        $palabras = $linea.Split(" ")
        $registro = "" | Select-Object IP, URL, Estado
        $registro.IP = $palabras[0] 
        $registro.URL = $palabras[6] 
        $registro.Estado = $palabras[8] 
        $registro
    }
}

if ($null -eq $datosProcesados -or $datosProcesados.Count -eq 0) { 
    Write-Host "Sin datos."
} else {

$informe = "informe_temp.txt"

"--- Total de peticiones realizadas ---"
$datosProcesados.Count >> $informe

"--- TOP 5 IPs ---" >> $informe
$datosProcesados | Group-Object IP | Sort-Object Count -Descending | Select-Object -First 5 Name, Count >> $informe

"--- TOP 5 Recursos utilizados ---" >> $informe
$datosProcesados | Group-Object URL | Sort-Object Count -Descending | Select-Object -First 5 Name, Count >> $informe

"--- Resumen por C�digo HTTP ---" >> $informe
$datosProcesados | Group-Object Estado | Sort-Object Count -Descending | Select-Object Name, Count >> $informe

Get-Content $informe
}