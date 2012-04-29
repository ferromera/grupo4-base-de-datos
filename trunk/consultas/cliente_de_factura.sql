select p.* from facturacion as f , indicacion_medica as i, paciente as p
 where f.nro_indicacion = i.nro_indicacion 
    and p.id_paciente = i.id_paciente
     and f.nro_facturacion = 1;