disciplina("Inteligência Artificial").
disciplina("Estrutura de Dados").
disciplina("Algoritmos B").

pre_requisito("Algoritmos B", "Estrutura de Dados").
pre_requisito("Estrutura de Dados", "Inteligência Artificial").

ja_cursou("Santos","Algoritmos B").
ja_cursou("Gomes", "Estrutura de Dados").

pode_cursar(Aluno,Disciplina) :-
    ja_cursou(Aluno, Pre),
    pre_requisito(Pre, Disciplina).