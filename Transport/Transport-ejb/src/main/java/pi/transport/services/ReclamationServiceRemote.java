package pi.transport.services;

import java.util.List;

import javax.ejb.Remote;

import pi.transport.persistance.Reclamation;
import pi.transport.persistance.User;

@Remote
public interface ReclamationServiceRemote {
	void add(Reclamation reclamation);
	Reclamation find(Integer id);
	void update(Reclamation r);
	void Delete (Reclamation r);
	void Delete(Integer id);
	List<Reclamation> findAll();
	
    Boolean addReclamation(Reclamation reclamation);
	

}
