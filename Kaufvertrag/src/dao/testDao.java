package dao;

import businessObjects.Adresse;
import businessObjects.Vertragspartner;
import businessObjects.Ware;
import com.sun.tools.javac.Main;

import java.sql.SQLException;
import java.util.ArrayList;

public class testDao {
    public static void main(String[] args) throws Exception {
        VertragspartnerDao vertragspartnerDao=new VertragspartnerDao();
        ArrayList<Vertragspartner>vertragspartnerArrayList=new  VertragspartnerDao().read();
        for (Vertragspartner v : vertragspartnerArrayList) {
            System.out.println(v);
        }

        Vertragspartner vertragspartner1=new Vertragspartner("Hatem","Alsimo");
        vertragspartner1.setAdresse(new Adresse("Luneplate","12345","12112","Bremen"));
        vertragspartner1.setAusweisNr("Hatem3");
        vertragspartnerDao.create(vertragspartner1);


        Waredao waredao=new Waredao();
        Ware ware=waredao.read(1);
        System.out.println(ware);
        waredao.Delet(2);


    }
}

