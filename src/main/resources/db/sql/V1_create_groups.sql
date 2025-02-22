create table if not exists groups
(
    id     bigserial    not null primary key,
    number varchar(255) not null,
    create_at   date         not null default current_date,
    update_at   date         not null default current_date
)