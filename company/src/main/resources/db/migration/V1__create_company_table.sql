create table company (
    id serial primary key,
    name varchar(256),
    company_registration_number varchar(256),
    registered_address varchar(256),
    registered_on TIMESTAMP default CURRENT_TIMESTAMP,
	  enabled boolean not null
);
