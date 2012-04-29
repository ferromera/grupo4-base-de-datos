select p.cod_entidad, e.nombre, sum(f.monto) from entidad_financiera e, facturacion f, plan_cobertura p
    where e.cod_entidad = p.cod_entidad 
        and p.cod_entidad = f.cod_entidad 
            and p.numero_plan = f.nro_plan
                group by p.cod_entidad, e.nombre; 