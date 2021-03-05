package ru.netology.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class FlightSelection implements Comparable<FlightSelection> {
        private int id;
        private int price;
        private String departureAirport;
        private String arrivalAirport;
        private int flightTime;

        public boolean matches(String from, String to) {
            if (this.departureAirport.equalsIgnoreCase(from) && this.arrivalAirport.equalsIgnoreCase(to)) {
                return true;
            }
            return false;
        }

        @Override
        public int compareTo(FlightSelection o) {
            return price - o.price;
        }


    }
