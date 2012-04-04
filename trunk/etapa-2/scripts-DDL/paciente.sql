DROP TABLE IF EXISTS `base_datos`.`paciente`;
CREATE TABLE  `base_datos`.`paciente` (
  `dni` integer unsigned NOT NULL,
  `nombre_apellido` varchar(100) NOT NULL,
  `telefono` varchar(30) DEFAULT NULL,
  `domicilio` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`dni`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;