CREATE TABLE Achievements
(
    id          INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    resource_id INT             NOT NULL UNIQUE
);

INSERT INTO Achievements (resource_id)
VALUES (150),
       (151),
       (152),
       (153),
       (154),
       (155),
       (156),
       (157),
       (158);

INSERT INTO Resources (id, name, description, group_id, permanent)
VALUES (150, 'First blood', 'Win first time', 10, true),
       (151, 'Equipped', 'Get upgrade', 10, true),
       (152, 'Sniper!', '5 hits without miss', 10, true),
       (153, 'Long runner', 'Play more than hour', 10, true),
       (154, 'Welcome!', 'Start the game', 10, true),
       (155, 'Unlucky', 'Miss three times in a row', 10, true),
       (156, 'RIP', 'Loose the game', 10, true),
       (157, 'Sneaky', 'Get stealth weapon', 10, true),
       (158, 'Medic', 'Make repair', 10, true);
