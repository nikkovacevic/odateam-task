package odateam.intro.service;

import odateam.intro.model.Country;
import odateam.intro.utils.DataLoader;
import odateam.intro.utils.Query;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RatesServiceTest {

    @Mock
    private DataLoader dataLoader;

    @InjectMocks
    private RatesService ratesService;

    @Test
    void testLoadJsonData() throws IOException {

        List<Country> countries = new ArrayList<>();
        Country country1 = new Country("Austria", 20.0, 10.0);
        Country country2 = new Country("Belgium", 21.0, 12.0);
        Country country3 = new Country("Bulgaria", 20.0, 9.0);

        countries.add(country1);
        countries.add(country2);
        countries.add(country3);

        when(dataLoader.loadRatesData()).thenReturn(countries);

        List<Country> result = ratesService.getRatesData();

        assertEquals(3, result.size());
    }

    @Test
    void testGetRatesData() {



    }

    @Test
    void testGetHighestStandardRates() throws IOException {

        List<Country> countries = new ArrayList<>();
        Country country1 = new Country("Austria", 20.0, 10.0);
        Country country2 = new Country("Belgium", 21.0, 12.0);
        Country country3 = new Country("Bulgaria", 20.0, 9.0);
        Country country4 = new Country("Cyprus", 19.0, 9.0);
        Country country5 = new Country("Czech Republic", 21.0, 15.0);
        Country country6 = new Country("Denmark", 25.0, 15.0);
        Country country7 = new Country("Germany", 19.0, 7.0);
        Country country8 = new Country("Estonia", 20.0, 9.0);

        countries.add(country1);
        countries.add(country2);
        countries.add(country3);
        countries.add(country4);
        countries.add(country5);
        countries.add(country6);
        countries.add(country7);
        countries.add(country8);

        when(ratesService.loadJsonData()).thenReturn(countries);

        List<Country> result = ratesService.getHighestStandardRates();

        assertEquals(3, result.size());
        assertEquals("Denmark", result.get(0).getCountry());
        assertEquals("Belgium", result.get(1).getCountry());
        assertEquals("Czech Republic", result.get(2).getCountry());

    }

    @Test
    void testGetLowestReducedRates() throws IOException {
        List<Country> countries = new ArrayList<>();
        Country country1 = new Country("Austria", 20.0, 10.0);
        Country country2 = new Country("Belgium", 21.0, 12.0);
        Country country3 = new Country("Bulgaria", 20.0, 9.0);
        Country country4 = new Country("Cyprus", 19.0, 9.0);
        Country country5 = new Country("Czech Republic", 21.0, 15.0);
        Country country6 = new Country("Denmark", 25.0, 15.0);
        Country country7 = new Country("Germany", 19.0, 7.0);
        Country country8 = new Country("Estonia", 20.0, 9.0);

        countries.add(country1);
        countries.add(country2);
        countries.add(country3);
        countries.add(country4);
        countries.add(country5);
        countries.add(country6);
        countries.add(country7);
        countries.add(country8);

        when(ratesService.loadJsonData()).thenReturn(countries);

        List<Country> result = ratesService.getLowestReducedRates();

        assertEquals(3, result.size());
        assertEquals("Germany", result.get(0).getCountry());
        assertEquals("Bulgaria", result.get(1).getCountry());
        assertEquals("Cyprus", result.get(2).getCountry());
    }

    @Test
    void testGetQueryStrategy() {
        Query queryAll = Query.ALL;
        IQueryStrategy allStrategy = ratesService.getQueryStrategy(queryAll);
        assertTrue(allStrategy instanceof GetAllStrategy);

        Query queryHighest = Query.HIGHEST;
        IQueryStrategy highestStrategy = ratesService.getQueryStrategy(queryHighest);
        assertTrue(highestStrategy instanceof GetHighestStrategy);

        Query queryLowest = Query.LOWEST;
        IQueryStrategy lowestStrategy = ratesService.getQueryStrategy(queryLowest);
        assertTrue(lowestStrategy instanceof GetLowestStrategy);

        String invalidQueryType = "invalid";
        assertThrows(IllegalArgumentException.class, () -> ratesService.getQueryStrategy(Query.valueOf(invalidQueryType)));
    }


}