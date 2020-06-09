
create table tbClassificacao(
idClassificacao int not null auto_increment primary key,
rank varchar(45),
nivel int,
pontuacao float);

create table tbUsuario(
idUsuario int not null auto_increment primary key,
nome varchar(30) ,
idade int null,
login varchar(45),
email varchar(45),
estado varchar(45),
pais varchar(45),
senha varchar(10),
fkClassificacao int not null, 
foreign key (fkClassificacao) references tbClassificacao (idClassificacao));

create table mensagem(
idMensagem  int not null auto_increment primary key,
texto varchar(100),
data_hora datetime,
de_quem int not null,
para_quem int not null,
foreign key (de_quem) references tbUsuario (idUsuario),
foreign key (para_quem) references tbUsuario (idUsuario));

create table tbSabedoria(
idSabedoria int not null auto_increment primary key,
conhecimento varchar(45) ,
descricao varchar(100),
level INT );

create table tbSabedoria_tbUsuario(
sabedoria_id int not null,
usuario_id int not null,
foreign key (sabedoria_id) references tbSabedoria (idSabedoria),
foreign key (usuario_id) references tbUsuario (idUsuario),
primary key (sabedoria_id, usuario_id));

create table tbInteresse (
idInteresse int not null auto_increment primary key ,
descricao varchar(100),
palavra_chave varchar(45));

create table tbInteresse_tbUsuario(
interesse_id int not null,
usuario_id int not null,
foreign key (interesse_id) references tbInteresse (idInteresse),
foreign key (usuario_id) references tbUsuario (idUsuario),
primary key (interesse_id, usuario_id));


-- TEM  DUAS TABELAS QUE FORAM CRIADAS POR TERMOS RELACIONAMENTO DE MUITOS PARA MUITOS 
--tbSabedoria_tbUsuario e tbInteresse_tbUsuario














