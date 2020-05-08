package Classes;

import java.time.LocalDateTime;
import java.util.Date;

public class cmd_restaurant extends commande {
	private Table table;
	public Table getTable() {
		return table;
	}
	public void setTable(Table table) {
		this.table = table;
	}
    public boolean place; // inter ou exter le restaurant
	public cmd_restaurant(client cl, int nbr_personne, LocalDateTime heure_cons, boolean place) {
		super(cl,nbr_personne, heure_cons);
		this.place=place;
		
	}



}
