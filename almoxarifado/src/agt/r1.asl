// Agent robo1 in project almoxarifado

/* Initial beliefs and rules */
viagens(5).
guarda(peq).

/* Initial goals */

!start.

+!start : true
    <-
        ?viagens(Qtd);
        ?guarda(Peca);
        .print("Sou responsável pelas peças ", Peca, " e tenho ", Qtd, " viagens").

+peca(Peca) : viagens(Qtd) & Qtd > 0 & guarda(Peca)
    <-
        .print("Percebi uma peça ", Peca, " e vou guardá-la");
        guardar(Peca).

+peca(Peca) : guarda(Peca)
    <-
        .print("Percebi uma peça ", Peca, " mas não tenho mais como guarda peças").


