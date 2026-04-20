delimiter $$
create or replace procedure dividirDepartamentos();
begin

   declare dep row type of departamento;
   declare nuevoPresupuestio decimal(10,2);
   declare fin int deafault 0;
   declare cur cursor for select d.* from departamento d inner join empleado e on d.CodDep = e.CodDep where e.NumHi > 0 group by d.CodDep having(count(e.CodDep) > 1);
    declare continue handler for not found set fin = 1;

    open cur;
    fetch cur into dep;
    set nuevoPresupuestio = dep.Presupuesto / 2;
    while fin = 0 do
        insert int departamentofamiliar select * from departamento d where d.CodDep = dep.CodDep;
        update departamentofamiliar set preAnu = nuevoPresupuestio where CodDep = dep.CodDep;
        set nuevoCodigo = concat(substring(dep.CodDep,1,4), '2');
        set nuevoNombre = concat(dep.Nombre, ' Familiar');
        insert into departamentofamiliar values (nuevoCodigo, dep.codEmpDir, dep.codEmp, dep.codCen, nuevoNombre, nuevoPresupuestio, dep.TiDir);

    end while;
    close cur;

    end $$

    delimiter ;
        