CREATE TABLE `Upgrades`
(
    `id`          int primary key NOT NULL auto_increment,
    `resource_id` int             NOT NULL
);

-- созданы таблицы ресурсы и ресурсы апгрейд

INSERT INTO Upgrades (resource_id)
values (145),
       (146),
       (147),
       (148),
       (149);

INSERT INTO Resources (id, name, description, group_id, permanent)
values (145, 'first', 'here will be first up', 9, true),
       (146, 'second', 'here will be second up', 9, true),
       (147, 'third', 'here will be third up', 9, true),
       (148, 'fourth', 'here will be fourth up', 9, true),
       (149, 'fifth', 'here will be fifth up', 9, true);

INSERT INTO ResourcesGroups
(name, description)
VALUES ('Ships', 'Has max slots'),
       ('Bays', 'Control lifecycle'),
       ('Resources', 'For move and fight'),
       ('Augmentations', 'Prokachka'),
       ('Weapons', 'Oruzhie'),
       ('People', 'Ludi'),
       ('Drones', 'Drony'),
       ('Fighters', 'Boyci'),
       ('Upgrades', 'Usovershenstvovaniya'),
       ('Achievements', 'Dostizheniya'),
       ('Notification', 'Uvedomleniya'),
       ('Dialogs', 'Razgovory');

ALTER TABLE Upgrades
    ADD FOREIGN KEY (resource_id) REFERENCES Resources (id);

ALTER TABLE Resources
    ADD FOREIGN KEY (group_id) REFERENCES ResourcesGroups (id);
    

