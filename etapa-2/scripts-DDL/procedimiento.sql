DROP TABLE IF EXISTS `base_datos`.`procedimiento`;
CREATE TABLE  `base_datos`.`procedimiento` (
  `codigo` int(10) unsigned NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `tecnica` varchar(100) DEFAULT NULL,
  `tiempo` int(10) unsigned DEFAULT NULL,
  `condiciones` varchar(100) DEFAULT NULL,
  `recursos_necesarios` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;