use tempProj;


/*
Создать таблицу Bays с полями:
  id int
  resource_id int
*/
CREATE TABLE Bays
(
    id          INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    resource_id INT             NOT NULL
);
/*
Если не создана то создать таблицу ResourcesGroups с полями:
  id int
  name varchar
  description varchar
*/
CREATE TABLE IF NOT EXISTS ResourcesGroups
(
    id          INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name        varchar(50)     NOT NULL UNIQUE,
    description varchar(120)    NOT NULL

);
/*
Если не создана то создать таблицу Resources с полями:
  id int
  name varchar
  description varchar
  group_id int
  permanent boolean
*/
CREATE TABLE IF NOT EXISTS Resources
(
    id          INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name        varchar(50)     NOT NULL UNIQUE,
    description varchar(120)    NOT NULL,
    group_id    INT             NOT NULL
);
/*
Добавить в этот файл SQL скрипты для заполнения таблиц данными из GoogleDocs.
*/
INSERT INTO Bays
    (resource_id)
VALUES (1),
       (2),
       (3),
       (4),
       (5);

INSERT INTO Resources
    (name, description, group_id)
VALUES ('Fuel', 'Toplivo', 3),
       ('Missiles', 'Rakety', 3),
       ('DroneParts', 'Zapchasti', 3),
       ('Scrap', 'Kuski', 3),
       ('Hull', 'Korpus', 3);

INSERT INTO ResourcesGroups
(name, description)
VALUES
('Ships', 'Has max slots'),
('Systems', 'Control lifecycle'),
('Resources', 'For move and fight'),
('Augmentations', 'Prokachka'),
('Weapons', 'Oruzhie'),
('People', 'Ludi'),
('Drones', 'Drony'),
('Fighters', 'Boyci');

# SELECT LEFT JOIN STATEMENT:
# SELECT ResourcesGroups.id, ResourcesGroups.name, ResourcesGroups.description,
#        Resources.name, Resources.description, Resources.group_id
# FROM ResourcesGroups
#          LEFT JOIN Resources ON ResourcesGroups.id=Resources.group_id;