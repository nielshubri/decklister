INSERT INTO player (id, name) VALUES (1, 'Niels');
INSERT INTO player (id, name) VALUES (2, 'Heiko');

INSERT INTO deck (id, name, player_id) VALUES (1, 'SneakAndShow', 1);
INSERT INTO deck (id, name, player_id) VALUES (2, 'Elves', 2);

INSERT INTO card (id, name, quantity, deck_id) VALUES (1, 'Griselbrand', 4, 1);
INSERT INTO card (id, name, quantity, deck_id) VALUES (2, 'Sneak Attack', 4, 1);
INSERT INTO card (id, name, quantity, deck_id) VALUES (3, 'Forest', 7, 2);
INSERT INTO card (id, name, quantity, deck_id) VALUES (4, 'Nettle Sentinel', 4, 2);