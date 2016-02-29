package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import superHeroTest.SuperPersonType;
import superHeroTest.SuperPersons;
import superHeroTest.SuperType;

@Transactional
public class SuperDAO
{
	@PersistenceContext
	private EntityManager em;

	public List<SuperPersons> getByName(String name)
	{
		return em.createNamedQuery("SuperPersons.getName", SuperPersons.class).setParameter("name", "%" + name + "%")
				.getResultList();
	}

	// public SuperPersons getByName(String name) {
	// return
	// em.createNamedQuery("SuperPersons.getName",SuperPersons.class).setParameter("name",
	// "%" + name + "%").getSingleResult();
	// }
	public SuperPersons getById(int Id)
	{
		return em.find(SuperPersons.class, Id);
	}

	public List<SuperPersons> getAllSuperheroes()
	{
		return em.createNamedQuery("SuperPersons.getAllSuperHeros", SuperPersons.class)
				.setParameter("supertype", SuperType.superhero).getResultList();
	}

	public List<SuperPersons> getAllVillains()
	{
		return em.createNamedQuery("SuperPersons.getAllSuperHeros", SuperPersons.class)
				.setParameter("supertype", SuperType.villain).getResultList();
	}

	public List<SuperPersons> getAllCharacters()
	{
		return em.createQuery("select s from SuperPersons s", SuperPersons.class).getResultList();
	}

	public void addSuperPerson(SuperPersons sp)
	{
		List<SuperPersons> characters = em.createQuery("select s from SuperPersons s", SuperPersons.class).getResultList();
		boolean match = true;
		for (SuperPersons superperson : characters)
		{
			if (superperson.getName().equals(sp.getName()))
			{
				match = false;
				break;
			}
		}
		if (match)
			em.persist(sp);
	}

	public void updateCharacter(SuperPersons sp)
	{
		SuperPersons sperson = getById(sp.getId());
		sperson.setName(sp.getName());
		sperson.setAlias(sp.getAlias());
		sperson.setCreator(sp.getCreator());
		sperson.setFirstAppearance(sp.getFirstAppearance());
		sperson.setTeam(sp.getTeam());
		sperson.setOrigin(sp.getOrigin());
		sperson.setPublisher(sp.getPublisher());
		sperson.setSuperType(sp.getSuperType());
		sperson.setImage(sp.getImage());
		em.persist(sperson);
	}

	public SuperPersons refreshSuperPersons(SuperPersons sp)
	{
		sp = em.merge(sp);
		em.refresh(sp);
		return sp;
	}
}