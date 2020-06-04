package org.kpu.myweb.controller;

import java.util.List;

import org.kpu.myweb.domain.RecipeVO;
import org.kpu.myweb.domain.SearchVO;
import org.kpu.myweb.domain.StudentVO;
import org.kpu.myweb.service.RecipeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value="/post")
public class PostController {
	
	@Autowired
    private RecipeService recipeService;

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
    
	@RequestMapping(value = {"/postRecipe"}, method = RequestMethod.GET)
	public String postRecipeGet() throws Exception {
		logger.info(" /register URL GET method called. then forward post.jsp.");
		return "post";
	}
	
	@RequestMapping(value = {"/postRecipe"}, method = RequestMethod.POST)
	public String signupMemberPost( @ModelAttribute("recipe") RecipeVO vo) throws Exception {
		recipeService.addRecipe(vo);
		logger.info(vo.toString());
		logger.info(" /register URL GET method called. then forward post.jsp.");
		return "redirect:/post/list";
	}

	
	
	@RequestMapping(value = {"/list"}, method = RequestMethod.GET)
	public String recipeListGet() throws Exception {
		logger.info(" /register URL GET method called. then forward list.jsp.");
		return "list";
	}
	
	@RequestMapping(value = {"/search"}, method = RequestMethod.POST)
	public String recipeSearchPost(@ModelAttribute("search") SearchVO vo,Model model) throws Exception {
		List<RecipeVO> recipe = recipeService.searchRecipe(vo);
		model.addAttribute("recipe",recipe);
		System.out.println(vo.getSearch1());
		System.out.println(recipe.size());
		logger.info(vo.toString());
		logger.info(" /register URL GET method called. then forward list.jsp.");
		return "detail";
	}
	
	@RequestMapping(value = {"/detail"}, method = RequestMethod.GET)
	public String recipeDetailGet() throws Exception {
		logger.info(" /register URL GET method called. then forward detail.jsp.");
		return "redirect:/post/read";
	}
	
    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public String readMember(@RequestParam("id") String id, Model model) throws Exception {
    	RecipeVO recipe = recipeService.readRecipe(id);
		logger.info(" /read?id=kang URL called. then readMemebr method executed.");
        model.addAttribute("recipe", recipe);
        return "detail";
    }
	
}