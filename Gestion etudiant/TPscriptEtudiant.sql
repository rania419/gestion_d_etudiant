/*user*/
create user bddadmin identified by tpadmin;



/*table etudiant*/

create table etudiant
(
matricule_etu  integer  not null ,
nom_etu varchar(20),
prenom_etu varchar(20),
date_naissance date,
constraint pk_etu primary key (matricule_etu)
);
/*table enseugnant*/
create table enseignant(
  matricule_ens integer,
  nom_ens varchar(20),
  prenom_ens varchar(20),
  age integer,
  CONSTRAINT pk_ens primary key (matricule_ens)
);


/*table etudiant unite*/
create table etudiantunite (
matricule_etu integer,
code_unite varchar2(15),
note_cc integer,
note_tp integer,
note_examen integer,
constraint pk_etunit primary key (matricule_etu,code_unite),
CONSTRAINT fk_codeu foreign key (code_unite ) REFERENCES unite ( code_unite) ,
CONSTRAINT fk_matu FOREIGN KEY (matricule_etu ) REFERENCES etudiant ( matricule_etu)  
);
/*table unite*/
create table unite(
code_unite integer,
matricule_ens integer,
libelle varchar(40),
nbr_heur integer,
constraint pk_unit primary key (code_unite),
constraint fk_unit foreign key (matricule_ens) references enseignant(matricule_ens)
);




/*les indexs*/
 create  index in_nom on etudiant (
   nom_etu ASC
);

  create  index in_ens on enseignant (
   nom_ens desc
);


/*creation user etudiant*/
create user Etudiant identified by TPEtudiant;

/*accord de privilege select au user etudiant*/
grant select on etudiant to Etudiant;

/*creation yser enseignant*/
create user Enseignant identified by TPenseignant;
/*accord de privilege select  et insert au user enseignant*/
grant select,insert on enseignant to Enseignant;
/* ajout nv attribue addresse*/
alter table etudiant 
add  adresse varchar(100);



/* suppression colonne age*/
alter table enseignant
drop column age;
/*ajout de condition sur matricule*/
alter table etudiant
add  constraint ch_matetu check(matricule_etu>=20190000 AND matricule_etu<=20199999);

/*augmentation la taille de le chaine prenom*/
alter table etudiant
modify  prenom_etu varchar(25);
  
/*insertion sur la table etudiant*/
INSERT INTO etudiant VALUES (20190001, 'boussai', 'mohamed','12/01/2000','alger');
INSERT INTO etudiant VALUES (20190002, 'chaid', 'lamia','01/10/199','batna');
INSERT INTO etudiant VALUES (20190003, 'brahimi', 'souad','18/11/2000','setif');
INSERT INTO etudiant VALUES (20190004, 'lama', 'said','23/05/1999','oran');

/*insertion sur la table enseignant*/
INSERT INTO enseignant VALUES (20000001, 'harouni', 'amine');
INSERT INTO enseignant VALUES (19990011, 'fethi', 'omar');
INSERT INTO enseignant VALUES (19980078, 'bouzidane', 'farah');
INSERT INTO enseignant VALUES (20170015, 'arabi', 'zoubida');

/*insertion sur la table etudiantunite*/
INSERT INTO etudiantunite VALUES (20190001, 'FEI0001', 10,15,9);
INSERT INTO etudiantunite VALUES (20190002 ,'FEI0001' ,20 ,13, 10);
INSERT INTO etudiantunite VALUES (20190004, 'FEI0001' ,13, 17, 16);
INSERT INTO etudiantunite VALUES (20190002, 'FEI0002', 10, 16, 17);
INSERT INTO etudiantunite VALUES (20190003 ,'FEI0002' ,9, 8, 15);
INSERT INTO etudiantunite VALUES (20190004 ,'FEI0002', 15, 9, 20);
INSERT INTO etudiantunite VALUES (20190002 ,'FEI0004' ,12 ,18, 14);
INSERT INTO etudiantunite VALUES (20190003 ,'FEI0004' ,17 ,12, 15);
INSERT INTO etudiantunite VALUES (20190004, 'FEI0004',12, 13, 20);


/*insertion sur la table unite*/
INSERT INTO unite VALUES ('FEI0001',20000001, 'POO'  ,6 ) ;
INSERT INTO unite VALUES ('FEI0002',19990011 , 'BDD', 6);
INSERT INTO unite VALUES ('FEI0003', 20170015 , 'RESEAU',3);
INSERT INTO unite VALUES ('FEI0004',19980078 ,'SYSTEME' ,6 );  



/*note: j'ai changer le type de code_unite*/
alter table etudiantunite
modify code_unite varchar2(15);/*modification le type de code_unite sur la table etudiantunite*/
  
alter table unite
modify code_unite varchar2(15);/*modification le type de code_unite sur la table unite*/

alter table etudiantunite
drop constraint fk_codeu ;

alter table etudiantunite
add constraint fk_codeu foreign key (code_unite ) REFERENCES unite ( code_unite) ;

/*augmentation la note_cc si le nom de etudiant commence par b*/
update etudiantunite eu
set eu.note_cc =eu.note_cc+2
where eu.matricule_etu IN (select etudiantunite.matricule_etu
   	from etudiantunite 
	JOIN etudiant
	on etudiant.matricule_etu=etudiantunite.matricule_etu
	where etudiant.nom_etu like 'b%');


/*remettre tout les note de examen a 0 dont libelle est system*/
update etudiantunite eu
set eu.note_examen =0
where eu.code_unite IN (select etudiantunite.code_unite
   	from etudiantunite 
	JOIN unite
	on unite.code_unite=etudiantunite.code_unite
	where unite.libelle='SYSTEME');

/*affichage des etudiant qui ont eux des notes 20 au examen*/
select nom_etu,prenom_etu
from etudiant
where etudiant.matricule_etu in (select etudiant.matricule_etu
						from etudiant
						JOIN etudiantunite
						on etudiant.matricule_etu=etudiant.matricule_etu
						where etudiantunite.note_examen=20
						);

/*affichage des  noms et prénoms des étudiants qui ne sont pas inscrit dans l'unité (poo)*/



select nom_etu,prenom_etu
from etudiant
where etudiant.matricule_etu in (select etudiant.matricule_etu
						from etudiant
						JOIN etudiantunite
						on etudiant.matricule_etu=etudiant.matricule_etu
						where etudiantunite.code_unite IN (select etudiantunite.code_unite
												   	from etudiantunite 
													JOIN unite
													on unite.code_unite=etudiantunite.code_unite
													where unite.libelle<>'POO')
																		);

/*Affichage les libellés des unités d'enseignement dont aucun étudiant n'est inscrit*/

select e.nom_etu,e.prenom_etu,u.libelle,(eu.note_cc+eu.note_tp+eu.note_examen)/3 moyenne
from etudiant e
JOIN etudiantunite eu
on eu.matricule_etu = e.matricule_etu 
JOIN unite u
on u.code_unite = eu.code_unite
order by e.matricule_etu;
								                                   
/* Affichage  des  noms et prénom pour chaque étudiant, sa moyenne par unité d'enseignement
ainsi que le libellé de l'unité*/																		
								
select unite.code_unite,libelle
from unite
where unite.code_unite not IN ( select distinct etudiantunite.code_unite
		from etudiantunite);



	                               