# Создать таблицу Achievements с полями:
# id int
# resource_id int
CREATE TABLE Achievements (
    id          INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    resource_id INT NOT NULL UNIQUE
);

# Если не создана то создать таблицу ResourcesGroups с полями:
# id int
# name varchar
# description varchar
CREATE TABLE IF NOT EXISTS ResourcesGroups (
    id          INT PRIMARY KEY NOT NULL UNIQUE,
    name        varchar(50)     NOT NULL UNIQUE,
    description varchar(120)    NOT NULL
);

# Если не создана то создать таблицу Resources с полями:
# id int
# name varchar
# description varchar
# group_id int
# permanent boolean
CREATE TABLE IF NOT EXISTS Resources (
    id          INT             NOT NULL UNIQUE,
    name        varchar(50)     NOT NULL UNIQUE,
    description varchar(120)    NOT NULL,
    group_id    INT             NOT NULL,
    permanent   BOOLEAN         NOT NULL,
    FOREIGN KEY (id) REFERENCES Achievements(resource_id),
    FOREIGN KEY (group_id) REFERENCES ResourcesGroups(id)
);

# Добавить в этот файл SQL скрипты для заполнения таблиц данными из GoogleDocs.
# https://docs.google.com/spreadsheets/d/167KEn2IT7hZb-g3VfPGJTjFj7ujDB6yWOSyZoo-HjkU/edit?usp=sharing
INSERT INTO Achievements (resource_id)
VALUES (1011), (1012), (1013), (1014), (1015), (1016), (1017), (1018), (1019);

INSERT IGNORE INTO ResourcesGroups (id, name, description)
VALUES (1, 'Ships', 'Has max slots'),
       (2, 'Bays', 'Control lifecycle'),
       (3, 'Resources', 'For move and fight'),
       (4, 'Augmentations', 'Prokachka'),
       (5, 'Weapons', 'Oruzhie'),
       (6, 'People', 'Ludi'),
       (7, 'Drones', 'Drony'),
       (8, 'Fighters', 'Boyci'),
       (9, 'Upgrades', 'Usovershenstvovaniya'),
       (10, 'Achievements', 'Dostizheniya'),
       (11, 'Notification', 'Uvedomleniya'),
       (12, 'Dialogs', 'Razgovory');

INSERT INTO Resources (id, name, description, group_id, permanent)
VALUES (1011, 'First blood', 'Win first time', 10, true),
       (1012, 'Equipped', 'Get upgrade', 10, true),
       (1013, 'Sniper!', '5 hits without miss', 10, true),
       (1014, 'Long runner', 'Play more than hour', 10, true),
       (1015, 'Welcome!', 'Start the game', 10, true),
       (1016, 'Unlucky', 'Miss three times in a row', 10, true),
       (1017, 'RIP', 'Loose the game', 10, true),
       (1018, 'Sneaky', 'Get stealth weapon', 10, true),
       (1019, 'Medic', 'Make repair', 10, true);
