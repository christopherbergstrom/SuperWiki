package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import dao.LoginDAO;
import dao.SuperDAO;
import superHeroTest.Comment;
import superHeroTest.SuperPersons;
import superHeroTest.User;

@Controller
@SessionAttributes({"user", "admin"})
public class LoginController
{
	@Autowired
	private LoginDAO loginDao;
	@Autowired
	private SuperDAO superDao;

	@ModelAttribute("user")
	public User createUser()
	{
		User user = new User();
		user.setId(2);
		user.setUsername(null);
		return user;
	}
	@ModelAttribute("admin")
	public Boolean createAdmin()
	{
		return false;
	}

	@RequestMapping(path = "login.do", method = RequestMethod.GET)
	public String showLoginPage()
	{
		return "login.jsp";
	}

	@RequestMapping(path = "login.do", method = RequestMethod.GET, params = { "username", "password" })
	public ModelAndView homePage(@RequestParam("username") String username, @RequestParam("password") String password, @ModelAttribute("user") User user, @ModelAttribute("admin") Boolean admin)
	{
		try
		{
			user = loginDao.getUser(username, password);			
			admin = user.isAdmin();
			ModelAndView mv = new ModelAndView();
			mv.setViewName("home.jsp");
			mv.addObject("user", user);
			mv.addObject("admin", admin);
			return mv;
		}
		catch (Exception e)
		{	
			
			//user = loginDao.getUser(2);	
			
			ModelAndView mv = new ModelAndView();
			mv.setViewName("error.jsp");
			mv.addObject("user", user);
			mv.addObject("admin", admin);
			return mv;
		}
	}
	@RequestMapping(path = "logout.do", method = RequestMethod.GET)
	public ModelAndView logout(@ModelAttribute("user") User user, @ModelAttribute("admin") Boolean admin)
	{
		admin = false;

		user = loginDao.getUser(2);

		user.setId(2);
		user.setUsername(null);
		user.setPassword("guest");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home.jsp");
		mv.addObject("user", user);
		mv.addObject("admin", admin);
		return mv;
	}

	@RequestMapping(path = "addFav.do", method = RequestMethod.POST)
	public ModelAndView addFav(@RequestParam("selectionid") int id, @ModelAttribute("user") User user, @ModelAttribute("admin") Boolean admin)
	{
		SuperPersons sp = superDao.getById(id);
		try
		{			
			loginDao.addFavorites(sp, user);
			user = loginDao.refreshUser(user);
			ModelAndView mv = profile(user, admin);
			return mv;
		}
		catch(Exception e)
		{			
			user.setId(2);
			user.setUsername("guest");
			user.setPassword("guest");
			loginDao.addFavorites(sp, user);
			user = loginDao.refreshUser(user);
			ModelAndView mv = profile(user, admin);
			return mv;
		}
	}
	
	@RequestMapping(path = "addUser.do", method = RequestMethod.GET)
	public String showAddUser()
	{
		return "addUser.jsp";
	}
	
	@RequestMapping(path = "addUser.do", method = RequestMethod.POST)
	public ModelAndView addUser(User user)
	{
		loginDao.addUser(user);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login.jsp");
		return mv;
	}
	

	@RequestMapping(path = "deleteFavorite.do", method = RequestMethod.POST)
	public ModelAndView deleteFav(@RequestParam("deleteid") int id, @ModelAttribute("user") User user, @ModelAttribute("admin") Boolean admin)
	{
		SuperPersons sp = superDao.getById(id);
		loginDao.deleteFavorite(sp, user);
		user = loginDao.refreshUser(user);
		ModelAndView mv = profile(user, admin);
		return mv;
	}

	@RequestMapping(path = "profile.do", method = RequestMethod.GET)
	public ModelAndView profile(@ModelAttribute("user") User user, @ModelAttribute("admin") Boolean admin)
	{
		List<User> users = loginDao.getAllUsers();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("profile.jsp");
		mv.addObject("user", user);
		mv.addObject("admin", admin);
		mv.addObject("users", users);
		return mv;
	}
	@RequestMapping(path = "deleteUser.do", method = RequestMethod.POST, params = "deleteUserid")
	public ModelAndView deleteUser(@RequestParam("deleteUserid") int id, @ModelAttribute("user") User user, @ModelAttribute("admin") Boolean admin)
	{
		User user1 = loginDao.getUser(id);
		loginDao.deleteUser(user1);
//		user = loginDao.refreshUser(user);
		ModelAndView mv = profile(user, admin);
//		new ModelAndView();
//		mv.setViewName("profile.jsp");
//		mv.addObject("admin", admin);
//		mv.addObject("user", user);
		return mv;
	}
	@RequestMapping("index.do")
	public ModelAndView index(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home.jsp");
		return mv;
	}
}