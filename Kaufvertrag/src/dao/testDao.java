package dao;

import businessObjects.Adresse;
import businessObjects.Vertragspartner;
import businessObjects.Ware;
import com.sun.tools.javac.Main;

import java.sql.SQLException;
import java.util.ArrayList;

public class testDao {
    public static void main(String[] args) throws Exception {

        VertragspartnerDao vertragspartnerDao=new VertragspartnerDao();               //.........................................Read
        ArrayList<Vertragspartner>vertragspartnerArrayList= vertragspartnerDao.read();
        for (Vertragspartner v : vertragspartnerArrayList) {
            System.out.println(v);
        }

        //.....................................................................................................  Creat
      Vertragspartner vertragspartner1=new Vertragspartner("Hatem","Alsimo");
      vertragspartner1.setAdresse(new Adresse("Luneplate","12345","12112","Bremen"));

      vertragspartnerDao.Delet("Hatem3");
      //....................................................................................................... Delet

      //..................................................................................................... ware

      Waredao waredao=new Waredao();
      Ware ware=waredao.read(1);
      System.out.println(ware);
      Ware ware1=new Ware(123,"Auto",1);
      ware.setBeschreibung(" Kann gut fahren");

      //......................................................................................



    }
}

