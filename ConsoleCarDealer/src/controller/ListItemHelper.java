package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ListType;

public class ListItemHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ConsoleCarDealer");

	public void insertItem(ListType li) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();
	}

	public List<ListType> showAllItems() {
		EntityManager em = emfactory.createEntityManager();
		List<ListType> allItems = em.createQuery("SELECT i FROM ListType i").getResultList();
		return allItems;
	}

	public void deleteItem(ListType toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListType> typedQuery = em.createQuery(
				"select li from ListType li where li.make = :selectedMake and li.type = :selectedType",
				ListType.class);
		// Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedMake", toDelete.getMake());
		typedQuery.setParameter("selectedType", toDelete.getType());

		// we only want one result
		typedQuery.setMaxResults(1);

		// get the result and save it into a new list item
		ListType result = typedQuery.getSingleResult();

		// remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();

	}

	public ListType searchForItemById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		ListType found = em.find(ListType.class, idToEdit);
		em.close();
		return found;
	}

	public void updateItem(ListType toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	public List<ListType> searchForItemByStore(String makeName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListType> typedQuery = em.createQuery("select li from ListType li where li.make = :selectedMake", ListType.class);
		typedQuery.setParameter("selectedMake", makeName);

		List<ListType> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	public List<ListType> searchForItemByItem(String typeName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListType> typedQuery = em.createQuery("select li from ListType li where li.type = :selectedType", ListType.class);
		typedQuery.setParameter("selectedType", typeName);

		List<ListType> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	
	public void cleanUp(){
		emfactory.close();
	}

}
