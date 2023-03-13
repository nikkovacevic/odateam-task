package odateam.intro.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import odateam.intro.model.Country;
import odateam.intro.model.Rates;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataLoader {

    public static List<Country> loadRatesData() throws IOException {
        ClassPathResource resource = new ClassPathResource("data.json");
        byte[] jsonData = FileCopyUtils.copyToByteArray(resource.getInputStream());

        ObjectMapper objectMapper = new ObjectMapper();
        Rates rates = objectMapper.readValue(jsonData, Rates.class);
        Map<String, Country> ratesMap = rates.getRates();
        return new ArrayList<>(ratesMap.values());

    }
}