/*
1. Matriculas de los profesionales que unicamente tienen indicaciones
antes del 30 / 5 / 2012.
*/
select distinct(r1.matricula) from indicacionmedica r1 where r1.fecha < '20120530';
/*
2. Tipo de documento Numero de documento y Nombre de las personas
que tienen un mismo numero de afiliado en distintas obras sociales
(evitar pares duplicados).
*/
select r1.tipodoc,r1.numerodoc,r1.nombre from paciente r1 ,afiliado r2 
where r1.numerodoc = r2.numerodoc
and r1.tipodoc = r2.tipodoc
group by r2.numeroafiliado
having count(*)>1;
/*
4. Matriculas de los profesionales que tienen indicaciones medicas para
todos los CPT.
*/
--matriculas para los cuales no existe CPT que no este en indicacion medica
select r1.matricula from indicacionmedica r1 where not exists (
	select * from cpt r2 where 
		not exists (
			select * from indicacionmedica r3
			where r3.codigoCpt = r2.codigoCpt
		)
)