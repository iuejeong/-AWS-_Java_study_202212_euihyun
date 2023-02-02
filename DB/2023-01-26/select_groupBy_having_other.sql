/*====================<< select >>====================*/

select * from student_mst;
/* 전체 컬럼 조회 */
select
	*
from
	student_mst;
    
/* 지정 컬럼 조회 */
select -- 처음에는 지정 컬럼을 전부 다 적는 게 좋다
	student_id,
    student_name,
    mentor_id
from
	student_mst;
    
/* 임시 컬럼 추가 */
select 
	1 as num,
    '김준일' as name;
    
select
	student_id,
    student_name,
    '김준일' as instructor_name
from
	student_mst;
    
/* 컬럼명을 임시로 바꾸는 방법 as(alias) 알리아스 */
-- as가 생략 가능함. 보통 컬럼에는 생략을 안 하고 table에 함
-- student_mst.student_id가 정석이다.
-- sm.student_id로도 가능하다
-- 컬럼에는 띄어쓰기 구분이 어려워서 알리아스를 쓴다
-- 하지만 테이블에는 보통 알리아스를 생략한다
select
	student_id as studentId -- 이렇게 하면 카멜 표기법으로 변경 된다.
from
	student_mst sm;

/* select문 실행 순서 
1. from -> 테이블명
2. where -> 테이블 조건
3. select -> 컬럼명
*/

/* 조회조건 where */

select
	*
from
	student_mst
where
	mentor_id = (select
					mentor_id
				from
					mentor_mst
				where
					mentor_name = '문자영'); -- 서브쿼리는 무조건 괄호가 열리고 닫힌다
                    
select
	student_id,
    student_name,
    mentor_id,
    (select 
		mentor_name 
    from 
		mentor_mst 
	where 
		mentor_id = student_mst.mentor_id) as mentor_name
from
	student_mst;
    
/* 그룹으로 묶어서 조회하기 */
-- 그룹끼리 묶어서 연산, 통계 처리할 때 쓰인다
-- count, min, max가 정말 많이 쓰인다
-- count는 좋아요 수, 조회수 볼 때 쓰인다
-- DB는 Y,N으로 쓰이고 true, false가 존재하지 않는다.
select
	count(mentor_id),
    min(student_id),
    max(student_id),
	avg(student_id),
    sum(student_id),
	mentor_id
from
	student_mst
group by
	mentor_id;
    
/* 중복 제거 */
select distinct
	mentor_id
from
	student_mst;

/* 그룹으로 조회한 결과에 조건주는 방법 */
-- where은 처음 데이터를 조회할 때 쓰인다
-- having은 데이터를 그룹화된 것들을 조건화할 때 쓰인다. 방식은 where이랑 동일			
select
	count(mentor_id) as mentor_count,
    min(student_id),
    max(student_id),
	avg(student_id),
    sum(student_id),
	mentor_id
from
	student_mst
group by
	mentor_id
having
    mentor_count = 5;
    
/* 정렬 */
-- default : 오름차순
-- desc : 내림차순

select
	*
from
	student_mst
order by
	mentor_id,
    student_id desc;
    
/* 전체 조합 실습 */
select
	count(*) as student_count,
    mentor_id
from
	student_mst
where
	student_id > 2
group by
	mentor_id
having
	student_count = 1
order by 
	mentor_id desc;
	
    
    
    
    
    
    
    
    







