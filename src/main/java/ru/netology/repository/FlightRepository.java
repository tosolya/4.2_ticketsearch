package ru.netology.repository;

import ru.netology.domain.FlightSelection;

public class FlightRepository {
    private FlightSelection[] offers = new FlightSelection[0];

    public void save(FlightSelection offer) {
        int length = offers.length + 1;
        FlightSelection[] tmp = new FlightSelection[length];
        System.arraycopy(offers, 0, tmp, 0, offers.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = offer;
        offers = tmp;
    }

    public FlightSelection[] getAll() {
        return offers;
    }

    public void removeById(int id) {
        if (getAll() == null) {
            throw new NegativeArraySizeException ("Element with id:" + id + "not found");
        }
        int length = offers.length - 1;
        FlightSelection[] tmp = new FlightSelection[length];
        int index = 0;
        for (FlightSelection item : offers) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        offers = tmp;
    }
}

