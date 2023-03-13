package odateam.intro.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Rates {

    private String last_updated;
    private String disclaimer;
    private Map<String, Country> rates;
}
