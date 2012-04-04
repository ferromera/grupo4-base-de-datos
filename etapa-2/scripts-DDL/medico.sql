DROP TABLE IF EXISTS `base_datos`.`medico`;
CREATE TABLE  `base_datos`.`medico` (
  `nro_matricula` int(10) unsigned NOT NULL,
  `nombre_apellido` varchar(100) NOT NULL,
  `telefono` varchar(30) DEFAULT NULL,
  `domicilio` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`nro_matricula`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;