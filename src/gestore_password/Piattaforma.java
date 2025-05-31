package gestore_password;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.io.*;


public class Piattaforma implements Serializable{
	String piattaforma,password,email="",username="",date;
	
	
	public Piattaforma() {
		piattaforma = ChiediDati.ChiediStringa("Inserisci piattaforma");
		password = ChiediDati.ChiediStringa("Inserisci password");    
        email = ChiediDati.ChiediStringa("Inserisci e-mail");    
        username = ChiediDati.ChiediStringa("Inserisci username");
        date = DataEOraFormattata();
	}
	
	public Piattaforma(String piattaforma,String password,String email,String username,String date) {
		this.piattaforma = piattaforma;
        this.password = password;
        this.email = email;
        this.username = username;
        this.date = date;
	}
	
	public String getPiattaforma() {
        return piattaforma;
    }
	
	public String getPassword() {
        return password;
    }
	
	public String getUsername() {
        return username;
    }
	
	public String getEmail() {
        return email;
	}
	
	public String getPasswordFormatOra() {
        return password+"  | date: "+date;
    }
	
	public String DataEOraFormattata() {
        LocalDateTime dataEOra = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd MMMM yyyy - HH:mm", Locale.ITALIAN);
        String dataOraFormattata = dataEOra.format(formato);   
        return dataOraFormattata;
    }
	
	public String infoFormattati() {
		return piattaforma+","+password+","+email+","+username+","+date;
	}
	
	@Override
    public String toString() {
        return "    PIATTAFORMA   |   " + piattaforma + "\n" + 
               "    PASSWORD      |   " + password + "\n" +
               "    EMAIL         |   " + email + "\n" +
               "    USERNAME      |   " + username + "\n" +
               "    DATE          |   " + date+"\n"+"\n";
    }

	
	
}
