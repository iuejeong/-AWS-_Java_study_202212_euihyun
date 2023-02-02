/*
	DML
    C: insert / into 	데이터 추가
    R: select / from	데이터 조회
    U: update / set		데이터 수정
    D: delete / from	데이터 삭제



*/

/*==================<< insert >>=====================*/
-- 쿼리는 명령호출 횟수를 최대한 줄여야 한다
-- db_study2_explain db를 사용하겠다, 컬럼의 순서 그대로 짝을 맞춰줘야 한다 value 안의 값과 괄호에 들어가야 할 값의 순서가 일치해야 함. 넣고 싶은 것만 컬럼을 지정해준다. 다 넣어야 한다면 괄호를 생략해주고 값을 다 넣어야 함.
select * from student_mst;

insert into student_mst 
	(student_id, 	student_name, 	mentor_id)
values 
	(4,				'손지호'),
	(5, 			'이강용', 			10),
	(6, 			'김준경', 			10),
	(7, 			'이현수', 			10),
	(8, 			'정의현', 			10);
    
insert into university_mst
	(university_id, university_name)
values
	(4, 	'고려대'),
	(5, 	'연세대'),
	(6, 	'서강대'),
	(7, 	'성균관대'),
	(8, 	'한양대');
select * from university_mst;

/*=============<< update >>=============*/

select * from student_mst;

update student_mst
set
	student_name = '김재영',
	mentor_id = 15
where
	student_id = 5;
    
/* 멘토 아이디가 10인 학생들의 멘토 아이디를 1로 바꿔라*/

update student_mst
set
	mentor_id = 1 -- set에서는 =가 대입
where
	mentor_id = 10; -- where에서는 =가 비교
	
select * from student_mst;

/*=================<< delete >>==================*/
-- where은 키값으로 연습해야 한다.
delete 
from 
	student_mst  -- delete랑 from 사이에는 아무것도 적지 않는다. 이 상태로 실행하면 안에 정보들 다 지워버림.
where 
	student_id = 4
and	student_name = '손지호';

delete
from
	university_mst
where
	university_id = 6
and	university_name = '서강대';

select * from university_mst;












