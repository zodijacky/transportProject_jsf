package pi.transport.services;

import java.util.List;

import javax.ejb.Remote;

import pi.transport.persistance.Van;
import pi.transport.persistance.WheelChairVan;

@Remote
public interface WheelChairVanServiceRemote {
	
	void create(WheelChairVan  wcvan);
	WheelChairVan find (Integer id);
		void update (WheelChairVan  wcvan);
		void delete (WheelChairVan wcvan );
		void delete(Integer id );
		List<WheelChairVan> findAll();

}
