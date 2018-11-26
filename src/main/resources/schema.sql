create table users
(
  id int(11) not null auto_increment,
  name varchar (100) not null,
  email varchar (100) default null,
  primary key (id)
);