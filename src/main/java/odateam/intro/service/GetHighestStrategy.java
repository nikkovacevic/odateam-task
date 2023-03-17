package odateam.intro.service;

import odateam.intro.model.Country;

import java.io.IOException;
import java.util.List;

public class GetHighestStrategy implements IQueryStrategy{

    private final RatesService ratesService;

    public GetHighestStrategy(RatesService ratesService) {
        this.ratesService = ratesService;
    }

    @Override
    public List<Country> execute() throws IOException {
        return ratesService.getHighestStandardRates();
    }
}
