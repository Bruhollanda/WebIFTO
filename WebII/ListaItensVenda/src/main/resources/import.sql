INSERT INTO produto (descricao, valor) VALUES ( 'Ovo', 15.00 );
INSERT INTO produto (descricao, valor) VALUES ( 'Frango', 14.00 );
INSERT INTO produto (descricao, valor) VALUES ( 'Whey', 113 );

INSERT INTO venda(data) VALUES ('2023-10-10');
INSERT INTO venda(data) VALUES ('2024-01-25');

INSERT INTO item_venda(quantidade, produto_id, venda_id) VALUES (2, 1, 1)
INSERT INTO item_venda(quantidade, produto_id, venda_id) VALUES (1, 3, 1)
INSERT INTO item_venda(quantidade, produto_id, venda_id) VALUES (5, 2, 1)
INSERT INTO item_venda(quantidade, produto_id, venda_id) VALUES (10, 2, 1)


INSERT INTO item_venda(quantidade, produto_id, venda_id) VALUES (1, 1, 2)
INSERT INTO item_venda(quantidade, produto_id, venda_id) VALUES (2, 3, 2)
INSERT INTO item_venda(quantidade, produto_id, venda_id) VALUES (3, 3, 2)
INSERT INTO item_venda(quantidade, produto_id, venda_id) VALUES (4, 2, 2)
