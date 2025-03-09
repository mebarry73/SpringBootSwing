drop table Doctor;
create table Doctor(
  ID int not null,
  NAME varchar(100) not null,
  PRIMARY KEY ( ID )
);

INSERT INTO Doctor (id, name) VALUES (1245, 'Doctor Fisch');
INSERT INTO Doctor (id, name) VALUES (66645, 'Doctor Hummel');
INSERT INTO Doctor (id, name) VALUES (199985, 'Doctor Winter');

