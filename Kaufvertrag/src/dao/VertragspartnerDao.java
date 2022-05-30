package dao;

import businessObjects.Adresse;
import businessObjects.Vertragspartner;

import java.sql.*;
import java.util.ArrayList;

public class VertragspartnerDao {
    private final  String CLASSNAME="org.sqlite.JDBC";
    private final  String CONNECTIONSTRING="jdbc:sqlite:Kaufvertrag/src/data/Kaufvertrag_MA21.db";
    public VertragspartnerDao()throws  ClassNotFoundException{
        Class.forName(CLASSNAME);
        System.out.println("Mika");

    }
    /**
     * Lies einen Vertragspartner auf Basis seiner Ausweisnummer
     *
     * @param ausweisNr Die Ausweisnummer
     * @return Der gewünschte Vertragspartner

     */
    public Vertragspartner read(String ausweisNr) {
        Vertragspartner vertragspartner = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        //Verbindung zu Datenbank herstellen

        try {
            connection = DriverManager.getConnection(CONNECTIONSTRING);

            //SQL-Abfrage erstellen

            String sql = "SELECT * FROM Vertragspartner where AusweisNR = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, ausweisNr);

            // SQL Abfrage auführen

            ResultSet resultSet = preparedStatement.executeQuery();

            // Zeiger auf den ersten Datensatz setzen

            resultSet.next();

            //Resultset auswerten

            String nr = resultSet.getString("AusweisNR");
            String vorname = resultSet.getString("Vorname");
            String nachname = resultSet.getString("Nachname");
            String strasse = resultSet.getString("Strasse");
            String hausNr = resultSet.getString("HausNr");
            String plz = resultSet.getString("plz");
            String ort = resultSet.getString("Ort");

            // Vertragspartner erstellen

            vertragspartner = new Vertragspartner(vorname, nachname);
            vertragspartner.setAusweisNr(nr);
            Adresse adresse = new Adresse(strasse, hausNr, plz, ort);
            vertragspartner.setAdresse(adresse);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return vertragspartner;

    }
    public ArrayList read() {
        ArrayList<Vertragspartner> vertragspartnerliste = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        //Verbindung zu Datenbank herstellen
        try {

            connection = DriverManager.getConnection(CONNECTIONSTRING);

            //SQL-Abfrage erstellen

            String sql = "SELECT * FROM Vertragspartner";
            preparedStatement = connection.prepareStatement(sql);

            // SQL Abfrage auführen

            ResultSet resultSet = preparedStatement.executeQuery();
            vertragspartnerliste = new ArrayList<>();

            // Zeiger auf den ersten Datensatz setzen


           while (resultSet.next()) {
               //Resultset auswerten

               String nr = resultSet.getString("AusweisNR");
               String vorname = resultSet.getString("Vorname");
               String nachname = resultSet.getString("Nachname");
               String strasse = resultSet.getString("Strasse");
               String hausNr = resultSet.getString("HausNr");
               String plz = resultSet.getString("plz");
               String ort = resultSet.getString("Ort");


               // Vertragspartner erstellen
               Vertragspartner vertragspartner = new Vertragspartner(vorname, nachname);
               vertragspartner.setAusweisNr(nr);
               Adresse adresse = new Adresse(strasse, hausNr, plz, ort);
               vertragspartner.setAdresse(adresse);
               vertragspartnerliste.add(vertragspartner);
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
        return vertragspartnerliste;

    }




    private Vertragspartner creatObject(ResultSet resultSet) {
        Vertragspartner vertragspartner = null;
        try {
            String nr = resultSet.getString("AusweisNR");
            String vorname = resultSet.getString("Vorname");
            String nachname = resultSet.getString("Nachname");
            String strasse = resultSet.getString("Strasse");
            String hausNr = resultSet.getString("HausNr");
            String plz = resultSet.getString("plz");
            String ort = resultSet.getString("Ort");

            // Vertragspartner erstellen

            vertragspartner = new Vertragspartner(vorname, nachname);
            vertragspartner.setAusweisNr(nr);
            Adresse adresse = new Adresse(strasse, hausNr, plz, ort);
            vertragspartner.setAdresse(adresse);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vertragspartner;

    }




    public  void Delet( String ausweisNr){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try{
            connection = DriverManager.getConnection(CONNECTIONSTRING);
            String sql="DELETE FROM Vertragspartner Where ausweisNR =?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, ausweisNr);
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void update (String ausweisNr){
        Connection connection =null;
        PreparedStatement preparedStatement=null;

        try {
            connection=DriverManager.getConnection(CONNECTIONSTRING);
            String sql="UPDATE Vertragspartner SET ausweisNR =0 Where ausweisNR =1 =? ";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, ausweisNr);
            preparedStatement.executeQuery();



        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}





