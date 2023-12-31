-- Inserir Estados
INSERT INTO ESTADO (NOME) VALUES ('Acre');
INSERT INTO ESTADO (NOME) VALUES ('Alagoas');
INSERT INTO ESTADO (NOME) VALUES ('Amazonas');
INSERT INTO ESTADO (NOME) VALUES ('Amapá');
INSERT INTO ESTADO (NOME) VALUES ('Bahia');
INSERT INTO ESTADO (NOME) VALUES ('Ceará');
INSERT INTO ESTADO (NOME) VALUES ('Distrito Federal');
INSERT INTO ESTADO (NOME) VALUES ('Espírito Santo');
INSERT INTO ESTADO (NOME) VALUES ('Goiás');
INSERT INTO ESTADO (NOME) VALUES ('Maranhão');
INSERT INTO ESTADO (NOME) VALUES ('Minas Gerais');
INSERT INTO ESTADO (NOME) VALUES ('Mato Grosso do Sul');
INSERT INTO ESTADO (NOME) VALUES ('Mato Grosso');
INSERT INTO ESTADO (NOME) VALUES ('Pará');
INSERT INTO ESTADO (NOME) VALUES ('Paraíba');
INSERT INTO ESTADO (NOME) VALUES ('Pernambuco');
INSERT INTO ESTADO (NOME) VALUES ('Piauí');
INSERT INTO ESTADO (NOME) VALUES ('Paraná');
INSERT INTO ESTADO (NOME) VALUES ('Rio de Janeiro');
INSERT INTO ESTADO (NOME) VALUES ('Rio Grande do Norte');
INSERT INTO ESTADO (NOME) VALUES ('Rondônia');
INSERT INTO ESTADO (NOME) VALUES ('Roraima');
INSERT INTO ESTADO (NOME) VALUES ('Rio Grande do Sul');
INSERT INTO ESTADO (NOME) VALUES ('Santa Catarina');
INSERT INTO ESTADO (NOME) VALUES ('Sergipe');
INSERT INTO ESTADO (NOME) VALUES ('São Paulo');
INSERT INTO ESTADO (NOME) VALUES ('Tocantins');

-- Adicione mais estados aqui, se necessário

-- Inserir Cidades
INSERT INTO CIDADE (NOME, ESTADO_ID) VALUES ('São Paulo', 26);
INSERT INTO CIDADE (NOME, ESTADO_ID) VALUES ('Rio de Janeiro', 19);
INSERT INTO CIDADE (NOME, ESTADO_ID) VALUES ('Belo Horizonte', 11);
INSERT INTO CIDADE (NOME, ESTADO_ID) VALUES ('Vitória', 8);
INSERT INTO CIDADE (NOME, ESTADO_ID) VALUES ('Florianópolis', 24);
INSERT INTO CIDADE (NOME, ESTADO_ID) VALUES ('Porto Algere', 23);
INSERT INTO CIDADE (NOME, ESTADO_ID) VALUES ('Coritiba', 18);

-- Adicione mais cidades aqui, se necessário

-- Inserir Clientes
INSERT INTO CLIENTE (NOME, EMAIL, CPF_OU_CNPJ, TIPO, SENHA) VALUES ('Cliente Exemplo', 'cliente@example.com', '12345678901', 1, 'senha123');
-- Adicione mais clientes aqui, se necessário

-- Inserir Telefones dos Clientes
INSERT INTO TELEFONE (CLIENTE_ID, TELEFONES) VALUES (1, '(11) 1234-5678');
INSERT INTO TELEFONE (CLIENTE_ID, TELEFONES) VALUES (1, '(11) 9876-5432');
-- Adicione mais telefones dos clientes aqui, se necessário

-- Inserir Perfis dos Clientes

INSERT INTO PERFIS (CLIENTE_ID, PERFIS) VALUES (1, 2); -- Cliente Exemplo tem perfil de CLIENTE
-- Adicione mais perfis dos clientes aqui, se necessário


-- Inserir Categorias
INSERT INTO CATEGORIA (NOME) VALUES ('Bolos');
INSERT INTO CATEGORIA (NOME) VALUES ('Doces');
-- Adicione mais categorias aqui, se necessário

-- Inserir Produtos
INSERT INTO PRODUTO (NOME, PRECO) VALUES ('Bolo de Chocolate', 25.0);
INSERT INTO PRODUTO (NOME, PRECO) VALUES ('Bolo de Morango', 28.0);
INSERT INTO PRODUTO (NOME, PRECO) VALUES ('Brigadeiro', 2.5);
-- Adicione mais produtos aqui, se necessário

-- Relação entre Produtos e Categorias (produto_categoria)
INSERT INTO PRODUTO_CATEGORIA (PRODUTO_ID, CATEGORIA_ID) VALUES (1, 1); -- Bolo de Chocolate é da categoria 'Bolos'
INSERT INTO PRODUTO_CATEGORIA (PRODUTO_ID, CATEGORIA_ID) VALUES (2, 1); -- Bolo de Morango é da categoria 'Bolos'
INSERT INTO PRODUTO_CATEGORIA (PRODUTO_ID, CATEGORIA_ID) VALUES (3, 2); -- Brigadeiro é da categoria 'Doces'
-- Adicione mais relações entre produtos e categorias aqui, se necessário

-- Inserir Endereços
INSERT INTO ENDERECO (LOGRADOURO, NUMERO, COMPLEMENTO, BAIRRO, CEP, CLIENTE_ID, CIDADE_ID) VALUES ('Rua A', '123', 'Apto 101', 'Centro', '12345-678', 1, 1);
-- Adicione mais endereços aqui, se necessário

-- Inserir Pedidos
INSERT INTO PEDIDO (INSTANTE, CLIENTE_ID, ENDERECO_ID) VALUES ('2023-08-11 12:00:00', 1, 1);
-- Adicione mais pedidos aqui, se necessário

-- Inserir Itens de Pedido
INSERT INTO ITEM_PEDIDO (PEDIDO_ID, PRODUTO_ID, DESCONTO, QUANTIDADE, PRECO) VALUES (1, 1, 0.0, 2, 30.0);
-- Adicione mais itens de pedido aqui, se necessário

-- Inserir Pagamentos
INSERT INTO PAGAMENTO (ESTADO, PEDIDO_ID) VALUES (1, 1);
-- Adicione mais pagamentos aqui, se necessário

-- Inserir Pagamentos com Cartão
INSERT INTO PAGAMENTO_COM_CARTAO (NUMERO_DE_PARCELAS, PEDIDO_ID) VALUES (3, 1);
-- Adicione mais pagamentos com cartão aqui, se necessário