DROP TABLE IF EXISTS `base_datos`.`turno`;
CREATE TABLE  `base_datos`.`turno` (
  `fecha_hora` datetime NOT NULL,
  `lugar` varchar(100) NOT NULL,
  `piso` int(10) unsigned NOT NULL,
  `especialidad` varchar(100) NOT NULL,
  PRIMARY KEY (`fecha_hora`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;