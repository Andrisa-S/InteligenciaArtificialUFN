disciplina("Inteligência Artificial").
disciplina("Estrutura de Dados").
disciplina("Algoritmos B").

nota("Andrisa", "Algoritmos B", 8.0).
nota("Gustavo", "Algoritmos B", 6.0).
nota("Andrisa", "Inteligência Artificial", 10.0).
nota("Gustavo", "Inteligência Artificial", 7.0).
nota("Mateus", "Inteligência Artificial", 9.0).
nota("Gustavo", "EStrutura de Dados", 5.5).

aprovado(Aluno, Disciplina) :-
    nota(Aluno, Disciplina, Valor),
    Valor >= 7.0.

reprovado(Aluno, Disciplina) :-
    nota(Aluno, Disciplina, Valor),
    Valor < 7.0.