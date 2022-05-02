INSERT INTO deck (id,name,uuid) VALUES (1,'SneakAndShow',uuid());
INSERT INTO deck (id,name,uuid) VALUES (2,'Elves',uuid());

INSERT INTO card (id,name, quantity, uuid,deck_id) VALUES (1,'Griselbrand', 4, uuid(),1);
INSERT INTO card (id,name, quantity, uuid,deck_id) VALUES (2,'Sneak Attack', 4, uuid(),1);
INSERT INTO card (id,name, quantity, uuid,deck_id) VALUES (3,'Forest', 7, uuid(), 2);
INSERT INTO card (id,name, quantity, uuid,deck_id) VALUES (4,'Nettle Sentinel', 4, uuid(),2);