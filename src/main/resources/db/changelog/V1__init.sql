create table if not exists categories
(
    id         serial
        primary key,
    created_at timestamp(6),
    updated_at timestamp(6),
    category   varchar(255) not null
        constraint uk_5ky4frjmcobbiayt5jyx53mff
            unique
);

create table if not exists products
(
    id          serial
        primary key,
    created_at  timestamp(6),
    updated_at  timestamp(6),
    name        varchar(255)   not null,
    price       numeric(38, 2) not null,
    category_id integer        not null
        constraint fkog2rp4qthbtt2lfyhfo32lsw9
            references categories
);

create table if not exists roles
(
    id   serial
        primary key,
    name varchar(255) not null
        constraint uk_ofx66keruapi6vyqpv6f2or37
            unique
);

create table if not exists users
(
    id          serial
        primary key,
    created_at  timestamp(6),
    updated_at  timestamp(6),
    birthday    date         not null,
    code        varchar(255) not null,
    email       varchar(255) not null
        constraint uk_6dotkott2kjsp8vw4d0m25fb7
            unique,
    is_verified boolean      not null,
    lastname    varchar(255) not null,
    name        varchar(255) not null,
    password    varchar(255) not null,
    role_id     integer      not null
        constraint fkp56c1712k691lhsyewcssf40f
            references roles
);
