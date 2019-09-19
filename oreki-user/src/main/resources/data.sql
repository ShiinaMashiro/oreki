insert into user(id, username, password, locked, expired, expire_date) values (1, 'oreki', '123', false, false, null);
insert into user(id, username, password, locked, expired, expire_date) values (2, 'ywc', '123', true, false, null);
insert into role(id, name, remark) values (1, '管理员', '');
insert into role(id, name, remark) values (2, '贱民', '');
insert into user_roles values (1, 1);
insert into user_roles values (2, 2);