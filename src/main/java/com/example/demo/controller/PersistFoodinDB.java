package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.FoodItems;
import com.example.demo.persist.FoodRepository;
@Controller
public class PersistFoodinDB {

	@Autowired
	private FoodRepository fr;
	
	@GetMapping("/User")
	public String show(Model model)
	{		
		List <FoodItems>items=fr.findAll();
		model.addAttribute("items", items);
		return "user";

	}
	
	@RequestMapping("/User/addFoodItem")
	public String storeFood()
	{
		return "user";
	}
	
	@PostMapping("/User/saveInDB")
	public String saver(HttpServletRequest r,Model model)
	{
		System.out.println("save in db is working");
		String data=r.getParameter("value");
		FoodItems fi=new FoodItems();
		fi.setItemName(data);
		fr.save(fi);
		
		System.out.println("save in db is working");
		
		return "redirect:/User";
	}
	@PostMapping("/Admin/deleteFromDB")
	public String deleter(HttpServletRequest r,Model model)
	{
		Integer data=Integer.parseInt(r.getParameter("value"));
	fr.deleteById(data);
		
		return "Admin";
	}
	
	
	@GetMapping("/Admin")
	public String adminPage(Model model)
	{
		List <FoodItems>items=fr.findAll();
		model.addAttribute("items", items);
		return "Admin";
	}
	
	
}
