package pi.transport.services;

import java.util.List;

import javax.ejb.Remote;

import pi.transport.persistance.PrivateTransport;

@Remote
public interface PrivateTransportServiceRemote {
	
	void create(PrivateTransport pt);
    PrivateTransport find (Integer id);
	void update (PrivateTransport pt);
	void delete (PrivateTransport pt );
	void delete(Integer id );
	List<PrivateTransport> findAll();
	//List<Employee> findDriverByPrivateTransport(PrivateTransport pt);

}
