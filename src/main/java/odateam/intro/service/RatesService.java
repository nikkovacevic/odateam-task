package odateam.intro.service;

import odateam.intro.model.Country;
import odateam.intro.utils.DataLoader;
import odateam.intro.utils.Query;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RatesService {

    //to prevent loading the data from the data.json file multiple times
    private List<Country> jsonData = null;

    public List<Country> loadJsonData() throws IOException {
        if (jsonData == null) {
            jsonData = DataLoader.loadRatesData();
        }
        return jsonData;
    }

    public List<Country> getRatesData() throws IOException {
        return loadJsonData();
    }

    public List<Country> getHighestStandardRates() throws IOException {
        List<Country> allCountries = loadJsonData();
        List<Country> filteredCountries = removeDuplicates(allCountries);

        filteredCountries.sort(Comparator.comparingDouble(Country::getStandard_rate));
        Collections.reverse(filteredCountries);

        return filteredCountries.subList(0, 3);
    }

    public List<Country> getLowestReducedRates() throws IOException {
        List<Country> allCountries = loadJsonData();
        List<Country> filteredCountries = removeDuplicates(allCountries);
        List<Country> newCountries = removeCountriesWithInvalidType(filteredCountries);

        newCountries.sort(Comparator.comparingDouble(o -> (Double) o.getReduced_rate()));

        return newCountries.subList(0, 3);
    }

    public IQueryStrategy getQueryStrategy(Query query) {
        switch (query) {
            case ALL:
                return new GetAllStrategy(this);
            case HIGHEST:
                return new GetHighestStrategy(this);
            case LOWEST:
                return new GetLowestStrategy(this);
            default:
                throw new IllegalArgumentException("Invalid query type: " + query);
        }
    }

    private List<Country> removeCountriesWithInvalidType(List<Country> countries) {
        return countries.stream()
                .filter(country -> !country.getReduced_rate().equals(false))
                .collect(Collectors.toList());
    }

    private List<Country> removeDuplicates(List<Country> countries) {
        List<String> countryNames = new ArrayList<>();
        return countries.stream()
                .filter(country -> {
                    if (countryNames.contains(country.getCountry())) {
                        return false;
                    } else {
                        countryNames.add(country.getCountry());
                        return true;
                    }
                })
                .collect(Collectors.toList());
    }


}
