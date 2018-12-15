package com.cg.springass2.Controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;



import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.springass2.Dto.Trainee;
import com.cg.springass2.Service.TraineeService;



@Controller
public class TraineeController {
	@Autowired
	TraineeService traineeservice;
	@RequestMapping(value="/home")
	public String login(){
		return "login";
		
	}
	
	@RequestMapping(value="menu")
	public String menu(){
		return "menu";
		
	}
	@RequestMapping(value="addtrainee")
	public String adata(@ModelAttribute("y") Trainee trainee,Map<String,Object> modal){
		
		List<String> mylist = new ArrayList<>();
		mylist.add("JEE");
		mylist.add("JFSD");
		mylist.add("WB");
		modal.put("cato",mylist);
	
		return "addtrainee";
		}
	@RequestMapping(value="adddata",method=RequestMethod.POST)
	public String addDetails(@ModelAttribute("y") Trainee trainee,Map<String,Object> modal){
		
		List<String> mylist = new ArrayList<>();
		mylist.add("JEE");
		mylist.add("JFSD");
		mylist.add("WB");
		modal.put("cato",mylist);
		traineeservice.addTrainee(trainee);
		return "welcome";
		
	}


	@RequestMapping(value="alltrainee",method=RequestMethod.GET)
	public ModelAndView showAllTrainee()
	{
		List<Trainee> myAllData=traineeservice.retrieveAllTrainee();
		return new ModelAndView("showall","temp",myAllData);
	}
	
	@RequestMapping(value="retrivetrainee", method=RequestMethod.GET)
	public String searchData(@ModelAttribute("my") Trainee tran){
		return "searchtrainee";
	}
	
	@RequestMapping(value="traineesearch", method=RequestMethod.POST)
	public ModelAndView dataSearch(@ModelAttribute("my") Trainee tran){
		Trainee tranSearch = traineeservice.retrieveATrainee(tran.getTraineeId());
		//System.out.println(mobSearch);
		return new ModelAndView("showsearch","temp", tranSearch);	
	}
	
	@RequestMapping(value="deletetrainee", method=RequestMethod.GET)
	public String deleteData(@ModelAttribute("my") Trainee trai){
		return "deleteatrainee";
		
	}
	
	@RequestMapping(value="delete", method=RequestMethod.POST)
	public String dataDelete(@ModelAttribute("my") Trainee trai){
		traineeservice.deleteATrainee(trai.getTraineeId());
		//System.out.println(mobSearch);
		return "delete";
	}
	
	@RequestMapping(value="modifytrainee",method=RequestMethod.GET)
	public String updateData(@ModelAttribute("up") Trainee trai){
		return "updatetrainee";
		
	}
	@RequestMapping(value="updatesuccess",method=RequestMethod.POST)
	public String update2(@ModelAttribute("up") Trainee trai){
		
		Trainee trai1=traineeservice.modifyATrainee(trai);
		System.out.println(trai);
		
		return "updatesuccess";
			}
}

