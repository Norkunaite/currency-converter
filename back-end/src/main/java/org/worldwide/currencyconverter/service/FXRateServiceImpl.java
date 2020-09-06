package org.worldwide.currencyconverter.service;

import java.math.BigDecimal;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.worldwide.currencyconverter.model.ConversionRequestDTO;
import org.worldwide.currencyconverter.model.FXRate;
import org.worldwide.currencyconverter.repository.RateRepository;


@Service
public class FXRateServiceImpl implements FXRateService {

	@Autowired
	RateRepository repo;

	@Override
	public void saveCurrentRates() {
		String url = "https://www.lb.lt/webservices/FxRates/FxRates.asmx/getCurrentFxRates?tp=EU";

		try {

			URL obj = new URL(url);
			HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(con.getInputStream());
			
			NodeList rateList = (NodeList) doc.getElementsByTagName("CcyAmt");
			for (int i = 0; i < rateList.getLength(); i++) {
				Node rate=rateList.item(i);
				if(rate.getTextContent().contains("EUR")) {
					continue;
				}
				String[] strArr=rate.getTextContent().split("\n");
				
				repo.save(new FXRate(strArr[1], Double.parseDouble(strArr[2])));
				
			
			}
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
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
