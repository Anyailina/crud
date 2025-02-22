create table if not exists students
(
    id                 bigserial    not null primary key,
    name               varchar(255) not null,
    date_of_enrollment date         not null default current_date,
    group_id           bigint,
    create_at          date         not null default current_date,
    update_at          date         not null default current_date,
    constraint  students_fk foreign key (group_id) references  groups(id)
)