package org.worldwide.currencyconverter.model;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class ConversionRequestDTO {
	
	private String fromCurrency;
	private String toCurrency;
	private BigDecimal amount;
	@Override
	public String toString() {
		return "ConversionRequestDTO [fromCurrency=" + fromCurrency + ", toCurrency=" + toCurrency + ", amount="
				+ amount + "]";
	}
	
	

}
