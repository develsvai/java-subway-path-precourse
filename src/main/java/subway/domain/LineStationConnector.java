package subway.domain;

public class LineStationConnector {
    private Line line;
    private Station station;
    private int distance;
    private int time;

    public LineStationConnector(Line line, Station station, int distance , int time) {
        this.line = line;
        this.station = station;
        this.distance = distance;
        this.time = time;
    }

    public Line getLine() {
        return line;
    }

    public Station getStation() {
        return station;
    }

    public int getDistance() {
        return distance;
    }

    public int getTime() {
        return time;
    }
}
