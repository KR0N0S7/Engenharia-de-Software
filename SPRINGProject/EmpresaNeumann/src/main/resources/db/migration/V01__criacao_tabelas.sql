
CREATE TABLE departamentos (
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
	descricao VARCHAR(100) NOT NULL
);

CREATE TABLE tipo_empresa (
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
	tipo_empresa VARCHAR(10)
);

CREATE TABLE empresas (
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
	
	tipo_empresa_id BIGINT,
		CONSTRAINT FK_empresas_tipo_empresa 
		FOREIGN KEY(tipo_empresa_id) REFERENCES tipo_empresa(id)
);

CREATE TABLE paises (
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
	descricao VARCHAR(50) NOT NULL
);

CREATE TABLE produtos (
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
	nome VARCHAR(50) NOT NULL,
	descricao VARCHAR(100)
);

CREATE TABLE tipos_enderecos  (
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
	nome VARCHAR(50) NOT NULL,
	descricao VARCHAR(50) NOT NULL
);

CREATE TABLE tipos_logradouros (
id BIGINT AUTO_INCREMENT PRIMARY KEY,
	nome VARCHAR(50) NOT NULL,
	descricao VARCHAR(50) NOT NULL
);

CREATE TABLE tipos_telefones (
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
	descricao VARCHAR(50) NOT NULL
);

CREATE TABLE estados (
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
	descricao VARCHAR(20),
	sigla CHAR(2) NOT NULL,
	
    pais_id BIGINT,
		CONSTRAINT FK_estados_paises 
		FOREIGN KEY(pais_id) REFERENCES paises(id)
);

CREATE TABLE cidades (
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
	descricao VARCHAR(50) NOT NULL,
	
    estado_id BIGINT,
		CONSTRAINT FK_cidades_estados 
		FOREIGN KEY(estado_id) REFERENCES estados(id)
);

CREATE TABLE enderecos (
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
	cep VARCHAR(8) NOT NULL,
	logradouro VARCHAR(50),
	numero VARCHAR(7) NOT NULL,
	bairro VARCHAR(50),
	complemento VARCHAR(20),
	
    cidade_id BIGINT,
		CONSTRAINT FK_enderecos_cidades 
		FOREIGN KEY(cidade_id) REFERENCES cidades(id),
    tipo_logradouro_id BIGINT,
		CONSTRAINT FK_enderecos_tipos_logradouros 
		FOREIGN KEY(tipo_logradouro_id) REFERENCES tipos_logradouros(id),
    tipo_endereco_id BIGINT,
		CONSTRAINT FK_enderecos_tipos_enderecos 
		FOREIGN KEY(tipo_endereco_id) REFERENCES tipos_enderecos(id)
);

CREATE TABLE status (
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
    status VARCHAR(10)
);

CREATE TABLE tipo_fornecimento (
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
    tipo_fornecimento VARCHAR(10)
);

CREATE TABLE fornecedores (
	id BIGINT AUTO_INCREMENT PRIMARY kEY,
	cnpj VARCHAR(20) NOT NULL,
	dt_cadastro BIGINT(8) NOT NULL,
	email VARCHAR(100) NOT NULL,
	inscricao_estadual VARCHAR(20),
	inscricao_municipal VARCHAR(20),
	nm_fantasia VARCHAR(50),
	rz_social VARCHAR(20) NOT NULL,
	
	tipo_fornecimento_id BIGINT,
		CONSTRAINT FK_fornecedores_tipo_fornecimento
		FOREIGN KEY(tipo_fornecimento_id) REFERENCES tipo_fornecimento(id),
	
	status_id BIGINT,
		CONSTRAINT FK_fornecedores_status 
		FOREIGN KEY(status_id) REFERENCES status(id),
	
    endereco_id BIGINT,
		CONSTRAINT FK_fornecedores_enderecos 
		FOREIGN KEY(endereco_id) REFERENCES enderecos(id)
);

CREATE TABLE cnaes (
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
	numero VARCHAR(50) NOT NULL,
	
	fornecedor_id BIGINT,
		CONSTRAINT FK_cnaes_fornecedores 
		FOREIGN KEY(fornecedor_id) REFERENCES fornecedores(id)
);

CREATE TABLE ordens_servicos (
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
	dt_inicio BIGINT(8) NOT NULL,
	
    empresa_id BIGINT,
		CONSTRAINT FK_ordens_servicos_empresas 
		FOREIGN KEY(empresa_id) REFERENCES empresas(id),
    fornecedor_id BIGINT,
		CONSTRAINT FK_ordens_servicos_fornecedores 
		FOREIGN KEY(fornecedor_id) REFERENCES fornecedores(id)
);

CREATE TABLE telefones (
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
	ddd VARCHAR(3),
	numero VARCHAR(10) NOT NULL,
	ddi VARCHAR(3),
    fornecedor_id BIGINT,
		CONSTRAINT FK_telefones_fornecedores 
		FOREIGN KEY(fornecedor_id) REFERENCES fornecedores(id),
    tipos_telefone_id BIGINT,
		CONSTRAINT FK_telefones_tipos_telefone 
		FOREIGN KEY(tipos_telefone_id) REFERENCES tipos_telefones(id),
	codigo VARCHAR(3) NOT NULL,
	descricao VARCHAR(50)
);

CREATE TABLE pessoas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    email VARCHAR(50),
    
    departamento_id BIGINT,
	    CONSTRAINT FK_pessoas_departamentos 
	    FOREIGN KEY(departamento_id) REFERENCES departamentos(id),
    fornecedor_id BIGINT,
	    CONSTRAINT FK_pessoas_fornecedores 
	    FOREIGN KEY(fornecedor_id) REFERENCES fornecedores(id),
    telefone_id BIGINT,
    	CONSTRAINT FK_pessoas_telefones 
    	FOREIGN KEY(telefone_id) REFERENCES telefones(id)
);

CREATE TABLE servicos (
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
	descricao VARCHAR(50) NOT NULL,
	
    ordem_servico_id BIGINT,
		CONSTRAINT FK_servicos_ordens_servicos 
		FOREIGN KEY(ordem_servico_id) REFERENCES ordens_servicos(id),
	
	fornecedor_id BIGINT,
		CONSTRAINT FK_servicos_fornecedores 
		FOREIGN KEY(fornecedor_id) REFERENCES fornecedores(id)
);

CREATE TABLE usuarios (
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
	login VARCHAR(50) NOT NULL,
	senha VARCHAR(50) NOT NULL,
	
    pessoa_id BIGINT,
		CONSTRAINT FK_usuarios_pessoas 
		FOREIGN KEY(pessoa_id) REFERENCES pessoas(id),
		
	UNIQUE KEY login_UNIQUE (login)
);

CREATE TABLE fornecimentos (
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
	
    fornecedor_id BIGINT,
		CONSTRAINT FK_fornecimentos_fornecedores 
		FOREIGN KEY(fornecedor_id) REFERENCES fornecedores(id),
    empresa_id BIGINT,
		CONSTRAINT FK_fornecimentos_empresas 
		FOREIGN KEY(empresa_id) REFERENCES empresas(id)
);