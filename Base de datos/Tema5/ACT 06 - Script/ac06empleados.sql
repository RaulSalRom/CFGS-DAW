--1.
drop table if exists dashboard_dpto;
create table dashboard_dpto 
as select d.CodDep, d.NomDep, d.PreAnu, count(e.CodEmp) 
as NumEmpleado, sum(e.SalEmp) as 
GastosSalariales from departamento d left join empleado e 
on d.CodDep = e.CodDep 
group by d.CodDep, d.NomDep, d.PreAnu;

--2.
drop table if exists dashboard_centro;
create table dashboard_centro as 
select c.CodCen, c.NomCen, count(d.CodDep) as NumDepartamentos, sum(d.PreAnu) 
as PresupuestoAnual 
from centro c left join departamento d 
on c.CodCen = d.CodCen 
group by c.CodCen, c.NomCen; 