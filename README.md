# Visual-mix-oficial
Utilizar o pessoa (Os demais são meus cases de estudo);

Script tabela para o projeto pessoa

CREATE TABLE t_pessoa_fisica
(
id_pessoa number(10) NOT NULL,
nome varchar2(50) NOT NULL,
endereco varchar2(50),
tel varchar2(10),
email varchar2(20),
rg varchar2(14)   )

Alter table t_pessoa_fisica add constraint id_pessoa_pk primary key (id_pessoa);
