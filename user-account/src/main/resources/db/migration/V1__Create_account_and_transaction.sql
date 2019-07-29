CREATE SEQUENCE account_number_seq START 1000000;

create table account
(
    id      serial primary key,
    balance NUMERIC(21, 2) not null default 0,
    user_id BIGINT         not null,
    enabled boolean        not null
);

CREATE SEQUENCE account_transaction_id_seq START 1;

create table account_transaction
(
    id         serial primary key,
    amount     numeric(21, 2) not null,
    account_id BIGINT         not null,
    created_at  TIMESTAMP    NOT NULL,
    FOREIGN KEY (account_id) REFERENCES account (id)
);
