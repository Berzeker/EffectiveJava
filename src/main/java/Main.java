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

        //2- La classe Date est mutable, la valeur du champ dateNaissance peut être modifiée et changer ainsi changer
        //le status de l'instance
        System.out.println("Pas de copie defensive au niveau du constructeur");
        Microbe microbeBeta = new Microbe("Beta", dateNaissance);
        System.out.println(microbeBeta.getDateNaissance());
        dateNaissance.setTime(new Date().getTime());
        System.out.println(microbeBeta.getDateNaissance());

        System.out.println("Pas de copie defensive au niveau du getteur");
        dateNaissance = formater.parse(dateNaissanceStr);
        Microbe microbeGama = new Microbe("Gama", dateNaissance);
        System.out.println(microbeGama.getDateNaissance());
        microbeGama.getDateNaissance().setTime(new Date().getTime());
        System.out.println(microbeGama.getDateNaissance());

    }
}
