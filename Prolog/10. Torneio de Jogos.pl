venceu("Andrisa", "Gustavo").
venceu("Mateus", "Gustavo").
venceu("Gustavo", "Bitas").
venceu("Mateus", "Andrisa").
venceu("Bitas", "Gustavo").

invicto(Jogador) :-
    \+ venceu(_, Jogador).