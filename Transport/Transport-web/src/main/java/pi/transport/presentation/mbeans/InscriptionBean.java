package pi.transport.presentation.mbeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.json.JSONException;

import pi.transport.persistance.User;
import pi.transport.services.UserService;
import pi.transport.webservices.httpClientInscription;

@ManagedBean
@SessionScoped
public class InscriptionBean {

	@EJB
	private UserService  service;
	private int cin;
	
	private String password;
	private String firstName;
	private String lastName;
	private String adress;
	private String Email;
	
	
	
	
	
	public int getCin() {
		return cin;
	}
	public void setCin(int cin) {
		this.cin = cin;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
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
	
	
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		this.Email = email;
	}
	public String inscription()throws JSONException, IllegalAccessException{

		httpClientInscription service=new httpClientInscription();
	User u =new User();
		u.setEmail(Email);
		u.setCin(cin);
		u.setLastName(lastName);
		u.setFirstName(firstName);
		u.setpassword(password);
		u.setAdress(adress);
		
		service.register(u);
		
		
		return "/template/index.xhtml";
		
	}	
	
}
