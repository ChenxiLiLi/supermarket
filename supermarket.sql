-- 创建用户表
create table user
(
    id int not null auto_increment,
    username varchar(20) not null,
    password varchar(50) null,
    constraint user_pk
        primary key (id)
)
    comment '系统用户';
-- 用户名唯一
create unique index user_username_uindex
    on user (username);

insert into user values (null, "ceshi", "123456");
