package chapter03.intro.domain;

import chapter03.intro.enums.Direction;

public class Room extends MapSite {

    private MapSite[] sides = new MapSite[4];
    private int roomNumber;

    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
        for (int i=0; i<sides.length; i++) {
            sides[i] = new Wall();
        }
    }

    @Override
    public void enter() {
        // ...
    }

    public MapSite getSide(Direction direction) {
        return sides[direction.ordinal()];
    }

    public void setSide(Direction direction, MapSite mapSite) {
        sides[direction.ordinal()] = mapSite;
    }
}
