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
    public List<Country> getAll() throws IOException {
        try {
            return ratesService.getRatesData();
        } catch (Exception e) {
            System.out.println("Error getting all countries...");
            throw e;
        }
    }

    @GetMapping("/highest")
    @ResponseBody
    public List<Country> getTopThreeHighest() throws IOException {
        try {
            return ratesService.getHighestStandardRates();
        } catch (Exception e) {
            System.out.println("Error getting the three countries with the highest standard VAT rates...");
            throw e;
        }
    }

    @GetMapping("/lowest")
    @ResponseBody
    public List<Country> getTopThreeLowest() throws IOException {
        try {
            return ratesService.getLowestReducedRates();
        } catch (Exception e) {
            System.out.println("Error getting the three countries with the lowest reduced VAT rates...");
            throw e;
        }
    }


}
