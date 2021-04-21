--Oracle Database 11g Express Edition Release 11.2.0.2.0 - 64bit Production
--TAB USUARIO
create table ZUP.USUARIO(
    id_usuario number not null,
    cpf varchar2(14) not null,
    nm_usuario varchar2(100) null,
    email varchar2(150) not null,
    dt_nasc date null,
    constraint pk_id_usuario primary key (id_usuario),
    constraint uk_cpf_usuario unique(cpf),
    constraint uk_email unique(email)
);
--SEQUENCE USUARIO
create sequence ZUP.SEQ_ID_USUARIO
minvalue 1
maxvalue 9999999999
start with 1
increment by 1
nocache
nocycle
;
--TAB ENDERECO
create table ZUP.ENDERECO(
    id_endereco number not null,
    id_usuario number not null,
    cep varchar2(9) not null,
    logradouro varchar2(300) null,
    numero number null,
    complemento varchar2(100) null,
    bairro varchar2(100) null,
    cidade varchar2(100) null,
    uf varchar2(2) null,
    constraint pk_id_endereco primary key(id_endereco),
    constraint fk_endereco_usuario foreign key(id_usuario) references usuario(id_usuario)
);
--SEQUENCE ENDERECO
create sequence ZUP.SEQ_ID_ENDERECO
minvalue 1
maxvalue 9999999999
start with 1
increment by 1
nocache
nocycle
;