package pl.springboot.file.services;

import pl.springboot.file.model.RodzajRozkladu;

import java.util.List;

public interface RozkladService {
    List<RodzajRozkladu> findAll();

    void save(RodzajRozkladu rodzajRozkladu);
}
