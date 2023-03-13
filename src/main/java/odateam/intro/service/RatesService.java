package odateam.intro.service;

import odateam.intro.model.Country;
import odateam.intro.utils.DataLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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

        filteredCountries.sort(Comparator.comparingDouble(o -> o.getStandard_rate()));
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

    private List<Country> removeCountriesWithInvalidType(List<Country> countries) {
        List<Country> newList = new ArrayList<>();

        for (Country country : countries) {
            //some countries have a reduced rate value set to false
            boolean validRateType = !country.getReduced_rate().equals(false);
            if (validRateType) {
                newList.add(country);
            }
        }
        return newList;
    }

    private List<Country> removeDuplicates(List<Country> countries) {
        List<Country> filteredList = new ArrayList<>();
        List<String> countryNames = new ArrayList<>();

        for (Country country : countries) {
            if (!countryNames.contains(country.getCountry())) {
                filteredList.add(country);
                countryNames.add(country.getCountry());
            }
        }
        return filteredList;
    }


}
