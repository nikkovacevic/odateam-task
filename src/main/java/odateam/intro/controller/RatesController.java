package odateam.intro.controller;

import odateam.intro.model.Country;
import odateam.intro.service.RatesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/rates")
public class RatesController {

    private final RatesService ratesService;

    public RatesController(RatesService ratesService) {
        this.ratesService = ratesService;
    }

    @GetMapping("/")
    @ResponseBody
    public List<Country> getAll() {
        try {
            return ratesService.getRatesData();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/highest")
    @ResponseBody
    public List<Country> getTopThreeHighest() {
        try {
            return ratesService.getHighestStandardRates();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/lowest")
    @ResponseBody
    public List<Country> getTopThreeLowest() {
        try {
            return ratesService.getLowestReducedRates();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
