esta_em("Escova", "Banheiro").
esta_em("Fogão", "Cozinha").
esta_em("Roupeiro", "Quarto").
esta_em("Mesa", "Sala").
esta_em("Cama", "Quarto").
esta_em("Chuveiro", "Banheiro").
esta_em("Cadeira", "Sala").

comodo_em("Sala", "Casa1").
comodo_em("Banheiro", "Casa1").
comodo_em("Cozinha", "Casa3").
comodo_em("Quarto", "Casa2").

localizacao_geral(Objeto, Casa) :-
    esta_em(Objeto, Comodo),
    comodo_em(Comodo, Casa).