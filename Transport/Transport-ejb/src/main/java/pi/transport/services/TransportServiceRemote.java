package pi.transport.services;

import java.util.List;

import javax.ejb.Remote;

import pi.transport.persistance.Transport;

@Remote
public interface TransportServiceRemote {
	void add(Transport transport);
	Transport find(Integer id);
	void update(Transport transport);
	void Delete (Transport transport);
	void Delete(Integer id);
	List<Transport> findAll();
}
