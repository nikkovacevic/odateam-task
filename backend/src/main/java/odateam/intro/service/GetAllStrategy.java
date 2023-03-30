package odateam.intro.service;

import odateam.intro.model.Country;

import java.io.IOException;
import java.util.List;

public class GetAllStrategy implements IQueryStrategy{
    private final RatesService ratesService;

    public GetAllStrategy(RatesService ratesService) {
        this.ratesService = ratesService;
    }

    @Override
    public List<Country> execute() throws IOException {
        return ratesService.getRatesData();
    }
}
