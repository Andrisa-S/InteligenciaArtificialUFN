**Tarefa IA: Modelagem Canibais e Missionários - Andrisa Santos**



**Problema:** Três missionários e três canibais estão à beira de um rio e dispõem de um barco com capacidade para apenas duas pessoas. O problema consiste em determinar as tripulações de uma série de travessias de forma que todo o grupo atravesse para o outro lado do rio, respeitando a condição de que, em nenhum momento, os canibais sejam mais numerosos do que os missionários em qualquer uma das margens.



**Modelagem:**



1. Estados

&#x09;int canEsq (canibais na esquerda)

&#x09;int canDir (canibais na direita)

&#x09;int misEsq (missionários na esquerda)

&#x09;int misDir (missionários na direita)

&#x09;char barco (lado do barco)

&#x09;String op (Números na esquerda e posição do barco)

&#x09;

&#x09;Estado inicial:

&#x09;	canEsq, misEsq = 3

&#x09;	canDir, misDir = 0

&#x09;	barco = 'e'

&#x09;	op = 33E



**2.** Regras de transições

&#x09;**R1)** Levar 1 missionário

&#x09;**R2)** Levar 1 canibal

&#x09;**R3)** Levar 1 missionário e 1 canibal

&#x09;**R4)** Levar 2 missionários

&#x09;**R5)** Levar 2 canibais



**3.** Restrições

&#x09;misEsq >= canEsq 

&#x09;misDir >= canDir



**4.** Lista de visitados

&#x09;Concatenar e transformar em string as 2 variáveis da esquerda a variável do barco.

&#x09;'11e'

&#x09;'22d'

&#x09;...



**5.** Função objetivo

&#x09;

&#x09;Objetivo estado final:

&#x09;	canDir, misDir = 3

&#x09;	canEsq, misEsq = 0

&#x09;	barco = 'd'

&#x09;	op = 00D



