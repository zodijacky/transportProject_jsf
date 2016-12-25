package pi.transport.persistance;

import java.io.Serializable;
import java.util.Date;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="t_subscription")
public class Subscription implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3131887515664370718L;

	public enum SubscriptionTypes{
		Bus, Train
	}
	
	private int id;
	private Date startDate;
	private Date expirationDate;
	private SubscriptionTypes type;
	
	
	private Route route;
	
	private Student student;
	
	public Subscription(){}
	
	public Subscription(Date startDate, Date expirationDate,
			SubscriptionTypes type, Route route, Student student) {
		super();

		this.startDate = startDate;
		this.expirationDate = expirationDate;
		this.type = type;
		this.route = route;
		this.student = student;
	}
	
	
	@Id @GeneratedValue(strategy= GenerationType.IDENTITY)
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	@Temporal(TemporalType.DATE)
	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Temporal(TemporalType.DATE)
	public Date getExpirationDate() {
		return expirationDate;
	}


	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}


	public SubscriptionTypes getType() {
		return type;
	}


	public void setType(SubscriptionTypes type) {
		this.type = type;
	}


	@ManyToOne
	@JoinColumn(name="id_route")
	public Route getRoute() {
		return route;
	}


	public void setRoute(Route route) {
		this.route = route;
	}

	@ManyToOne
	@JoinColumn(name="id_student")
	public Student getStudent() {
		return student;
	}


	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Subscription [id=" + id + ", startDate=" + startDate
				+ ", expirationDate=" + expirationDate + ", type=" + type
				+ ", route=" + route + ", student=" + student + "]";
	}

	
	
	
	
	

}
