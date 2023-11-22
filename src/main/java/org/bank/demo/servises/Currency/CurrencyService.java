package org.bank.demo.servises.Currency;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class CurrencyService {
    public String getCurrency() {
        String url = "http://www.cbr.ru/scripts/XML_daily.asp?";
        RestTemplate restTemplate = new RestTemplate();
        String xml = restTemplate.getForObject(url, String.class);
        try {
            ObjectMapper xmlMapper = new XmlMapper();
            ObjectMapper jsonMapper = new JsonMapper();
            JsonNode jsonNode = xmlMapper.readTree(xml);
            String json = jsonNode.toPrettyString();
            ValCurs valCurs = jsonMapper.readValue(json, ValCurs.class);

            List<Valute> filteredValutes = valCurs.getValutes().stream()
                    .filter(valute -> "USD".equals(valute.getCharCode()) || "EUR".equals(valute.getCharCode())
                            || "BYN".equals(valute.getCharCode()) || "KZT".equals(valute.getCharCode())
                            || "CNY".equals(valute.getCharCode()))
                    .collect(Collectors.toList());

            ValCurs filteredValCurs = new ValCurs();
            filteredValCurs.setDate(valCurs.getDate());
            filteredValCurs.setValutes(filteredValutes);

            return jsonMapper.writerWithDefaultPrettyPrinter().writeValueAsString(filteredValCurs);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}


