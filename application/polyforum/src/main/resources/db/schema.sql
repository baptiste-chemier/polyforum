drop table ETUDIANT if exists;

create table ETUDIANT (
	ETUDIANT_ID bigint generated by default as identity (start with 1),
	NOM		varchar(145),
	PRENOM	varchar(145),
	EMAIL	varchar(145),
	primary key (ETUDIANT_ID)
);