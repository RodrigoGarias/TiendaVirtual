
-- CLIENTE
INSERT INTO CLIENT ( oid , created_by ,  created_date , update_by , update_date , dni , email , last_name , name , phone ) VALUES ( '1' , 'System' , '2022-12-28 00:00:00' , 'System' , '2022-12-28 00:00:00' , '40126170' , 'Roarias96@gmai.com', 'Gonzalez arias' , 'Rodrigo' , '1531537175');

-- PRODUCTOS 
INSERT INTO PRODUCT ( oid , active , category , description , expiration_date , file_image , name , price ) VALUES ('1',1,'0','Mantecol bajo en sodio',NULL,NULL,'Mantecol',232);
INSERT INTO PRODUCT ( oid , active , category , description , expiration_date , file_image , name , price ) VALUES ('2',1,'0','Vainillas Mauri Galetitas Dulces',NULL,NULL,'Vainillas',81);
INSERT INTO PRODUCT ( oid , active , category , description , expiration_date , file_image , name , price ) VALUES ('3',1,'0','Nespresso 4 capsulas recargables cafe',NULL,NULL,'Caffetino',2300);
INSERT INTO PRODUCT ( oid , active , category , description , expiration_date , file_image , name , price ) VALUES ('4',1,'0','Almendras peladas 1kg',NULL,NULL,'Almendras',3590);
INSERT INTO PRODUCT ( oid , active , category , description , expiration_date , file_image , name , price ) VALUES ('5',1,'0','Garrapi�ada de Mani Georgalos',NULL,NULL,'Garrapi�ada',117);
INSERT INTO PRODUCT ( oid , active , category , description , expiration_date , file_image , name , price ) VALUES ('6',1,'0','Turron de Mani Georgalos Namur',NULL,NULL,'Turron',97);
INSERT INTO PRODUCT ( oid , active , category , description , expiration_date , file_image , name , price ) VALUES ('7',1,'0','Aceite de oliva virgen extra clasico' , NULL,NULL,'Aceite',1564);
INSERT INTO PRODUCT ( oid , active , category , description , expiration_date , file_image , name , price ) VALUES ('8',1,'0','Pan dulce Cosani Pan del cielo',NULL,NULL,'Pan Dulce',2380);
INSERT INTO PRODUCT ( oid , active , category , description , expiration_date , file_image , name , price ) VALUES ('9',1,'0','Nueces Mariposas 1kg',NULL,NULL,'Nueces',2340);
INSERT INTO PRODUCT ( oid , active , category , description , expiration_date , file_image , name , price ) VALUES ('10',1,'0',NULL,NULL,NULL,'Pasta de mani',640);
INSERT INTO PRODUCT ( oid , active , category , description , expiration_date , file_image , name , price ) VALUES ('11',1,'0','Alfajor Chocolate Dulce De leche',NULL,NULL,'Alfajor Guaymalen',1613);
INSERT INTO PRODUCT ( oid , active , category , description , expiration_date , file_image , name , price ) VALUES ('16',1,'1', 'Disco solido interno Kingston',NULL,NULL,'Disco Solido',7830);
INSERT INTO PRODUCT ( oid , active , category , description , expiration_date , file_image , name , price ) VALUES ('17',1,'1','Pasta Termina Arctic 4g',NULL,NULL,'Paste Termica',2744);
INSERT INTO PRODUCT ( oid , active , category , description , expiration_date , file_image , name , price ) VALUES ('18',1,'1','Memoria Ram Fury Beast DDR4',NULL,NULL,'Memoria Ram',15199);
INSERT INTO PRODUCT ( oid , active , category , description , expiration_date , file_image , name , price ) VALUES ('19',1,'1','CPU Cooler Xigmatek',NULL,NULL,'Cpu Cooler',5499);
INSERT INTO PRODUCT ( oid , active , category , description , expiration_date , file_image , name , price ) VALUES ('20',1,'1','Fuente Solarmaz 700W' , NULL, NULL,'Fuente',6659);
INSERT INTO PRODUCT ( oid , active , category , description , expiration_date , file_image , name , price ) VALUES ('21',1,'1','Capturadora Video HDMI Digital',NULL,NULL,'Capturadora Video',2699);
INSERT INTO PRODUCT ( oid , active , category , description , expiration_date , file_image , name , price ) VALUES ('22',1,'1','Placa de video AMD ASRock' , NULL , NULL , 'Placa de Video' , 13000);
INSERT INTO PRODUCT ( oid , active , category , description , expiration_date , file_image , name , price ) VALUES ('27',1,'2','Samsung Galaxy AO3',NULL,NULL,'Ceular',51999);
INSERT INTO PRODUCT ( oid , active , category , description , expiration_date , file_image , name , price ) VALUES ('28',1,'2','Tablet Samsung Galaxy A7',NULL,NULL,'Tablet',54999);
INSERT INTO PRODUCT ( oid , active , category , description , expiration_date , file_image , name , price ) VALUES ('29',1,'2',NULL,NULL,NULL,'Aspiradora',43999);
INSERT INTO PRODUCT ( oid , active , category , description , expiration_date , file_image , name , price ) VALUES ('30',1,'2','Pantalla Curva',NULL,NULL,'Monitor',157999);
INSERT INTO PRODUCT ( oid , active , category , description , expiration_date , file_image , name , price ) VALUES ('31',1,'2','Auriculares in-ear gamer',NULL,NULL,'Auriculares',53999);
INSERT INTO PRODUCT ( oid , active , category , description , expiration_date , file_image , name , price ) VALUES ('32',1,'2','Watch4 classic',NULL,NULL,'Reloj',99999);
INSERT INTO PRODUCT ( oid , active , category , description , expiration_date , file_image , name , price ) VALUES ('33',1,'2','Anafe electrico Samsung CRT264',NULL,NULL,'Anafe',169999);


-- Promotion Dates
Insert into PROMOTION_DATE ( oid , final_date , initial_date ) values ('1' , '2022-12-30' , '2022-12-29');