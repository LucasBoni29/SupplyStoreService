USE supplyStore;

INSERT INTO
  vendas(id_cliente, id_produto, quantidade, data_venda)
VALUES (11111111111, 1, 3, NOW()),
       (22222222222, 2, 5, NOW()),
       (33333333333, 3, 7, NOW());