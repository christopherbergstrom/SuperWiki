package superHeroTest;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "superpersons")
@NamedQueries({ @NamedQuery(name = "SuperPersons.getName", query = "select s FROM SuperPersons s WHERE s.name like :name"),
		@NamedQuery(name = "SuperPersons.getAllSuperHeros", query = "select s from SuperPersons s WHERE s.superType = :supertype") })

public class SuperPersons {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;
	@Column(name = "alias_names")
	private String alias;

	private String firstAppearance;
	private String creator;
	@ManyToOne
	@JoinColumn(name = "Team_id")
	private SuperTeam team;
	private String origin;
	private String publisher;
	@Enumerated(EnumType.STRING)
	private SuperType superType;
	private String image;
	@ManyToMany
	@JoinTable(name = "nemesis", joinColumns = @JoinColumn(name = "superperson_id") , inverseJoinColumns = @JoinColumn(name = "nemesis_id") )
	private List<SuperPersons> nemesis = new ArrayList<SuperPersons>();
	@OneToMany(mappedBy = "superPerson", fetch=FetchType.EAGER)
	private List<Comment> comments = new ArrayList<Comment>();
	@OneToMany(mappedBy="superPerson")
	private List<Favorite> userfavorites;

	public SuperPersons()
	{

	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getFirstAppearance()
	{
		return firstAppearance;
	}

	public void setFirstAppearance(String fa)
	{
		firstAppearance = fa;
	}

	public String getCreator()
	{
		return creator;
	}

	public void setCreator(String creator)
	{
		this.creator = creator;
	}

	public String getAlias()
	{
		return alias;
	}

	public void setAlias(String alias)
	{
		this.alias = alias;
	}

	public String getOrigin()
	{
		return origin;
	}

	public void setOrigin(String origin)
	{
		this.origin = origin;
	}

	public String getPublisher()
	{
		return publisher;
	}

	public void setPublisher(String publisher)
	{
		this.publisher = publisher;
	}

	public SuperTeam getTeam()
	{
		return team;
	}

	public void setTeam(SuperTeam team)
	{
		this.team = team;
	}

	public List<SuperPersons> getNemesis()
	{
		return nemesis;
	}

	public void setNemesis(List<SuperPersons> nemesis)
	{
		this.nemesis = nemesis;
	}

	public SuperType getSuperType()
	{
		return superType;
	}

	public void setSuperType(SuperType superType)
	{
		this.superType = superType;
	}

	public List<Comment> getComments()
	{
		return comments;
	}

	public void setComments(List<Comment> comments)
	{
		this.comments = comments;
	}

	public String getImage()
	{
		return image;
	}

	public void setImage(String image)
	{
		this.image = image;
	}

	@Override
	public String toString()
	{
		return "SuperPersons [id=" + id + ", name=" + name + ", alias=" + alias + "]";
	}

}