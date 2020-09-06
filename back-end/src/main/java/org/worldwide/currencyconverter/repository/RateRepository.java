package org.worldwide.currencyconverter.repository;

import org.springframework.data.repository.CrudRepository;
import org.worldwide.currencyconverter.model.FXRate;

public interface RateRepository extends CrudRepository<FXRate, Long> {
	
	FXRate findByCurrency(String currency);

}
