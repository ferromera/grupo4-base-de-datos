DROP TABLE IF EXISTS `base_datos`.`solicitud`;
CREATE TABLE  `base_datos`.`solicitud` (
  `nro_solicitud` int(10) unsigned NOT NULL,
  `firmante` varchar(100) NOT NULL,
  `estado` varchar(1) NOT NULL,
  PRIMARY KEY (`nro_solicitud`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;