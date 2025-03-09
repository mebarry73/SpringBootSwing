drop table Persons;
create table Persons(
  ID int not null,
  NAME varchar(100) not null,
  PRIMARY KEY ( ID )
);

INSERT INTO Persons (id, name) VALUES (1245, 'Doctor Fisch');
INSERT INTO Persons (id, name) VALUES (66645, 'Doctor Hummel');
INSERT INTO Persons (id, name) VALUES (199985, 'Doctor Winter');

