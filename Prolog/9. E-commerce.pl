cliente("Andrisa", 10.0).
cliente("Mateus", 50.5).
cliente("Gustavo", 0.0).
cliente("Adele", 1000.0).
cliente("Beyonce", 90000.0).

produto("Ferrari", 8000.0).
produto("Pão", 3.0).
produto("Casa", 500.0).
produto("Arroz", 20.0).
produto("Sushi", 100.0).

pode_comprar(Nome, Item) :-
    cliente(Nome, Saldo),
    produto(Item, Preco),
    Saldo >= Preco.