create table users
(
    id  int auto_increment comment '学号'
        primary key,
    pwd varchar(32) null comment '密码'
)
    comment '账号信息';


INSERT INTO test.users (id, pwd) VALUES (1, '3');
INSERT INTO test.users (id, pwd) VALUES (2, '3');
INSERT INTO test.users (id, pwd) VALUES (3, '1111');
INSERT INTO test.users (id, pwd) VALUES (4, '1111');
INSERT INTO test.users (id, pwd) VALUES (5, '66666');
INSERT INTO test.users (id, pwd) VALUES (6, '111111111111111');
INSERT INTO test.users (id, pwd) VALUES (7, 'jdbc');
INSERT INTO test.users (id, pwd) VALUES (8, 'jdbc');
INSERT INTO test.users (id, pwd) VALUES (9, 'jdbc');
INSERT INTO test.users (id, pwd) VALUES (10, 'jdbc');
INSERT INTO test.users (id, pwd) VALUES (11, '1111');
INSERT INTO test.users (id, pwd) VALUES (12, '1111');
INSERT INTO test.users (id, pwd) VALUES (13, '333');
INSERT INTO test.users (id, pwd) VALUES (14, '333');
INSERT INTO test.users (id, pwd) VALUES (15, '333');
INSERT INTO test.users (id, pwd) VALUES (16, '333');
INSERT INTO test.users (id, pwd) VALUES (17, '333');
INSERT INTO test.users (id, pwd) VALUES (18, '333');
INSERT INTO test.users (id, pwd) VALUES (19, '333');
INSERT INTO test.users (id, pwd) VALUES (20, '333');
INSERT INTO test.users (id, pwd) VALUES (21, '333');

create table classify
(
    classify_id   int auto_increment comment '分类id'
        primary key,
    classify_name varchar(64) null comment '分类名称'
)
    comment '图书分类';


INSERT INTO test.classify (classify_id, classify_name) VALUES (1, '文学文言');
INSERT INTO test.classify (classify_id, classify_name) VALUES (2, '故事会');
INSERT INTO test.classify (classify_id, classify_name) VALUES (3, '北京那点事');