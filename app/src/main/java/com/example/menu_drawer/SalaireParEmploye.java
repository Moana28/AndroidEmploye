package com.example.menu_drawer;

public class SalaireParEmploye {
    private String num_employe_S;
    private String nom_employe_S;
    private String adresse_S;
    private double salaire;

    public SalaireParEmploye(String num_employe_S, String nom_employe_S,String adresse_S, double salaire) {
        this.num_employe_S = num_employe_S;
        this.nom_employe_S = nom_employe_S;
        this.adresse_S = adresse_S;
        this.salaire = salaire;
    }

    public String getNum_employe_S() {
        return num_employe_S;
    }

    public void setNum_employe_S(String num_employe_S) {
        this.num_employe_S = num_employe_S;
    }


    public String getNom_employe_S() {
        return nom_employe_S;
    }

    public void setNom_employe_S(String nom_employe_S) {
        this.nom_employe_S = nom_employe_S; }


        public String getAdresse_S() {
        return adresse_S;
    }

    public void setAdresse_S(String adresse_S) {
        this.adresse_S = adresse_S;
    }


    public double getSalaire() {return salaire; }

    public void setSalaire() {this.salaire = salaire; }

}
