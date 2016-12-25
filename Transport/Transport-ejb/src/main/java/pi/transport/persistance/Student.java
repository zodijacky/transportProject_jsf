package pi.transport.persistance;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Student  extends User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4310860483262930563L;

	private String establishment;
	public enum StudentLevels{
		primary, secondary, highSchool;
	}
	private StudentLevels level;
	
	List<Subscription> subscription;

	
	
	public Student() {
		this.subscription = new ArrayList<>();
	}
	
	

	public Student(Integer cin, String login, String passWord,
			String firstName, String lastName, Date birthDate, String adress,
			String mail, String phoneNumber, String establishment,
			StudentLevels level) {
		super(cin, login, passWord, firstName, lastName, birthDate, adress,
				mail, phoneNumber);
		this.establishment = establishment;
		this.level = level;
	}



	public Student(String establishment, StudentLevels level, List<Subscription> subscription) {
		super();
		this.establishment = establishment;
		this.level = level;
		this.subscription = subscription;
	}
	
	public Student(String establishment, StudentLevels level)
	{
		this.establishment = establishment;
		this.level = level;
		this.subscription = new ArrayList<Subscription>();
	}

	public String getEstablishment() {
		return establishment;
	}
	
	public void setEstablishment(String establishment) {
		this.establishment = establishment;
	}
	public StudentLevels getLevel() {
		return level;
	}
	public void setLevel(StudentLevels level) {
		this.level = level;
	}
	
	@OneToMany (mappedBy = "student") //Subscription doit avoir un att student
	public List<Subscription> getSubscription() {
		return subscription;
	}
	public void setSubscription(List<Subscription> subscription) {
		this.subscription = subscription;
	}



	@Override
	public String toString() {
		return super.toString() + "Student [establishment=" + establishment + ", level=" + level + "]";
	}
	
	
	
	
}
