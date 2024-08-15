create table users
(
    id       bigserial
        primary key,
    username varchar(255)
        unique
);

insert into users (username)
values ('user1'),
       ('user2'),
       ('user3');

create table products
(
    id          bigserial,
    account_num bigint,
    balance     numeric,
    type        text,
    user_id     bigint
);

insert into products (account_num, balance, type, user_id)
values (753159, 10, 'счет', 2),
       (456321, 175.5, 'карта', 1),
       (147852, 1963, 'счет', 1),
       (852369, 10.1, 'карта', 2),
       (789321, 111.11, 'счет', 1),
       (102350, 1369.12, 'карта', 3),
       (123456, 30.66, 'карта', 2),
       (888888, 938.04, 'карта', 3);
