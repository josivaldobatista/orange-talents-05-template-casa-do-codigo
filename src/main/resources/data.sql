
INSERT INTO tb_autor (nome, email, descricao, instante_criacao) VALUES ('Felipe Barelli', 'felipe@email.com', 'Felipe Barelli é bacharel em Ciência da Computação pela Universidade Vila Velha (UVV) e especialista em Engenharia Elétrica com ênfase em Sistemas Inteligentes Aplicados à Automação pelo Instituto Federal do Espírito Santo (Ifes).', '2015-06-02T21:34:33.616Z');

INSERT INTO tb_categoria (nome) VALUES ('Programação');

INSERT INTO tb_livro (titulo, resumo, sumario, preco, numero_paginas, isbn, data_publicacao, autor_id, categoria_id) VALUES ('Introdução à Visão Computacional', 'Uma abordagem prática com Python e OpenCV', '1 Introdução à Visão Computacional | 2 Preparando o ambiente de estudo', 29.90, 256, '978-85-94188-57-1', '2021-07-04T21:31:41.527Z', 1, 1);