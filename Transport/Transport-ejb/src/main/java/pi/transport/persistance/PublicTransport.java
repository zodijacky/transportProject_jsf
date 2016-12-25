package pi.transport.persistance;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class PublicTransport  extends Transport  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Integer code;
	protected Integer SeatingCapacity;
	protected Integer StandingCapacity;
	
	private List<News> news;
	
	
	public PublicTransport(String immatriculation, String status,
			Integer code, Integer seatingCapacity, Integer standingCapacity) {
		super(immatriculation, status);
		this.code = code;
		SeatingCapacity = seatingCapacity;
		StandingCapacity = standingCapacity;
	}
	
	
	/*public PublicTransport(String immatriculation, String status,
			Integer code, Integer seatingCapacity, Integer standingCapacity,
			List<News> news) {
		super(immatriculation, status);
		this.code = code;
		SeatingCapacity = seatingCapacity;
		StandingCapacity = standingCapacity;
		this.news = news;
	}*/
	
	public PublicTransport() {
		this.news=new ArrayList<>();
	}
	

	
	@OneToMany(mappedBy = "publicTransport")
	public List<News> getNews() {
		return news;
	}
	public void setNews(List<News> news) {
		this.news = news;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	
	public Integer getCode() {
		return code;
	}
	
	public Integer getSeatingCapacity() {
		return SeatingCapacity;
	}
	public void setSeatingCapacity(Integer seatingCapacity) {
		SeatingCapacity = seatingCapacity;
	}
	public Integer getStandingCapacity() {
		return StandingCapacity;
	}
	public void setStandingCapacity(Integer standingCapacity) {
		StandingCapacity = standingCapacity;
	}


	
	public String toString() {
		return "PublicTransport [code=" + code + ", SeatingCapacity="
				+ SeatingCapacity + ", StandingCapacity=" + StandingCapacity
				+ ", Immatriculation="+ Immatriculation+",+Status="+Status+" ]";
	}
	
}

