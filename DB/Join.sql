select
	*
from
	library_mst;
    
select
	*
from
	author_mst;
    
-- 컬럼명을 바꿔줘야 할 때 as를 쓴다. as가 없다면 값 그 자체로 컬럼명이 된다.
-- select 안에는 값을 추가할 수 있다.
-- 서브쿼리는 하나의 값만 출력 가능
-- 컬럼명이 많아질수록 서브쿼리는 비효율적이기에 join을 쓴다.
select
	순번,
	도서관명,
    구분,
    도서명,
    저작자,
    (select author_name from author_mst where author_id = 저작자) as 저작자명,
    출판사,
    (select publisher_name from publisher_mst where publisher_id = 출판사) as 출판사명,
    (select publisher_year from publisher_mst where publisher_id = 출판사) as 출판사설립일,
    발행연도,
    청구기호
from
	library_mst;
    
/*============================================================*/

-- join은 mst가 중요하다.
-- mst이 기준이 된다. 그 기준에 따라 join의 형식이 달라진다.
-- join에는 집합이 사용된다.
-- 그 종류는 inner와 outer 조인이 있다.
-- 교집합 -> inner join
-- 그 바깥 -> outer juin
-- on -> 같은 값 찾는 조건식
-- A와 B가 있다면 교집합과 A의 값만 출력하는 것을 left outer join이라 한다. 뒤에 붙일 것이 없다면 null로 채워진다.
-- A의 차집합을 구하려면 where 안에 B is null로 잡아주면 된다.
insert into library_mst
values (0, '테스트도서관', '999(테스트)', '테스트도서명', '9999', '9999', '2023','999.9-테99ㅌ');

select
	lm.순번,
    lm.도서관명,
    lm.구분,
    lm.도서명,
    lm.출판사,
    pm.publisher_name,
    pm.publisher_year
from
	library_mst lm
    left outer join publisher_mst pm on(pm.publisher_id = lm.출판사)
order by
	lm.순번 desc;
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    