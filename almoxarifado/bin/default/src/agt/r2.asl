// Agent robo2 in project almoxarifado

/* Initial beliefs and rules */
viagens(10).
guarda(med).

/* Initial goals */

!start.

+!start : true
    <-
        ?viagens(Qtd);
        ?guarda(Peca);
        .print("Sou responsável pelas peças ", Peca, " e tenho ", Qtd, " viagens").

/* Plans */

+!start : true <- .print("hello world.").
