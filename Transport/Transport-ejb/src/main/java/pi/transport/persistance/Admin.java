package pi.transport.persistance;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Admin extends User implements Serializable{
	
	public enum AdminLevels{
		superAdmin, admin;
	}
	
	private AdminLevels level;
	
	private List<Request> reservations;
		
	public Admin() {
		reservations = new ArrayList<Request>();
	}

	public Admin(AdminLevels level)
	{
		reservations = new ArrayList<Request>();
		this.level = level;
	}
	
	public Admin(AdminLevels level, List<Request> reservations) {
		super();
		this.level = level;
		this.reservations = reservations;
	}
	
	
	
	public Admin(Integer cin, String login, String passWord, String firstName,
			String lastName, Date birthDate, String adress, String mail,
			String phoneNumber, AdminLevels level) {
		super(cin, login, passWord, firstName, lastName, birthDate, adress,
				mail, phoneNumber);
		this.level = level;
		this.reservations = reservations;
	}

	public void addReservation(Request reservation){
		reservations.add(reservation);
	}

	public AdminLevels getLevel() {
		return level;
	}

	public void setLevel(AdminLevels level) {
		this.level = level;
	}

	@OneToMany (mappedBy = "author") //request doit avoir un att admin
	public List<Request> getReservations() {
		return reservations;
	}

	public void setReservations(List<Request> reservations) {
		this.reservations = reservations;
	}

	@Override
	public String toString() {
		return super.toString() + "Admin [level=" + level + ", reservations=" + reservations + "]";
	}

	

	
	
	
	

}
