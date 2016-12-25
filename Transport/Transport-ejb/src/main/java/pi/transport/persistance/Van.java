package pi.transport.persistance;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


@Entity

public class Van extends PrivateTransport implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private double price;
	private Integer capacity;

	public Van() {
		
	}

	public Van(String immatriculation, String status,
			List<Driver> driver, double price, Integer capacity) {
		super(immatriculation, status, driver);
		this.price = price;
		this.capacity = capacity;
	}
    
	public Van(String immatriculation, String status, double price,
			Integer capacity) {
		super(immatriculation, status);
		this.price = price;
		this.capacity = capacity;
	}




	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}




	@Override
	public String toString() {
		return "Van [price=" + price + ", capacity=" + capacity + ", id=" + id
				+ ", Immatriculation=" + Immatriculation + ", Status=" + Status
				+ "]";
	}

	
   
}
