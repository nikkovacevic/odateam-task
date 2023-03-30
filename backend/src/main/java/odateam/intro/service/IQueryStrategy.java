package odateam.intro.service;

import odateam.intro.model.Country;

import java.io.IOException;
import java.util.List;

public interface IQueryStrategy {
    List<Country> execute() throws IOException;
}
