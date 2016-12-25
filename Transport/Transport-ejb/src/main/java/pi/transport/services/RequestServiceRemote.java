package pi.transport.services;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import pi.transport.persistance.Request;
import pi.transport.persistance.User;

@Remote
public interface RequestServiceRemote {

	 public void create(Request request);
	 public void update(Request request);
	 public void delete(Request request);
	 public void delete(Integer id);
	 public Request find(Integer id);
	 public List<Request> findAll();
	 public List<Request> findRequestByUser(User user);
	 public List<Request> FindRequestLikeNameUser(String name);
	
}
