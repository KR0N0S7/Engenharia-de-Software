INSERT INTO paises (descricao) VALUES ('Brasil');
INSERT INTO paises (descricao) VALUES ('Argentina');
INSERT INTO paises (descricao) VALUES ('Japão');
INSERT INTO paises (descricao) VALUES ('França');
INSERT INTO paises (descricao) VALUES ('Africa do Sul');


INSERT INTO estados (descricao, sigla) VALUES ('São Paulo', 'SP');
INSERT INTO estados (descricao, sigla) VALUES ('Amazonas', 'AM');
INSERT INTO estados (descricao, sigla) VALUES ('Rio de Janeiro', 'RJ');
INSERT INTO estados (descricao, sigla) VALUES ('Paraná', 'PR');
INSERT INTO estados (descricao, sigla) VALUES ('Tocantins', 'TO');


INSERT INTO cidades (descricao) VALUES ('Mogi das Cruzes');
INSERT INTO cidades (descricao) VALUES ('São Paulo');
INSERT INTO cidades (descricao) VALUES ('Suzano');
INSERT INTO cidades (descricao) VALUES ('Franca');
INSERT INTO cidades (descricao) VALUES ('São José');


INSERT INTO tipos_logradouros (nome, descricao) VALUES ('Rua', 'Exemplo');
INSERT INTO tipos_logradouros (nome, descricao) VALUES ('Avenida', 'Exemplo');

INSERT INTO tipos_enderecos (nome, descricao) VALUES ('Residencial', 'Exemplo');
INSERT INTO tipos_enderecos (nome, descricao) VALUES ('Trabalho', 'Exemplo');


INSERT INTO enderecos (cep, logradouro, numero, bairro, complemento) VALUES ('00000000', 'Lovelace', '17', 'Cerejeiras', 'Casa');
INSERT INTO enderecos (cep, logradouro, numero, bairro, complemento) VALUES ('76543213', 'Neumann', '37', 'Olimpo', 'Apto 32');


INSERT INTO departamentos (descricao) VALUES ('TI');
INSERT INTO departamentos (descricao) VALUES ('Administração');
INSERT INTO departamentos (descricao) VALUES ('Marketing');


INSERT INTO fornecedores (cnpj, dt_cadastro, email, inscricao_estadual, inscricao_municipal, nm_fantasia, rz_social) VALUES ('12345678901234', '17052017', 'teste@teste', 'Exemplo', 'Exemplo', 'Empty', '234RT1');
INSERT INTO fornecedores (cnpj, dt_cadastro, email, inscricao_estadual, inscricao_municipal, nm_fantasia, rz_social) VALUES ('12345678901237', '27122021', 'exempl@com.br', 'Exemplo2', 'Exemplo2', 'BlackSpace', '4212WSE');


INSERT INTO usuarios (login, senha) VALUES ('admin', 'admin');
INSERT INTO usuarios (login, senha) VALUES ('L@7ty', '1234+aw/\');
INSERT INTO usuarios (login, senha) VALUES ('neumann', 'q12fsd!ca#');
INSERT INTO usuarios (login, senha) VALUES ('user1237', '123');
INSERT INTO usuarios (login, senha) VALUES ('hopper', 'saf[]wer2*6723');



