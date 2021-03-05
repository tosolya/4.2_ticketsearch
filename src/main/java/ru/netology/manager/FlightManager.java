package ru.netology.manager;

import ru.netology.domain.FlightSelection;
import ru.netology.repository.FlightRepository;

import java.util.Arrays;

public class FlightManager {
    private FlightRepository repository;

    public void removeById(int id) {
        repository.removeById(id);
    }

    public void add(FlightSelection flight) {
        repository.save(flight);
    }

    public void findAll(FlightSelection flight) {
        repository.getAll();
    }

    public FlightSelection[] findAllMatches(String from, String to) {
        FlightSelection[] result = new FlightSelection[0];
        for (FlightSelection flight : repository.getAll()) {
            if (flight.matches(from, to)) {
                FlightSelection[] tmp = new FlightSelection[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = flight;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

    public FlightManager(FlightRepository repository) {
        this.repository = repository;
    }
}
