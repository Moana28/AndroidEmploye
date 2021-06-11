package com.example.menu_drawer;

public class Travail {
    private String num_employe_T;
    private String num_entreprise_T;
    private double nbHeure;
    private String date_travail;

    public Travail(String num_employe_T, String num_entreprise_T,double nbHeure) {
        this.num_employe_T = num_employe_T;
        this.num_entreprise_T = num_entreprise_T;
        this.nbHeure = nbHeure;
//        this.date_travail = date_travail;
    }

    public String getNum_employe_T() {
        return num_employe_T;
    }

    public void setNum_employe_T(String num_employe_T) {
        this.num_employe_T = num_employe_T;
    }

    public String getNum_entreprise_T() {
        return num_entreprise_T;
    }

    public void setNum_entreprise_T(String num_entreprise_T) {
        this.num_entreprise_T = num_entreprise_T;
    }

    public double getNbHeure() {
        return nbHeure;
    }

    public void setNbHeure(double nbHeure) {
        this.nbHeure = nbHeure;
    }

//    public String getDate_travail() {
//        return date_travail;
//    }
//
//    public void setDate_travail(String date_travail) {
//        this.date_travail = date_travail;
//    }
}
