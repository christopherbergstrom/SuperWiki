package controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import dao.SuperDAO;
import superHeroTest.SuperPersons;
import superHeroTest.SuperType;

@Controller
@SessionAttributes({"user", "admin"})
public class SuperController
{
	@Autowired
	private SuperDAO superDao;

	@RequestMapping(path = "selectID.do", params = "id")
	public ModelAndView getById(@RequestParam("id") int id)
	{
		SuperPersons SP = superDao.getById(id);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result.jsp");
		mv.addObject("result", SP);
		return mv;
	}

	@RequestMapping(path = "select.do", params = "text")
	public ModelAndView getByName(@RequestParam("text") String text)
	{
		List<SuperPersons> SP = superDao.getByName(text);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("resultList.jsp");
		mv.addObject("result", SP);
		return mv;
	}

	@RequestMapping(path = "allSuperheroes.do")
	public ModelAndView getAllSuperheroes()
	{
		List<SuperPersons> superPersons = superDao.getAllSuperheroes();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("resultList.jsp");
		mv.addObject("result", superPersons);
		return mv;
	}

	@RequestMapping(path = "allVillains.do")
	public ModelAndView getAllVillains()
	{
		List<SuperPersons> villains = superDao.getAllVillains();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("resultList.jsp");
		mv.addObject("result", villains);
		return mv;
	}
	@RequestMapping(path = "allCharacters.do")
	public ModelAndView getAllCharacters()
	{
		List<SuperPersons> characters = superDao.getAllCharacters();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("resultList.jsp");
		mv.addObject("result", characters);
		return mv;
	}

	@RequestMapping(path = "addSuperhero.do", method = RequestMethod.GET)
	public ModelAndView addSuperForm()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("addSuperhero.jsp");
		mv.addObject(new SuperPersons());
		return mv;
	}

	@RequestMapping(path = "addSuperhero.do", method = RequestMethod.POST)
	public ModelAndView addSuperhero(SuperPersons sp, @RequestParam("good") boolean superhero)
	{
		if (superhero)
		{
			sp.setSuperType(SuperType.superhero);

		} else
		{
			sp.setSuperType(SuperType.villain);
		}
		superDao.addSuperPerson(sp);
		ModelAndView mv = getAllCharacters();
		return mv;
	}

	@RequestMapping(path = "updateCharacter.do", method = RequestMethod.GET)
	public ModelAndView updateForm(@RequestParam("id") int id)
	{
		SuperPersons sp = superDao.getById(id);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("updateCharacter.jsp");
		mv.addObject("character", sp);
		return mv;
	}

	@RequestMapping(path = "updateCharacter.do", method = RequestMethod.POST)
	public ModelAndView updateCharacter(SuperPersons sp, @RequestParam("good") boolean superhero)
	{
		if (superhero)
		{
			sp.setSuperType(SuperType.superhero);

		} 
		else
		{
			sp.setSuperType(SuperType.villain);
		}
		superDao.updateCharacter(sp);
		ModelAndView mv = getById(sp.getId());
		return mv;
	}
}