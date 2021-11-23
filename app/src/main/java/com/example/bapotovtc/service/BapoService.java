package com.example.bapotovtc.service;

import com.example.bapotovtc.dao.BapoteurDAO;
import com.example.bapotovtc.dao.ReservationDAO;
import com.example.bapotovtc.model.Bapoteur;

import java.util.logging.LogManager;

public class BapoService<InputReaderUtil> {

    private LogManager LOGGER = LogManager.getLogManager();


    private BapoteurDAO bapoteurDAO;
    private ReservationDAO reservationDAO;

    public BapoService( BapoteurDAO bapoteurDAO, ReservationDAO reservationDAO) {
        this.bapoteurDAO = bapoteurDAO;
        this.reservationDAO = reservationDAO;
    }


    public void processInscription() {
        Bapoteur bapoteur = new Bapoteur();
        String nom = bapoteur.getNom();

        boolean newBapoteur = bapoteurDAO.newBapoteur(nom, bapoteur.getMotDePasse());
        //DAO vérifiant si le bapoteur est existant en checkat l'ID et l'existence d'un MdP.
        try {

            if (newBapoteur) {
                Bapoteur bapoInscription = new Bapoteur();
                bapoInscription.getID();
                bapoInscription.getNom();
                bapoInscription.getPrenom();
                bapoInscription.getAdresseMail();
                bapoInscription.getTelephone();
                bapoInscription.getMotDePasse();
                bapoteurDAO.saveBapoteur(bapoInscription);
            }

        } catch (Exception e){
            e.printStackTrace();
        }


    }
}
