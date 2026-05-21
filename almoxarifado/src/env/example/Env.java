package example;

// Environment code for project almoxarifado

import jason.asSyntax.*;
import jason.environment.*;
import jason.asSyntax.parser.*;

import java.util.Random;
import java.util.logging.*;

public class Env extends Environment {

    private Logger logger = Logger.getLogger("almoxarifado."+Env.class.getName());

    String sorteiaPeca() {
        Random gerador = new Random();
        String resposta = "";
        switch (gerador.nextInt(3)) {
            case 0:
                resposta = "peca(peq)";
                break;
            case 1:
                resposta = "peca(med)";
                break;
            case 2:
                resposta = "peca(grd)";
                break;
            default:
                break;
        }
        return resposta;
    }

    /** Called before the MAS execution with the args informed in .mas2j */
    @Override
    public void init(String[] args) {
        super.init(args);
        try {
            String peca = sorteiaPeca();
            addPercept(ASSyntax.parseLiteral(peca));
            logger.info("Entrou a peca: " + peca);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean executeAction(String agName, Structure action) {
        logger.info(agName + "está solicitando a ação: " + action.getFunctor());
        if (true) { 
            informAgsEnvironmentChanged(); // if the action changes the environment, inform the agents that are subscribed to environment changes
        } else logger.info("executando a ação: " + action + " com falha");
        return true; // the action was executed with success
    }

    /** Called before the end of MAS execution */
    @Override
    public void stop() {
        super.stop();
    }
}
