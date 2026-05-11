/**
 * DAWConnect - Lógica de la aplicación
 * ASIGNATURA: Lenguajes de Marcas (JavaScript)
 * - Manipulación del DOM
 * - Eventos
 * - Carga dinámica de datos
 */

(function() {
    'use strict';

    // ==================== MENÚ MÓVIL ====================
    const menuBtn = document.getElementById('menuBtn');
    const mainNav = document.getElementById('mainNav');

    if (menuBtn && mainNav) {
        menuBtn.addEventListener('click', function() {
            mainNav.classList.toggle('active');
        });

        // Cerrar menú al hacer clic en un enlace
        mainNav.querySelectorAll('a').forEach(link => {
            link.addEventListener('click', () => {
                mainNav.classList.remove('active');
            });
        });
    }

    // ==================== INICIO: ESTADÍSTICAS ====================
    function cargarEstadisticasInicio() {
        const statAlumnos = document.getElementById('statAlumnos');
        const statProfesores = document.getElementById('statProfesores');
        const statAsignaturas = document.getElementById('statAsignaturas');
        const statMatriculas = document.getElementById('statMatriculas');

        if (statAlumnos) animateNumber(statAlumnos, DAW.alumnos.length);
        if (statProfesores) animateNumber(statProfesores, DAW.profesores.length);
        if (statAsignaturas) animateNumber(statAsignaturas, DAW.asignaturas.length);
        if (statMatriculas) animateNumber(statMatriculas, DAW.matriculas.length);
    }

    function animateNumber(el, target) {
        let current = 0;
        const increment = Math.ceil(target / 30);
        const timer = setInterval(() => {
            current += increment;
            if (current >= target) {
                current = target;
                clearInterval(timer);
            }
            el.textContent = current;
        }, 30);
    }

    // ==================== MÓDULOS GRID ====================
    function cargarModulos() {
        const grid = document.getElementById('modulesGrid');
        if (!grid) return;

        grid.innerHTML = DAW.asignaturas.map(asig => `
            <article class="module-card">
                <div class="module-card__icon">${asig.icono}</div>
                <span class="module-card__code">${asig.codigo}</span>
                <h3 class="module-card__title">${asig.nombre}</h3>
                <p class="module-card__desc">${asig.desc}</p>
                <div class="module-card__hours">
                    <span>${asig.horas}h/sem</span>
                    <span>${asig.creditos} créditos</span>
                </div>
            </article>
        `).join('');
    }

    // ==================== TOP ALUMNOS ====================
    function cargarTopAlumnos() {
        const container = document.getElementById('topAlumnos');
        if (!container) return;

        const top = [...DAW.alumnos]
            .filter(a => a.activo)
            .sort((a, b) => b.nota - a.nota)
            .slice(0, 5);

        const medallas = ['🥇', '🥈', '🥉', '4️⃣', '5️⃣'];
        const clases = ['ranking__item--1', 'ranking__item--2', 'ranking__item--3', '', ''];

        container.innerHTML = top.map((a, i) => `
            <div class="ranking__item ${clases[i] || ''}">
                <span class="ranking__pos">${medallas[i]}</span>
                <span class="ranking__name">${a.nombre} ${a.apellidos}</span>
                <span class="ranking__nota ${DAW.helpers.getNotaClass(a.nota)}">${a.nota.toFixed(2)}</span>
            </div>
        `).join('');
    }

    // ==================== TABLA DE ALUMNOS ====================
    function cargarTablaAlumnos() {
        const tbody = document.getElementById('tbody-alumnos');
        if (!tbody) return;

        tbody.innerHTML = DAW.alumnos.map(a => `
            <tr>
                <td>${a.dni}</td>
                <td><strong>${a.nombre} ${a.apellidos}</strong></td>
                <td>${a.expediente}</td>
                <td><span class="${DAW.helpers.getNotaClass(a.nota)}">${a.nota.toFixed(2)}</span></td>
                <td><span class="badge ${a.activo ? 'badge--active' : 'badge--inactive'}">${a.activo ? '✅ Activo' : '❌ Inactivo'}</span></td>
            </tr>
        `).join('');
    }

    // ==================== TABLA DE PROFESORES ====================
    function cargarTablaProfesores() {
        const tbody = document.getElementById('tbody-profesores');
        if (!tbody) return;

        tbody.innerHTML = DAW.profesores.map(p => `
            <tr>
                <td>${p.dni}</td>
                <td><strong>${p.nombre} ${p.apellidos}</strong></td>
                <td>${p.codigo}</td>
                <td>${p.dept}</td>
                <td>${p.esTutor ? '<span class="badge badge--info">🧑‍🏫 Tutor</span>' : '—'}</td>
            </tr>
        `).join('');
    }

    // ==================== TABLA DE ASIGNATURAS ====================
    function cargarTablaAsignaturas() {
        const tbody = document.getElementById('tbody-asignaturas');
        if (!tbody) return;

        tbody.innerHTML = DAW.asignaturas.map(a => {
            const media = DAW.helpers.getNotaMediaAsignatura(a.codigo);
            return `
                <tr>
                    <td><strong>${a.codigo}</strong></td>
                    <td>${a.nombre}</td>
                    <td>${a.horas}h/sem</td>
                    <td>${a.creditos}</td>
                    <td><span class="${DAW.helpers.getNotaClass(media)}">${media.toFixed(2)}</span></td>
                </tr>
            `;
        }).join('');
    }

    // ==================== TABLA DE MATRÍCULAS ====================
    function cargarTablaMatriculas() {
        const tbody = document.getElementById('tbody-matriculas');
        if (!tbody) return;

        tbody.innerHTML = DAW.matriculas.map(m => {
            const nombre = DAW.helpers.getAlumnoNombre(m.alumno);
            const estadoClass = m.estado === 'ACTIVA' ? 'badge--active' : 'badge--warning';
            return `
                <tr>
                    <td><strong>${m.id}</strong></td>
                    <td>${m.alumno}</td>
                    <td>${nombre}</td>
                    <td>${m.curso}</td>
                    <td><span class="badge ${estadoClass}">${m.estado}</span></td>
                </tr>
            `;
        }).join('');
    }

    // ==================== TABLA DE CALIFICACIONES ====================
    function cargarTablaCalificaciones() {
        const tbody = document.getElementById('tbody-calificaciones');
        if (!tbody) return;

        const codigosAsignaturas = DAW.asignaturas.map(a => a.codigo);

        tbody.innerHTML = DAW.alumnos
            .filter(a => a.activo)
            .sort((a, b) => b.nota - a.nota)
            .map(a => {
                const califs = DAW.helpers.getCalificacionesAlumno(a.dni);
                const notas = codigosAsignaturas.map(cod => {
                    const nota = califs[cod];
                    return nota !== undefined 
                        ? `<span class="${DAW.helpers.getNotaClass(nota)}">${nota.toFixed(1)}</span>`
                        : '—';
                }).join('</td><td>');
                return `<tr><td><strong>${a.nombre} ${a.apellidos}</strong></td><td>${notas}</td><td class="${DAW.helpers.getNotaClass(a.nota)}"><strong>${a.nota.toFixed(2)}</strong></td></tr>`;
            }).join('');
    }

    // ==================== TABLA DE EMPRESAS ====================
    function cargarTablaEmpresas() {
        const tbody = document.getElementById('tbody-empresas');
        if (!tbody) return;

        tbody.innerHTML = DAW.empresas.map(e => `
            <tr>
                <td>${e.cif}</td>
                <td><strong>${e.nombre}</strong></td>
                <td>${e.localidad}</td>
                <td>${e.sector}</td>
                <td>${e.plazas}</td>
                <td><span class="badge ${e.activo ? 'badge--active' : 'badge--inactive'}">${e.activo ? '✅ Activo' : '❌ Inactivo'}</span></td>
            </tr>
        `).join('');
    }

    // ==================== PÁGINA DE ESTADÍSTICAS ====================
    function cargarEstadisticas() {
        // Resumen
        const el = (id) => document.getElementById(id);
        if (el('total-alumnos')) el('total-alumnos').textContent = DAW.alumnos.length;
        if (el('total-profesores')) el('total-profesores').textContent = DAW.profesores.length;
        if (el('total-asignaturas')) el('total-asignaturas').textContent = DAW.asignaturas.length;
        if (el('total-matriculas')) el('total-matriculas').textContent = DAW.matriculas.length;
        if (el('total-empresas')) el('total-empresas').textContent = DAW.empresas.length;

        // Nota media global
        const mediaGlobal = DAW.alumnos.reduce((s, a) => s + a.nota, 0) / DAW.alumnos.length;
        if (el('nota-media-global')) el('nota-media-global').textContent = mediaGlobal.toFixed(2);

        // Alumnos activos
        const activos = DAW.alumnos.filter(a => a.activo).length;
        if (el('alumnos-activos')) el('alumnos-activos').textContent = activos;

        // Alumnos con media >= 5 (aprobados globales)
        const aprobados = DAW.alumnos.filter(a => a.nota >= 5).length;
        if (el('alumnos-aprobados')) el('alumnos-aprobados').textContent = aprobados;

        // Empresas activas
        const empresasActivas = DAW.empresas.filter(e => e.activo).length;
        if (el('empresas-activas')) el('empresas-activas').textContent = empresasActivas;
    }

    // ==================== INICIALIZACIÓN ====================
    document.addEventListener('DOMContentLoaded', function() {
        cargarEstadisticasInicio();
        cargarModulos();
        cargarTopAlumnos();

        // Inicializar según la página
        const page = document.body.dataset.page;

        if (page === 'alumnos') {
            cargarTablaAlumnos();
        } else if (page === 'profesores') {
            cargarTablaProfesores();
        } else if (page === 'asignaturas') {
            cargarTablaAsignaturas();
        } else if (page === 'matriculas') {
            cargarTablaMatriculas();
        } else if (page === 'calificaciones') {
            cargarTablaCalificaciones();
        } else if (page === 'empresas') {
            cargarTablaEmpresas();
        } else if (page === 'estadisticas') {
            cargarEstadisticas();
        }
    });

})();
