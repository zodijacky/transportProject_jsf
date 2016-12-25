package pi.transport.persistance;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class TripSchedule implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6487784958266093138L;

	private int id;
	
	private Time depTime;
	private Time arrTime;
	private Date date;

	private Trip trip;
	
	
	public TripSchedule() {
		
	}


	public TripSchedule(Time depTime, Time arrTime, Date date, Trip trip) {
		super();
		this.depTime = depTime;
		this.arrTime = arrTime;
		this.date = date;
		this.trip = trip;
	}

	@ManyToOne
	@JoinColumn(name= "id_trip")
	public Trip getTrip() {
		return trip;
	}


	public void setTrip(Trip trip) {
		this.trip = trip;
	}

	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Time getDepTime() {
		return depTime;
	}

	public void setDepTime(Time depTime) {
		this.depTime = depTime;
	}

	public Time getArrTime() {
		return arrTime;
	}

	public void setArrTime(Time arrTime) {
		this.arrTime = arrTime;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
	

}
