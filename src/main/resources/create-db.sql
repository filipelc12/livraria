DROP table if exists autor cascade;

create table autor
(
    id SERIAL NOT NULL,
    data_de_criacao character varying(12) NOT NULL,
    descricao character varying(1200) NOT NULL,
    email character varying(100) NOT NULL,
    nome character varying(100) NOT NULL,
    PRIMARY KEY (id)
);

