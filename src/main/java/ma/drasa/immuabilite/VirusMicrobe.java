package ma.drasa.immuabilite;

import java.util.Date;

/**
 * Created by berzeker on 30/11/16.
 */
public class VirusMicrobe extends Microbe {

    public VirusMicrobe (String name, Date dateNaissance) {
        super(name, dateNaissance);
    }

    @Override
    public String getName() {
        return "virus";
    }
}
