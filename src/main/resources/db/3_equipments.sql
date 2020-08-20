CREATE TABLE Equipments
(
    id          INT NOT NULL AUTO_INCREMENT,
    resource_id INT NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO Equipments
    (resource_id)
VALUE (28),
      (29),
      (30),
      (31),
      (32);

INSERT INTO Resources
    (id, name, description, group_id, permanent)
VALUES (28, 'Fuel', 'Toplivo', 3, true),
       (29, 'Missiles', 'Snaryady', 3, true),
       (30, 'Drone Parts', 'Zapchasti dlya dronov', 3, true),
       (31, 'Scrap', 'Detalki', 3, true),
       (32, 'Hull', 'Korpusa', 3, true);
