package pi.transport.services;

import java.util.List;

import javax.ejb.Remote;

import pi.transport.persistance.Van;

@Remote
public interface vanServiceRemote {
	
	void create(Van  van);
   Van find (Integer id);
	void update (Van  van);
	void delete (Van  van );
	void delete(Integer id );
	List<Van> findAll();

}
