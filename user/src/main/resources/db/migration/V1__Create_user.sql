create table users
(
    id         serial primary key,
    first_name varchar(256),
    last_name  varchar(256),
    username   varchar(256) not null unique,
    email      varchar(256),
    enabled    boolean      not null
);
