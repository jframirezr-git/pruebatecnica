--liquibase formatted sql
--changeset felipe_ramirez:R1.01

create table profile
(
    id   serial
        constraint profile_pkey
            primary key,
    name varchar(255)
);

create table user_app
(
    id  serial
        constraint user_app_pkey
            primary key,
    name       varchar(255)
        constraint uk_iuik2deybkowqoq5ag6oyxbju
            unique,
    start_date timestamp,
    year       integer not null,
    profile_id integer
        constraint fkktbju6kc5mi0eajpnq3ynnp9q
            references profile
);

create table product
(
    id  serial
        constraint product_pkey
            primary key,
    name       varchar(255)
        constraint uk_jmivyxk9rmgysrmsqw15lqr5b
            unique,
    product    varchar(255),
    quantity   integer not null,
    start_date timestamp,
    user_id    integer
        constraint fk103id5mroasf2khdfw7qlmwr7
            references user_app
);

create table update_products
(
    id  serial
        constraint update_products_pkey
            primary key,
    last_update timestamp,
    product_id  integer
        constraint fkfwm27xjvr3y4euuuy6g68u527
            references product,
    user_id     integer
        constraint fkefk3xigrtwsku32pbr5fbyk42
            references user_app
);

INSERT INTO profile (name) VALUES ('Asesor de ventas');
INSERT INTO profile (name) VALUES ('Administrador');
INSERT INTO profile (name) VALUES ('Soporte');