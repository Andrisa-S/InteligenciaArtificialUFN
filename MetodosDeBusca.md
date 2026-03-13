# Métodos de Busca

### Cega ~= Força bruta
  - Dedutivo -> Profundidade
    - Pilha (Recursiva S.O)
    - Visitados
  - Largura/amplitude
  - 
    **Árvore completa**:
    - Fila
    - Visitados

### Heurísticos ~= Informação ~= "Dica"
  - Heurística ou informação
    - Custo Real - g(n)
    - Custo Estimado/Heurístico - h(n)
  - 
  **Visitados**:
  - Subida de encosta/montanha - Climb Hill
    - Profundidade -> Pilha recursiva
    - Custo Real - g(n)
  - Guloso
    - Amplitude/Largura -> Fila
    - Custo Estimado
  - A*
    - Amplitude -> FIla
    - Combinação = Custo real (acumulado) e Custo estimado
