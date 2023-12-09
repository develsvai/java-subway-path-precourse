package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Station {
    private String name;
    private List<LineStationConnector> connectors;


    public Station(String name) {
        this.name = name;
        this.connectors = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addConnector(LineStationConnector connector) {
        connectors.add(connector);
    }

    public List<LineStationConnector> getConnectors() {
        return connectors;
    }

    // 추가 기능 구현
}
