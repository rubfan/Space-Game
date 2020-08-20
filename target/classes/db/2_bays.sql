CREATE TABLE Bays
(
    id          INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    resource_id INT             NOT NULL
);

INSERT INTO Bays
    (resource_id)
VALUES (11),
       (12),
       (13),
       (14),
       (15),
       (16),
       (17),
       (18),
       (19),
       (20),
       (21),
       (22),
       (23),
       (24),
       (25),
       (26),
       (27);

INSERT INTO Resources
(id, name, description, group_id, permanent)
VALUES (11, 'Shields', 'Schity', 2, true),
       (12, 'Engines', 'Dvigately', 2, true),
       (13, 'Oxygen', 'Kislorod', 2, true),
       (14, 'Weapon Control', 'Upravlenie oruzhiem', 2, true),
       (15, 'Drone Control', 'Upravlenie dronami', 2, true),
       (16, 'Medbay', 'Sredniy otsek', 2, true),
       (17, 'Crew Teleporter', 'Teleport comandy', 2, true),
       (18, 'Cloaking', 'Maskirovka', 2, true),
       (19, 'Artillery Beam', 'Artileristskiy luch', 2, true),
       (20, 'Artillery Flak', 'Artileristskaya zenitka', 2, true),
       (21, 'Clone Bay', 'Otsek klonirovaniya', 2, true),
       (22, 'Mind Control', 'Control soznaniya', 2, true),
       (23, 'Hacking', 'Vzlom', 2, true),
       (24, 'Piloting', 'Pilotirovanie', 2, true),
       (25, 'Sensors', 'Sensory', 2, true),
       (26, 'Door System', 'Dvernaya systema', 2, true),
       (27, 'Backup Batter', 'Rezervnaya batareya', 2, true);
