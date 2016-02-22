package superHeroTest;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="favorite_superpersons")
public class Favorite {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name="superpersons_id")
	private SuperPersons superPerson;
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	public Favorite(User user, SuperPersons superPerson){
		this.superPerson = superPerson;
		this.user = user;
	}
	public Favorite(){
		
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public SuperPersons getSuperPerson()
	{
		return superPerson;
	}
	public void setSuperPerson(SuperPersons superPerson)
	{
		this.superPerson = superPerson;
	}
	public User getUser()
	{
		return user;
	}
	public void setUser(User user)
	{
		this.user = user;
	}
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((superPerson == null) ? 0 : superPerson.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Favorite other = (Favorite) obj;
		if (id != other.id)
			return false;
		if (superPerson == null) {
			if (other.superPerson != null)
				return false;
		} else if (!superPerson.equals(other.superPerson))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	
}
