insert into `tp2`.`cpt` values 
(99214,'Pract 1'),
(90716,'Pract 2');

insert into `tp2`.`paciente` values 
(11111111,'DNI','Arnaldo','Andre'),
(22222222,'DNI','Beatriz','Bordo'),
(33333333,'DNI','Carlos','Cascia'),
(44444444,'LC','Denis','Derek'),
(55555555,'DNI','Edgar','Egar'),
(66666666,'DNI','Fernando','Fernandez');

insert into `tp2`.`afiliado` values 
(12345,'TIT','310','OSDE','DNI',11111111),
(54321,'TIT','310','OSDE','DNI',22222222),
(77777,'TIT','210','OSDE','DNI',33333333),
(77777,'TIT','AZUL','GALENO','DNI',55555555),
(54321,'TIT','AZUL','GALENO','DNI',66666666);

insert into `tp2`.`indicacionmedica` values 
(44444444,'LC',1001,20120601,1000,99214,1),
(55555555,'DNI',1001,20120501,1100,90716,1),
(11111111,'DNI',2002,20120507,1200,99214,1),
(22222222,'DNI',2002,20120509,1300,99214,2),
(55555555,'DNI',3003,20120601,1400,90716,2);