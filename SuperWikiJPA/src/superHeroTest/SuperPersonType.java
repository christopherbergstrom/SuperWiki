package superHeroTest;

import java.time.Year;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="superpersontypes")
public class SuperPersonType
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Enumerated(EnumType.STRING)
	private SuperType superType;
	@ManyToOne
	@JoinColumn(name= "superperson_id")
	private SuperPersons superPerson;
	private Year startYear;
	private Year endYear;
	
	public Year getStartYear()
	{
		return startYear;
	}
	public void setStartYear(Year startYear)
	{
		this.startYear = startYear;
	}
	public Year getEndYear()
	{
		return endYear;
	}
	public void setEndYear(Year endYear)
	{
		this.endYear = endYear;
	}
	public SuperType getSuperType()
	{
		return superType;
	}
	public void setSuperType(SuperType superType)
	{
		this.superType = superType;
	}
	public SuperPersons getSuperPerson()
	{
		return superPerson;
	}
	public void setSuperPerson(SuperPersons superPerson)
	{
		this.superPerson = superPerson;
	}
}