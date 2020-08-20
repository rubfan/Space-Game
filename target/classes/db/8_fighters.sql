CREATE TABLE Fighters
(
    id          INT NOT NULL AUTO_INCREMENT,
    resource_id INT NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO Fighters
    (resource_id)
VALUES (140),
       (141),
       (142),
       (143),
       (144);

INSERT INTO Resources
    (id, name, description, group_id, permanent)
VALUES (140, 'Fighter 1', 'Boyets 1', 8, true),
       (141, 'Fighter 2', 'Boyets 2', 8, true),
       (142, 'Fighter 3', 'Boyets 3', 8, true),
       (143, 'Fighter 4', 'Boyets 4', 8, true),
       (144, 'Fighter 5', 'Boyets 5', 8, true);
