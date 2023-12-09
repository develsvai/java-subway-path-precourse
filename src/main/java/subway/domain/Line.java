package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private String name;
    private List<LineStationConnector> connectors;


    public Line(String name) {
        this.name = name;
        this.connectors = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addStation(Station station, int distance , int time) {
        LineStationConnector connector = new LineStationConnector(this, station, distance, time);
        connectors.add(connector);
        station.addConnector(connector);
    }

    public List<LineStationConnector> getConnectors() {
        return connectors;
    }


    // 추가 기능 구현
}
