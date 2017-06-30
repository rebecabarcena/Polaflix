use polaflix;
select * from espacio_personal_marcadores_series;
select * from espacio_personal_capitulos_vistos;
select * from espacio_personal_series_pendientes;

insert into serie values ('Gold', 1, 2014, 'Después de que un acelerador de partículas cause una extraña tormenta, al investigador científico de la policía, Barry Allen, le cae un rayo y entra en coma. ...', 'The Flash', 1.50);
insert into serie values('Gold', 2, 2012, 'Adaptación libre de un personaje de DC Comics, playboy de día, que, durante la noche, usa su arco y sus flechas contra el crimen...', 'Arrow', 1.50);
insert into serie values('Estandar',3,2005,'Cuando eran niños, Sam y Dean Winchester, perdieron a su madre debido a una misteriosa y demoníaca fuerza sobrenatural...', 'Sobrenatural',0.50);
insert into serie values('Silver',4,2005,'Michael Scofield (Wentworth Miller) es un hombre desesperado en un situación deseperada. Su hermano Lincoln Burrows (Dominic Purcell), condenado a la pena capital está a la espera de ser ejecutado...','Prison Break',0.75);

insert into persona values('Actor',1,'Purcell','Dominic');
insert into persona values('Actor',2,'Miller','Wentworth');
insert into persona values('Creador',3,'Roth','Bobby');
insert into serie_actores_principales values(4,1);
insert into serie_actores_principales values(4,2);
insert into serie_creador values(4,3);
insert into persona values('Actor',4,'Gustin','Grant');
insert into persona values('Creador',5,'Winter','Glen');
insert into serie_actores_principales values(1,4);
insert into serie_creador values(1,5);
insert into persona values('Actor',6,'Padalecki','Jared');
insert into persona values('Actor',7,'Ackles','Jensen');
insert into persona values('Creador',8,'Kripke','Eric');
insert into serie_actores_principales values(3,6);
insert into serie_actores_principales values(3,7);
insert into serie_creador values(3,8);
insert into persona values('Actor',9,'Amell','Stephen');
insert into persona values('Actor',10,'Bett','Emily');
insert into persona values('Creador',11,'Behring','John');
insert into serie_actores_principales values(2,9);
insert into serie_actores_principales values(2,10);
insert into serie_creador values(2,11);

insert into temporada values(1,'Temporada 1',1);
insert into temporada values(2,'Temporada 2',2);
insert into temporada values(3,'Temporada 1',1);
insert into temporada values(4,'Temporada 2',2);
insert into temporada values(5,'Temporada 1',1);
insert into temporada values(6,'Temporada 2',2);
insert into temporada values(7,'Temporada 1',1);
insert into temporada values(8,'Temporada 2',2);

insert into serie_temporadas values(1,1);
insert into serie_temporadas values(1,2);
insert into serie_temporadas values(2,3);
insert into serie_temporadas values(2,4);
insert into serie_temporadas values(3,5);
insert into serie_temporadas values(3,6);
insert into serie_temporadas values(4,7);
insert into serie_temporadas values(4,8);

insert into capitulo values(1,'11.html','Piloto',1,1);
insert into capitulo values(2,'11.html','Allen',2,1);
insert into capitulo values(3,'11.html','Manhunt',1,2);
insert into capitulo values(4,'11.html','Otis',2,2);
insert into capitulo values(5,'11.html','Piloto',1,3);
insert into capitulo values(6,'11.html','El hombre más rápido del mundo',2,3);
insert into capitulo values(7,'11.html','El hombre que salvó Central City',1,4);
insert into capitulo values(8,'11.html','Entre dos mundos',2,4);
insert into capitulo values(9,'11.html','Piloto',1,5);
insert into capitulo values(10,'11.html','Wendigo',2,5);
insert into capitulo values(11,'11.html','Cuando llegue mi hora',1,6);
insert into capitulo values(12,'11.html','A todo el mundo le gustan los payasos',2,6);
insert into capitulo values(13,'11.html','Piloto',1,7);
insert into capitulo values(14,'11.html','Honra a tu padre',2,7);
insert into capitulo values(15,'11.html','Ciudad de héroes',1,8);
insert into capitulo values(16,'11.html','Identidad',2,8);


insert into temporada_capitulos values(1,1);
insert into temporada_capitulos values(1,2);
insert into temporada_capitulos values(2,3);
insert into temporada_capitulos values(2,4);
insert into temporada_capitulos values(3,5);
insert into temporada_capitulos values(3,6);
insert into temporada_capitulos values(4,7);
insert into temporada_capitulos values(4,8);
insert into temporada_capitulos values(5,9);
insert into temporada_capitulos values(5,10);
insert into temporada_capitulos values(6,11);
insert into temporada_capitulos values(6,12);
insert into temporada_capitulos values(7,13);
insert into temporada_capitulos values(7,14);
insert into temporada_capitulos values(8,15);
insert into temporada_capitulos values(8,16);

insert into espacio_personal values(1);
insert into usuario values('pepito','1212',true,'1');
insert into espacio_personal values(2);
insert into usuario values('marta','1212',true,'2');
insert into espacio_personal values(3);
insert into usuario values('juan','1212',true,'3');

insert into marcador_serie values(1,1,1,1,1);
insert into marcador_serie values(2,2,3,2,2);
insert into marcador_serie values(3,3,5);
insert into marcador_serie values(4,3,5,3,5);

insert into espacio_personal_marcadores_series values(1,1,1);
insert into espacio_personal_marcadores_series values(2,2,2);
insert into espacio_personal_marcadores_series values(3,3,3);

insert into espacio_personal_series_finalizadas values(1,2);
insert into espacio_personal_series_finalizadas values(1,4);
insert into espacio_personal_series_finalizadas values(2,3);
insert into espacio_personal_series_finalizadas values(3,4);

insert into espacio_personal_series_pendientes values(1,3);
insert into espacio_personal_series_pendientes values(2,4);
insert into espacio_personal_series_pendientes values(3,1);

insert into espacio_personal_capitulos_vistos values (1,1);
insert into espacio_personal_capitulos_vistos values (2,2);
insert into espacio_personal_capitulos_vistos values (3,3);

insert into capitulo_visto values (1,"2016-09-09",1.5,1);
insert into capitulo_visto values (2,"2017-12-12",1.5,2);
insert into capitulo_visto values (3,"2017-01-01",0.5,3);
insert into capitulo_visto values (4,"2017-01-01",0.5,3);
insert into capitulo_visto values (5,"2017-01-01",0.5,3);

insert into factura_cobrada values(1,"2016-10-1");
insert into factura_cobrada values(2,"2017-1-1");
insert into factura_cobrada values(3,"2017-2-1");
insert into facturseriea_cobrada values(4,"2017-3-1");

insert into factura_cobrada_capitulos_vistos values(1,1);
insert into factura_cobrada_capitulos_vistos values(1,2);
insert into factura_cobrada_capitulos_vistos values(1,3);
insert into factura_cobrada_capitulos_vistos values(2,2);
insert into factura_cobrada_capitulos_vistos values(3,3);
insert into factura_cobrada_capitulos_vistos values(4,4);
insert into factura_cobrada_capitulos_vistos values(4,5);

insert into usuario_facturas_cobradas values('pepito',1);
insert into usuario_facturas_cobradas values('pepito',4);
insert into usuario_facturas_cobradas values('marta',2);
insert into usuario_facturas_cobradas values('juan',3);
