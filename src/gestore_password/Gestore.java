package gestore_password;
import java.io.*;
import java.util.*;
public class Gestore {
	Vector<Piattaforma> database = new Vector<>();
	String filename = "Filippo_password.csv";
	
	StringTokenizer st;
	
	FileReader f = null;
	BufferedReader fIN = null;
	FileWriter f1 = null;
	PrintWriter fOUT = null;
	
	
	String piattaforma,password,email,username,date;
	String intestazione = "PIATTAFORMA,PASSWORD,EMAIL,USERNAME,DATE";
	
	
	
	public void caricaPassword() {
		try {
			f = new FileReader(filename);
			fIN = new BufferedReader(f);
			
		}catch(IOException e) {}
		
		try {
		    String s;
		    int cont = 0;
		    while ((s = fIN.readLine()) != null) {
		        if (!s.trim().isEmpty()) {
		            if (cont != 0) { 
		                StringTokenizer st = new StringTokenizer(s, ",");
		                if (st.countTokens() >= 5) {
		                    piattaforma = st.nextToken();
		                    password    = st.nextToken();
		                    email       = st.nextToken();
		                    username    = st.nextToken();
		                    date        = st.nextToken();

		                    Piattaforma p = new Piattaforma(piattaforma, password, email, username, date);
		                    database.addElement(p);
		                }
		            }
		            cont++;
		        }
		    }
		} catch (Exception e) {
		    System.out.println("Errore nella lettura del file");
		    e.printStackTrace(); 
		}

		
		try {
			f.close();
		}catch(IOException e) {}
	}
	
	public void aggiungiPassword() {
		Piattaforma p = new Piattaforma();
		database.addElement(p);
		
		try {
			f1 = new FileWriter(filename,true);
			fOUT = new PrintWriter(f1);
		}catch(IOException e) {}
		
		try {
			fOUT.println(p.infoFormattati());
			fOUT.flush();
		}catch(Exception e) {}
		
		try {
			f1.close();
		}catch(IOException e) {}
	}
	
	public void stampaSpecifica() {
		System.out.println();
		String piattaforma = ChiediDati.ChiediStringa("Inserisci piattaforma");
		for(Piattaforma p : database) {
			if(p.getPiattaforma().equals(piattaforma)) {
				System.out.println(p);
			}
		}
	}
	
	public void stampaPasswordSpecifica() {
		System.out.println();
        String piattaforma = ChiediDati.ChiediStringa("Inserisci piattaforma");
        for (Piattaforma p : database) {
            if(p.getPiattaforma().equals(piattaforma)){
                System.out.println("La password di "+piattaforma+" e': "+p.getPasswordFormatOra());
            }
        }
	}
	
	public void stampaEmailSpecifica() {
		System.out.println();
        String piattaforma = ChiediDati.ChiediStringa("Inserisci piattaforma");
        for (Piattaforma p : database) {
            if(p.getPiattaforma().equals(piattaforma)){
                System.out.println("L' e-mail di "+piattaforma+" e': "+p.getEmail());
            }
        }
	}
	
	public void stampaUsernameSpecifico() {
		System.out.println();
        String piattaforma = ChiediDati.ChiediStringa("Inserisci piattaforma");
        for (Piattaforma p : database) {
            if(p.getPiattaforma().equals(piattaforma)){
                System.out.println("L'username di "+piattaforma+" e': "+p.getUsername());
            }
        }
	}
	
	public void stampaPassword() {
		System.out.println("Ecco tutte le password: ");
        System.out.println();
        for (Piattaforma p : database) {
            System.out.println(p);
        }
	}
	
	public void verificaEsistenza() {
		File file = new File(filename);

        if (!file.exists()) {
            try {
            	f1 = new FileWriter(filename,true);
            	fOUT = new PrintWriter(f1);
            }catch(IOException e) {}
                      
            fOUT.println(intestazione);
            fOUT.flush();
            
            try {
            	f1.close();
            }catch(IOException e) {}
            
        }
	}
	
}

