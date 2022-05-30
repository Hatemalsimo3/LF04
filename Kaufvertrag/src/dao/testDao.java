package dao;

import businessObjects.Vertragspartner;
import businessObjects.Ware;
import com.sun.tools.javac.Main;

import java.sql.SQLException;
import java.util.ArrayList;

public class testDao {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        VertragspartnerDao vertragspartnerDao=new VertragspartnerDao();
        ArrayList<Vertragspartner>vertragspartnerArrayList=new  VertragspartnerDao().read();
        for (Vertragspartner v : vertragspartnerArrayList) {
            System.out.println(v);
        }
        vertragspartnerDao.Delet("0123456789");

        Waredao waredao=new Waredao();
        Ware ware=waredao.read(1);
        System.out.println(ware);
        waredao.Delet(2);


        Vertragspartner vertragspartner=new VertragspartnerDao().read("0123456789");
        System.out.println(vertragspartner.getVorname());


    }
}

