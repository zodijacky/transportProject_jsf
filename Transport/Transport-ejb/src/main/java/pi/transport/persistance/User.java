package pi.transport.persistance;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="t_user")
public class User implements Serializable 
{
	private static final long serialVersionUID = 1L;
	private String id;
	private Integer cin;
	private String login;
	private String password;
	private String firstName;
	private String lastName;
    private Date birthDate;
	private String adress;
	private String Email;
	private String phoneNumber;
	private byte[] picture;
	private List<Reclamation> reclamations;
	private List<Request> requests;
	
	
	public User () {}
	
	



	public User(Integer cin, String login, String password) {
		super();
		this.cin = cin;
		this.login = login;
		this.password = password;
		this.reclamations=new ArrayList<Reclamation>();
		this.requests=new ArrayList<Request>();
		
	}




@Column(name="Id")
	public String getId() {
		return id;
	}





	public void setId(String id) {
		this.id = id;
	}





	public User(Integer cin, String login, String password, String firstName,
			String lastName) {
		super();
		this.cin = cin;
		this.login = login;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}





	public User(Integer cin, String login, String password, String firstName,
			String lastName, Date birthDate, String adress, String Email,
			String phoneNumber, byte[] picture,
			List<Reclamation> reclamations, List<Request> requests) {
		super();
		this.cin = cin;
		this.login = login;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.adress = adress;
		this.Email = Email;
		this.phoneNumber = phoneNumber;
		this.picture = picture;
		this.reclamations = reclamations;
		this.requests = requests;
	}





	public User(Integer cin, String login, String password, String firstName,
			String lastName, Date birthDate, String adress, String Email,
			String phoneNumber) {
		super();
		this.cin = cin;
		this.login = login;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.adress = adress;
		this.Email = Email;
		this.phoneNumber = phoneNumber;
		this.reclamations=new ArrayList<Reclamation>();
		this.requests=new ArrayList<Request>();
		
	}

	@Id
	public Integer getCin() {
		return cin;
	}

	public void setCin(Integer cin) {
		this.cin = cin;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getpassword() {
		return password;
	}

	public void setpassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Temporal(TemporalType.DATE)
	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String Email) {
		this.Email = Email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Lob
	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}




    @OneToMany(mappedBy="user")
	public List<Reclamation> getReclamations() {
		return reclamations;
	}


	public void setReclamations(List<Reclamation> reclamations) {
		this.reclamations = reclamations;
	}

    @OneToMany(mappedBy="user")
	public List<Request> getRequests() {
		return requests;
	}
   public void setRequests(List<Request> requests) {
		this.requests = requests;
	}





@Override
public String toString() {
	return "cin=" + cin + ", login=" + login + ", password=" + password
			+ ", firstName=" + firstName + ", lastName=" + lastName
			+ ", birthDate=" + birthDate + ", adress=" + adress + ", Email="
			+ Email + ", phoneNumber=" + phoneNumber + "]";
}


	
	
	}	