package com.example.menu_drawer;

public class Employe {
    private String num_employe;
    private String nom_employe;
    private String adresse;
    private double taux_horaire;

    public Employe(String num_employe, String nom_employe,String adresse, double taux_horaire) {
        this.num_employe = num_employe;
        this.nom_employe = nom_employe;
        this.adresse = adresse;
        this.taux_horaire = taux_horaire;
    }

    public String getNum_employe() {
        return num_employe;
    }

    public void setNum_employe(String num_employe) {
        this.num_employe = num_employe;
    }

    public String getNom_employe() {
        return nom_employe;
    }

    public void setNom_employe(String nom_employe) {
        this.nom_employe = nom_employe;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public double getTaux_horaire() {
        return taux_horaire;
    }

    public void setTaux_horaire(double taux_horaire) {
        this.taux_horaire = taux_horaire;
    }
}
