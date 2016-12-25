package pi.transport.services;

import java.util.List;

import javax.ejb.Remote;

import pi.transport.persistance.News;

@Remote
public interface NewsServiceRemote {
	public void create(News news);
	
	public void delete(News n);
	public void delete(Integer id);
	public List<News> findAll();
	public void update(News n);
	public News find(Integer id);
	public List<News> findNewsLike(String str);
	
}
