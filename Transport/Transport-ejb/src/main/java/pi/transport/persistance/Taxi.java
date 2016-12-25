package pi.transport.persistance;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


@Entity


public class Taxi extends PrivateTransport implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private Integer numTaxi;
	private double workHours;


	public Taxi() {
		
	}
	

	public Taxi(String immatriculation, String status,
			List<Driver> driver, Integer numTaxi, double workHours) {
		super(immatriculation, status, driver);
		this.numTaxi = numTaxi;
		this.workHours = workHours;
	}

  
	public Taxi(String immatriculation, String status, Integer numTaxi,
			double workHours) {
		super(immatriculation, status);
		this.numTaxi = numTaxi;
		this.workHours = workHours;
	}






	public Integer getNumTaxi() {
		return numTaxi;
	}


	public void setNumTaxi(Integer numTaxi) {
		this.numTaxi = numTaxi;
	}


	public double getWorkHours() {
		return workHours;
	}


	public void setWorkHours(double workHours) {
		this.workHours = workHours;
	}


	@Override
	public String toString() {
		return "Taxi [numTaxi=" + numTaxi + ", workHours=" + workHours
				+ ", id=" + id + ", Immatriculation=" + Immatriculation
				+ ", Status=" + Status + "]";
	}


	
	
	
   
}

