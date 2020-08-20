CREATE TABLE Notifications
(
    id          INT NOT NULL AUTO_INCREMENT,
    resource_id INT NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO Notifications (resource_id)
VALUES (159),
       (160),
       (161),
       (162),
       (163),
       (164),
       (165),
       (166),
       (167),
       (168),
       (169);

INSERT INTO Resources
(id, name, description, group_id, permanent)
VALUES (159, 'Notification_1', 'Pervyy uvedomleniye', 11, true),
       (160, 'Notification_2', 'Vtoroy uvedomleniye', 11, true),
       (161, 'Notification_3', 'Tretiy uvedomleniye', 11, true),
       (162, 'Notification_4', 'Chetvertyy uvedomleniye', 11, true),
       (163, 'Notification_5', 'Pyatyy uvedomleniye', 11, true),
       (164, 'Notification_6', 'Shestoy uvedomleniye', 11, true),
       (165, 'Notification_7', 'Sedmoy uvedomleniye', 11, true),
       (166, 'Notification_8', 'Vasmoy uvedomleniye', 11, true),
       (167, 'Notification_9', 'Devyatyy uvedomleniye', 11, true),
       (168, 'Notification_10', 'Devyatyy uvedomleniye', 11, true),
       (169, 'Notification_11', 'Desyatyy uvedomleniye', 11, true);
