--1.
select d.PROFESOR from D d left join I i on d.PROFESOR = i.PROFESOR where i.PROFESOR is null;
--2.
select PROFESOR from I group by PROFESOR having count(distinct MODULO) = 2;
--3.
select d.DEPARTAMENTO from D d join I i on d.PROFESOR = i.PROFESOR JOIN E e on i.MODULO = e.MODULO group by d.DEPARTAMENTO having count(distinct e. CICLO) > 1;
--4.
select ALUMNO from M group by  ALUMNO  HAVING MIN(NOTA) >= 5;
--5.
select  
--6.
SELECT e.MODULO  from  E e where e.CICLO = 'DAW' group by e.CICLO ASC;
--7.
SELECT i.PROFESOR, e.MODULO from I join E where i.MODULO = e.MODULO;
