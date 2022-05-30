package dao;

import businessObjects.Adresse;
import businessObjects.Vertragspartner;
import businessObjects.Ware;
import jdk.internal.jimage.ImageStrings;

import java.sql.*;
import java.util.ArrayList;

public class Waredao {


    private final String CLASSNAME = "org.sqlite.JDBC";
    private final String CONNECTIONSTRING = "jdbc:sqlite:Kaufvertrag/src/data/Kaufvertrag_Ma21.db";


    public Waredao() throws ClassNotFoundException {
        Class.forName(CLASSNAME);

    }

    public Ware read(int WarenNr) throws SQLException {
        Ware ware = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        //Verbindung zu Datenbank herstellen

        try {
            connection = DriverManager.getConnection(CONNECTIONSTRING);

            //SQL-Abfrage erstellen

            String sql = "SELECT * FROM Waren where WarenNR = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, WarenNr);

            // SQL Abfrage auführen

            ResultSet resultSet = preparedStatement.executeQuery();

            // Zeiger auf den ersten Datensatz setzen

            resultSet.next();


            //Resultset auswerten

            int warenNR = resultSet.getInt("WarenNR");
            String bezeichnung = resultSet.getString("Bezeichnung");
            String beschreibung = resultSet.getString("Beschreibung");
            double preis = resultSet.getDouble("preis");
            String besonderheiten = resultSet.getString("Besonderheiten");
            String maengel = resultSet.getString("Maengel");

            // ware erstellen

            ware = new Ware(warenNR, bezeichnung, preis);

            ware.setBeschreibung(beschreibung);
            if (besonderheiten != null) {
                String[] besonderheitenArray = besonderheiten.split(";");
                for (String b : besonderheitenArray) {
                    ware.getBesonderheitenListe().add(b.trim());
                }

                if (maengel != null) {
                    String[] maengelArray = maengel.split(";");
                    for (String b : maengelArray) ;
                    ware.getMaengelListe().add(beschreibung.trim());
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            try {

                connection.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return ware;

    }

    public void reas() {

        ArrayList<Ware> wareArrayList = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        //Verbindung zu Datenbank herstellen

        try {

            connection = DriverManager.getConnection(CONNECTIONSTRING);

            //SQL-Abfrage erstellen

            String sql = "SELECT* FROM Vertragspartner";
            preparedStatement = connection.prepareStatement(sql);

            // SQL - Abfrage erstellen

            ResultSet resultSet = preparedStatement.executeQuery(sql);
            wareArrayList = new ArrayList<>();

            // Zeiger auf den ersten Datensatz setzen

            while (resultSet.next()) {
                //Resultset auswerten
                int warenNR = resultSet.getInt("WarenNR");
                String bezeichnung = resultSet.getString("Bezeichnung");
                String beschreibung = resultSet.getString("Beschreibung");
                double preis = resultSet.getDouble("preis");
                String besonderheiten = resultSet.getString("Besonderheiten");
                String maengel = resultSet.getString("Maengel");

                Ware ware = new Ware(warenNR, bezeichnung, preis);
                ware.setWarenNR(warenNR);
                wareArrayList.add(ware);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            try {

                connection.close();

            } catch (SQLException e) {

                e.printStackTrace();

            }


        }
    }

    private Ware creatObject(ResultSet resultSet) {
        Ware ware = null;

        try {

            int warenNR = resultSet.getInt("WarenNR");
            String bezeichnung = resultSet.getString("Bezeichnung");
            String beschreibung = resultSet.getString("Beschreibung");
            double preis = resultSet.getDouble("preis");
            String besonderheiten = resultSet.getString("Besonderheiten");
            String maengel = resultSet.getString("Maengel");

            // Vertragspartner erstellen

             ware = new Ware(warenNR, bezeichnung, preis);
            ware.setWarenNR(warenNR);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ware;


    }

    public  void Delet(int warenNr){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try{
            connection = DriverManager.getConnection(CONNECTIONSTRING);
            String sql="DELETE FROM Waren Where warenNr?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, warenNr);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



