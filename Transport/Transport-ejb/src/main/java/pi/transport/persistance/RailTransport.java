

package pi.transport.persistance;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class RailTransport extends PublicTransport{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String type;
	public Integer specialPlaceCapacity;
	
	
	private Sector sector;
	
	public RailTransport(){
		
	}
	public RailTransport(String immatriculation, String status,
			Integer code, Integer seatingCapacity, Integer standingCapacity,
			String type, Integer specialPlaceCapacity, Sector sector) {
		super(immatriculation, status, code, seatingCapacity,
				standingCapacity);
		this.type = type;
		this.specialPlaceCapacity = specialPlaceCapacity;
		this.sector = sector;
	}

	
	public RailTransport(String immatriculation, String status,
			Integer code, Integer seatingCapacity, Integer standingCapacity,
			String type, Integer specialPlaceCapacity) {
		super(immatriculation, status, code, seatingCapacity,
				standingCapacity);
		this.type = type;
		this.specialPlaceCapacity = specialPlaceCapacity;
		
	}

	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}

    @ManyToOne
    @JoinColumn(name="id_sector")
	public Sector getSector() {
		return sector;
	}


	public void setSector(Sector sector) {
		this.sector = sector;
	}


	public Integer getSpecialPlaceCapacity() {
		return specialPlaceCapacity;
	}


	public void setSpecialPlaceCapacity(Integer specialPlaceC) {
		specialPlaceCapacity = specialPlaceC;
	}


	
	
	public String toString() {
		return "RailTransport [Immatriculation="+ Immatriculation +", Status ="+ Status +",type=" + type + ",code=" + code + ", SeatingCapacity="
				+ SeatingCapacity + ", StandingCapacity=" + StandingCapacity
				+ ", SpecialPlaceCapacity="
				+ specialPlaceCapacity + ", sector=" + sector +"]";
	}
	 
	
	

}