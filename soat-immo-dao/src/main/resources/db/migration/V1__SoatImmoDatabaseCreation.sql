CREATE TABLE Photo(
  idPhoto BIGINT NOT NULL,
  photoUrl VARCHAR(128),
  PRIMARY KEY (idPhoto)
);

CREATE TABLE USER(
  idUser BIGINT NOT NULL,
  login VARCHAR(16),
  password VARCHAR(40),
  PRIMARY KEY (idUser)
);

CREATE TABLE Agent(
  idAgent BIGINT NOT NULL,
  nom VARCHAR(32),
  prenom VARCHAR(32),
  userId BIGINT NOT NULL,

  PRIMARY KEY (idagent),
  FOREIGN KEY (userId) REFERENCES USER(idUser)
);

CREATE TABLE Client(
  idclient BIGINT NOT NULL,
  nom VARCHAR (32),
  prenom VARCHAR(32),
  dateNaissance  TIMESTAMP NULL,
  salaire DOUBLE NULL,
  periodEssai tinyint(1) NULL,
  userId BIGINT NOT NULL,

  PRIMARY KEY (idclient),
  FOREIGN KEY (userId) REFERENCES USER(idUser)
);

CREATE TABLE BienImmobilier(
  idBien BIGINT NOT NULL,
  type VARCHAR (8),
  adresse VARCHAR(32) NULL,
  surface VARCHAR(8) NULL,
  nbPieces smallint NULL,
  etage smallint NULL,
  ascenseur tinyint(1) NULL,
  typeChauffage VARCHAR(16),
  typeProdEauChaude VARCHAR(16),
  loyer DOUBLE NULL,
  charges DOUBLE NULL,
  dateDisponibilite TIMESTAMP NULL,
  active tinyint(1) NULL,
  published tinyint(1) NULL,
  publishedSeLoger tinyint(1),
  description TEXT ,

  PRIMARY KEY (idBien)
);

CREATE TABLE BI_PHOTOS(
  idBien BIGINT NOT NULL,
  idPhoto BIGINT NOT NULL,

  FOREIGN KEY (idBien) REFERENCES BienImmobilier(idBien),
  FOREIGN KEY (idPhoto) REFERENCES Photo(idPhoto)
);

CREATE TABLE Visite(
  idVisite BIGINT NOT NULL PRIMARY KEY ,
  id_bien_immo BIGINT NOT NULL,
  id_agent BIGINT NOT NULL,
  id_client BIGINT NOT NULL,
  dateVisite TIMESTAMP NOT NULL ,
  heureDebut TIMESTAMP NOT NULL,
  heureFin TIMESTAMP NOT NULL,

  FOREIGN KEY (id_bien_immo) REFERENCES BienImmobilier(idBien),
  FOREIGN KEY (id_agent) REFERENCES Agent(idAgent),
  FOREIGN KEY (id_client) REFERENCES Client(idclient)
);

COMMIT;


