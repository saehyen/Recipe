package com.hustar.recipe.controller;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hustar.recipe.service.RecipeService;
import com.hustar.recipe.vo.ResultVO;

@Controller
@RequestMapping("recipe/")
public class RecipeController {

	private static final Logger LOG = LoggerFactory.getLogger(RecipeController.class);

	@Autowired
	RecipeService recipeService;

	@CrossOrigin(origins = "*")
	@ResponseBody
	@RequestMapping(value = "get-recipe-list.do", method = RequestMethod.POST)
	public ResultVO getRecipeList() throws IOException, ParseException {

		LOG.info("[GET] getRecipeList");

		ResultVO result = new ResultVO(false, null);

		try {
			result.setResult(recipeService.getRecipeList());
			result.setSuccess(true);
		} catch (Exception e) {
			LOG.error("[Recipe] getRecipeList : " + e.getMessage(), e);
		}

		return result;
	}

}