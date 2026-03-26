## Problemas que a IA resolve
  - Problemas de diagnóstico;
  - Problemas em que não se sabe como chegar no estado final -> 'empacotamento'

## Técnicas de IA geram ou constroem SISTEMAS DE COMPORTAMENTO INTELIGENTE
  - Base de conhecimento
  - Motores de raciocínio -> DEDUÇÃO e INDUÇÃO
    - Algoritmos de busca
      - Cega ou força bruta
        - Profundidade -> PILHA
        - Largura/Amplitude -> FILA

      - Informados ou heurísticos
        - CUSTOS
          - real g(n)
          - estimado ou heurístico h(n) -> ADMISSÍVEL ou INADMISSÍVEL
        - Métodos
          - Subida de Encosta -> baseado no profundidade e foca nos custo real
          - Guloso -> baseado no amplitude e foca no custo estimado
          - A* -> baseado no amplitude e soma custo real (acumulado) com custo estimado -> com isso, pode corrigir a heurística
            - a heurística é ESTÁTICA 

# Métodos de Busca
  - Soluções para problemas
    - Gerar ou atingir Estado(s) desejado(s)
    - Gerar ou produzir passo-a-passo até o Estado(s) desejado(s)
