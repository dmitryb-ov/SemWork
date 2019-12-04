CREATE SEQUENCE user_id_seq;
CREATE TABLE user_table(
    ID INTEGER not null default nextval('user_id_seq') primary key ,
    Email VARCHAR(255) not null ,
    Password VARCHAR(255) not null,
    Name VARCHAR(255) ,
    Points INTEGER,
    Role VARCHAR(10)
);
SELECT * FROM user_table;

INSERT INTO user_table VALUES (nextval('user_id_seq'), 'myMail@123','pass1','Dima',0,'GUEST');
INSERT INTO user_table VALUES (nextval('user_id_seq'), 'aaaaayMail@123','pass2','Wwwww',0,'GUEST');
INSERT INTO user_table VALUES (nextval('user_id_seq'), 'gfggfgyMail@123','apass13','NO',0,'GUEST');
INSERT INTO user_table VALUES (nextval('user_id_seq'), 'lllllMail@123','spass1','OI',0,'GUEST');
INSERT INTO user_table VALUES (nextval('user_id_seq'), 'fffMail@123','padfdfss1','WHAt',0,'GUEST');
INSERT INTO user_table VALUES (nextval('user_id_seq'), 'fdfdi@123ff','pasfddaaaas1','dFDFD',0,'GUEST');
INSERT INTO user_table VALUES (nextval('user_id_seq'), 'mdfdfMail@123fdfd','passsdqqq1','MED',0,'GUEST');
INSERT INTO user_table VALUES (nextval('user_id_seq'), 'myMadfdfdil@123','llllpass2323231','IG',0,'GUEST');

drop sequence user_id_seq;
drop table user_table;