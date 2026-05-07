package pkg;

import java.util.LinkedList;
import java.util.List;

public class Cromossomo implements Comparable<Cromossomo> {
    public int portagemAptidao;
    public List<Integer> caminho = new LinkedList<Integer>();	
	public int aptidao;
	
	public Cromossomo(List<Integer> valor, Mapa mapa) {
		this.caminho.addAll(valor);
		this.aptidao = calcularAptidao(mapa);
	}
	
	private int calcularAptidao(Mapa mapa) { //heurística do sistema ou do AG
		int aptidao = 0;

        // Restrição 1: cidade de número maior antes de menor → +10 por violação
        for (int i = 0; i < caminho.size() - 1; i++) {
            if (caminho.get(i) > caminho.get(i + 1)) {
                aptidao += 10;
            }
        }

        // Restrição 2: cidade repetida → +20 por PAR de ocorrência
        for (int i = 0; i < caminho.size(); i++) {
            int contagem = 0;
            for (int j = i + 1; j < caminho.size(); j++) {
                if (caminho.get(i).equals(caminho.get(j))) {
                    contagem++;
                }
            }
            // cada par extra conta como uma violação
            aptidao += contagem * 20;
        }

        return aptidao;
	}
	
    private int porcentagemAptidao(int aptidao, Mapa mapa) {
        return (int) ((aptidao * 100) / (mapa.quantidadeCidades * 20)); //considerando o pior caso possível
    }

	@Override
	public String toString() {
		return "rota=" + caminho + ", aptidao=" + aptidao;
	}
	
	@Override
    public int compareTo(Cromossomo cromossomo) {
        if (this.aptidao < cromossomo.aptidao) {
            return -1;
        }
        return 1;
    }
}
