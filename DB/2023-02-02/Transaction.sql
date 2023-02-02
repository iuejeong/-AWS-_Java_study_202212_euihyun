show variables like 'AUTOCOMMIT';
set autocommit = 0;

start transaction;

savepoint sp3;



insert into user_mst
values (0, 'jjjj', '1234', '김준일', 'jjjj@gmail.com');

select * from user_mst;

rollback to sp1;

commit;

