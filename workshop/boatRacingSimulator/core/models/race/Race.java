package workshop.boatRacingSimulator.core.models.race;

import workshop.boatRacingSimulator.core.exceptions.DuplicateModelException;
import workshop.boatRacingSimulator.core.models.boats.Boat;

import java.util.*;
import java.util.stream.Collectors;

public class Race {
    private int distance;
    private int windSpeed;
    private int oceanCurrentSpeed;
    private Map<String, Boat> participants;
    private static boolean allowMotorboats;

    public Race(int distance, int windSpeed, int oceanCurrentSpeed, String allowMotorboats) {
        this.setDistance(distance);
        this.setWindSpeed(windSpeed);
        this.setOceanCurrentSpeed(oceanCurrentSpeed);
        this.participants = new LinkedHashMap<>();
        setAllowMotorboats(allowMotorboats);
    }

    private void setAllowMotorboats(String allowMotorboats) {
        if (allowMotorboats.equals("true")) {
            Race.allowMotorboats = true;
        } else if (allowMotorboats.equals("false")) {
            Race.allowMotorboats = false;
        }

    }

    public int getDistance() {
        return this.distance;
    }

    private void setDistance(int distance) {
        if (distance <= 0) {
            throw new IllegalArgumentException("Distance must be a positive integer.");
        }
        this.distance = distance;
    }

    public int getWindSpeed() {
        return this.windSpeed;
    }

    private void setWindSpeed(int windSpeed) {
        this.windSpeed = windSpeed;
    }

    public int getOceanCurrentSpeed() {
        return this.oceanCurrentSpeed;
    }

    private void setOceanCurrentSpeed(int oceanCurrentSpeed) {
        this.oceanCurrentSpeed = oceanCurrentSpeed;
    }

    public Map<String, Boat> getParticipants() {
        return this.participants;
    }

    private boolean isAllowMotorboats() {
        return allowMotorboats;
    }

    public String addParticipants(Boat participant) throws DuplicateModelException {
        String message = "";

        if (this.participants.containsKey(participant.getModel())) {
            throw new DuplicateModelException();
        } else {
            if (isAllowMotorboats()) {
                this.participants.put(participant.getModel(), participant);
                message = String.format("Boat with model %s has signed up for the current Race."
                        , participant.getModel());
            } else {
                if (participant.isMotorboat()) {
                    message = "The specified boat does not meet the race constraints.";
                } else {
                    this.participants.put(participant.getModel(), participant);
                    message = String.format("Boat with model %s has signed up for the current Race."
                            , participant.getModel());
                }
            }
        }
        return message;
    }

    public String startRace() {
        List<Boat> boatsAbove = new ArrayList<>();
        List<Boat> boatsUnder = new ArrayList<>();

        List<Boat> boats = new ArrayList<>();
        boats.addAll(this.participants.values());

        for (int i = 0; i < boats.size(); i++) {
            if (this.distance / boats.get(i).calcBoatSpeed(this) <= 0) {
                boatsUnder.add(boats.get(i));
            } else {
                boatsAbove.add(boats.get(i));
            }
        }

        boatsAbove = boatsAbove.stream().sorted((f, s) -> Double.compare(this.distance / f.calcBoatSpeed(this)
                , this.distance / s.calcBoatSpeed(this)))
                .collect(Collectors.toCollection(ArrayList::new));
        boatsUnder = boatsUnder.stream().sorted((f, s) -> Double.compare(this.distance / f.calcBoatSpeed(this)
                , this.distance / s.calcBoatSpeed(this)))
                .collect(Collectors.toCollection(ArrayList::new));

        List<Boat> winners = new ArrayList<>();

        winners.addAll(boatsAbove);

        for (Boat b : boatsUnder) {
            winners.add(b);
        }

        String message = printRaceWinners(winners);
        return message;
    }

    private String printRaceWinners(List<Boat> boats) {
        StringBuilder sb = new StringBuilder();

        if (this.distance / boats.get(0).calcBoatSpeed(this) > 0) {
            sb.append(String.format("First place: %s Model: %s Time: %.2f sec"
                    , boats.get(0).getClass().getSimpleName(), boats.get(0).getModel()
                    , this.distance / boats.get(0).calcBoatSpeed(this)));
        } else {
            sb.append(String.format("First place: %s Model: %s Time: Did not finish!"
                    , boats.get(0).getClass().getSimpleName(), boats.get(0).getModel()));
        }
        sb.append(System.lineSeparator());

        if (this.distance / boats.get(1).calcBoatSpeed(this) > 0) {
            sb.append(String.format("Second place: %s Model: %s Time: %.2f sec"
                    , boats.get(1).getClass().getSimpleName(), boats.get(1).getModel()
                    , this.distance / boats.get(1).calcBoatSpeed(this)));
        } else {
            sb.append(String.format("Second place: %s Model: %s Time: Did not finish!"
                    , boats.get(1).getClass().getSimpleName(), boats.get(1).getModel()));
        }
        sb.append(System.lineSeparator());

        if (this.distance / boats.get(2).calcBoatSpeed(this) > 0) {
            sb.append(String.format("Third place: %s Model: %s Time: %.2f sec"
                    , boats.get(2).getClass().getSimpleName(), boats.get(2).getModel()
                    , this.distance / boats.get(2).calcBoatSpeed(this)));
        } else {
            sb.append(String.format("Third place: %s Model: %s Time: Did not finish!"
                    , boats.get(2).getClass().getSimpleName(), boats.get(2).getModel()));
        }

        return sb.toString();
    }

    @Override
    public String toString() {
        return String.format("A new race with distance %d meters, wind speed %d m/s " +
                        "and ocean current speed %d m/s has been set."
                , this.distance, this.windSpeed, this.oceanCurrentSpeed);
    }

    public String getStatistics() {
        int size = this.participants.size();
        double rowBoats = 0;
        double powerBoats = 0;
        double sailBoats = 0;
        double yachtBoats = 0;

        for (Boat participant : this.participants.values()) {
            switch (participant.getClass().getSimpleName()) {
                case "PowerBoat" :
                    powerBoats++;
                    break;
                case "RowBoat" :
                    rowBoats++;
                    break;
                case "SailBoat" :
                    sailBoats++;
                    break;
                case "Yacht" :
                    yachtBoats++;
                    break;
            }
        }


        StringBuilder sb = new StringBuilder();
        if (powerBoats > 0) {
            powerBoats = (powerBoats * 100) / size;
            sb.append(String.format("PowerBoat -> %.2f%s", powerBoats, "%"));
        }

        if (rowBoats > 0) {
            rowBoats = (rowBoats * 100) / size;
            sb.append(System.lineSeparator()).append(String.format("RowBoat -> %.2f%s", rowBoats, "%"));
        }

        if (sailBoats > 0) {
            sailBoats = (sailBoats * 100) / size;
            sb.append(System.lineSeparator()).append(String.format("SailBoat -> %.2f%s", sailBoats, "%"));
        }

        if (yachtBoats > 0) {
            yachtBoats = (yachtBoats * 100) / size;
            sb.append(System.lineSeparator()).append(String.format("Yacht -> %.2f%s", yachtBoats, "%"));
        }
        return sb.toString();
    }
}