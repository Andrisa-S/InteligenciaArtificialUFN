% PROLOG  é uma linguagem do paradigma lógico = o programador implementa o que quer e quando quer
% Usa como motor de raciocínio o método de busca por PROFUNDIDADE (recursivo e de força bruta)
% Baseado em sentenças ou predicados ou assertivas ou cláusulas
% O mais comum é usar PREDICADO = relação entre os objetos da sentença.
% Em PROLOG um argumento/parâmetro pode ser: OBJETO, LITERAL, VARIÁVEL (1ª letra é maiúscula)

% fato no predicado jogador(nome,idade)
jogador('Andrisa', 17).
jogador('Mateus', 25).
jogador('Alexandre', 45).
jogador('Gustavo', 23).
jogador('Júlia', 16).

% fato no predicado homem(nome)
homem('Mateus').
homem('Alexandre').
homem('Gustavo').

% regra no predicado mulher(nome)
mulher(M) :-  % :- significa se somente se
    		jogador(M,_),
    		not(homem(M)).

% fato no predicado joga(nome, tipo)
joga('Andrisa', 'RPG').
joga('Mateus', 'RPG').
joga('Alexandre', 'RPG').
joga('Gustavo', 'MMO').
joga('Júlia', 'RPG').
joga('Júlia', 'FPS').

% fato no predicado jogo(nomeJogo, tipo, classificacaoEtaria)
jogo('The sims 4', 'RPG', 14).
jogo('The Witcher 3', 'RPG', 18).
jogo('Counter Strike', 'MMO', 18).
jogo('Bioshock', 'FPS', 10).

% regra no predicado recomendaRPG(nome, jogo)
recomendaRPG(Pessoa,Jogo) :- jogador(Pessoa, IdadeJogador),
                             joga(Pessoa,'RPG'),
                             jogo(Jogo,'RPG',IdadeCensura),
                             IdadeJogador >= IdadeCensura.

censura(Pessoa, Jogo) :- jogador(Pessoa, IdadeJogador),
    					joga(Pessoa, Tipo),
    					jogo(Jogo, Tipo, IdadeCensura),
    					IdadeJogador >= IdadeCensura.
