import java.util.HashSet;
import java.util.Stack;
import javax.swing.JOptionPane;

import busca.BuscaLargura;
import busca.BuscaProfundidade;
import busca.Estado;
import busca.MostraStatusConsole;
import busca.Nodo;
import java.util.List;

public class HomemLoboAlfaceCarneiro implements Estado {
    char homem = 'e';
    char lobo = 'e';
    char alface = 'e';
    char carneiro = 'e';

    @Override
    public String getDescricao() {
       return "Problema do Homem, Lobo, Alface e Carneiro...";
    }

    public HomemLoboAlfaceCarneiro() {
        this.homem = homem;
        this.lobo = lobo;
        this.alface = alface;
        this.carneiro = carneiro;
    }

    @Override
    public boolean ehMeta() {
        return homem == 'd' && lobo == 'd' && alface == 'd' && carneiro == 'd';
    }

    @Override
    public int custo() {
        return 1;}

    @Override
    public List<Estado> sucessores() {
        return;
    }
  
}

/*  Regras de Transição
r1) levarNada
r2) levarLobo
r3) levarAlface
r4) levarCarneiro

    Restrições 
homem != lobo && lobo == carneiro || homem != carneiro && carneiro == alface

    Visitados
concatenar e transformar em string as 4 variaveis
            "eeee"
            "deed"

    Função objetivo (estado final)
homem == 'd' && lobo == 'd' && alface == 'd' && carneiro == 'd'
*/

