tem_penas("pinguim").
tem_penas("galinha").
tem_penas("pato").

nada("pinguim").
nada("pato").
nada("peixe").
nada("tubarão").
nada("foca").

poe_ovos("pinguim").
poe_ovos("ornitorrinco").
poe_ovos("pato").
poe_ovos("sapo").
poe_ovos("galinha").

ave(X) :-
    tem_penas(X),
    poe_ovos(X).