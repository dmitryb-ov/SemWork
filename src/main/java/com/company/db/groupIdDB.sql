CREATE SEQUENCE group_id_seq;
CREATE TABLE group_table(
  group_id int not null default nextval('group_id_seq'),
  group_number VARCHAR(30)  primary key
);

INSERT INTO group_table VALUES (nextval('group_id_seq'), '11-801');
INSERT INTO group_table VALUES (nextval('group_id_seq'), '11-802');
INSERT INTO group_table VALUES (nextval('group_id_seq'), '11-803');
INSERT INTO group_table VALUES (nextval('group_id_seq'), '11-804');
INSERT INTO group_table VALUES (nextval('group_id_seq'), '11-805');
INSERT INTO group_table VALUES (nextval('group_id_seq'), '11-806');
INSERT INTO group_table VALUES (nextval('group_id_seq'), '11-807');
INSERT INTO group_table VALUES (nextval('group_id_seq'), '11-808');
INSERT INTO group_table VALUES (nextval('group_id_seq'), '11-809');