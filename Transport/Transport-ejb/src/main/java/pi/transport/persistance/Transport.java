package pi.transport.persistance;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="t_transport")
public class Transport implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Integer id;
	public String Immatriculation;
	public String Status;
	

	public Transport() {
		
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	
	public Transport(Integer id) {
		this.id = id;		
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getImmatriculation() {
		return Immatriculation;
	}
	
	public Transport(String immatriculation, String status) {
		Immatriculation = immatriculation;
		Status = status;
	}
	
	public void setImmatriculation(String immatriculation) {
		Immatriculation = immatriculation;
	}
	
	public String getStatus() {
		return Status;
	}
	public void setState(String status) {
		Status = status;
	}
	
	public String toString() {
		return "PublicTransport [Immatriculation=" + Immatriculation
				+ ", Status=" + Status + "]";
	}
	

}
