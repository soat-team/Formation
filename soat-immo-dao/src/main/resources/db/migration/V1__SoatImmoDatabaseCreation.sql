CREATE SCHEMA IF NOT EXISTS `SoatImmo` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;


CREATE TABLE IF NOT EXISTS `SoatImmo`.`bien_immobilier` (
  `idbien_immobilier` INT NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(45) NULL,
  `adresse` VARCHAR(100) NULL,
  `surface` VARCHAR(45) NULL,
  `nb_pieces` INT NULL,
  `etage` INT NULL,
  `ascenseur` TINYINT(1) NULL,
  `type_chauffage` VARCHAR(45) NULL,
  `type_production_eau_chaude` VARCHAR(45) NULL,
  `loyer` DOUBLE NULL,
  `charges` DOUBLE NULL,
  `date_disponibilite` DATETIME NULL,
  `annonce_active` TINYINT(1) NULL,
  `publication_site_web` TINYINT(1) NULL,
  `publication_seLoger` TINYINT(1) NULL,
  `url_photo` VARCHAR(45) NULL,
  PRIMARY KEY (`idbien_immobilier`))
  ENGINE = InnoDB;


  CREATE TABLE IF NOT EXISTS `SoatImmo`.`client` (
  `idclient` INT NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(45) NULL,
  `prenom` VARCHAR(45) NULL,
  `date_de_naissance` DATETIME NULL,
  `salaire` VARCHAR(45) NULL,
  `periode_essai` TINYINT(1) NULL,
  `criteres_recherche` VARCHAR(100) NULL,
  PRIMARY KEY (`idclient`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `SoatImmo`.`agent` (
  `idagent` INT NOT NULL,
  `nom` VARCHAR(45) NOT NULL,
  `prenom` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idagent`))
  ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `SoatImmo`.`visite` (
  `idvisite` INT NOT NULL,
  `heure_debut` DATETIME NOT NULL,
  `heure_fin` DATETIME NOT NULL,
  `id_agent` INT NOT NULL,
  `id_bien_immo` INT NOT NULL,
  PRIMARY KEY (`idvisite`),
  INDEX `id_agent_idx` (`id_agent` ASC),
  INDEX `id_bien_immobilier_idx` (`id_bien_immo` ASC),
  CONSTRAINT `id_agent`
    FOREIGN KEY (`id_agent`)
    REFERENCES `SoatImmo`.`agent` (`idagent`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `id_bien_immobilier`
    FOREIGN KEY (`id_bien_immo`)
    REFERENCES `SoatImmo`.`bien_immobilier` (`idbien_immobilier`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
