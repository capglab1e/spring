package com.cg.capstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.capstore.dto.Store;
import com.cg.capstore.service.CapStoreService;


@Controller
public class CapStoreController 
{
	@Autowired
	CapStoreService service;
	
	@RequestMapping(value="all")
	public String start()
	{
		return "home";
		
	}
	
	@RequestMapping(value="products")
	public ModelAndView Categories(@ModelAttribute("my") Store s, @RequestParam("id") int i)
	{
		List<Store> list=service.getAllProducts(i);
		return new ModelAndView("categories","data",list);
		
	}
	
	
	

}
