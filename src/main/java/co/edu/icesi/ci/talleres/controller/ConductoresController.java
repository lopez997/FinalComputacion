package co.edu.icesi.ci.talleres.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.edu.icesi.ci.talleres.delegate.ConductorDelegateImpl;
import co.edu.icesi.ci.talleres.model.Tmio1Bus;
import co.edu.icesi.ci.talleres.model.Tmio1Conductore;


@Controller
public class ConductoresController {

	ConductorDelegateImpl conductorDelegate;
	
	@Autowired
	public ConductoresController(ConductorDelegateImpl conductorDelegate) {
		this.conductorDelegate = conductorDelegate;
		;
	}
    
	@GetMapping("/conductores/")
	public String indexConductor(Model model) {
		model.addAttribute("conductores", conductorDelegate.findAll());
		return "conductores/index";
	}
	
	@GetMapping("/conductores/add1")
	public String addConductor(Model model) {
		model.addAttribute("driver", new Tmio1Conductore());
		return "/conductores/add-conductor";
	}
	
	@PostMapping("/conductores/add1")
	public String saveConductor(@ModelAttribute("driver") @Valid Tmio1Conductore driver, BindingResult bindingResult,@RequestParam(value = "action", required = true) String action , Model model) {
		if (!action.equals("Cancel")) {
		if (bindingResult.hasErrors()) {
				return "/conductores/add-conductor";
			} else {
				try {
					conductorDelegate.saveConductor(driver);
				} catch (Exception e) {
					model.addAttribute("error", new Error(e.getMessage()));
					return "redirect:/conductores/"; 
				}
			}
		}
		return "redirect:/conductores/";
	}
	
	@GetMapping("/conductores/del/{cedula}")
	public String borrarConductor(@PathVariable("cedula") String cedula) throws Exception {
		Tmio1Conductore conductor = conductorDelegate.findByCedula(cedula);
		conductorDelegate.delete(conductor);
		return "redirect:/conductores/";
	}
	
}
