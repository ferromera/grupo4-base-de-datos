/*
1. Matriculas de los profesionales que unicamente tienen indicaciones
antes del 30 / 5 / 2012.
*/
select distinct(r1.matricula) from indicacionmedica r1 where r1.fecha < '20120530'
	and r1.matricula not in (Select r2.matricula from indicacionmedica r2 where r2.fecha >= '20120530');

/*
2. Tipo de documento Numero de documento y Nombre de las personas
que tienen un mismo numero de afiliado en distintas obras sociales
(evitar pares duplicados).
*/
select r1.tipodoc,r1.numerodoc,r1.nombre from paciente r1,afiliado a
	where r1.tipodoc = a.tipodoc
	and r1.numerodoc = a.numerodoc
	and a.numeroafiliado
		in (
		select r2.numeroafiliado from afiliado r2
		group by r2.numeroafiliado
		having count(*)>1);

/* 3-
*/
select obraSocial,p.* from afiliado a,paciente p
where p.tipoDoc=a.tipoDoc and p.numeroDoc=a.numeroDoc
    and exists (
	select max(numeroafiliado),obrasocial from afiliado a2
	group by a2.obrasocial
	having a2.obrasocial = a.obrasocial and a.numeroafiliado = max(numeroafiliado)
	);

/*
4. Matriculas de los profesionales que tienen indicaciones medicas para
todos los CPT.
*/
/*matriculas para los cuales no existe CPT que no este en indicacion medica */

select distinct(r1.matricula) from indicacionmedica r1 where not exists (
	select * from cpt r2 where
		not exists (
			select * from indicacionmedica r3
			where r3.codigoCpt = r2.codigoCpt
			and r1.matricula = r3.matricula
		)
);
/*
5. Matriculas de los profesionales que no tienen indicaciones medicas para
Arnaldo Andre.
*/
select distinct matricula from indicacionmedica i1 
where matricula not in(
	select matricula from paciente p,indicacionmedica i2
		where i2.tipoDoc = p.tipoDoc
          and i2.numeroDoc = p.numeroDoc
          and p.nombre = 'Arnaldo'
          and p.apellido = 'Andre'
);

/*
6. El plan con mayor cantidad de afiliados.---> pero si hay mas de uno??
*/

select obraSocial, plan
from afiliado
group by obraSocial, plan
having count(*)>= all(Select count(*)
 from afiliado
group by obraSocial, plan);

/* 
7. Para todos los pacientes con al menos una indicacion medica, el nombre y plan de su
 cobertura. En caso de no tener, indicar 'SIN COBERTURA' en ambos campos(Hipotesis tomada:
 1 paciente puede estar afiliado a 1 plan de una obra social o a ninguno).
*/
select nombre,apellido,obraSocial,plan
from paciente p, afiliado a
where  a.numeroDoc = p.numeroDoc
   and   a.tipoDoc = p.tipoDoc
   and   exists ( select * from indicacionmedica i
                       where i.tipoDoc = p.tipoDoc and i.numeroDoc = p.numeroDoc )
union
select  nombre,apellido, 'SIN COBERTURA', 'SIN COBERTURA'
from  paciente p
where   exists ( select * from indicacionmedica i
                       where i.tipoDoc = p.tipoDoc and i.numeroDoc = p.numeroDoc )
   and   not exists ( select * from afiliado a
                             where p.tipoDoc = a.tipoDoc and p.numeroDoc = a.numeroDoc );
/*
8. Para cada obra social, su promedio de cantidad de pacientes por plan.
*/
select obraSocial, count(*) /count(distinct(plan)) 'promedio'
    from afiliado
        group by ObraSocial;

/* 
9. El número de quirofano con la mayor cantidad de turnos reservados.
*/

select NumeroQuirofano
    from indicacionmedica
        group by NumeroQuirofano
            having count(*)>= all(Select count(*)
                from indicacionmedica
                    group by NumeroQuirofano);

/* 
10. Para todos los pacientes del sistema, la cantidad de indicaciones medicas que tiene
 (indicar 0 en caso 
 de no tener).
*/

select tipoDoc , numeroDoc, count(*) from indicacionmedica
    group by tipoDoc, numeroDoc
        union 
            select tipoDoc, numeroDoc, 0 from paciente p 
                where not exists (select tipoDoc, numeroDoc from indicacionmedica i 
                                    where i.tipoDoc = p.tipoDoc
                                        and i.numeroDoc = p.numeroDoc);
