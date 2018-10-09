package com.apap.tutorial5.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.apap.tutorial5.model.CarModel;
import com.apap.tutorial5.model.DealerModel;
import com.apap.tutorial5.service.CarService;
import com.apap.tutorial5.service.DealerService;

/**
 * 
 * @author faisalridwan
 * DealerController
 */
@Controller
public class DealerController {
	@Autowired
	private DealerService dealerService;
	
	@Autowired
	private CarService carService;
	
	@RequestMapping("/")
	private String home(Model model) {
		model.addAttribute("dealer_list", dealerService.getAllDealer());
		model.addAttribute("pageTitle", "Home");
		return "home";
	}
	
	@RequestMapping(value = "/dealer/add", method = RequestMethod.GET)
	private String add(Model model) {
		model.addAttribute("dealer", new DealerModel());
		model.addAttribute("pageTitle", "Add Dealer");
		return "addDealer";
	}
	
	@RequestMapping(value = "/dealer/add", method = RequestMethod.POST)
	private String addDealerSubmit(@ModelAttribute DealerModel dealer) {
		dealerService.addDealer(dealer);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/dealer/view", method = RequestMethod.GET)
	public String viewById(
			@RequestParam(value = "dealerId", required = true) Long dealerId,
			Model model
			) {
		DealerModel dealer = dealerService.getDealerDetailById(dealerId).get();
		
		String alamat = dealer.getAlamat();
		String no_telp = dealer.getNoTelp();
		Long id = dealer.getId();
		List<CarModel> car_list = dealer.getListCar();

		model.addAttribute("dealerID", id);
		model.addAttribute("alamat", alamat);
		model.addAttribute("no_telp", no_telp);
		model.addAttribute("car_list", car_list);
		model.addAttribute("dealer", dealer);
		
		model.addAttribute("pageTitle", "View Dealer");
		return "view-dealer";
	}
	
	@RequestMapping(value = "/dealer/delete/{dealerId}", method = RequestMethod.POST)
	private String deleteDealer(@PathVariable(value = "dealerId") Long dealerId, Model model) {
		dealerService.deleteDealer(dealerId);
		model.addAttribute("pageTitle", "Delete Dealer");
		return "delete-dealer";
	}
	
	@RequestMapping(value = "/dealer/edit/{dealerId}", method = RequestMethod.GET)
	private String editDealer(@PathVariable(value = "dealerId") Long dealerId, Model model) {
		DealerModel dealer = dealerService.getDealerDetailById(dealerId).get();
		
		String alamat = dealer.getAlamat();
		String no_telp = dealer.getNoTelp();
		Long id = dealer.getId();

		model.addAttribute("dealerId", id);
		model.addAttribute("alamat", alamat);
		model.addAttribute("no_telp", no_telp);
		model.addAttribute("pageTitle", "Edit Dealer");
		return "edit-dealer";
	}
	
	@RequestMapping(value = "/dealer/edit/{dealerId}", method = RequestMethod.POST)
	private String editDealer(@PathVariable(value = "dealerId") Long dealerId, @ModelAttribute DealerModel newDealer) {
		dealerService.editDealer(newDealer, dealerId);
		return "redirect:/dealer/view?dealerId=" + Long.toString(dealerId);
	}

}
