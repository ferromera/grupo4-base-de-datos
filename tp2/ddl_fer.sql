/*Tablas que use para probar las consultas*/

CREATE DATABASE `tp2` /*!40100 DEFAULT CHARACTER SET latin1 */;

CREATE SCHEMA IF NOT EXISTS `tp2` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `tp2` ;


CREATE TABLE `tp2`.`paciente` (
`NumeroDoc` int(11) NOT NULL,
`TipoDoc` varchar(45) NOT NULL,
`Nombre` varchar(45) DEFAULT NULL,
`Apellido` varchar(45) DEFAULT NULL,
CONSTRAINT `pk_paciente`
PRIMARY KEY (`NumeroDoc`,`TipoDoc`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `tp2`.`afiliado` (
`NumeroAfiliado` int(11) NOT NULL,
`TipoBeneficiario` varchar(45) DEFAULT NULL,
`Plan` varchar(45) DEFAULT NULL,
`ObraSocial` varchar(45) NOT NULL,
`TipoDoc` varchar(45) NOT NULL,
`NumeroDoc` int(11) NOT NULL,
CONSTRAINT `pk_afiliado`
PRIMARY KEY (`NumeroAfiliado`,`ObraSocial`),
CONSTRAINT `fk_paciente_afiliado` 
    FOREIGN KEY (`NumeroDoc`,`TipoDoc`) REFERENCES `tp2`.`paciente`(`NumeroDoc`,`TipoDoc`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `tp2`.`cpt` (
`CodigoCPT` int(11) NOT NULL,
`Descripcion` varchar(45) DEFAULT NULL,
PRIMARY KEY (`CodigoCPT`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `tp2`.`indicacionmedica` (
`NumeroDoc` int(11) NOT NULL,
`TipoDoc` varchar(45) NOT NULL,
`Matricula` int(11) NOT NULL,
`Fecha` int(11) NOT NULL,
`Hora` int(11) NOT NULL,
`CodigoCPT` int(11) NOT NULL,
`NumeroQuirofano` int(11) DEFAULT NULL,
PRIMARY KEY (`NumeroDoc`,`TipoDoc`,`Fecha`,`Matricula`,`Hora`),
CONSTRAINT `fk_paciente_indicacion` 
    FOREIGN KEY (`NumeroDoc`,`TipoDoc`) REFERENCES `tp2`.`paciente`(`NumeroDoc`,`TipoDoc`),
CONSTRAINT `fk_cpt_indicacion` 
    FOREIGN KEY (`CodigoCPT`) REFERENCES `tp2`.`cpt`(`CodigoCPT`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



