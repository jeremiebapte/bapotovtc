package com.example.bapotovtc.model;

public class Bapoteur {
    private int ID;
    private String nom;
    private String prenom;
    private String adresseMail;
    private int telephone;
    private String motDePasse;


    public Bapoteur(int ID, String nom, String prenom, String adresseMail, int telephone, String motDePasse) {
        this.ID = ID;
        this.nom = nom;
        this.prenom = prenom;
        this.adresseMail = adresseMail;
        this.telephone = telephone;
        this.motDePasse = motDePasse;
    }

    public Bapoteur() {

    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresseMail() {
        return adresseMail;
    }

    public void setAdresseMail(String adresseMail) {
        this.adresseMail = adresseMail;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }
}