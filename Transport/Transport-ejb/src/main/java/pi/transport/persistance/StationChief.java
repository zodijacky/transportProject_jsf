package pi.transport.persistance;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class StationChief extends User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3422331196358516884L;
	
	private Station station;
	private Date dateEmbauche;
	private double salaire;
	private long matricule;
	
	public StationChief() {
	}
	
	

	public StationChief(Integer cin, String login, String passWord,
			String firstName, String lastName, Date birthDate, String adress,
			String mail, String phoneNumber, Station station,
			Date dateEmbauche, double salaire, long matricule) {
		super(cin, login, passWord, firstName, lastName, birthDate, adress,
				mail, phoneNumber);
		this.station = station;
		this.dateEmbauche = dateEmbauche;
		this.salaire = salaire;
		this.matricule = matricule;
	}
	
	
	@OneToOne(mappedBy = "stationChief")
	public Station getStation() {
		return station;
	}


	public void setStation(Station station) {
		this.station = station;
	}


	public Date getDateEmbauche() {
		return dateEmbauche;
	}


	public void setDateEmbauche(Date dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}


	public double getSalaire() {
		return salaire;
	}


	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}


	public long getMatricule() {
		return matricule;
	}


	public void setMatricule(long matricule) {
		this.matricule = matricule;
	}
	
	
	

}
