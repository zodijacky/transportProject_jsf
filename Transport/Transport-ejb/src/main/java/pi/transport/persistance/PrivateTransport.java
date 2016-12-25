package pi.transport.persistance;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


@Entity

public class PrivateTransport extends Transport implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	
	List<Driver> driver;

	public PrivateTransport() {
		
	}
	
	

	public PrivateTransport(String immatriculation, String status) {
		super(immatriculation, status);
	}



	public PrivateTransport(String immatriculation, String status,
			List<Driver> driver) {
		super(immatriculation, status);
		this.driver = driver;
	}


    @OneToMany(mappedBy=  "privateTransport")
	public List<Driver> getDriver() {
		return driver;
	}

	public void setDriver(List<Driver> driver) {
		this.driver = driver;
	}



	@Override
	public String toString() {
		return "PrivateTransport [id=" + id
				+ ", Immatriculation=" + Immatriculation + ", Status=" + Status
				+ "]";
	}



	
    
	
	
   
}
