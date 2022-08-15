CREATE TABLE items (
id serial,
val int ,
version bigint DEFAULT 0,
PRIMARY KEY (id));

insert into items (val) select 0 from generate_series(1,40);
