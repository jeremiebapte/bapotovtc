package com.example.bapotovtc.dao;

import com.example.bapotovtc.config.DataBaseConfig;
import com.example.bapotovtc.constants.DBConstants;
import com.example.bapotovtc.model.Bapoteur;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.LogManager;
import java.util.logging.Logger;


public class BapoteurDAO {
    public BapoteurDAO(DataBaseConfig dataBaseConfig) {
        this.dataBaseConfig = dataBaseConfig;
    }

    public BapoteurDAO() {
    }

    private static LogManager LogManager;
    private static final Logger LOGGER = LogManager.getLogger("BapoteurDAO");

    public DataBaseConfig dataBaseConfig = new DataBaseConfig();

    public final boolean saveBapoteur(Bapoteur bapoteur) {
        Connection con = null;
        try {
            con = dataBaseConfig.getConnection();
            PreparedStatement ps = con.prepareStatement(DBConstants.SAVE_BAPOTEUR);
            ps.setInt(1, bapoteur.getID());
            ps.setString(2, bapoteur.getNom());
            ps.setString(3, bapoteur.getPrenom());
            ps.setString(4, bapoteur.getAdresseMail());
            ps.setInt(5, bapoteur.getTelephone());
            ps.setString(6, bapoteur.getMotDePasse());
            ps.execute();
            return true;
        } catch (Exception ex) {
            LOGGER.info("Erreur dans la création du Bapoteur");
            return false;
        } finally {
            dataBaseConfig.closeConnection(con);
        }


    }

    public final boolean newBapoteur(String nom, String motDePasse) {

        Connection con = null;
        int entry = 0;
        try {
            con = dataBaseConfig.getConnection();
            PreparedStatement ps = con.prepareStatement(DBConstants.NEW_BAPOTEUR);
            ps.setString(1, nom);
            ps.setString(2, motDePasse);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                entry = rs.getInt(1);

            }
            dataBaseConfig.closeResultSet(rs);
            dataBaseConfig.closePreparedStatement(ps);

        } catch (Exception ex) {
            LOGGER.info("Error verify bapoteur");
        } finally {
            dataBaseConfig.closeConnection(con);
            return entry != 0;
        }

    }
}