# Computação Evolutiva: Algoritmos Genéticos (AG)
- Método de busca heurístico dinâmico, 'turbinado' com aleatoriedade controlada... maior chute da paróquia
- Gerar e testar, N
- Cálculo de aptidão (fitness)
- Problemas de **alta complexidade** (esforço)
  - Muitas restrições;
  - Heurística.
- Tipo de problema com muitas restrições (ifs) e sem o conhecimento de estado final
- Produz estados como os métodos de busca tradicionais, entretanto, a produção/geração não é linear, mas sim paralelo (como se fosse um vetor/lista)... a cada geraçção um AG pode produzir/gerar N estados novos
- Teoria da Evolução Genética - Charles Darwin
  - Método de Seleção Natural (os mais aptos ou os mais perto da solução ou os com menos restrições feridas irão passar para a próxima geração)

## Contexto
- Área da IA inspirada na:
  - Teoria da Evolução Natural;
  - Genética
- Sub-áreas
  - **Algoritmos Genéticos**
    - Método de Resolução de Problemas
      - Modelos computacionais baseados nas teorias:
        - Seleção Natural
        - Hereditariedade
  - Estratégias da Evolução
  - ...
- Métodos de Resolução de Problemas
  - Toda tarefa de busca ou otimização possui:
    - Estados finais e iniciais
    - Regras de transição
    - ....

## Definição
- Método de Resolução de Problemas
  - Busca de soluções em Espaço de Estados
    - Os **estados** produzidos são prováveis soluções ou **indivíduos** da população, denominados CROMOSSOMOS
    - Os operadores ou **regras de transição de estados** são MECANISMOS DE SELEÇÃO E DE REPRODUÇÃO que tentam encontrar melhores soluções (ou indivíduos)
      - SOBREVIVÊNCIA DO MAIS FORTE (melhores soluções a cada geração)
      - **CRUZAMENTO (*crossover*)**
      - **MUTAÇÃO**
  - É possível operar sobre uma população de candidatos (espaço de estados) em PARALELO
  - Usa a estratégia de gerar e testar

## Fluxograma básico
<img width="735" height="431" alt="image" src="https://github.com/user-attachments/assets/893130ee-af9c-444f-b8ba-fc78f9692b0e" />

### Exemplo - https://rednuht.org/genetic_cars_2/


