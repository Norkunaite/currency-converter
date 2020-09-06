package org.worldwide.currencyconverter.service;

import java.math.BigDecimal;

import org.worldwide.currencyconverter.model.ConversionRequestDTO;

public interface FXRateService {

	void saveCurrentRates();
	
	BigDecimal convertCurrency( ConversionRequestDTO req);

}