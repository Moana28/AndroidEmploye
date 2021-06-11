package com.example.menu_drawer;

public class SalaireGlobal {
    private String num_employe_G;
    private String nom_employe_G;
    private double salaire_G;

    public SalaireGlobal(String num_employe_G, String nom_employe_G, double salaire_G) {
        this.num_employe_G = num_employe_G;
        this.nom_employe_G = nom_employe_G;
        this.salaire_G = salaire_G;
    }

    public String getNum_employe_G() {
        return num_employe_G;
    }

    public void setNum_employe_G(String num_employe_G) {
        this.num_employe_G = num_employe_G;
    }


    public String getNom_employe_G() {
        return nom_employe_G;
    }

    public void setNom_employe_G(String nom_employe_G) {
        this.nom_employe_G = nom_employe_G; }


    public double getSalaire_G() {return salaire_G; }

    public void setSalaire_G() {this.salaire_G = salaire_G; }

}
