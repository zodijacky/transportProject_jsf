package pi.transport.persistance;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity 
public class Bus extends PublicTransport implements Serializable {
	private int numero;
	
	private List<Route> routes= new ArrayList<Route>();
	public Bus(){
		
	}
	/*String immatriculation, String status,
			Integer code, Integer seatingCapacity, Integer standingCapacity) {
		super(immatriculation, status);
		this.code = code;
		SeatingCapacity = seatingCapacity;
		StandingCapacity = standingCapacity */



	



	public Bus(String immatriculation, String status, Integer code,
			Integer seatingCapacity, Integer standingCapacity, int numero,
			List<Route> routes) {
		super(immatriculation, status, code, seatingCapacity, standingCapacity);
		this.numero = numero;
		this.routes = routes;	
	}
	public Bus(String immatriculation, String status, Integer code,
			Integer seatingCapacity, Integer standingCapacity, int numero) {
		super(immatriculation, status, code, seatingCapacity, standingCapacity);
		this.numero = numero;	
		this.routes = new ArrayList<Route>();
	}



	public Bus(int numero, List<Route> listRoute) {
		this.numero = numero;
		this.routes = new ArrayList<>();
	}
	 
	public int getNumero() {
		return numero;
	}
	public void setNumero(int immat) {
		this.numero = immat;
	}
	
	@ManyToMany(cascade=CascadeType.ALL,mappedBy="buses")	
	public List<Route> getListRoute() {
		return routes;
	}
	public void setListRoute(List<Route> listRoute) {
		this.routes = listRoute;
	}



	@Override
	public String toString() {
		return "Bus [code=" + code + ", SeatingCapacity="
				+ SeatingCapacity + ", StandingCapacity=" + StandingCapacity
				+ ", numero=" + numero + ", id=" + id
				+ ", Immatriculation=" + Immatriculation + ", Status=" + Status
				+ "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numero;
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bus other = (Bus) obj;
		if (numero != other.numero)
			return false;
		return true;
	}




	
	
	
	
	
	

}
