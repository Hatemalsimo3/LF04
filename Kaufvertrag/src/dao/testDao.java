package dao;

import businessObjects.Adresse;
import businessObjects.Vertragspartner;
import businessObjects.Ware;
import com.sun.tools.javac.Main;

import java.sql.SQLException;
import java.util.ArrayList;

public class testDao {
    public static void main(String[] args) throws Exception {

        //.........................................Read
        VertragspartnerDao vertragspartnerDao=new VertragspartnerDao();
        ArrayList<Vertragspartner>vertragspartnerArrayList= vertragspartnerDao.read();
        for (Vertragspartner v : vertragspartnerArrayList) {
            System.out.println(v);
        }
        //.....................................................................................................  Creat
      Vertragspartner vertragspartner1=new Vertragspartner("Hatem","Alsimo");
      vertragspartner1.setAdresse(new Adresse("Luneplate","12345","12112","Bremen"));

       //---------------------------------------------------------------------------------------------------------------Delet
          vertragspartnerDao.Delet("Hatem3");
      //..........................................................Update
        vertragspartnerDao.update(vertragspartner1);

      //:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::Ware
        // _____________________________________________Read
      Waredao waredao=new Waredao();
      Ware ware=waredao.read(1);
      System.out.println(ware);

      //_______________________________________________________Creat

      Ware ware1=new Ware(123,"Auto",1);
      ware.setBeschreibung(" Kann gut fahren");
      //......................................................................................Delet
        waredao.Delet(1);


        //.............................................Update
        waredao.update(ware1);



    }
}

