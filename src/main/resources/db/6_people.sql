CREATE TABLE People
(
    id          INT NOT NULL AUTO_INCREMENT,
    resource_id INT NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO People
(resource_id)
VALUES (115),
       (116),
       (117),
       (118),
       (119);

INSERT INTO Resources
    (id, name, description, group_id, permanent)
VALUES
    (115, 'Crew Member 1', 'Chlen ekipazha 1', 6, true),
    (116, 'Crew Member 2', 'Chlen ekipazha 2', 6, true),
    (117, 'Crew Member 3', 'Chlen ekipazha 3', 6, true),
    (118, 'Crew Member 4', 'Chlen ekipazha 4', 6, true),
    (119, 'Crew Member 5', 'Chlen ekipazha 5', 6, true);
