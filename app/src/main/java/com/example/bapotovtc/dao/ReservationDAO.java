package com.example.bapotovtc.dao;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.bapotovtc.config.DataBaseConfig;
import com.example.bapotovtc.constants.DBConstants;
import com.example.bapotovtc.model.Reservation;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import java.util.logging.Logger;


public class ReservationDAO {


    public ReservationDAO(DataBaseConfig dataBaseConfig){ this.dataBaseConfig = dataBaseConfig;}
    public ReservationDAO(){
    }



    public DataBaseConfig dataBaseConfig = new DataBaseConfig();

    @RequiresApi(api = Build.VERSION_CODES.O)
    public final boolean  newResa(Reservation reservation) {
        Connection con = null;
        try{
            con = dataBaseConfig.getConnection();
            PreparedStatement ps = con.prepareStatement(DBConstants.NEW_RESA);
            ps.setInt(1,reservation.getID());
            ps.setString(2, reservation.getNom());
            ps.setString(3, reservation.getPrenom());
            ps.setString(4, reservation.getAdresseMail());
            ps.setInt(5,reservation.getTelephone());
            ps.setString(6, String.valueOf(reservation.getHeureResa().toLocalTime()));
            ps.setDate(7, Date.valueOf(String.valueOf(reservation.getDateResa())));
            ps.setString(8, reservation.getLieuPrise());
            ps.setString(9, reservation.getDestination());
            ps.execute();
            return true;
        }catch (Exception ex){
            Logger.getAnonymousLogger("Erreur dans la prise de la réservation");
            return false;
        } finally {
            dataBaseConfig.closeConnection(con);
        }


    }



}
