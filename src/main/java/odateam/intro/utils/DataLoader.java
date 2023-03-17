package odateam.intro.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import odateam.intro.model.Country;
import odateam.intro.model.Rates;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataLoader {

    public List<Country> loadRatesData() throws IOException {

        RestTemplate restTemplate = new RestTemplate();
        String url = "https://euvatrates.com/rates.json";

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        String jsonData = response.getBody();

        ObjectMapper objectMapper = new ObjectMapper();
        Rates rates = objectMapper.readValue(jsonData, Rates.class);
        Map<String, Country> ratesMap = rates.getRates();
        return new ArrayList<>(ratesMap.values());

    }
}
