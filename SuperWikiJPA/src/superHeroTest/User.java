package superHeroTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "user")
@NamedQuery(name = "User.getAllUsers", query = "select u from User u")
public class User
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String username;
	private String email;
	private String password;

	@Column(name = "create_time")
	private Date timeStamp;
	@OneToMany(mappedBy = "user")
	private List<Comment> comments = new ArrayList<Comment>();
	@OneToMany( mappedBy = "user", fetch = FetchType.EAGER)
	private Set<Favorite> favorites = new LinkedHashSet<Favorite>();

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public Date getTimeStamp()
	{
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp)
	{
		this.timeStamp = timeStamp;
	}

	public List<Comment> getComments()
	{
		return comments;
	}

	public void setComments(List<Comment> comments)
	{
		this.comments = comments;
	}

	public Set<Favorite> getFavorites()
	{
		return favorites;
	}

	public void setFavorites(Set<Favorite> favorites)
	{
		this.favorites = favorites;
	}

	public void addFavorites(Favorite fav)
	{
		if (!favorites.contains(fav))
		{
			favorites.add(fav);
		}
	}

	public void removeFavorites(Favorite fav)
	{
		if (favorites.contains(fav))
		{
			favorites.remove(fav);
		}
	}
	public boolean isAdmin()
	{
		if (username.equals("admin") && password.equals("admin"))
		{
			return true;
		}
		else if (username.equals("will") && password.equals("sokolowski"))
		{
			return true;
		}
		else if (username.equals("chris") && password.equals("bergstrom"))
		{
			return true;
		}
		else if (username.equals("shelby") && password.equals("escobedo"))
		{
			return true;
		}
		return false;
	}
}
