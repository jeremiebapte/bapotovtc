package com.example.bapotovtc.model;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Date;

public class Reservation {
    private int ID;
    private String nom;
    private String prenom;
    private String adresseMail;
    private int telephone;
    private LocalDateTime heureResa;
    private Date dateResa;
    private String lieuPrise;
    private String destination;


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

    public LocalDateTime getHeureResa() {
        return heureResa;
    }

    public void setHeureResa(LocalDateTime heureResa) {
        this.heureResa = heureResa;
    }

    public Date getDateResa() {
        return dateResa;
    }

    public void setDateResa(Date dateResa) {
        this.dateResa = dateResa;
    }

    public String getLieuPrise() {
        return lieuPrise;
    }

    public void setLieuPrise(String lieuPrise) {
        this.lieuPrise = lieuPrise;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
