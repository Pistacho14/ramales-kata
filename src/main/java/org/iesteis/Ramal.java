package org.iesteis;

public class Ramal {

    private String name;
    private String direction;
    private Integer distance;

    public Ramal(String ramal) {

        this.name = ramal.split(" ")[0];
        this.direction = ramal.split(" ")[1];
        this.distance = Integer.parseInt(ramal.split(" ")[2]);
    }

    public String getName() {
        return name;
    }

    public String getDirection() {
        return direction;
    }

    public Integer getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return name;
    }
}
