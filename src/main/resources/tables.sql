create table rodzaj_rozkladu
(
  id             bigint       not null
    primary key,
  brygada        varchar(255) null,
  godzina        varchar(255) null,
  linia          varchar(255) null,
  miejsce_zmiany varchar(255) null,
  pierwsza_linia varchar(255) null,
  typ_rozkladu   varchar(255) null
);
create table schedule
(
  id             bigint       not null
    primary key,
  date           varchar(255) null,
  koniec_pracy   varchar(255) null,
  linia          varchar(255) null,
  miejsce_zmiany varchar(255) null,
  nr_sluzbowy    varchar(255) null,
  poczatek_pracy varchar(255) null,
  typ_rozkladu   varchar(255) null
)