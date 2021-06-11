package com.example.menu_drawer;

public class Entreprise {
    private String num_entreprise;
    private String design_entreprise;

    public Entreprise(String num_entreprise, String design_entreprise) {
        this.num_entreprise = num_entreprise;
        this.design_entreprise = design_entreprise;
    }

    public String getNum_entreprise() {
        return num_entreprise;
    }

    public void setNum_entreprise(String num_entreprise) {
        this.num_entreprise = num_entreprise;
    }

    public String getDesign_entreprise() {
        return design_entreprise;
    }

    public void setDesign_entreprise(String design_entreprise) {
        this.design_entreprise = design_entreprise;
    }
}
