package pi.transport.persistance;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="t_reclamation")
public class Reclamation   implements Serializable{
	
	private Integer id;
	
	private String subject;
	private String text;
    private User user;
	
	public Reclamation() {
		
	}
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="cin_user")
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Reclamation(String subject, String text) {
		
		this.subject = subject;
		this.text = text;
	}
	public Reclamation(String subject, String text,User user) {
		
		this.subject = subject;
		this.text = text;
		this.user=user;
	}
	
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	public String toString() {
		return "Reclamation [id=" + id + ", subject=" + subject + ", text="
				+ text  + ",user="
				+ user  + "]";
	}
	
	
	
	
	

}
