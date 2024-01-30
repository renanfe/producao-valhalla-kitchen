CREATE TABLE IF NOT EXISTS produto(
    id SERIAL NOT NULL,
    nome VARCHAR(100) NOT NULL,
    descricao VARCHAR(100) NOT NULL,
    categoria VARCHAR(30) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS pedido(
    id SERIAL NOT NULL,
    cliente_id UUID NOT NULL,
    nome_cliente VARCHAR(100) NOT NULL,
    status VARCHAR(15) NOT NULL,
    status_pagamento VARCHAR(15) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS pedido_produto(
    pedido_id INTEGER NOT NULL,
    FOREIGN KEY (pedido_id)
        REFERENCES "pedido" (id),
    produto_id INTEGER NOT NULL,
    FOREIGN KEY (produto_id)
        REFERENCES "produto" (id)
);

INSERT INTO produto (nome, descricao, categoria)
VALUES
('Odin', 'Pão, hambúrguer de carne bovina, alface, tomate, cebola, picles, maionese, ketchup, mostarda', 'Burger'),
('Thor', 'Pão, hambúrguer de frango, queijo, maionese, ketchup, mostarda', 'Burger');