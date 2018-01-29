package com.eduit.spring.clase4.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.eduit.spring.clase4.model.Factura;
import com.eduit.spring.clase4.service.FacturaService;

@Controller
public class FacturasController {

	@Autowired
	private FacturaService facturaService;

	@RequestMapping(value = "/facturas", method = RequestMethod.GET)
	public String init(ModelMap model) {

		model.addAttribute("factura", new Factura());

		List<Factura> facturas = facturaService.listarFacturas();
		model.addAttribute("facturas", facturas);

		return "facturas";
	}

	@RequestMapping(value = "/agregarFactura", method = RequestMethod.POST)
	public ModelAndView agregarFactura(@ModelAttribute("factura") @Valid Factura factura, BindingResult result) {

		ModelAndView model = new ModelAndView("facturas");

		if (result.hasErrors()) {
			return model;
		}

		facturaService.salvarFactura(factura);
		List<Factura> facturas = facturaService.listarFacturas();

		model.addObject("facturas", facturas);

		return model;
	}
}
