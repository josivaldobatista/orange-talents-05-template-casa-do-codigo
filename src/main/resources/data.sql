INSERT INTO tb_livro (titulo, resumo, sumario, preco, num_paginas, isbn, data_publicacao) VALUES ('Introdução à Visão Computacional', 'Uma abordagem prática com Python e OpenCV', '1 Introdução à Visão Computacional | 2 Preparando o ambiente de estudo', 29.90, 256, '978-85-94188-57-1', '2021-05-18 15:48:25.315173');

INSERT INTO tb_autor (nome, email, descricao, instante_criacao, livro_id) VALUES ('Felipe Barelli', 'felipe@email.com', 'Felipe Barelli é bacharel em Ciência da Computação pela Universidade Vila Velha (UVV) e especialista em Engenharia Elétrica com ênfase em Sistemas Inteligentes Aplicados à Automação pelo Instituto Federal do Espírito Santo (Ifes).', '2021-05-18 15:48:25.315173', 1);

INSERT INTO tb_categoria (nome, livro_id) VALUES ('Programação', 1);