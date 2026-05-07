package pkg;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Principal {
    public static void gerarRota(List<Cromossomo> rota, int tamanhoRota, Mapa mapa) {
        // Gera uma rota aleatória
        List<Integer> sequenciaRota = new LinkedList<Integer>();
        for (int i = 0; i <= mapa.quantidadeCidades; i++) {
            sequenciaRota.add(i);
        }

        for (int i = 0; i < tamanhoRota; i++) {
            Collections.shuffle(sequenciaRota);
            rota.add(new Cromossomo(sequenciaRota, mapa));
        }
    }

    public static void exibirRota(List<Cromossomo> rota) {
        for (Cromossomo cromossomo : rota) {
            System.out.println(cromossomo);
        }
        System.out.println("Aptidão: " + rota.get(0).aptidao);
    }
    
    public static void ordenarRota(List<Cromossomo> rota) {
        boolean houveTroca;
        Cromossomo tmp;
        int distancia = rota.size();
        do {
            distancia = (int) (distancia / 1.3);
            if (distancia <= 0) {
                distancia = 1;
            }
            houveTroca = false;
            for (int i = 0; i < rota.size() - distancia; i++) {
                if (rota.get(i).compareTo(rota.get(i + distancia)) > 0) {
                    tmp = rota.get(i);
                    rota.set(i, rota.get(i + distancia));
                    rota.set(i + distancia, tmp);
                    houveTroca = true;
                }
            }
        } while (distancia > 1 || houveTroca);
    }

    public static void selecionarRotaRoleta(List<Cromossomo> rota, List<Cromossomo> novaRota, int quantidadeSelecionada) {
        int aptidaoTotal = 0;
        for (int i = 0; i < rota.size(); i++) {
            aptidaoTotal += rota.get(i).aptidao;
        }

        for (int i = 0; i < rota.size(); i++){
            rota.get(i).portagemAptidao = (int) ((rota.get(i).aptidao * 100) / aptidaoTotal);
            if (rota.get(i).portagemAptidao == 0) {
                rota.get(i).portagemAptidao = 1; //garante que mesmo os piores tenham chance de serem selecionados
                
            }
        }

        List<Cromossomo> sorteio = new LinkedList<>();
        for (int i = 0; i < rota.size(); i++) {
            for (int j = 0; j < rota.get(i).portagemAptidao; j++) {
                sorteio.add(rota.get(i));
            }
        }

        Random gerador = new Random();
        int posicaoSorteio;

        int quantidadeSorteada = quantidadeSelecionada * rota.size() / 100;

        novaRota.add(rota.get(0)); //garante que o melhor sempre seja selecionado
        Cromossomo selecionado;

        for (int i = 0; i < quantidadeSorteada; i++) {
            posicaoSorteio = gerador.nextInt(sorteio.size());
            selecionado = sorteio.get(posicaoSorteio);
            novaRota.add(selecionado);
            while (sorteio.remove(selecionado)) {
                //remove todas as ocorrências do selecionado para evitar que seja selecionado novamente
            }
        }

    }

    public static void selecionarRotaTorneio(List<Cromossomo> rota, List<Cromossomo> novaRota, int quantidadeSelecionada) {
        Cromossomo c1, c2, c3;
        List<Cromossomo> torneio = new LinkedList<>();
        Cromossomo selecionado;

        int quantidadeSorteada = quantidadeSelecionada * rota.size() / 100;

        novaRota.add(rota.get(0)); //garante que o melhor sempre seja selecionado

        Random gerador = new Random();
        int i = 1;
        do {
            c1 = rota.get(gerador.nextInt(rota.size()));
            do {
                c2 = rota.get(gerador.nextInt(rota.size()));
            } while (c1 == c2);
            do {
                c3 = rota.get(gerador.nextInt(rota.size()));
            } while (c1 == c3 || c2 == c3);

            torneio.add(c1);
            torneio.add(c2);    
            torneio.add(c3);
            ordenarRota(torneio);

            selecionado = torneio.get(0);

            if(!novaRota.contains(selecionado)) {
                novaRota.add(selecionado);
                i++;
            }

            torneio.clear();
        } while (i < quantidadeSorteada);
    }

    public static void reproduzirRotas(List<Cromossomo> rota, List<Cromossomo> novaRota, int quantidadeReproduzida, Mapa mapa) {
        List<Integer> caminhoPai = new LinkedList<>();
        List<Integer> caminhoMae = new LinkedList<>();
        List<Integer> caminhoFilho1 = new LinkedList<>();
        List<Integer> caminhoFilho2 = new LinkedList<>();

        Random gerador = new Random();
        Cromossomo pai, mae;

        int quantidadeGerada = quantidadeReproduzida * rota.size() / 100;

        int i = 0;
        do {
            pai = rota.get(gerador.nextInt(rota.size()) / 4); //garante que os pais sejam selecionados entre os melhores 25% da população
            do {
                mae = rota.get(gerador.nextInt(rota.size()));
            } while (pai == mae);

            caminhoPai.addAll(pai.caminho);
            caminhoMae.addAll(mae.caminho);

            //Primeiro filho - herda a primeira metade do pai e a segunda metade da mãe
            for (int j = 0; j < (int)caminhoPai.size()/2; j++) {
            	caminhoFilho1.add(caminhoPai.get(j));
            }
            for (int j = ((int)caminhoMae.size() / 2); j < caminhoMae.size(); j++ ) {
            	caminhoFilho1.add(caminhoMae.get(j));
            }

            //Segundo filho - herda a primeira metade da mãe e a segunda metade do pai
            for (int j = 0; j < (int)caminhoMae.size()/2; j++) {
            	caminhoFilho2.add(caminhoMae.get(j));
            }
            for (int j = ((int)caminhoPai.size() / 2); j < caminhoMae.size(); j++ ) {
            	caminhoFilho2.add(caminhoPai.get(j));
            }

            novaRota.add(new Cromossomo(caminhoFilho1, mapa));
            novaRota.add(new Cromossomo(caminhoFilho2, mapa));
            i += 2;

            caminhoPai.clear();
            caminhoMae.clear();
            caminhoFilho1.clear();
            caminhoFilho2.clear();

        } while (i < quantidadeGerada);

        while (novaRota.size() < rota.size()) {
            novaRota.remove(novaRota.size() - 1); //garante que a nova rota tenha o mesmo tamanho da antiga, removendo os piores filhos gerados
        }
    }

    public static void main(String[] args) {
        Mapa mapa = new Mapa(9);

        List<Cromossomo> rota = new LinkedList<>();
        List<Cromossomo> novaRota = new LinkedList<>();

        int tamanhoRota = 100;
        int quantidadeSelecionada = 50;
        int quantidadeReproduzida = 30;

        gerarRota(rota, tamanhoRota, mapa);
        System.out.println("Rota gerada:");
        exibirRota(rota);
        ordenarRota(rota);
        System.out.println("\nRota ordenada:");
        exibirRota(rota);

    }

}
