package pi.transport.persistance;

import java.awt.List;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name ="t_news")
public class News implements Serializable{
	private Integer id;
	private String description;
	private Date dateNews;
	private PublicTransport publicTransport;
	private Route route;
	
	
	   public News(){
		
	}
     public News(Integer id, String description) {
		
		this.id = id;
		this.description = description;
		
	      }
	public News(Integer id, String description, Date dateNews) {
		
		this.id = id;
		this.description = description;
		this.dateNews = dateNews;
	}
	
	public News(Integer id, String description, Date dateNews,
			PublicTransport publicTransport, Route route) {
		this.id = id;
		this.description = description;
		this.dateNews = dateNews;
		this.publicTransport = publicTransport;
		this.route = route;
	}
	
	public News(String description, Date dateNews,
			PublicTransport publicTransport, Route route) {
		super();
		this.description = description;
		this.dateNews = dateNews;
		this.publicTransport = publicTransport;
		this.route = route;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDateNews() {
		return dateNews;
	}
	public void setDateNews(Date dateNews) {
		this.dateNews = dateNews;
	}
	
	@ManyToOne
	@JoinColumn(name="id_publicTransport")
	public PublicTransport getPublicTransport() {
		return publicTransport;
	}
	public void setPublicTransport(PublicTransport publicTransport) {
		this.publicTransport = publicTransport;
	}
	@ManyToOne
	@JoinColumn(name="id_route")
	public Route getRoute() {
		return route;
	}
	public void setRoute(Route route) {
		this.route = route;
	}
	@Override
	public String toString() {
		return "News [id=" + id + ", description=" + description
				+ ", dateNews=" + dateNews + ", publicTransport="
				+ publicTransport + ", route=" + route + "]";
	}
}
