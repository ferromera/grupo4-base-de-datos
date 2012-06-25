SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';


-- -----------------------------------------------------
-- Table `tp2Indicaciones`.`cpt`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `tp2Indicaciones`.`cpt` (
  `codigoCPT` INT NOT NULL ,
  `descripcion` VARCHAR(100) NULL ,
  PRIMARY KEY (`codigoCPT`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tp2Indicaciones`.`paciente`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `tp2Indicaciones`.`paciente` (
  `tipoDoc` VARCHAR(5) NOT NULL ,
  `numeroDoc` INT NOT NULL ,
  `nombre` VARCHAR(100) NULL ,
  `apellido` VARCHAR(100) NULL ,
  PRIMARY KEY (`tipoDoc`, `numeroDoc`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tp2Indicaciones`.`indicacionMedica`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `tp2Indicaciones`.`indicacionMedica` (
  `tipoDoc` VARCHAR(5) NOT NULL ,
  `numeroDoc` INT NOT NULL ,
  `matricula` VARCHAR(45) NOT NULL ,
  `fecha` DATETIME NOT NULL ,
  `hora` TIME NOT NULL ,
  `codigoCPT` INT NULL ,
  `numeroQuirofano` INT NULL ,
  PRIMARY KEY (`tipoDoc`, `numeroDoc`, `fecha`, `matricula`, `hora`) ,
  INDEX `fk_cpt_indicacion` (`codigoCPT` ASC) ,
  INDEX `fk_paciente_indicacion` (`tipoDoc` ASC, `numeroDoc` ASC) ,
  CONSTRAINT `fk_cpt_indicacion`
    FOREIGN KEY (`codigoCPT` )
    REFERENCES `tp2Indicaciones`.`cpt` (`codigoCPT` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_paciente_indicacion`
    FOREIGN KEY (`tipoDoc` , `numeroDoc` )
    REFERENCES `tp2Indicaciones`.`paciente` (`tipoDoc` , `numeroDoc` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tp2Indicaciones`.`afiliado`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `tp2Indicaciones`.`afiliado` (
  `obraSocial` VARCHAR(100) NOT NULL ,
  `numeroAfiliado` INT NOT NULL ,
  `tipoDoc` VARCHAR(5) NULL ,
  `numeroDoc` INT NULL ,
  `plan` VARCHAR(100) NULL ,
  `tipoBeneficiario` VARCHAR(45) NULL ,
  PRIMARY KEY (`obraSocial`, `numeroAfiliado`) ,
  INDEX `fk_paciente_afiliado` (`tipoDoc` ASC, `numeroDoc` ASC) ,
  CONSTRAINT `fk_paciente_afiliado`
    FOREIGN KEY (`tipoDoc` , `numeroDoc` )
    REFERENCES `tp2Indicaciones`.`paciente` (`tipoDoc` , `numeroDoc` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
