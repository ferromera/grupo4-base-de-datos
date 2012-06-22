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
3-
select r2.numerodoc from afiliado r2
where exists (

select max(numeroafiliado),obrasocial from afiliado r1
group by r1.obrasocial
having r1.obrasocial = r2.obrasocial and r2.numeroafiliado = max(numeroafiliado)
);


select * from paciente p where exists(

select numerodoc from afiliado a where numerodoc not in (
select r2.numerodoc from afiliado r2, afiliado r1
where r2.numeroafiliado < r1.numeroafiliado and r1.obrasocial = r2.obrasocial
)
and a.tipodoc = p.tipodoc and a.numerodoc = p.numerodoc);

/*
4. Matriculas de los profesionales que tienen indicaciones medicas para
todos los CPT.
*/
--matriculas para los cuales no existe CPT que no este en indicacion medica
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
select r1.matricula from indicacionmedica r1 where not exists (
			select * from paciente r2
			where r2.tipoDoc = r1.tipoDoc
      and r2.numeroDoc = r1.numeroDoc
      and r2.nombre = 'Arnaldo'
      and r2.apellido = 'Andre'
)

/*
6. El plan con mayor cantidad de afiliados.---> pero si hay mas de uno??
*/
/*
8. Para cada obra social, su promedio de cantidad de pacientes por plan.
*/
SELECT r1.obrasocial,r1.plan,count(*) cantidad_por_os FROM afiliado r1
group by r1.obrasocial,r1.plan


UTIL
SELECT plan FROM afiliado a
group by plan
having count(*)=1