CREATE TABLE pacientes(
    id bigint not null auto_increment,
    nome varchar(100) not null,
    email varchar(100) not null unique,
    logradouro varchar(100) not null,
    bairro varchar(100) not null,
    cep varchar(9) not null,
    localidade varchar(100),
    uf char(2) not null,
    primary key(id)
)
