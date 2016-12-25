package pi.transport.services;

import java.util.List;

import javax.ejb.Remote;

import pi.transport.persistance.News;
import pi.transport.persistance.PublicTransport;
import pi.transport.persistance.Sector;

@Remote
public interface PublicTransportServiceRemote {
	void add(PublicTransport publictransport);
	PublicTransport find(Integer id);
	void update(PublicTransport publictransport);
	void Delete (PublicTransport publictransport);
	void Delete(Integer id);
	List<PublicTransport> findAll();
	List<PublicTransport> findPublicTransportBySector(Sector s);
	List<News> findNewsByPublicTransport(PublicTransport pt);
	

}
