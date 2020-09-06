package org.worldwide.currencyconverter.service;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.worldwide.currencyconverter.model.ConversionRequestDTO;
import org.worldwide.currencyconverter.model.FXRate;
import org.worldwide.currencyconverter.repository.RateRepository;

@Service
public class FXRateServiceImpl implements FXRateService {

	@Autowired
	RateRepository repo;

	@Override
	public void saveCurrentRates() {
		String[] arr = parseXmlToStringArr();
		for (int i = 1; i < arr.length; i++) {
			FXRate rate = parsedStringConvertToFXRateObj(arr[i]);
			repo.save(rate);
		}
	}

	private FXRate parsedStringConvertToFXRateObj(String str) {
		String[] firstSplit = str.split("</Dt>");
		String date = firstSplit[0];
		date = date.replace("<Dt>", "");
		String name = firstSplit[1].split("</Ccy>")[0];
		name = name.replace("<Ccy>", "");
		String rate = str.split("</Ccy>")[1];
		rate = rate.replace("</Amt>", "");
		rate = rate.replace("<Amt>", "");
		try {
			return new FXRate(new SimpleDateFormat("yyyy-MM-dd").parse(date), name, Double.parseDouble(rate));
		} catch (NumberFormatException e) {
			return new FXRate(new Date(), name, Double.parseDouble(rate));
		} catch (ParseException e) {
			return new FXRate(new Date(), name, Double.parseDouble(rate));
		}

	}

	private String[] parseXmlToStringArr() {
		String url = "https://www.lb.lt/webservices/FxRates/FxRates.asmx/getCurrentFxRates?tp=EU";
		String str = "";
		try {
			URL obj = new URL(url);
			HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");

			InputStream is = con.getInputStream();

			int i = 0;
			while ((i = is.read()) != -1) {
				str += String.valueOf((char) i);
			}

			str = str.replace("</FxRates>", "");
			str = str.replace("<?xml version=\"1.0\" encoding=\"utf-8\"?>", "");
			str = str.replace("<FxRates xmlns=\"http://www.lb.lt/WebServices/FxRates\">", "");
			str = str.replace("<Tp>EU</Tp>", "");
			str = str.replace("<CcyAmt>", "");
			str = str.replace("<Ccy>EUR</Ccy>", "");
			str = str.replace("<Amt>1</Amt>", "");
			str = str.replace("</CcyAmt>", "");
			str = str.replace("</FxRate>", "");
			str = str.replaceAll("\\s", "");

		} catch (IOException e) {
			e.printStackTrace();
		}
		return str.split("<FxRate>");
	}

	@Override
	public BigDecimal convertCurrency(ConversionRequestDTO req) {
		BigDecimal fromCurrRate = null;
		BigDecimal toCurrRate = null;
		if (req.getFromCurrency().equals("EUR")) {
			fromCurrRate = new BigDecimal(1);
		} else {
			fromCurrRate = new BigDecimal(repo.findByCurrency(req.getFromCurrency()).getCurrentCurrencyRate());
		}
		if (req.getToCurrency().equals("EUR")) {
			toCurrRate = new BigDecimal(1);
		} else {
			toCurrRate = new BigDecimal(repo.findByCurrency(req.getToCurrency()).getCurrentCurrencyRate());
		}
		BigDecimal initialAmount = req.getAmount();

		BigDecimal convertedToEur = initialAmount.divide(fromCurrRate, 6, BigDecimal.ROUND_HALF_UP);

		return convertedToEur.multiply(toCurrRate).setScale(2, BigDecimal.ROUND_HALF_UP);
	}

}
