import java.util.HashSet;
import java.util.Stack;
import javax.swing.JOptionPane;

import busca.BuscaLargura;
import busca.BuscaProfundidade;
import busca.Estado;
import busca.MostraStatusConsole;
import busca.Nodo;
import java.util.LinkedList;
import java.util.List;

//Falta consertar levarNada com outros

public class HomemLoboAlfaceCarneiro implements Estado {
    char homem = 'e';
    char lobo = 'e';
    char alface = 'e';
    char carneiro = 'e';
    String op;

    @Override
    public String getDescricao() {
       return "Problema do Homem, Lobo, Alface e Carneiro...";
    }

    public HomemLoboAlfaceCarneiro(char homem, char lobo, char alface, char carneiro, String op) {
        this.homem = homem;
        this.lobo = lobo;
        this.alface = alface;
        this.carneiro = carneiro;
        this.op = op;
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
        List<Estado> visitados = new LinkedList<Estado>();
        
        levarNada(visitados);
        levarLobo(visitados);
        levarAlface(visitados);
        levarCarneiro(visitados);
        
        return visitados;
    }

    private void levarNada(List<Estado> visitados) {
        if(homem == 'e'){
            HomemLoboAlfaceCarneiro novo = new HomemLoboAlfaceCarneiro('d', lobo, alface, carneiro, "Levando nada!");
            if (!visitados.contains(novo)){
                visitados.add(novo);
            }
        } else {
            HomemLoboAlfaceCarneiro novo = new HomemLoboAlfaceCarneiro('e', lobo, alface, carneiro, "Levando nada!");
            if (!visitados.contains(novo)){
                visitados.add(novo);
            }
        }
    }

    private void levarLobo(List<Estado> visitados) {
        if(lobo == 'e'){
            if(homem == 'd'){
                levarNada(visitados);
            }
            HomemLoboAlfaceCarneiro novo = new HomemLoboAlfaceCarneiro(homem, 'd', alface, carneiro, "Levando lobo!");
            if (!visitados.contains(novo)){
                visitados.add(novo);
            }
        } else {
            if(homem == 'd'){
                levarNada(visitados);
            }
            HomemLoboAlfaceCarneiro novo = new HomemLoboAlfaceCarneiro(homem, 'e', alface, carneiro, "Levando lobo!");
            if (!visitados.contains(novo)){
                visitados.add(novo);
            }
        }
    }

    private void levarAlface(List<Estado> visitados) {
        if(alface == 'e'){
            if(homem == 'd'){
                levarNada(visitados);
            }
            HomemLoboAlfaceCarneiro novo = new HomemLoboAlfaceCarneiro(homem, lobo, 'd', carneiro, "Levando alface!");
            if (!visitados.contains(novo)){
                visitados.add(novo);
            }
        } else {
            if(homem == 'd'){
                levarNada(visitados);
            }
            HomemLoboAlfaceCarneiro novo = new HomemLoboAlfaceCarneiro(homem, lobo, 'e', carneiro, "Levando alface!");
            if (!visitados.contains(novo)){
                visitados.add(novo);
            }
        }
    }

    private void levarCarneiro(List<Estado> visitados) {
        if(carneiro == 'e'){
            if(homem == 'd'){
                levarNada(visitados);
            }
            HomemLoboAlfaceCarneiro novo = new HomemLoboAlfaceCarneiro(homem, lobo, alface, 'd', "Levando carneiro!");
            if (!visitados.contains(novo)){
                visitados.add(novo);
            }
        } else {
            if(homem == 'd'){
                levarNada(visitados);
            }
            HomemLoboAlfaceCarneiro novo = new HomemLoboAlfaceCarneiro(homem, lobo, alface, 'd', "Levando carneiro!");
            if (!visitados.contains(novo)){
                visitados.add(novo);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof HomemLoboAlfaceCarneiro) {
            HomemLoboAlfaceCarneiro e = (HomemLoboAlfaceCarneiro)o;
            return this.homem == e.homem && 
                   this.lobo == e.lobo &&
                   this.alface == e.alface && 
                   this.carneiro == e.carneiro;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return (""+this.homem + this.lobo +this.alface + this.carneiro).hashCode();
    }

    @Override
    public String toString() {
        return "(" + this.homem + "," + this.lobo + this.alface + "," + this.carneiro +") "  + op + "\n";
    }
  
    public static void main(String[] a) {
        HomemLoboAlfaceCarneiro estadoInicial = new HomemLoboAlfaceCarneiro('e', 'e', 'e', 'e', "estado inicial");
        
        // chama busca em largura
        System.out.println("busca em ....");
        Nodo n = new BuscaProfundidade(new MostraStatusConsole()).busca(estadoInicial);
        if (n == null) {
            System.out.println("sem solucao!");
        } else {
            System.out.println("solucao:\n" + n.montaCaminho() + "\n\n");
        }
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
