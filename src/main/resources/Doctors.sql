drop table Doctor if exists;
create table Doctor(
  ID varchar(36) default(uuid()),
  license int,
  NAME varchar(100) not null,
  PRIMARY KEY (ID)
);

drop index Doctor if exists;
CREATE INDEX idx_doctor ON Doctor (ID);

INSERT INTO Doctor (license, name) VALUES (1245, 'Doctor Fisch');
INSERT INTO Doctor (license, name) VALUES (66645, 'Doctor Hummel');
INSERT INTO Doctor (license, name) VALUES (199985, 'Doctor Winter');
INSERT INTO Doctor (license, name) VALUES (1245, 'Doctor Fischer');
INSERT INTO Doctor (license, name) VALUES (66645, 'Doctor Berlin');
INSERT INTO Doctor (license, name) VALUES (199985, 'Doctor Sommer');
INSERT INTO Doctor (license, name) VALUES (199985, 'Doctor Filler');

