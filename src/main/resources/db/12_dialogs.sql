CREATE TABLE Dialogs
(
    id          INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    resource_id INT             NOT NULL
);

INSERT INTO Dialogs (resource_id)
VALUES (170),
       (171),
       (172),
       (173),
       (174),
       (175),
       (176),
       (177),
       (178),
       (179);

INSERT INTO Resources
    (id, name, description, group_id, permanent)
VALUES (170, 'Dialog_1', 'Pervyy Dialog', 12, true),
       (171, 'Dialog_2', 'Vtoroy Dialog', 12, true),
       (172, 'Dialog_3', 'Tretiy Dialog', 12, true),
       (173, 'Dialog_4', 'Chetvertyy Dialog', 12, true),
       (174, 'Dialog_5', 'Pyatyy Dialog', 12, true),
       (175, 'Dialog_6', 'Shestoy Dialog', 12, true),
       (176, 'Dialog_7', 'Sedmoy Dialog', 12, true),
       (177, 'Dialog_8', 'Vasmoy Dialog', 12, true),
       (178, 'Dialog_9', 'Devyatyy Dialog', 12, true),
       (179, 'Dialog_10', 'Desyatyy Dialog', 12, true);
