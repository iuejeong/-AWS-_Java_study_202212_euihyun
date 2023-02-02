-- like = 문자열을 포함하고 있는 것을 출력, %%는 like에만 쓰인다 '%~%' = ~시작이든 끝이든 포함에서 출력, ~% = ~가 끝에 왔을 때 출력, %~ = ~가 처음에 왔을 때 출력
-- like랑 in은 같이 못 쓴다
select
	*
from
	library_mst
where
	발행연도 > 2000;

	
    
/*=====================<< select insert >>=======================*/
insert into author_mst 
	(author_name)
select distinct
	저작자
from
	library_mst
order by
	저작자;
    
select * from author_mst;


insert into publisher_mst
	(publisher_name)
    
select distinct
	출판사
    
from
	library_mst
order by
	출판사;
    
select * from publisher_mst;

/*====================<< select update >>=====================*/

update 
	library_mst lm
set 
	lm.저작자 = (
select 
	am.author_id
from 
	author_mst am
where
	am.author_name = lm.저작자);
    
    
update 
	library_mst, 
    author_mst
set
	저작자 = author_id
where
	저작자 = author_name;
    
select
	*
from
	library_mst;
    
    
select
	*
from
	library_mst lm
    left outer join author_mst am on(am.author_id = lm.저작자)
	left outer join publisher_mst pm on(pm.publisher_id = lm.출판사);

update 
	library_mst, 
	publisher_mst
set
	출판사 = publisher_id
where
	출판사 = publisher_name;


/*=======================================*/

set profiling = 1;
set profiling_history_size = 30;

select
	도서관명,
    도서명
from
	library_mst
where
	저작자 in (select
				author_id
			from
				author_mst
			where
				author_name like '%김주%'
			or	author_name like '%김민%'); -- like를 여러 번 쓰고 싶으면 or를 쓰면 된다.
    
select
	도서관명,
	도서명
from
	library_mst lm
    left outer join author_mst am on(am.author_id = lm.저작자)
where
	am.author_name like '%김주%';
show profiles;















