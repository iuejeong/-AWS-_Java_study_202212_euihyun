insert into student_mst values (1, '김동민');
insert into student_mst values (2, '김두영');
insert into student_mst values (3, '장진원');

select * from student_mst;

insert into lecture_mst values (1, 'java', 100000);
insert into lecture_mst values (2, 'python', 80000);
insert into lecture_mst values (3, 'c', 90000);

select * from lecture_mst;

insert into instructor_mst values (1, '김준일', '서울대');
insert into instructor_mst values (2, '김준이', '부산대');
insert into instructor_mst values (3, '김준삼', '경상대');
select * from instructor_mst;

insert into course_mst values (1, 1, 1, 1);
insert into course_mst values (2, 2, 1, 1);
insert into course_mst values (3, 3, 1, 1);
insert into course_mst values (4, 1, 3, 3);
select * from course_mst;

insert into university_mst values (1, '서울대');
insert into university_mst values (2, '부산대');
insert into university_mst values (3, '경상대');
select * from university_mst;

select
	*
from
	course_mst cm 
    left outer join student_mst sm on(sm.student_id = cm.student_id)
	left outer join lecture_mst lm on(lm.lecture_id = cm.lecture_id)
    left outer join instructor_mst im on(im.instructor_id = cm.instructor_id)
    left outer join university_mst um on(um.university_id = im.university_id)
    