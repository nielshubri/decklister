INSERT INTO Deck (id,name,uuid) VALUES (1,'Sneak and Show',uuid());
INSERT INTO Deck (id,name,uuid) VALUES (2,'Elves',uuid());

INSERT INTO Card (id,name,uuid,deck_id) VALUES (1,'Griselbrand',uuid(),1);
INSERT INTO Card (id,name,uuid,deck_id) VALUES (2,'Sneak Attack',uuid(),1);
INSERT INTO Card (id,name,uuid,deck_id) VALUES (3,'Forest',uuid(),2);
INSERT INTO Card (id,name,uuid,deck_id) VALUES (4,'Nettle Sentinel',uuid(),2);