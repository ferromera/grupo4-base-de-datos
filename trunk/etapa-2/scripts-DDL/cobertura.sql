DROP TABLE IF EXISTS `base_datos`.`cobertura`;
CREATE TABLE  `base_datos`.`cobertura` (
  `nro_afiliado` int(10) unsigned NOT NULL,
  `tipo_beneficiario` varchar(100) NOT NULL,
  `tipo_cobertura` varchar(100) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;