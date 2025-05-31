package gestore_password;
import java.io.*;


class Menu // HA IL COMPITO DI RESTITUIRE UNA SCELTA DI MENU' FORNITA DAGLI UTENTI
{



 // per definire un menù customizzato basta variare il contenuto delle stringhe componenti il seguente vettore
 public final static String SCELTE[] = 
  {
   "Digita 0 per uscire", 
   "Digita 1 per aggiungere una password.",
   "Digita 2 per per stampare la password specifica.",
   "Digita 3 per per stampare l' e-mail specifica.",
   "Digita 4 per per stampare l' username specifico.",
   "Digita 5 per per stampare le info specifiche.",
   "Digita 6 per stampare tutto.",
   
  };



 public static int ScegliVoce() // chiede una scelta da un menù
  {
   int scelta;
   String prompt = "Fai la tua scelta, digitando un numero";
   
   System.out.println(ChiediDati.SEPARATORE + ChiediDati.SEPARATORE);
   for (int i = 0; i < SCELTE.length; i++)
   {
      System.out.println(SCELTE[i]);
   }
   scelta = ChiediDati.ChiediIntero(prompt, 0, (SCELTE.length) - 1);
   System.out.println();
   

   return scelta;
  }

}