create table meminfo(num INT auto_increment primary key, name varchar(9), level varchar(9), dept varchar(9));

insert into meminfo(name,level,dept) values('홍길동', '사원', '부서');

select num, name, level, dept, del from meminfo;

테이블 추가
alter table meminfo add (del varchar(1));

update meminfo set del = 'Y' where num in ('4','5','7'); //여러개 바꿀때

조건 검색후 해당 조건에 맞는 컬럼에 대한 값 변경
update meminfo set level = '1', dept = '1' where  level = '사원';
다른 테이블에 대한 조건 검색후 해당 조건에 맞는 컬럼에 대한 값 변경
update meminfo set level = '1', dept = '1' where num in (select num from 조건검색용 테이블명 where level = '1'); 

select name, level, dept, del from meminfo where num = '1';

테이블 삭제
drop table meminfo;


	SELECT num, name, level, dept, del 
 		  from meminfo
		--where name like '%' || '길' || '%'  
		where INSTR(name,'길') > 0