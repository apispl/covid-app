package pl.pszczolkowski.covidapp.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import pl.pszczolkowski.covidapp.model.Country;
import pl.pszczolkowski.covidapp.model.CountryDate;
import pl.pszczolkowski.covidapp.model.Example;
import pl.pszczolkowski.covidapp.model.Global;
import pl.pszczolkowski.covidapp.service.CovidService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@CrossOrigin("*")
public class CovidNewsClient {
    private RestTemplate restTemplate = new RestTemplate();
    private CovidService covidService;

    @Autowired
    public CovidNewsClient(CovidService covidService) {
        this.covidService = covidService;
    }

    private Global getCovidGlobalNews(){
        Example example = restTemplate.getForObject("https://api.covid19api.com/summary", Example.class);
        return example.getGlobal();
    }

    private List<Country> getCovidCountryNews(){
        Example example = restTemplate.getForObject("https://api.covid19api.com/summary", Example.class);
        return example.getCountries();
    }

    private CountryDate getCovidLastInfoInCountry(String countryName, String type){
        String baseUrl = covidService.buildUrl(countryName, type);
        System.out.println(baseUrl);

        HttpHeaders headers = new HttpHeaders();
        HttpEntity httpEntity = new HttpEntity(headers);

        ResponseEntity<CountryDate[]> responseEntity = restTemplate.exchange(
                baseUrl,
                HttpMethod.GET,
                httpEntity,
                CountryDate[].class);

        List<CountryDate> countryDates = Stream.of(responseEntity.getBody())
                .filter(value -> value.getDate()
                        .equals(covidService.getFromDate()))
                .collect(Collectors.toList());
        Optional<CountryDate> first = countryDates.stream().findFirst();

        return first.orElse(null);
    }

    @GetMapping("/global")
    public Global getGlobal(){
        return getCovidGlobalNews();
    }

    @GetMapping("/countries")
    public List<Country> getCountryList(){
        return getCovidCountryNews();
    }

    @GetMapping("/countries/{countryName}/{type}")
    public CountryDate getLastInCountry(@PathVariable String countryName, @PathVariable String type){
        return getCovidLastInfoInCountry(countryName, type);
    }
}
