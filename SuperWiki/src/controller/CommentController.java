package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import dao.CommentDAO;
import dao.LoginDAO;
import dao.SuperDAO;
import superHeroTest.Comment;
import superHeroTest.SuperPersons;
import superHeroTest.User;
@Controller
@SessionAttributes({"user", "admin"})
public class CommentController {
	@Autowired
	private LoginDAO loginDao;
	@Autowired
	private SuperDAO superDao;
	@Autowired
	private CommentDAO commentDao;
	
	@RequestMapping(path = "addComment.do", method = RequestMethod.POST)
	public ModelAndView addComment(@RequestParam("superPersonID") int spersonId, @RequestParam("message") String message, @ModelAttribute("user") User user, @ModelAttribute("admin") Boolean admin)
	{
		SuperPersons sp = superDao.getById(spersonId);
		
		commentDao.addComment(sp, message, user);
		user = loginDao.refreshUser(user);
		sp = superDao.refreshSuperPersons(sp);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result.jsp");
		mv.addObject("result", sp);
		mv.addObject("user", user);
		mv.addObject("admin", admin);
		return mv;
	}
	@RequestMapping(path="deleteComment.do", method=RequestMethod.POST)
	public ModelAndView deleteComment(@RequestParam("commentid")int commentId, @RequestParam("superPersonID") int superpersonId,@ModelAttribute("user") User user, @ModelAttribute("admin") Boolean admin){
		Comment comment = commentDao.getComment(commentId);
		commentDao.deleteComment(comment);
		
		SuperPersons sp = superDao.getById(superpersonId);
		sp = superDao.refreshSuperPersons(sp);
		user = loginDao.refreshUser(user);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result.jsp");
		mv.addObject("result", sp);
		mv.addObject("user", user);
		mv.addObject("admin", admin);
		return mv;
	}
	@RequestMapping(path="updateComment.do", method=RequestMethod.GET)
	public ModelAndView updateCommentForm(@RequestParam("commentid") int commentId, @RequestParam("superPersonID") int superPersonId){
		SuperPersons sp = superDao.getById(superPersonId);
		Comment comment = commentDao.getComment(commentId);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("updateComment.jsp");
		mv.addObject("result", sp);
		mv.addObject("comment",comment);
		
		return mv;
	}
	
	@RequestMapping(path="updateComment.do", method=RequestMethod.POST)
	public ModelAndView updateComment(@RequestParam("commentid") int commentId, @RequestParam("superPersonID") int superPersonId, @RequestParam("message") String message, @ModelAttribute("user") User user, @ModelAttribute("admin") Boolean admin){
		SuperPersons sp = superDao.getById(superPersonId);
		Comment comment = commentDao.getComment(commentId);
		commentDao.updateComment(comment, message);
		sp = superDao.refreshSuperPersons(sp);
		user = loginDao.refreshUser(user);
	
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result.jsp");
		mv.addObject("result", sp);
		mv.addObject("user", user);
		mv.addObject("admin", admin);
		return mv;
	}
}
