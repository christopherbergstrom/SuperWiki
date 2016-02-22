package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import superHeroTest.Favorite;
import superHeroTest.SuperPersons;
import superHeroTest.SuperType;
import superHeroTest.User;

@Transactional
public class LoginDAO
{
	@PersistenceContext
	private EntityManager em;

	public User getUser(String username, String password)
	{
		String query = "select u from User u where u.username = '" + username + "' and u.password = '" + password + "'";
		User user = em.createQuery(query, User.class).getSingleResult();
		user = refreshUser(user);
		return user;
	}
	public void addUser(User newUser)
	{
			em.persist(newUser);
	}

	public void addFavorites(SuperPersons sp, User user)
	{
		Favorite fav = new Favorite(user, sp);
		boolean match = true;
		if (user.getFavorites().size() == 0)
		{
			user.addFavorites(fav);
			em.persist(fav);
		} 
		else
		{
			for (Favorite favorite : user.getFavorites())
			{
				if ((favorite.getSuperPerson().getId()) == (fav.getSuperPerson().getId()))
				{
					// tryin to add a fav that's already in list
					match = false;
					break;
				}
			}
			if (match)
			{
				user.addFavorites(fav);
				em.persist(fav);
			}
		}
	}

	public void deleteFavorite(SuperPersons sp, User user)
	{
		String query = "SELECT f from Favorite f where f.superPerson.id = " + sp.getId() + " AND f.user.id= "
				+ user.getId() + "";
		Favorite fav = em.createQuery(query, Favorite.class).getSingleResult();
		user.removeFavorites(fav);
		em.remove(fav);
	}

	public User refreshUser(User user)
	{
		user = em.merge(user);
		em.refresh(user);
		return user;
	}

	public List<User> getAllUsers()
	{
		return em.createNamedQuery("User.getAllUsers", User.class).getResultList();
	}

	public User getUser(int id)
	{
		return em.find(User.class, id);
	}

	public void deleteUser(User user)
	{
		user = refreshUser(user);
		user.getFavorites().clear();
		// user = refreshUser(user);
		em.remove(user);
	}

}