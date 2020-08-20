CREATE TABLE `Upgrades`
(
    id          INT NOT NULL AUTO_INCREMENT,
    resource_id INT NOT NULL,
    PRIMARY KEY (id)
);

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
