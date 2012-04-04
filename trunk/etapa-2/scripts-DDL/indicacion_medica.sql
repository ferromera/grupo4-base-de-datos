DROP TABLE IF EXISTS `base_datos`.`indicacion_medica`;
CREATE TABLE  `base_datos`.`indicacion_medica` (
  `tipo_anestesia` varchar(100) NOT NULL,
  `fecha_hora` datetime NOT NULL,
  PRIMARY KEY (`tipo_anestesia`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;