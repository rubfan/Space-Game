ALTER TABLE Resources
    ADD FOREIGN KEY (group_id) REFERENCES ResourcesGroups(id);

ALTER TABLE Ships
    ADD FOREIGN KEY (resource_id) REFERENCES Resources(id);

ALTER TABLE Bays
    ADD FOREIGN KEY (resource_id) REFERENCES Resources(id);

ALTER TABLE Equipments
    ADD FOREIGN KEY (resource_id) REFERENCES Resources(id);

ALTER TABLE Augumentations
    ADD FOREIGN KEY (resource_id) REFERENCES Resources(id);

ALTER TABLE Weapons
    ADD FOREIGN KEY (resource_id) REFERENCES Resources(id);

ALTER TABLE People
    ADD FOREIGN KEY (resource_id) REFERENCES Resources(id);

ALTER TABLE Drones
    ADD FOREIGN KEY (resource_id) REFERENCES Resources(id);

ALTER TABLE Fighters
    ADD FOREIGN KEY (resource_id) REFERENCES Resources(id);

ALTER TABLE Bays
    ADD FOREIGN KEY (resource_id) REFERENCES Resources(id);

ALTER TABLE Upgrades
    ADD FOREIGN KEY (resource_id) REFERENCES Resources(id);

ALTER TABLE Achivement
    ADD FOREIGN KEY (resource_id) REFERENCES Resources(id);

ALTER TABLE Notification
    ADD FOREIGN KEY (resource_id) REFERENCES Resources(id);

ALTER TABLE Dialogs
    ADD FOREIGN KEY (resource_id) REFERENCES Resources(id);
