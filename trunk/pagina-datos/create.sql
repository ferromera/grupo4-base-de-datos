 DROP TABLE IF EXISTS `entrega-2`.`afiliado`;
 CREATE TABLE  `entrega-2`.`afiliado` (
   `TipoDoc` varchar(5) NOT NULL,
   `NumeroDoc` int(10) unsigned NOT NULL,
   `ObraSocial` varchar(10) NOT NULL,
   `Plan` varchar(10) NOT NULL,
   `NumeroAfiliado` int(10) unsigned NOT NULL,
   `TipoBeneficiario` varchar(20) NOT NULL,
   PRIMARY KEY (`NumeroAfiliado`,`ObraSocial`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



DROP TABLE IF EXISTS `entrega-2`.`cpt`;
CREATE TABLE  `entrega-2`.`cpt` (
  `CodigoCPT` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Descripcion` varchar(100) NOT NULL,
  PRIMARY KEY (`CodigoCPT`)
) ENGINE=InnoDB AUTO_INCREMENT=99215 DEFAULT CHARSET=utf8;



DROP TABLE IF EXISTS `entrega-2`.`indicacionmedica`;
CREATE TABLE  `entrega-2`.`indicacionmedica` (
  `TipoDoc` varchar(5) NOT NULL,
  `NumeroDoc` int(10) unsigned NOT NULL,
  `Matricula` int(10) unsigned NOT NULL,
  `Fecha` int(10) unsigned NOT NULL,
  `Hora` int(10) unsigned NOT NULL,
  `CodigoCPT` int(10) unsigned NOT NULL,
  `NumeroQuirofano` int(10) unsigned NOT NULL,
  PRIMARY KEY (`CodigoCPT`,`NumeroDoc`,`NumeroQuirofano`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `entrega-2`.`paciente`;
CREATE TABLE  `entrega-2`.`paciente` (
  `TipoDoc` varchar(5) NOT NULL,
  `NumeroDoc` int(10) unsigned NOT NULL,
  `Nombre` varchar(45) NOT NULL,
  `Apellido` varchar(45) NOT NULL,
  PRIMARY KEY (`NumeroDoc`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;