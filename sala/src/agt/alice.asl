// Agent alice in project sala

/* Initial beliefs and rules */
disciplina(ia, sexta).
laboratorio(ia, 101).
laboratorio(ed, 108).
laboratorio(redes, 316).

/* Initial goals */

!start.

/* Plans */

+!start : true 
    <- 
        .print("hello world.");
        .send(bob, tell, lanche(sanduiche)).

// alice.asl executando raciocínio antes de responder
+!kqml_received(Agente, askOne, laboratorio(Disciplina, Laboratorio), MsgId)
    <- 
        // Calcula ou verifica algo internamente
        ?laboratorio(Disciplina, Laboratorio);
        .print(Agente, " está me perguntando qual o laboratorio de ", Disciplina, " que é no ", Laboratorio);
        .send(Agente, reply, laboratorio(Disciplina, Laboratorio), MsgId).