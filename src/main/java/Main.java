import ma.drasa.immuabilite.Microbe;
import ma.drasa.immuabilite.VirusMicrobe;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by berzeker on 30/11/16.
 */
public class Main {

    public static void main(String[] args) throws ParseException {

        String dateNaissanceStr = "22/07/1960";
        SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");

        Date dateNaissance = formater.parse(dateNaissanceStr);

        //1 - L'héritage peut faire simuler un état, et compromettre l'immuabilité
        Microbe microbe = new VirusMicrobe("ALPHA", dateNaissance);
        System.out.println(microbe.getName());

    }
}
