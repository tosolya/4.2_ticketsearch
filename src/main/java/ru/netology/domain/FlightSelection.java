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
        private String from;
        private String to;
        private int flightTime;

        public boolean matches(String from, String to) {
            if (this.from.equalsIgnoreCase(from) && this.to.equalsIgnoreCase(to)) {
                return true;
            }
            return false;
        }

        @Override
        public int compareTo(FlightSelection o) {
            return 0;
        }


    }
