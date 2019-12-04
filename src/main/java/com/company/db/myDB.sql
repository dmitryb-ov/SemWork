drop table my_user_table;
drop sequence my_user_id_seq;

CREATE SEQUENCE my_user_id_seq;

CREATE TABLE my_user_table(
    ID INTEGER not null default nextval('my_user_id_seq'),
    email VARCHAR(255) not null primary key ,
    password VARCHAR(255) not null ,
    name VARCHAR(255) not null ,
    secondName VARCHAR(255) not null ,
    group_id VARCHAR(20) not null ,
    points int,
    role VARCHAR(20)
);


CREATE TABLE user_groups(
    user_mail VARCHAR(255),
    group_number VARCHAR(255),
    foreign key(group_number) REFERENCES group_table(group_number) ON DELETE CASCADE,
    foreign key (user_mail) REFERENCES my_user_table(email) ON DELETE CASCADE
);
drop table user_groups;

INSERT INTO my_user_table VALUES (nextval('my_user_id_seq'), 'test@mail.ru','123','Dima','Belyakov','11-807','27','ADMIN');
INSERT INTO my_user_table VALUES (nextval('my_user_id_seq'), 'adm@mail.ru','21232f297a57a5a743894a0e4a801fc3','Dima','Belyakov','11-807','27','ADMIN');