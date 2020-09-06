package org.worldwide.currencyconverter.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.worldwide.currencyconverter.model.ConversionRequestDTO;
import org.worldwide.currencyconverter.service.FXRateService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ConverterController {
//	service sutvarkyti, kas darosi, kai gauni eur reiksmes
	
	@Autowired
	FXRateService converterService;
	
	@PostMapping
	public BigDecimal convert(@RequestBody ConversionRequestDTO req) {
		return converterService.convertCurrency(req);
	}

}
