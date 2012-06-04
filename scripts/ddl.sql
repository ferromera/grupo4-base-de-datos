SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE SCHEMA IF NOT EXISTS `grupo4` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `grupo4` ;

-- -----------------------------------------------------
-- Table `grupo4`.`entidad_financiera`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `grupo4`.`entidad_financiera` (
  `cod_entidad` INT NOT NULL ,
  `nombre` VARCHAR(100) NOT NULL ,
  CONSTRAINT `pk_entidad_financiera`
    PRIMARY KEY (`cod_entidad`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `grupo4`.`plan_de_cobertura`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `grupo4`.`plan_de_cobertura` (
  `cod_entidad` INT NOT NULL ,
  `numero_plan` INT NOT NULL ,
  `nombre` VARCHAR(100) NOT NULL ,
  CONSTRAINT `pk_plan_cobertura`
    PRIMARY KEY (`numero_plan`, `cod_entidad`) ,
  INDEX `fk_cod_entidad` (`cod_entidad` ASC) ,
  CONSTRAINT `fk_cod_entidad`
    FOREIGN KEY (`cod_entidad` )
    REFERENCES `grupo4`.`entidad_financiera` (`cod_entidad` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `grupo4`.`facturacion`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `grupo4`.`facturacion` (
  `nro_facturacion` INT NOT NULL ,
  `fecha` DATE NOT NULL ,
  `monto_total` INT NOT NULL ,
  CONSTRAINT `pk_facturacion`
    PRIMARY KEY (`nro_facturacion`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `grupo4`.`medico`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `grupo4`.`medico` (
  `matricula` INT NOT NULL ,
  `apellido` VARCHAR(100) NOT NULL ,
  `nombre` VARCHAR(100) NOT NULL ,
  CONSTRAINT `pk_medico`  
    PRIMARY KEY (`matricula`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `grupo4`.`paciente`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `grupo4`.`paciente` (
  `id_paciente` INT NOT NULL ,
  `nombre` VARCHAR(100) NOT NULL ,
  `apellido1` VARCHAR(100) NOT NULL ,
  `apellido2` VARCHAR(100) NOT NULL ,
  `tipo_documento` VARCHAR(100) NOT NULL ,
  `nro_documento` INT NOT NULL ,
  `condicion_iva` VARCHAR(100) NOT NULL ,
  CONSTRAINT `pk_paciente`
    PRIMARY KEY (`id_paciente`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `grupo4`.`solicitud_tentativa`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `grupo4`.`solicitud_tentativa` (
  `nro_solicitud` INT NOT NULL COMMENT '	' ,
  `estado` VARCHAR(100) NOT NULL ,
  CONSTRAINT `pk_solicitud`
    PRIMARY KEY (`nro_solicitud`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `grupo4`.`tipo_procedimiento_medico`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `grupo4`.`tipo_procedimiento_medico` (
  `codigo_procedimiento_medico` INT NOT NULL ,
  `nombre` VARCHAR(100) NOT NULL ,
  `duracion` INT NOT NULL ,
  `tecnica` VARCHAR(100) NOT NULL ,
  `precio` DOUBLE NOT NULL ,
  CONSTRAINT `pk_procedimiento_medico`
    PRIMARY KEY (`codigo_procedimiento_medico`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `grupo4`.`indicacion_medica`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `grupo4`.`indicacion_medica` (
  `nro_indicacion` INT NOT NULL ,
  `fecha_inicio` INT NOT NULL ,
  `hora_inicio` INT NOT NULL ,
  `tipo_anestesia` VARCHAR(100) NOT NULL ,
  `tiempo_anestesia` INT NOT NULL ,
  `matricula` INT NOT NULL ,
  `id_paciente` INT NOT NULL ,
  `nro_solicitud` INT NOT NULL ,
  `cod_cpt` INT NOT NULL ,
  `cod_entidad` INT NOT NULL ,
  `nro_plan` INT NOT NULL ,
  `consentimiento` TINYINT(1) NULL ,
  `autorización` TINYINT(1) NULL ,
  CONSTRAINT `pk_indicacion_medica`
    PRIMARY KEY (`nro_indicacion`) ,
  INDEX `fk_matricula` (`matricula` ASC) ,
  INDEX `fk_id_paciente` (`id_paciente` ASC) ,
  INDEX `fk_nro_solicitud` (`nro_solicitud` ASC) ,
  INDEX `fk_cod_cpt` (`cod_cpt` ASC) ,
  INDEX `fk_plan_ind_medica` (`nro_plan` ASC, `cod_entidad` ASC) ,
  CONSTRAINT `fk_matricula`
    FOREIGN KEY (`matricula` )
    REFERENCES `grupo4`.`medico` (`matricula` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_id_paciente`
    FOREIGN KEY (`id_paciente` )
    REFERENCES `grupo4`.`paciente` (`id_paciente` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_nro_solicitud`
    FOREIGN KEY (`nro_solicitud` )
    REFERENCES `grupo4`.`solicitud_tentativa` (`nro_solicitud` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cod_cpt`
    FOREIGN KEY (`cod_cpt` )
    REFERENCES `grupo4`.`tipo_procedimiento_medico` (`codigo_procedimiento_medico` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_plan_ind_medica`
    FOREIGN KEY (`nro_plan` , `cod_entidad` )
    REFERENCES `grupo4`.`plan_de_cobertura` (`numero_plan` , `cod_entidad` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `grupo4`.`historia_clinica`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `grupo4`.`historia_clinica` (
  `nro_historia` INT NOT NULL ,
  `datos_paciente` VARCHAR(100) NOT NULL ,
  `id_paciente` INT NOT NULL ,
  CONSTRAINT `pk_historia_clinica`
    PRIMARY KEY (`nro_historia`) ,
  INDEX `fk_id_paciente_historia_clinica` (`id_paciente` ASC) ,
  CONSTRAINT `fk_id_paciente_historia_clinica`
    FOREIGN KEY (`id_paciente` )
    REFERENCES `grupo4`.`paciente` (`id_paciente` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `grupo4`.`episodio`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `grupo4`.`episodio` (
  `cod_episodio` INT NOT NULL ,
  `nro_historia` INT NOT NULL ,
  `fecha_episodio` INT NOT NULL ,
  `descripcion_episodio` VARCHAR(100) NOT NULL ,
  `matricula` INT NOT NULL ,
  CONSTRAINT `pk_episodio`
    PRIMARY KEY (`cod_episodio`, `nro_historia`) ,
  INDEX `fk_nro_historia_episodio` (`nro_historia` ASC) ,
  INDEX `fk_matricula_episodio` (`matricula` ASC) ,
  CONSTRAINT `fk_nro_historia_episodio`
    FOREIGN KEY (`nro_historia` )
    REFERENCES `grupo4`.`historia_clinica` (`nro_historia` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_matricula_episodio`
    FOREIGN KEY (`matricula` )
    REFERENCES `grupo4`.`medico` (`matricula` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `grupo4`.`recurso`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `grupo4`.`recurso` (
  `cod_recurso` INT NOT NULL ,
  `nombre_recurso` VARCHAR(100) NOT NULL ,
  CONSTRAINT `pk_recurso`
    PRIMARY KEY (`cod_recurso`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `grupo4`.`tiene`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `grupo4`.`tiene` (
  `id_paciente` INT NOT NULL ,
  `cod_entidad` INT NOT NULL ,
  `nro_plan` INT NOT NULL ,
  `tipo_extension` VARCHAR(100) NOT NULL ,
  `tipo_beneficiario` VARCHAR(100) NOT NULL ,
  `nro_afiliado` INT NOT NULL ,
  CONSTRAINT `pk_tiene`
    PRIMARY KEY (`id_paciente`, `nro_plan`, `cod_entidad`) ,
  INDEX `fk_id_paciente_tiene` (`id_paciente` ASC) ,
  INDEX `fk_cod_entidad_nro_plan_tiene` (`nro_plan` ASC, `cod_entidad` ASC) ,
  CONSTRAINT `fk_id_paciente_tiene`
    FOREIGN KEY (`id_paciente` )
    REFERENCES `grupo4`.`paciente` (`id_paciente` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cod_entidad_nro_plan_tiene`
    FOREIGN KEY (`nro_plan` , `cod_entidad` )
    REFERENCES `grupo4`.`plan_de_cobertura` (`numero_plan` , `cod_entidad` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `grupo4`.`cubre`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `grupo4`.`cubre` (
  `cod_cpt` INT NOT NULL ,
  `cod_entidad` INT NOT NULL ,
  `fk_nro_plan_cubre` INT NOT NULL ,
  `autorizacion` VARCHAR(100) NOT NULL ,
  `bono` DOUBLE NOT NULL ,
  `monto_copago` DOUBLE NOT NULL ,
  CONSTRAINT `pk_cubre`
    PRIMARY KEY (`cod_cpt`, `fk_nro_plan_cubre`, `cod_entidad`) ,
  INDEX `fk_cod_cpt_cubre` (`cod_cpt` ASC) ,
  INDEX `fk_cod_entidad_nro_plan_cubre` (`fk_nro_plan_cubre` ASC, `cod_entidad` ASC) ,
  CONSTRAINT `fk_cod_cpt_cubre`
    FOREIGN KEY (`cod_cpt` )
    REFERENCES `grupo4`.`tipo_procedimiento_medico` (`codigo_procedimiento_medico` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cod_entidad_nro_plan_cubre`
    FOREIGN KEY (`fk_nro_plan_cubre` , `cod_entidad` )
    REFERENCES `grupo4`.`plan_de_cobertura` (`numero_plan` , `cod_entidad` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `grupo4`.`requiere`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `grupo4`.`requiere` (
  `cod_recurso` INT NOT NULL ,
  `nro_indicacion` INT NOT NULL ,
  CONSTRAINT `pk_requiere`
    PRIMARY KEY (`cod_recurso`, `nro_indicacion`) ,
  INDEX `fk_cod_recurso` (`cod_recurso` ASC) ,
  INDEX `fk_nro_indicacion_requiere` (`nro_indicacion` ASC) ,
  CONSTRAINT `fk_cod_recurso`
    FOREIGN KEY (`cod_recurso` )
    REFERENCES `grupo4`.`recurso` (`cod_recurso` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_nro_indicacion_requiere`
    FOREIGN KEY (`nro_indicacion` )
    REFERENCES `grupo4`.`indicacion_medica` (`nro_indicacion` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `grupo4`.`quirofano`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `grupo4`.`quirofano` (
  `nro_quirofano` INT NOT NULL ,
  `piso` INT NOT NULL ,
  `sector` VARCHAR(100) NOT NULL ,
  `hora_apertura` INT NOT NULL ,
  `hora_cierre` INT NOT NULL ,
  CONSTRAINT `pk_quirofano`
    PRIMARY KEY (`nro_quirofano`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `grupo4`.`turno_anulado`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `grupo4`.`turno_anulado` (
  `id_turno_anulado` INT NOT NULL ,
  `fecha_inicio` INT NOT NULL ,
  `hora_inicio` INT NOT NULL ,
  `nro_quirofano` INT NOT NULL ,
  `fecha_fin` INT NOT NULL ,
  `hora_fin` INT NOT NULL ,
  `nro_solicitud` INT NOT NULL ,
  CONSTRAINT `pk_turno_anulado`
    PRIMARY KEY (`id_turno_anulado`) ,
  INDEX `fk_nro_quirofano` (`nro_quirofano` ASC) ,
  INDEX `fk_solicitud_turno_anulado` (`nro_solicitud` ASC) ,
  CONSTRAINT `fk_nro_quirofano`
    FOREIGN KEY (`nro_quirofano` )
    REFERENCES `grupo4`.`quirofano` (`nro_quirofano` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_solicitud_turno_anulado`
    FOREIGN KEY (`nro_solicitud` )
    REFERENCES `grupo4`.`solicitud_tentativa` (`nro_solicitud` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `grupo4`.`turno`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `grupo4`.`turno` (
  `fecha_inicio` INT NOT NULL ,
  `hora_inicio` INT NOT NULL ,
  `nro_quirofano` INT NOT NULL ,
  `hora_fin` INT NOT NULL ,
  `fecha_fin` INT NOT NULL ,
  `nro_solicitud` INT NOT NULL ,
  CONSTRAINT `pk_turno`
    PRIMARY KEY (`fecha_inicio`, `nro_quirofano`, `hora_inicio`) ,
  INDEX `fk_nro_quirofano_turno` (`nro_quirofano` ASC) ,
  INDEX `fk_solicitud_turno` (`nro_solicitud` ASC) ,
  CONSTRAINT `fk_nro_quirofano_turno`
    FOREIGN KEY (`nro_quirofano` )
    REFERENCES `grupo4`.`quirofano` (`nro_quirofano` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_solicitud_turno`
    FOREIGN KEY (`nro_solicitud` )
    REFERENCES `grupo4`.`solicitud_tentativa` (`nro_solicitud` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `grupo4`.`condicion`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `grupo4`.`condicion` (
  `codigo_condicion` INT NOT NULL ,
  `descripcion` VARCHAR(100) NOT NULL ,
  CONSTRAINT `pk_condicion`
    PRIMARY KEY (`codigo_condicion`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `grupo4`.`condiciones_necesarias`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `grupo4`.`condiciones_necesarias` (
  `codigo_procedimiento_medico` INT NOT NULL ,
  `codigo_condicion` INT NOT NULL ,
  CONSTRAINT `pk_condiciones_necesarias`
    PRIMARY KEY (`codigo_procedimiento_medico`, `codigo_condicion`) ,
  INDEX `fk_codigo_procedimiento_medico` (`codigo_procedimiento_medico` ASC) ,
  INDEX `fk_codigo_condicion` (`codigo_condicion` ASC) ,
  CONSTRAINT `fk_codigo_procedimiento_medico`
    FOREIGN KEY (`codigo_procedimiento_medico` )
    REFERENCES `grupo4`.`tipo_procedimiento_medico` (`codigo_procedimiento_medico` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_codigo_condicion`
    FOREIGN KEY (`codigo_condicion` )
    REFERENCES `grupo4`.`condicion` (`codigo_condicion` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `grupo4`.`pago_paciente`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `grupo4`.`pago_paciente` (
  `nro_indicacion` INT NOT NULL ,
  `copago_cobrado` DOUBLE NOT NULL ,
  `bono_recibido` DOUBLE NOT NULL ,
  CONSTRAINT `pk_pago_paciente`
    PRIMARY KEY (`nro_indicacion`) ,
  INDEX `fk_nro_indicacion_pago_paciente` (`nro_indicacion` ASC) ,
  CONSTRAINT `fk_nro_indicacion_pago_paciente`
    FOREIGN KEY (`nro_indicacion` )
    REFERENCES `grupo4`.`indicacion_medica` (`nro_indicacion` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `grupo4`.`detalle_factura`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `grupo4`.`detalle_factura` (
  `nro_facturacion` INT NOT NULL ,
  `nro_indicacion` INT NOT NULL ,
  `monto` INT NOT NULL ,
  `nro_item` INT NOT NULL ,
  `fecha` DATE NOT NULL ,
  CONSTRAINT `pk_detalle_factura`
    PRIMARY KEY (`nro_facturacion`, `nro_item`) ,
  INDEX `fk_nro_indicacion_factura` (`nro_indicacion` ASC) ,
  INDEX `fk_nro_facturacion_factura` (`nro_facturacion` ASC) ,
  CONSTRAINT `fk_nro_indicacion_factura`
    FOREIGN KEY (`nro_indicacion` )
    REFERENCES `grupo4`.`indicacion_medica` (`nro_indicacion` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_nro_facturacion_factura`
    FOREIGN KEY (`nro_facturacion` )
    REFERENCES `grupo4`.`facturacion` (`nro_facturacion` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
