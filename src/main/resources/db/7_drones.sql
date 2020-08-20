CREATE TABLE Drones
(
    id          INT NOT NULL AUTO_INCREMENT,
    resource_id INT NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO Drones
    (resource_id)
VALUES (120),
       (121),
       (122),
       (123),
       (124),
       (125),
       (126),
       (127),
       (128),
       (129),
       (130),
       (131),
       (132),
       (133),
       (134),
       (135),
       (136),
       (137),
       (138),
       (139);


INSERT INTO Resources
    (id, name, description, group_id, permanent)
VALUES (120, 'Boarding Drone', 'Dron - internat', 7, true),
       (121, 'Boarding Drone (Boss)', 'Dron-abordazhnik (boss)', 7, true),
       (122, 'Ion Intruder', 'Ionnyy narushitel', 7, true),
       (123, 'Combat Drone Mark I', 'Boyevoy dron Mark I', 7, true),
       (124, 'Combat Drone Mark II', 'Boyevoy dron Mark II', 7, true),
       (125, 'Anti-Ship Beam Drone I', 'Protivokorabelnyy luch Drone I', 7, true),
       (126, 'Anti-Ship Beam Drone II', 'Protivokorabelnyy luch Drone II', 7, true),
       (127, 'Anti-Ship Fire Drone', ' Protivokorabelnyy pozharnyy dron ', 7, true),
       (128, 'Anti-Ship Ion Drone I', 'Protivokorabelnyy ionnyy dron I', 7, true),
       (129, 'Anti-Ship Missile Drone I', 'Protivokorabelnyy raketnyy bespilotnik I', 7, true),
       (130, 'Anti-Personnel Drone', 'Protivopekhotnyy dron ', 7, true),
       (131, 'System Repair Drone', 'Dron dlya vosstanovleniya sistemy ', 7, true),
       (132, 'Hull Repair Drone', 'Dron dlya remonta korpusa', 7, true),
       (133, 'Defensive Drones', 'Zashchitnyye drony', 7, true),
       (134, 'Defense Drone Mark II', 'Oboronitelnyy dron Mark II', 7, true),
       (136, 'Defense Drone Mark II (Boss)', 'Dron zashchity Mark II (boss)', 7, true),
       (137, 'Defense Drone Mark II (Enemy)', 'Dron zashchity Mark II (Vrag)', 7, true),
       (138, 'Anti-Combat Drone', 'Antiboyevoy dron', 7, true),
       (139, 'Shield Overcharger', 'Shield Overcharger', 7, true);
