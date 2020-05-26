/**
 * 
 */
package ec.edu.ups.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import ec.edu.ups.dao.GenericDAO;

/**
 * @author Orlando Real
 * @param <T>
 *
 */
public class JPAGenericDAO<T, ID> implements GenericDAO<T, ID>{

	private Class<T> persistentClass;
    protected EntityManager em;
    
	/**
	 * 
	 */
	public JPAGenericDAO(Class<T> persistentClass) {
		// TODO Auto-generated constructor stub
		this.persistentClass = persistentClass;
		this.em = Persistence.createEntityManagerFactory("jpa").createEntityManager();
	}


	@Override
	public boolean create(T entity) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		try {
			em.persist(entity);
		    em.getTransaction().commit();
		} catch (Exception e) {
		    System.out.println(">>>> ERROR:JPAGenericDAO:create " + e);
		    if (em.getTransaction().isActive())
			em.getTransaction().rollback();
		}
		return true;
	}

	@Override
	public T read(ID id) {
		// TODO Auto-generated method stub
		return em.find(persistentClass, id);
	}

	@Override
	public void update(T entity) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		try {
		    em.merge(entity);
		    em.getTransaction().commit();
		} catch (Exception e) {
		    System.out.println(">>>> ERROR:JPAGenericDAO:update " + e);
		    if (em.getTransaction().isActive())
			em.getTransaction().rollback();
		}
	}

	@Override
	public void delete(T entity) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		try {
		    em.remove(entity);
		    em.getTransaction().commit();
		} catch (Exception e) {
		    System.out.println(">>>> ERROR:JPAGenericDAO:delete " + e);
		    if (em.getTransaction().isActive())
			em.getTransaction().rollback();
		}
	}

	@Override
	public List<T> find() {
		// TODO Auto-generated method stub
		List<T>lista= new ArrayList<T>();
		
		return null;
	}

}
