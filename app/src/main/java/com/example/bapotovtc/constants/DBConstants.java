package com.example.bapotovtc.constants;

public class DBConstants {



    public static final String SAVE_BAPOTEUR = "insert into bapoteur(ID, Nom, Prenom, AdresseMail,Telephone,MotDePasse) values(?,?,?,?,?,?)";
    public static final String MODIFY_BAPOTEUR = "insert into ticket(PARKING_NUMBER, VEHICLE_REG_NUMBER, PRICE, IN_TIME, OUT_TIME) values(?,?,?,?,?)";
    public static final String NEW_RESA = "insert into reservations(ID, Nom, Prenom, AdresseMail, Telephone, Heurerésa, Daterésa, LieuPrise, Destination) values(?,?,?,?,?,?,?,?,?)";
    public static final String NEW_BAPOTEUR = "SELECT count(*) FROM bapoto b, where b.ID = ? and b.Nom = ? and b.MotDePasse is null";


}

