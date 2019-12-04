CREATE SEQUENCE role_seq;
CREATE TABLE role_table(
    role_ID INTEGER not null default nextval('role_seq') primary key ,
    my_Role VARCHAR(255)
);
 INSERT INTO role_table VALUES (nextval('role_seq'),'FIRSTRROLE');
 INSERT INTO role_table VALUES (nextval('role_seq'),'SECONDROLE');
 INSERT INTO role_table VALUES (nextval('role_seq'),'THIRDROLE');
 INSERT INTO role_table VALUES (nextval('role_seq'),'FOURTHROLE');


CREATE TABLE user_roles(
    user_id INTEGER,
    role_id INTEGER,
--     primary key (user_id,role_id),
    foreign key (user_id) REFERENCES user_table(id) ON DELETE CASCADE ,
    foreign key (role_id) REFERENCES role_table(role_ID) ON DELETE CASCADE
);

drop sequence role_seq;
drop table role_table;
drop table user_roles;