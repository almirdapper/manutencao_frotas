CREATE TABLE Abastecimento (
 idAbasteciento INT,
 qtdLitros INT,
 data CHAR(10),
 kmAbasteceimento CHAR(10)
);


CREATE TABLE CategoriaVeiculo (
 idCategoria INT,
 descricaoCategoria CHAR(10)
);


CREATE TABLE Entity0 (
);


CREATE TABLE ModeloVeiculo (
 idModelo INT,
 descricaoModelo CHAR(10)
);


CREATE TABLE OrdemDeServico (
 idOs INT,
 data CHAR(10),
 idVeiculo:int CHAR(10),
 status CHAR(10)
);


CREATE TABLE Percurso (
 idPercurso INT,
 dataSaida CHAR(10),
 horaSaida CHAR(10),
 kmSaida INT,
 trajeto CHAR(10),
 horaPrevistaChegada CHAR(10),
 dataPrevistaChegada CHAR(10),
 kmChegada INT,
 horaChegada CHAR(10),
 dataCheada CHAR(10),
 status CHAR(10),
 observacao CHAR(10)
);


CREATE TABLE Servico (
 idServico INT,
 descricaoServico CHAR(10)
);


CREATE TABLE situacaoVeiculo (
 idSituacao INT,
 descricaoSituacao CHAR(10)
);


CREATE TABLE TipoVeiculo (
 idTipo INT,
 descricaoTipo CHAR(10)
);


CREATE TABLE Veiculo (
 idVeiculo INT,
 placaVeiculo CHAR(10),
 corVeiculo CHAR(10),
 numeroPortas INT,
 situacaoVeiculo CHAR(10),
 categoria CHAR(10),
 modelo CHAR(10)
);


CREATE TABLE Funcioario (
 idUsuario INT,
 nomeUsuario CHAR(10),
 login CHAR(10),
 senha CHAR(10)
);


CREATE TABLE ItemOs (
 idItem INT,
 descricaoItem CHAR(10)
);


CREATE TABLE Manutencao (
 idManutencao INT,
 descricaoManutencao CHAR(10),
 tipoManutencao CHAR(10),
 dataManutencao CHAR(10),
 carroManutencao CHAR(10),
 statusManutencao CHAR(10)
);


CREATE TABLE Condutor (
 cnh INT,
 categoriaCnh CHAR(10),
 celular INT,
 situacao CHAR(10)
);


