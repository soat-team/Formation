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
ENGINE = InnoDB