package subway.service.pathservice;


import java.util.List;
import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.interfaces.ShortestPathAlgorithm.SingleSourcePaths;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.LineStationConnector;
import subway.domain.Station;
import subway.domain.StationRepository;

public class DistanceCalculatorService {

    public static DistanceInfo getDistanceInfo(String startStationName, String endStationName) {
        Graph<String, DefaultWeightedEdge> graph = createDistanceGraph();

        DijkstraShortestPath<String, DefaultWeightedEdge> dijkstra = new DijkstraShortestPath<>(graph);
        SingleSourcePaths<String, DefaultWeightedEdge> paths = dijkstra.getPaths(startStationName);

        GraphPath<String, DefaultWeightedEdge> path = paths.getPath(endStationName);

        if (path != null) {
            double shortestDistance = path.getWeight();
            List<DefaultWeightedEdge> edgeList = path.getEdgeList();
            double totalTime = 0;

            for (DefaultWeightedEdge edge : edgeList) {
                double weight = graph.getEdgeWeight(edge);
                totalTime += weight;
            }

            // 로그 추가
            System.out.println("Shortest Distance: " + shortestDistance + " km");
            System.out.println("Total Time: " + totalTime + " minutes");

            return new DistanceInfo(shortestDistance, totalTime);
        }
        return null;
    }

    private void calTotalTime(){

    }



    public static class DistanceInfo {
        private final double shortestDistance;
        private final double totalTime;

        public DistanceInfo(double shortestDistance, double totalTime) {
            this.shortestDistance = shortestDistance;
            this.totalTime = totalTime;
        }

        public double getShortestDistance() {
            return shortestDistance;
        }

        public double getTotalTime() {
            return totalTime;
        }
    }



    public static Graph<String, DefaultWeightedEdge> createDistanceGraph() {
        Graph<String, DefaultWeightedEdge> graph = new SimpleDirectedWeightedGraph<>(DefaultWeightedEdge.class);

        // 역과 노선 정보가 저장된 Repository 초기화
        initializeStationsAndLines();

        // 역을 그래프에 추가
        for (Station station : StationRepository.stations()) {
            graph.addVertex(station.getName());
        }

        // 노선과 역 간의 연결 정보를 그래프에 추가
        for (Line line : LineRepository.lines()) {
            List<LineStationConnector> connectors = line.getConnectors();

            for (int i = 0; i < connectors.size() - 1; i++) {
                Station source = connectors.get(i).getStation();
                Station target = connectors.get(i + 1).getStation();
                double distance = connectors.get(i).getDistance();
                double totalTime = connectors.get(i).getTime();

                DefaultWeightedEdge edge = graph.addEdge(source.getName(), target.getName());

                if (edge != null) {
                    // 거리와 시간을 더해서 가중치로 설정
                    graph.setEdgeWeight(edge, distance);
                }
            }
        }

        return graph;
    }



    private static void initializeStationsAndLines() {
        // 교대역, 강남역, 역삼역, 남부터미널역, 양재역, 양재시민의숲역, 매봉역 등록
        Station station1 = new Station("교대역");
        Station station2 = new Station("강남역");
        Station station3 = new Station("역삼역");
        Station station4 = new Station("남부터미널역");
        Station station5 = new Station("양재역");
        Station station6 = new Station("양재시민의숲역");
        Station station7 = new Station("매봉역");

        StationRepository.addStation(station1);
        StationRepository.addStation(station2);
        StationRepository.addStation(station3);
        StationRepository.addStation(station4);
        StationRepository.addStation(station5);
        StationRepository.addStation(station6);
        StationRepository.addStation(station7);

        Line line1 = new Line("2호선");
        Line line2 = new Line("3호선");
        Line line3 = new Line("신분당선");

        LineRepository.addLine(line1);
        LineRepository.addLine(line2);
        LineRepository.addLine(line3);

        connectStationsToLines();
    }

    private static void connectStationsToLines() {
        // 2호선
        Line line2 = LineRepository.lines().get(0);
        line2.addStation(StationRepository.stations().get(0), 2, 3);  // 교대역
        line2.addStation(StationRepository.stations().get(1), 2, 3);  // 강남역
        line2.addStation(StationRepository.stations().get(2), 2, 3);  // 역삼역

        // 3호선
        Line line3 = LineRepository.lines().get(1);
        line3.addStation(StationRepository.stations().get(0), 3, 2);  // 교대역
        line3.addStation(StationRepository.stations().get(3), 6, 5);  // 남부터미널역
        line3.addStation(StationRepository.stations().get(4), 1, 1);  // 양재역
        line3.addStation(StationRepository.stations().get(6), 1, 1);  // 매봉역

        // 신분당선
        Line lineSinBundang = LineRepository.lines().get(2);
        lineSinBundang.addStation(StationRepository.stations().get(1), 2, 8);  // 강남역
        lineSinBundang.addStation(StationRepository.stations().get(4), 10, 3); // 양재역
        lineSinBundang.addStation(StationRepository.stations().get(5), 3, 3);  // 양재시민의숲역
    }
}

