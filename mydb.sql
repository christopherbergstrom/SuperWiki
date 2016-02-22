-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mydb` ;

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET latin1 ;
SHOW WARNINGS;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `user` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(16) NOT NULL,
  `email` VARCHAR(255) NULL DEFAULT NULL,
  `password` VARCHAR(32) NOT NULL,
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

SHOW WARNINGS;
CREATE UNIQUE INDEX `username_UNIQUE` ON `user` (`username` ASC);

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `comment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `comment` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `comment` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `user_id` INT(11) NOT NULL,
  `message` VARCHAR(145) NULL DEFAULT NULL,
  `created` DATETIME NOT NULL,
  PRIMARY KEY (`id`, `user_id`),
  CONSTRAINT `id`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

SHOW WARNINGS;
CREATE INDEX `id_idx` ON `comment` (`user_id` ASC);

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `teams`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `teams` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `teams` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = latin1;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `superpersons`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `superpersons` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `superpersons` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `alias_names` VARCHAR(45) NULL DEFAULT NULL,
  `Created` YEAR NULL DEFAULT NULL,
  `Creator` VARCHAR(45) NULL DEFAULT NULL,
  `Team_id` INT(11) NULL DEFAULT NULL,
  `appearance` VARCHAR(1600) NULL DEFAULT NULL,
  `costume` VARCHAR(1600) NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `alias_name`
    FOREIGN KEY (`Team_id`)
    REFERENCES `teams` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = latin1;

SHOW WARNINGS;
CREATE INDEX `fk_Superhero_Team_idx` ON `superpersons` (`Team_id` ASC);

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `nemesis`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `nemesis` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `nemesis` (
  `superperson_id` INT(11) NOT NULL,
  `nemesis_id` INT(11) NOT NULL,
  CONSTRAINT `fk_Superperson_superperson`
    FOREIGN KEY (`superperson_id`)
    REFERENCES `superpersons` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_nemesis_superperson`
    FOREIGN KEY (`nemesis_id`)
    REFERENCES `superpersons` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

SHOW WARNINGS;
CREATE INDEX `fk_Superhero_has_Villain_Superhero1_idx` ON `nemesis` (`superperson_id` ASC);

SHOW WARNINGS;
CREATE INDEX `fk_nemesis_superperson_idx` ON `nemesis` (`nemesis_id` ASC);

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `supertypes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `supertypes` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `supertypes` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `superpersontypes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `superpersontypes` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `superpersontypes` (
  `supertype_id` INT NOT NULL,
  `superperson_id` INT(11) NOT NULL,
  `startYear` YEAR NOT NULL,
  `endYear` YEAR NULL,
  PRIMARY KEY (`supertype_id`, `superperson_id`),
  CONSTRAINT `fk_supertype_has_superperson_supertype1`
    FOREIGN KEY (`supertype_id`)
    REFERENCES `supertypes` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_supertype_has_superperson_superperson1`
    FOREIGN KEY (`superperson_id`)
    REFERENCES `superpersons` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;
CREATE INDEX `fk_supertype_has_superperson_superperson1_idx` ON `superpersontypes` (`superperson_id` ASC);

SHOW WARNINGS;
CREATE INDEX `fk_supertype_has_superperson_supertype1_idx` ON `superpersontypes` (`supertype_id` ASC);

SHOW WARNINGS;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `teams`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `teams` (`id`, `name`) VALUES (1, 'Avengers');

COMMIT;


-- -----------------------------------------------------
-- Data for table `superpersons`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `superpersons` (`id`, `name`, `alias_names`, `Created`, `Creator`, `Team_id`, `appearance`, `costume`) VALUES (1, 'Iron Man', NULL, 1963, 'Stan Lee', 1, NULL, NULL);
INSERT INTO `superpersons` (`id`, `name`, `alias_names`, `Created`, `Creator`, `Team_id`, `appearance`, `costume`) VALUES (2, 'Captain America', NULL, 1941, 'Stan Lee', 1, NULL, NULL);
INSERT INTO `superpersons` (`id`, `name`, `alias_names`, `Created`, `Creator`, `Team_id`, `appearance`, `costume`) VALUES (3, 'Hulk', NULL, 1962, 'Stan Lee', 1, NULL, NULL);
INSERT INTO `superpersons` (`id`, `name`, `alias_names`, `Created`, `Creator`, `Team_id`, `appearance`, `costume`) VALUES (4, 'Thor', NULL, 1951, 'Stan Lee', 1, NULL, NULL);
INSERT INTO `superpersons` (`id`, `name`, `alias_names`, `Created`, `Creator`, `Team_id`, `appearance`, `costume`) VALUES (5, 'Black Widow', NULL, 1964, 'Stan Lee', 1, NULL, NULL);
INSERT INTO `superpersons` (`id`, `name`, `alias_names`, `Created`, `Creator`, `Team_id`, `appearance`, `costume`) VALUES (6, 'Hawkeye', NULL, 1964, 'Stan Lee', 1, NULL, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `supertypes`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `supertypes` (`id`, `name`) VALUES (1, 'superhero');
INSERT INTO `supertypes` (`id`, `name`) VALUES (2, 'villain');

COMMIT;

