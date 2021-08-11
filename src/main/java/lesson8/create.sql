create table if not exists Weather
(
  id integer primary key autoincrement not null,
  city text not null,
  localDate text not null,
  weatherText text not null,
  temperature double not null
);
