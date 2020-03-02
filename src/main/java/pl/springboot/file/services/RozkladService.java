package pl.springboot.file.services;

import pl.springboot.file.model.RodzajRozkladu;

import java.util.List;

public interface RozkladService {
    List<RodzajRozkladu> findAll();

    RodzajRozkladu save(RodzajRozkladu rodzajRozkladu);
}
