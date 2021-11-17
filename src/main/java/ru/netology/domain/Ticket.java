package ru.netology.domain;

import java.util.Objects;

public class Ticket implements Comparable<Ticket> {
    private int id;
    private int cost;
    private String fromAirport;
    private String toAirport;
    private int travelTime;


    public Ticket(int id, int cost, String fromAirport, String toAirport, int travelTime) {
        this.id = id;
        this.cost = cost;
        this.fromAirport = fromAirport;
        this.toAirport = toAirport;
        this.travelTime = travelTime;
    }

    public Ticket() {
    }

    public int getId() {
        return id;
    }

    public int getCost() {
        return cost;
    }

    public String getFromAirport() {
        return fromAirport;
    }

    public String getToAirport() {
        return toAirport;
    }

    public int getTravelTime() {
        return travelTime;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setFromAirport(String fromAirport) {
        this.fromAirport = fromAirport;
    }

    public void setToAirport(String toAirport) {
        this.toAirport = toAirport;
    }

    public void setTravelTime(int travelTime) {
        this.travelTime = travelTime;
    }

    @Override
    public int compareTo(Ticket o) {
        Ticket ticket = (Ticket) o;
        int diff = this.cost - ticket.cost;
        if (diff == 0) {
            return 0;
        } else if (diff < 0) {
            return -1;
        } else {
            return 1;
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return id == ticket.id && cost == ticket.cost && travelTime == ticket.travelTime && Objects.equals(fromAirport, ticket.fromAirport) && Objects.equals(toAirport, ticket.toAirport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cost, fromAirport, toAirport, travelTime);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", cost=" + cost +
                ", fromAirport='" + fromAirport + '\'' +
                ", toAirport='" + toAirport + '\'' +
                ", travelTime=" + travelTime +
                '}';
    }
}

