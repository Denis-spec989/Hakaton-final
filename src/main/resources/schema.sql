DROP TABLE IF EXISTS petrolstations;

CREATE TABLE petrolstation (
    petrolstation_id uuid PRIMARY KEY,
    address varchar(100),
    latitude float8,
    longtitude float8,
    name_ varchar(20),
    country varchar(10),
    phone varchar(20),
    region varchar(100)
);

SELECT * FROM petrolstations;
insert into petrolstation (address,latitude,longtitude,name_,country,phone,region)
    values ('г.Майкоп, Хакурате, 654 ', 44.62423, 40.05552, '01023','RU','(8772) 53-46-05','Республика Адыгея');

