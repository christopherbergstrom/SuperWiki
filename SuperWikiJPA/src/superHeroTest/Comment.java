package superHeroTest;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="comment")
public class Comment
{	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	private String message;
	@Column(name="created")
	private Date dateTime;
	@ManyToOne
	@JoinColumn(name="superpersons_id")
	private SuperPersons superPerson;
	
	public Comment(){
		
	}
	
	public Comment(SuperPersons sp, String message, User user){
		this.superPerson = sp;
		this.message = message;
		this.user = user;
	}
	
	public SuperPersons getSuperPerson()
	{
		return superPerson;
	}
	public void setSuperPerson(SuperPersons superPerson)
	{
		this.superPerson = superPerson;
	}
	public void setUser(User user)
	{
		this.user = user;
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public User getUser()
	{
		return user;
	}
	public void setUser_id(User user)
	{
		this.user = user;
	}
	public String getMessage()
	{
		return message;
	}
	public void setMessage(String message)
	{
		this.message = message;
	}
	public Date getDateTime()
	{
		return dateTime;
	}
	public void setDateTime(Date dateTime)
	{
		this.dateTime = dateTime;
	}
}
