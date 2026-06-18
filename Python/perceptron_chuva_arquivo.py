import sys
import random

class Perceptron:
    def __init__(self, amostras, saidas, taxa_aprendizado=0.1, geracoes=1000, limiar=1):
        self.amostras = amostras
        self.saidas = saidas
        self.taxa_aprendizado = taxa_aprendizado
        self.geracoes = geracoes
        self.limiar = limiar
        self.n_amostras = len(amostras)
        self.n_atributos = len(amostras[0])
        self.pesos = []

    def treinar(self):
        for amostra in self.amostras:
            amostra.insert(0, self.limiar)
        for i in range(self.n_atributos):
            self.pesos.append(random.random())
        self.pesos.insert(0, self.limiar)

        geracoes = 0
        while True:
            aprendeu = True
            for i in range(self.n_amostras):
                soma = 0
                for j in range(self.n_atributos + 1):
                    soma += self.pesos[j] * self.amostras[i][j]
                saida_gerada = self.funcao_ativacao_signal(soma)
                if saida_gerada != self.saidas[i]:
                    erro = self.saidas[i] - saida_gerada
                    for j in range(self.n_atributos + 1):
                        self.pesos[j] = self.pesos[j] + self.taxa_aprendizado * erro * self.amostras[i][j]
                    aprendeu = False
            geracoes += 1
            if aprendeu or geracoes > self.geracoes:
                print('Quantidade de gerações para aprender: %d\n' % geracoes)
                print('Pesos: ', self.pesos)
                break

    def teste(self, amostra):
        amostra.insert(0, self.limiar)
        soma = 0
        for i in range(self.n_atributos + 1):
            soma += self.pesos[i] * amostra[i]
        saida_gerada = self.funcao_ativacao_signal(soma)
        if saida_gerada == 1:
            print('Classe: %d. Chuva' % saida_gerada)
        else:
            print('Classe: %d. Sol' % saida_gerada)

    def funcao_ativacao_signal(self, soma):
        if soma >= 0:
            return 1
        return -1


# ─── Leitura do arquivo CSV ───────────────────────────────────────────────────
def carregar_dados(caminho_arquivo):
    amostras = []
    saidas = []
    with open(caminho_arquivo, 'r') as f:
        for linha in f:
            linha = linha.strip()
            if not linha or linha.startswith('#'):  # pula vazias e comentários
                continue
            valores = linha.split(',')
            amostra = [float(v) for v in valores[:-1]]
            saida = int(valores[-1])
            amostras.append(amostra)
            saidas.append(saida)
    return amostras, saidas


amostras, saidas = carregar_dados('dados_chuva.csv')
print(f'{len(amostras)} amostras carregadas.\n')

rede = Perceptron(amostras, saidas)
rede.treinar()

while True:
    umidade = float(input('Valor para umidade: '))
    pressao = float(input('Valor para pressao: '))
    print('Ponto:', umidade, ',', pressao)
    rede.teste([umidade, pressao])