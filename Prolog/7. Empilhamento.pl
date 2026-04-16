sobre("Abajur", "Mesa").
sobre("TV", "Rack").
sobre("Microondas", "Geladeira").
sobre("Gato", "Sofá").
sobre("Cachorro", "Tapete").

no_chao("Mesa").
no_chao("Rack").
no_chao("Geladeira").
no_chao("Sofá").
no_chao("Tapete").
no_chao("Fogão").
no_chao("Cama").

abaixo(X, Y) :-
    sobre(Y, X),
    no_chao(X).

bloco_livre(X) :-
    no_chao(X),
    \+ (sobre(_, X)).