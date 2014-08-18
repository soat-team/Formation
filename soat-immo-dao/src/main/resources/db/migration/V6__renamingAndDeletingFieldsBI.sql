#BienImmo
ALTER TABLE Visite DROP FOREIGN KEY id_bien_immobilier;
ALTER TABLE BienImmobilier CHANGE idbien_immobilier idBienImmo BIGINT NOT NULL AUTO_INCREMENT;
ALTER TABLE BienImmobilier CHANGE nb_pieces nbPieces SMALLINT NULL;
ALTER TABLE BienImmobilier CHANGE type_chauffage typeChauffage VARCHAR(15) NULL;
ALTER TABLE BienImmobilier CHANGE type_production_eau_chaude typeProdEauChaude VARCHAR(10) NULL;
ALTER TABLE BienImmobilier CHANGE date_disponibilite dateDisponibilite DATE NULL;
ALTER TABLE BienImmobilier CHANGE annonce_active active tinyint(1) NULL;
ALTER TABLE BienImmobilier CHANGE publication_site_web published tinyint(1) NULL;
ALTER TABLE BienImmobilier CHANGE publication_seLoger publishedSeLoger tinyint(1) NULL;

ALTER TABLE BienImmobilier MODIFY etage SMALLINT;
ALTER TABLE BienImmobilier MODIFY type VARCHAR(6);