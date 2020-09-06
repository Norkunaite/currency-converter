package org.worldwide.currencyconverter.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class FXRate {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String currency;
	private double currentCurrencyRate;
	
	public FXRate(String currency, double currentCurrencyRate) {
		this.currency = currency;
		this.currentCurrencyRate = currentCurrencyRate;
	}

	@Override
	public String toString() {
		return "FXRate [currency=" + currency + ", currentCurrencyRate=" + currentCurrencyRate
				+ "]";
	}


	
	
	

	
	

}
