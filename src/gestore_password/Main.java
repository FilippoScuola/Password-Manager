package gestore_password;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) {
		Gestore g = new Gestore();
		Scanner scanner = new Scanner(System.in);
		boolean uscita = false;
		g.verificaEsistenza();
		g.caricaPassword();
		while (!uscita) {
            int x = Menu.ScegliVoce();
            switch (x) {
                case 1:
                    g.aggiungiPassword();
                    break;
                case 2:
                    g.stampaPasswordSpecifica();
                    break;
                case 3:
                    g.stampaEmailSpecifica();
                    break;
                case 4:
                    g.stampaUsernameSpecifico();
                    break;
                case 5:
                    g.stampaSpecifica();
                    break;
                case 6:
                    g.stampaPassword();
                    break;
                case 0:
                    uscita = true;
                    break;
                default:
                    uscita = true;
                    break;
            }
            System.out.println();
            if(x>=1 && x<=6){
                scanner.nextLine();
            }
            
        }
		
	}
}
