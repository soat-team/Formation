ALTER TABLE BienImmobilier CHANGE COLUMN idbien_immobilier idBienImmo BIGINT NOT NULL AUTO_INCREMENT;
ALTER TABLE BienImmobilier CHANGE COLUMN nb_pieces nbPieces SMALLINT NULL;
ALTER TABLE BienImmobilier CHANGE COLUMN type_chauffage typeChauffage VARCHAR(15) NULL;
ALTER TABLE BienImmobilier CHANGE COLUMN type_production_eau_chaude typeProdEauChaude VARCHAR(10) NULL;
ALTER TABLE BienImmobilier CHANGE COLUMN date_disponibilite dateDisponibilite DATE NULL;
ALTER TABLE BienImmobilier CHANGE COLUMN annonce_active active tinyint(1) NULL;
ALTER TABLE BienImmobilier CHANGE COLUMN publication_site_web published tinyint(1) NULL;
ALTER TABLE BienImmobilier CHANGE COLUMN  publication_seLoger publishedSeLoger tinyint(1) NULL;

ALTER TABLE BienImmobilier MODIFY etage SMALLINT;
ALTER TABLE BienImmobilier MODIFY type VARCHAR(6);