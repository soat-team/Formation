ALTER TABLE visite ADD id_client INT(11) NOT NULL;
ALTER TABLE visite ADD FOREIGN KEY (id_client) REFERENCES Client('idclient');
