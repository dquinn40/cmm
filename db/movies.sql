select * from movies order by title;

select * from people order by birthdate limit 3;

select distinct(p.name) from people p, roles r, mtm_credits c where r.role = 'Director' and r.id = c.role_id and c.person_id = p.id group by p.name;

select p.name, count(*) as director_count from people p, roles r, mtm_credits c where r.role = 'Director' and r.id = c.role_id and c.person_id = p.id group by p.name order by director_count desc limit 1;

select distinct(p.name) from people p, roles r, mtm_credits c where c.person_id = p.id and c.role_id = r.id and r.role = 'Actor' and p.name in (select distinct(p.name) from people p, roles r, mtm_credits c where c.person_id = p.id and  c.role_id = r.id and r.role = 'Director');

select p.name from people p, mtm_credits c where p.name <> 'Ben Affleck' and p.id = c.person_id and c.movie_id in (select m.id from movies m, people p, mtm_credits c where m.id = c.movie_id and c.person_id = p.id and p.name = 'Ben Affleck')
