use test;
desc users;
insert into users values(1,'liyu','123456');
desc roles;
insert into roles values(1,'admin','管理员');
desc user_roles;
insert into user_roles values(1,1);

配置证书
with ssl