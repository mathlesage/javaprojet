package sound;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/**Gestion du Son
 * @author ABDELOUHAB Yacine
*/
public class Sound {
	
	private String son_fichier;
	
	/**Constructeur Par defaut : pas de chemin
	 * */
	public Sound(){
		this.son_fichier = "";
	}
	
	/**Constructeur avec initialisation du chemin
	 * @param son_fichier chemin ou se trouve le fichier son (point de depart : racine du projet)
	 * */
	public Sound(String son_fichier){
		this.son_fichier = son_fichier;	
	}
	
	
	/**Set le fichier
	 * @param son_fichier chemin du fichier
	 * */
	public void set_son_fichier(String son_fichier) {
		this.son_fichier = son_fichier;
	}
	
	
	/** Va faire jouer le son
	 * */
	public void display_son() {
		 
		try {
			//Charger le Fichier Audio
			File fichierAudio = new File(this.son_fichier);
			AudioInputStream ais = AudioSystem.getAudioInputStream(fichierAudio);
			
			//Format audio
			AudioFormat format = ais.getFormat();
			
			//Config DataLine
			DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
			
			//LigneAudio
			SourceDataLine ligneAudio = (SourceDataLine) AudioSystem.getLine(info);
			ligneAudio.open(format);
			ligneAudio.start();
			
			
			//Lecture heheeee
			 byte[] tampon = new byte[4096];
	         int bytesRead;
	         while ((bytesRead = ais.read(tampon)) != -1) {
	                ligneAudio.write(tampon, 0, bytesRead);
	         }
	         
	         
	         //On ferme tt : ok pas d'erreur pour les prochains sons
	         ligneAudio.drain();
	         ligneAudio.close();
	         ais.close();
			
		}
		catch(Exception e) {
			System.out.println("Erreur Son !!!");
			System.out.println(e.getMessage());
		}
		
	}
	
}
