-- 코드를 입력하세요
SELECT o.animal_id, o.name
from animal_outs o join animal_ins i on o.animal_id = i.animal_id
where o.datetime < i.datetime
order by i.datetime