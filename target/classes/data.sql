INSERT INTO deck (id, uuid, name) VALUES (1, uuid(), 'SneakAndShow');
INSERT INTO deck (id, uuid, name) VALUES (2, uuid(), 'Elves');

INSERT INTO card (id, uuid, name, quantity, deck_id) VALUES (1, uuid(), 'Griselbrand', 4, 1);
INSERT INTO card (id, uuid, name, quantity, deck_id) VALUES (2, uuid(), 'Sneak Attack', 4, 1);
INSERT INTO card (id, uuid, name, quantity, deck_id) VALUES (3, uuid(), 'Forest', 7, 2);
INSERT INTO card (id, uuid, name, quantity, deck_id) VALUES (4, uuid(), 'Nettle Sentinel', 4, 2);

INSERT INTO player (id, uuid, name, deck_id) VALUES (1, uuid(), 'Niels', 1);
INSERT INTO player (id, uuid, name, deck_id) VALUES (2, uuid(), 'Heiko', 2);