-- MySQL Script generated by MySQL Workbench
-- Thu Apr 27 22:35:38 2023
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema sistema-carros
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema sistema-carros
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `sistema-carros` DEFAULT CHARACTER SET utf8 ;
USE `sistema-carros` ;

-- -----------------------------------------------------
-- Table `sistema-carros`.`carro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sistema-carros`.`carro` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `modelo` VARCHAR(45) NOT NULL,
  `fabricante` VARCHAR(45) NOT NULL,
  `cor` VARCHAR(45) NOT NULL,
  `ano` DATE NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sistema-carros`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sistema-carros`.`usuario` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;