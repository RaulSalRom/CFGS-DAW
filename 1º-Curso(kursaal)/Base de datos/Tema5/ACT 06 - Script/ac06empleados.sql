--1.Crea una tabla dashboard_dpto que muestre para cada departamento, además de su código y nombre y presupuesto anual, cuantos empleados y su gasto en salarios.

drop table if exists dashboard_dpto;
create table dashboard_dpto 
as select d.CodDep, d.NomDep, d.PreAnu, count(e.CodEmp) 
as NumEmpleado, sum(e.SalEmp) as 
GastosSalariales from departamento d left join empleado e 
on d.CodDep = e.CodDep 
group by d.CodDep, d.NomDep, d.PreAnu;

--2.Crea una tabla dashboard_centro que muestre para cada centro, además de su código y nombre, cuantos departamentos contiene y el presupuesto anual 
-- (entendido como la suma de los presupuestos de sus departamentos).
drop table if exists dashboard_centro;
create table dashboard_centro as 
select c.CodCen, c.NomCen, count(d.CodDep) as NumDepartamentos, sum(d.PreAnu) 
as PresupuestoAnual 
from centro c left join departamento d 
on c.CodCen = d.CodCen 
group by c.CodCen, c.NomCen; 