DROP TABLE IF EXISTS `base_datos`.`quirofano`;
CREATE TABLE  `base_datos`.`quirofano` (
  `lugar` varchar(100) NOT NULL,
  `piso` int(10) unsigned NOT NULL,
  `especialidad` varchar(100) NOT NULL,
  PRIMARY KEY (`lugar`,`piso`,`especialidad`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;