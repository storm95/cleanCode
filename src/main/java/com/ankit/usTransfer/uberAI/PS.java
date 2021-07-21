package com.ankit.usTransfer.uberAI;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//trip^2 * points^2
public class PS {
    public List<Location> getIntersections(List<Trip> trips){
        List<Location> intersections = new ArrayList<>();
        for(Trip trip1: trips) {
            for(Trip trip2: trips) {
                if(!trip1.equals(trip2)) {
                    intersections.addAll(getIntersections(trip1, trip2));
                }
            }
        }

        for(Trip trip1: trips) {

        }

//        s10 -> [trip1loc1, trip1loc2, ...]

        return intersections;
    }

    public List<Location> getIntersections(Trip trip1, Trip trip2){
//        S10 -> [trip1loc1, trip1loc2, ...]
//        S10 -> [trip2loc1, trip2loc2, ...]
//        List s2 trip1
//        List s2 trip 2


        List<Location> intersections = new ArrayList<>();
        for(int i=0;i<trip1.path.size()-1;++i) {
            for(int j=0;j<trip2.path.size()-1;++j) {
                Optional<Location> intersection = getIntersection(trip1.path.get(i), trip1.path.get(i+1), trip2.path.get(j), trip2.path.get(j+1));
                intersection.ifPresent(intersections::add);
            }
        }

        return intersections;
    }

    private Optional<Location> getIntersection(Location start1, Location end1, Location start2, Location end2) {
        return Optional.of(new Location(0, 0));
    }

    public  class Location {
        double lat, lng;

        Location(double lat, double lng) {
            this.lat = lat;
            this.lng = lng;
        }
    }

    public class Trip {
        List<Location> path;
        Trip(List<Location> path) {
            this.path = path;
        }
    }
}
