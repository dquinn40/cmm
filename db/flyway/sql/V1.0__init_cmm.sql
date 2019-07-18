CREATE TABLE people (
  id SERIAL PRIMARY KEY,
  name TEXT,
  birthdate TEXT
);

CREATE TABLE movies (
  id SERIAL PRIMARY KEY,
  title TEXT
);

CREATE TABLE roles (
  id SERIAL PRIMARY KEY,
  role TEXT
);

CREATE TABLE mtm_credits (
  movie_id INT,
  person_id INT,
  role_id INT,
  FOREIGN KEY (movie_id) REFERENCES movies (id),
  FOREIGN KEY (person_id) REFERENCES people (id),
  FOREIGN KEY (role_id) REFERENCES roles (id)
);

INSERT INTO people (name, birthdate)
VALUES
  ('George Miller', '1945-03-03'),
  ('Tom Hardy', '1977-09-15'),
  ('Charlize Theron', '1975-08-07'),
  ('Ridley Scott', '1937-11-30'),
  ('Noomi Rapace', '1979-12-28'),
  ('Ben Affleck', '1972-08-15'),
  ('Casey Affleck', '1972-08-12'),
  ('Alejandro G. Iñárritu', '1963-08-15'),
  ('Leonardo DiCaprio', '1974-11-11'),
  ('Gus Van Sant', '1952-07-24'),
  ('Matt Damon', '1980-10-08');

INSERT INTO movies (title)
VALUES
  ('Mad Max: Fury Road'),
  ('Prometheus'),
  ('Gone Baby Gone'),
  ('The Revenant'),
  ('Body of Lies'),
  ('Good Will Hunting');

INSERT INTO roles (role)
VALUES
  ('Actor'),
  ('Director');

INSERT INTO mtm_credits (movie_id, role_id, person_id)
VALUES
  ((SELECT id FROM movies WHERE title like 'Mad Max: Fury Road'),
    (SELECT id FROM roles WHERE role like 'Director'),
    (SELECT id FROM people WHERE name like 'George Miller')),
  ((SELECT id FROM movies WHERE title like 'Prometheus'),
    (SELECT id FROM roles WHERE role like 'Director'),
    (SELECT id FROM people WHERE name like 'Ridley Scott')),
  ((SELECT id FROM movies WHERE title like 'Gone Baby Gone'),
    (SELECT id FROM roles WHERE role like 'Director'),
    (SELECT id FROM people WHERE name like 'Ben Affleck')),
  ((SELECT id FROM movies WHERE title like 'The Revenant'),
    (SELECT id FROM roles WHERE role like 'Director'),
    (SELECT id FROM people WHERE name like 'Alejandro G. Iñárritu')),
  ((SELECT id FROM movies WHERE title like 'Body of Lies'),
    (SELECT id FROM roles WHERE role like 'Director'),
    (SELECT id FROM people WHERE name like 'Ridley Scott')),
  ((SELECT id FROM movies WHERE title like 'Good Will Hunting'),
    (SELECT id FROM roles WHERE role like 'Director'),
    (SELECT id FROM people WHERE name like 'Gus Van Sant')),
  ((SELECT id FROM movies WHERE title like 'Mad Max: Fury Road'),
    (SELECT id FROM roles WHERE role like 'Actor'),
    (SELECT id FROM people WHERE name like 'Tom Hardy')),
  ((SELECT id FROM movies WHERE title like 'Mad Max: Fury Road'),
    (SELECT id FROM roles WHERE role like 'Actor'),
    (SELECT id FROM people WHERE name like 'Charlize Theron')),
  ((SELECT id FROM movies WHERE title like 'Prometheus'),
    (SELECT id FROM roles WHERE role like 'Actor'),
    (SELECT id FROM people WHERE name like 'Charlize Theron')),
  ((SELECT id FROM movies WHERE title like 'Prometheus'),
    (SELECT id FROM roles WHERE role like 'Actor'),
    (SELECT id FROM people WHERE name like 'Noomi Rapace')),
  ((SELECT id FROM movies WHERE title like 'Gone Baby Gone'),
    (SELECT id FROM roles WHERE role like 'Actor'),
    (SELECT id FROM people WHERE name like 'Casey Affleck')),
  ((SELECT id FROM movies WHERE title like 'The Revenant'),
    (SELECT id FROM roles WHERE role like 'Actor'),
    (SELECT id FROM people WHERE name like 'Leonardo DiCaprio')),
  ((SELECT id FROM movies WHERE title like 'The Revenant'),
    (SELECT id FROM roles WHERE role like 'Actor'),
    (SELECT id FROM people WHERE name like 'Tom Hardy')),
  ((SELECT id FROM movies WHERE title like 'Body of Lies'),
    (SELECT id FROM roles WHERE role like 'Actor'),
    (SELECT id FROM people WHERE name like 'Leonardo DiCaprio')),
  ((SELECT id FROM movies WHERE title like 'Good Will Hunting'),
    (SELECT id FROM roles WHERE role like 'Actor'),
    (SELECT id FROM people WHERE name like 'Ben Affleck')),
  ((SELECT id FROM movies WHERE title like 'Good Will Hunting'),
    (SELECT id FROM roles WHERE role like 'Actor'),
    (SELECT id FROM people WHERE name like 'Matt Damon'));
