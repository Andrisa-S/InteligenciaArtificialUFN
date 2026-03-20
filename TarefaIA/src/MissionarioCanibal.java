import java.util.*;
import javax.swing.JOptionPane;

import busca.BuscaLargura;
import busca.BuscaProfundidade;
import busca.Estado;
import busca.MostraStatusConsole;
import busca.Nodo;

public class MissionarioCanibal implements Estado{
    int canEsq, misEsq = 3;
    int canDir, misDir = 0;
    char barco = 'e';
    String op;

    public MissionarioCanibal(int canEsq, int misEsq, int canDir, int misDir, char barco, String op) {
        this.canEsq = canEsq;
        this.misEsq = misEsq;
        this.canDir = canDir;
        this.misDir = misDir;
        this.barco = barco;
        this.op = op;
    }

    @Override
    public String getDescricao() {
        return "Problema dos 3 Canibais e 3 Missionários...";
    }

    @Override
    public boolean ehMeta() {
        return canEsq == 0 && misEsq == 0 && canDir == 3 && misDir == 3 && barco == 'd';
    }

    @Override
    public int custo() {
        return 1;
    }

    @Override
    public List<Estado> sucessores() {
        List<Estado> visitados = new LinkedList<>();

        Levar1Missionario(visitados);
        Levar1Canibal(visitados);
        Levar1Miss1Cani(visitados);
        Levar2Missionarios(visitados);
        Levar2Canibais(visitados);

        return visitados;
    }

    private void Levar2Canibais(List<Estado> visitados) {
        if(barco == 'e'){
            MissionarioCanibal novo = new MissionarioCanibal(canEsq-2, misEsq, canDir+2, misDir, 'd', "Levando 2 canibais");
            if (!visitados.contains(novo)) {
                visitados.add(novo);
            }
        } else if (barco == 'd'){
                MissionarioCanibal novo = new MissionarioCanibal(canEsq+2, misEsq, canDir-2, misDir, 'd', "Levando 2 canibais");
                if (!visitados.contains(novo)) {
                    visitados.add(novo);
                }
            }
    }

    private void Levar2Missionarios(List<Estado> visitados) {
        if(barco == 'e'){
            MissionarioCanibal novo = new MissionarioCanibal(canEsq, misEsq-2, canDir, misDir+2, 'd', "Levando 2 missionários");
            if (!visitados.contains(novo)) {
                visitados.add(novo);
            }
        } else if (barco == 'd'){
            MissionarioCanibal novo = new MissionarioCanibal(canEsq, misEsq+2, canDir, misDir-2, 'd', "Levando 2 missionários");
            if (!visitados.contains(novo)) {
                visitados.add(novo);
            }
        }
    }

    private void Levar1Miss1Cani(List<Estado> visitados) {
        if(barco == 'e'){
            MissionarioCanibal novo = new MissionarioCanibal(canEsq-1, misEsq-1, canDir+1, misDir+1, 'd', "Levando 1 missionário e 1 canibal");
            if (!visitados.contains(novo)) {
                visitados.add(novo);
            }
        } else if (barco == 'd'){
            MissionarioCanibal novo = new MissionarioCanibal(canEsq+1, misEsq+1, canDir-1, misDir-1, 'd', "Levando 1 missionário e 1 canibal");
            if (!visitados.contains(novo)) {
                visitados.add(novo);
            }
        }
    }

    private void Levar1Canibal(List<Estado> visitados) {
        if(barco == 'e'){
            MissionarioCanibal novo = new MissionarioCanibal(canEsq-1, misEsq, canDir+1, misDir, 'd', "Levando 1 canibal");
            if (!visitados.contains(novo)) {
                visitados.add(novo);
            }
        } else if (barco == 'd'){
            MissionarioCanibal novo = new MissionarioCanibal(canEsq+1, misEsq, canDir-1, misDir, 'd', "Levando 1 canibal");
            if (!visitados.contains(novo)) {
                visitados.add(novo);
            }
        }
    }

    private void Levar1Missionario(List<Estado> visitados) {
        if(barco == 'e'){
            MissionarioCanibal novo = new MissionarioCanibal(canEsq, misEsq-1, canDir, misDir+1, 'd', "Levando 1 missionário");
            if (!visitados.contains(novo)) {
                visitados.add(novo);
            }
        } else if (barco == 'd'){
            MissionarioCanibal novo = new MissionarioCanibal(canEsq, misEsq+1, canDir, misDir-1, 'd', "Levando 1 missionário");
            if (!visitados.contains(novo)) {
                visitados.add(novo);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof MissionarioCanibal){
            MissionarioCanibal e = (MissionarioCanibal)o;
            return this.canEsq == e.canEsq &&
                    this.canDir == e.canDir &&
                    this.misEsq == e.misEsq &&
                    this.misDir == e.misDir &&
                    this.barco == e.barco;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(canEsq, misEsq, canDir, misDir, barco, op);
    }

    @Override
    public String toString() {
        return "MissionarioCanibal{" +
                "canEsq=" + canEsq +
                ", misEsq=" + misEsq +
                ", canDir=" + canDir +
                ", misDir=" + misDir +
                ", barco=" + barco +
                ", op='" + op + '\'' +
                '}';
    }

    static void main() {
        MissionarioCanibal estadoInicial = new MissionarioCanibal(3, 3, 0, 0, 'e', "estado inicial");

        System.out.println("Busca em...");
        Nodo n = new BuscaProfundidade(new MostraStatusConsole()).busca(estadoInicial);
        if (n == null){
            System.out.println("Sem solução!");
        } else {
            System.out.println("Solução:\n" + n.montaCaminho() + "\n\n");
        }
    }
}
