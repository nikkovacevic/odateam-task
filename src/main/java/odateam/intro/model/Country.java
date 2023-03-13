package odateam.intro.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Country {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String _comment;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String iso_duplicate;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String iso_duplicate_of;
    private String country;
    private double standard_rate;
    private Object reduced_rate;
    private Object reduced_rate_alt;
    private Object super_reduced_rate;
    private Object parking_rate;

    // for testing purposes
    public Country(String country, double standard_rate, double reduced_rate) {
        this.country = country;
        this.standard_rate = standard_rate;
        this.reduced_rate = reduced_rate;
    }
}
