package pi.transport.persistance;

import java.io.Serializable;

import javax.persistence.*;


@Entity

public class WheelChairVan extends Van implements Serializable {

	
	private Integer NbWheelChairs;
	private static final long serialVersionUID = 1L;

	public WheelChairVan() {
		
	}  
	
	
	public WheelChairVan(String immatriculation, String status, double price,
			Integer capacity, Integer nbWheelChairs) {
		super(immatriculation, status, price, capacity);
		NbWheelChairs = nbWheelChairs;
	}


	public Integer getNbWheelChairs() {
		return this.NbWheelChairs;
	}

	public void setNbWheelChairs(Integer NbWheelChairs) {
		this.NbWheelChairs = NbWheelChairs;
	}
   
}
