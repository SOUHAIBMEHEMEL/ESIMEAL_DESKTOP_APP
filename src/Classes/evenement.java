package Classes;

import java.time.LocalDateTime;
import java.util.Date;

public class evenement extends commande {
	private menu menu;
	public void setMenu(menu menu) {
		this.menu = menu;
	}
	public menu getMenu() {
		return menu;
	}
	public evenement(client cl ,int nbr_personne, LocalDateTime heure_cons) {
		super(cl,nbr_personne, heure_cons);
	}
    public int getNbInvites(){return  this.nbr_personne;}
}
