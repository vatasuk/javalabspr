CREATE TABLE IF NOT EXISTS city
(
    id integer auto_increment primary key,
    pop character varying(8) NOT NULL,
    cityname character varying(40) NOT NULL
);

CREATE TABLE IF NOT EXISTS park
(
    id integer auto_increment primary key,
    cityid integer not null,
    pl integer NOT NULL,
    water character varying(10) NOT NULL,
    parktype character varying(25) NOT NULL,
    parkname character varying(40) NOT NULL,
    parkdate character varying(10) NOT NULL

);

ALTER TABLE park
    ADD FOREIGN KEY (cityid) references city(id);

