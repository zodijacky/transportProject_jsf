package pi.transport.persistance;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;


@Entity(name= "t_driver")
public class Driver extends User implements Serializable {
	private static final long serialVersionUID = 1L;
	
    private String availability;
    private String vchType;
    private String drivingLicense;
    private List<Course> courses;
    private PrivateTransport privateTransport;
	public Driver() {
		super();
	}
	

	public Driver(Integer cin, String login, String passWord,
			String availability) {
		super(cin, login, passWord);
		this.availability = availability;
		this.courses=new ArrayList<Course>();
	}
	public Driver(String availability, String vchType, String drivingLicense) {
		super();
		this.availability = availability;
		this.vchType = vchType;
		this.drivingLicense = drivingLicense;
		this.courses=new ArrayList<Course>();
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	public String getVchType() {
		return vchType;
	}
	public void setVchType(String vchType) {
		this.vchType = vchType;
	}
	public String getDrivingLicense() {
		return drivingLicense;
	}
	public void setDrivingLicense(String drivingLicense) {
		this.drivingLicense = drivingLicense;
	}
	@OneToMany(mappedBy="driver")
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	@ManyToOne
	@JoinColumn(name="id_privateTransport")
	public PrivateTransport getPrivateTransport() {
		return privateTransport;
	}
	public void setPrivateTransport(PrivateTransport privateTransport) {
		this.privateTransport = privateTransport;
	}


	@Override
	public String toString() {
		return super.toString()+"  Driver[availability=" + availability + ", vchType=" + vchType
				+ ", drivingLicense=" + drivingLicense 
				+ ", privateTransport=" + privateTransport +  "]";
	}


	


	

	
    
	

}
