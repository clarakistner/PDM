package com.example.myapplication;

import java.util.ArrayList;

public class PlanetaController {

    PlanetaDAO planetaDAO;

    public PlanetaController() {
        this.planetaDAO = new PlanetaDAO();
    }

    public void addPlaneta(Planeta planeta){
        //bla
    }
    public ArrayList<Planeta> getPlaneta(){
        return planetaDAO.getArrayListPlanetas();
    }

    public ArrayList<String> getNomePlaneta(){
        ArrayList<String> nomes = new ArrayList<String>();
        for (Planeta planeta: planetaDAO.getArrayListPlanetas()) {
            nomes.add(planeta.nome);
        }
        return nomes;
    }
}
