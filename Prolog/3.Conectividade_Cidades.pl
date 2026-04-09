estrada("São Sepé", "Santa Maria").
estrada("São Sepé", "Porto Alegre").
estrada("São Sepé", "Formigueiro").
estrada("Santa Maria", "Itaara").
estrada("Santa Maria", "Faxinal do Soturno").

pode_viajar(De, Para) :-
    estrada(De, Para).