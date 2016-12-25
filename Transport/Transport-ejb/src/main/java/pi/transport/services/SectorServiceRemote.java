package pi.transport.services;

import java.util.List;

import javax.ejb.Remote;

import pi.transport.persistance.Sector;

@Remote
public interface SectorServiceRemote {
	Sector create (Sector sect);
	Sector find (Integer id);
	void update (Sector sect);
	void delete (Sector sect);
	void delete(Integer id );
	List<Sector> findAll();
	List<Sector> findSectorsLike(String str);
    Sector findId(String area);
}
