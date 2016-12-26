package ma.drasa.immuabilite;

import java.util.Date;

/**
 * Created by berzeker on 30/11/16.
 */
public class Microbe {

    private final String name;
    private final Date dateNaissance;

    public static final Microbe GRIPPE = new Microbe("GRIPPE");
    public static final Microbe RHUME = new Microbe("RHUME");
    public static final Microbe GASTRO = new Microbe("GASTRO");
    
    private Microbe (String name, Date dateNaissance) {
        this.name = name;
        this.dateNaissance = (Date) dateNaissance.clone();
    }
    
    private Microbe (String name) {
        this.name = name;
        this.dateNaissance = new Date();
    }
    
    public static Microbe newInstance (String name, Date dateNaissance) {
    	return new Microbe(name, dateNaissance);
    }  
    
    public static Microbe newInstance (String name) {
    	Microbe microbeSearched = search(name);
    	if (microbeSearched != null) 
    		return microbeSearched;
    	return new Microbe(name);
    }  

    private static Microbe search(String name) {
    	switch (name) {
    		case "GRIPPE" : return GRIPPE;
    		case "RHUME"  : return RHUME;
    		case "GASTRO" : return GASTRO;
    		default : return null;
    	}
    }
    
    public String getName() {
        return name;
    }

    public Date getDateNaissance() {
    	if (dateNaissance != null) {
    		return (Date) dateNaissance.clone();
    	}
    	return dateNaissance;
    }
    
}
