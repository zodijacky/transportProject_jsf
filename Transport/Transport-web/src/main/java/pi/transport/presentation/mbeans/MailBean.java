package pi.transport.presentation.mbeans;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.mail.MessagingException;

import pi.transport.services.GwMailService;






@Named
@RequestScoped
public class MailBean {

	
	  private String recipient;
	    private String subject;
	    private String message;
	    private String statusMessage = "";
	 public String getMessage() {
	        return message;
	    }

	    public void setMessage(String message) {
	        this.message = message;
	    }

	    public String getRecipient() {
	        return recipient;
	    }

	    public void setRecipient(String recipient) {
	        this.recipient = recipient;
	    }

	    public String getSubject() {
	        return subject;
	    }

	    public void setSubject(String subject) {
	        this.subject = subject;
	    }

	    public String getStatusMessage() {
	        return statusMessage;
	    }
	    
	    public String send() {
	        statusMessage = "Message Sent";
	        try {
	            GwMailService.sendMessage(recipient, subject, message);
	        }
	        catch(MessagingException ex) {
	            statusMessage = ex.getMessage();
	        }
	        return "email";  // redisplay page with status message
	    }
	    
	  
}
