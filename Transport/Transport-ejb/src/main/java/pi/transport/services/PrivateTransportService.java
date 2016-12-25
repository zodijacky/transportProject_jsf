package pi.transport.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pi.transport.persistance.PrivateTransport;


@Stateless
@LocalBean
public class PrivateTransportService implements PrivateTransportServiceRemote {

    @PersistenceContext
	private EntityManager em;
    public PrivateTransportService() {
       
    }

	@Override
	public void create(PrivateTransport pt) {
		em.persist(pt);
		
	}

	@Override
	public PrivateTransport find(Integer id) {
	
 return em.find(PrivateTransport.class, id);
	}

	@Override
	public void update(PrivateTransport privatetransport) {
		em.merge(privatetransport);
		
	}

	@Override
	public void delete(PrivateTransport privatetransport) {
		em.remove(em.merge(privatetransport));
		
	}

	@Override
	public void delete(Integer id) {
		
		PrivateTransport pt = em.find(PrivateTransport.class, id);
		em.remove(pt);
		
	}

	@Override
	public List<PrivateTransport> findAll() {
		
		return em.createQuery("select p  from PrivateTransport p",PrivateTransport.class)
				.getResultList();

	}
	
    

}
