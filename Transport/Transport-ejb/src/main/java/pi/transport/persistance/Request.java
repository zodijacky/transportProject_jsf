package pi.transport.persistance;

import java.io.Serializable;
import java.util.Date;



import javax.persistence.*;

@Entity
@Table(name="t_request")

public class Request implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
    private Integer Id;
    private Date date;
    private Date time;
    private User author;
    private User user;
	private boolean state;
    
    public Request() {
		super();
	}


	



	public Request(Integer id, Date date, Date time, User author, User user) {
		super();
		Id = id;
		this.date = date;
		this.time = time;
		this.author = author;
		this.user = user;
		this.state = false;
	}
  












	public Request(Date date, Date time, User author, User user) {
		super();
		this.date = date;
		this.time = time;
		this.author = author;
		this.user = user;
		this.state = false;
	}













	public boolean getState() {
		return state;
	}




	public void setState(boolean state) {
		this.state = state;
	}




	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return Id;
	}


	public void setId(Integer id) {
		Id = id;
	}

	@Temporal(TemporalType.DATE)
	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}

	@Temporal(TemporalType.TIME)
	public Date getTime() {
		return time;
	}


	public void setTime(Date time) {
		this.time = time;
	}

   @ManyToOne
   @JoinColumn(name="id_author")
	public User getAuthor() {
		return author;
	}


	public void setAuthor(User author) {
		this.author = author;
	}


	@ManyToOne
	@JoinColumn(name="id_user")
	public User getUser() {
		return user;
	}
    
	public void setUser(User user) {
		this.user = user;
	}











	@Override
	public String toString() {
		return "Request [Id=" + Id + ", date=" + date + ", time=" + time
				+ ", author=" + author + ", user=" + user + ", state=" + state
				+ "]";
	}





	
	
}