CREATE TABLE Ships
(
    id          INT NOT NULL AUTO_INCREMENT,
    resource_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (resource_id) REFERENCES Resources (id)
);

CREATE TABLE IF NOT EXISTS Resources
(
    id          INT          NOT NULL,
    name        VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    group_id    INT          NOT NULL,
    permanent   BOOLEAN      NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO Ships
    (resource_id)
VALUES (1),
       (2),
       (3),
       (4),
       (5),
       (6),
       (7),
       (8),
       (9),
       (10);

INSERT INTO Resources
    (id, name, description, group_id, permanent)
VALUES (1, 'The Kestrel Cruiser', 'Kreyser Pustelga', 1, true),
       (2, 'The Engi Cruiser', 'Kreyser Engi', 1, true),
       (3, 'The Federation Cruiser', 'Kreyser Federatsii', 1, true),
       (4, 'The Zoltan Cruiser', 'Kreyser Zoltan', 1, true),
       (5, 'The Mantis Cruiser', 'Kreyser Bogomol', 1, true),
       (6, 'The Slug Cruiser', 'Kreyser Slizen', 1, true),
       (7, 'The Rock Cruiser', 'Kreyser Rok', 1, true),
       (8, 'The Stealth Cruiser', 'Kreyser Nevidimka', 1, true),
       (9, 'The Lanius Cruiser', 'Kreyser Lanius', 1, true),
       (10, 'The Crystal Cruiser', 'Kreyser Kristall', 1, true);








   