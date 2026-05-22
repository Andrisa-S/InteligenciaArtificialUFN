// Agent robo1 in project almoxarifado

/* Initial beliefs and rules */
viagens(r1, 5).
guarda(peq).

/* Initial goals */

!start.

+!start : true
    <-
        ?viagens(r1, Qtd);
        ?guarda(Peca);
        .print("Sou responsável pelas peças ", Peca, " e tenho ", Qtd, " viagens").

+peca(Peca) : viagens(r1, Qtd) & Qtd > 0 & guarda(Peca)
    <-
        .print("Percebi uma peça ", Peca, " e vou guardá-la");
        guardar(Peca);
        -viagens(r1, Qtd);
        NovoQtd = Qtd - 1;
        +viagens(r1, NovoQtd).

+peca(Peca) : guarda(Peca)
    <-
        .print("Percebi uma peça ", Peca, " mas não tenho mais como guarda peças").

+peca(Peca) : Peca == grd & viagens(r1, Qtd)  & Qtd > 0
    <-
        .print("Percebi uma peça ", Peca, " mas vou chamar o r2");
        .send(r2, askOne, viagens(r2, Qtd_r2));
        Qtd_r2 > 0;
        .print("r2 aceitou me ajudar").

+peca(Peca) : Peca == grd & viagens(r1, Qtd)  & Qtd > 0
    <-
        .print("r2 não pode me ajudar...").

