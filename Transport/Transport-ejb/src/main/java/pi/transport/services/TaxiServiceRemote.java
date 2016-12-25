package pi.transport.services;

import java.util.List;

import javax.ejb.Remote;

import pi.transport.persistance.Taxi;

@Remote
public interface TaxiServiceRemote {
	
	
	void create(Taxi taxi);
	Taxi find (Integer numtaxi);
    void update (Taxi taxi);
		void delete (Taxi taxi );
		void delete(Integer numtaxi );
		List<Taxi> findAll();
		public  Taxi findByImmatriculation(String immatriculation);

}
