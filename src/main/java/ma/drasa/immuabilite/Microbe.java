package ma.drasa.immuabilite;

import java.util.Date;

/**
 * Created by berzeker on 30/11/16.
 */
public final class Microbe {

    private final String name;
    private final Date dateNaissance;

    public Microbe (String name, Date dateNaissance) {
        this.name = name;
        this.dateNaissance = (Date) dateNaissance.clone();
    }

    public String getName() {
        return name;
    }

    public Date getDateNaissance() {
        return (Date) dateNaissance.clone();
    }
}
