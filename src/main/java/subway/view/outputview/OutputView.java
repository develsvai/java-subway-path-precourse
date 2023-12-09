package subway.view.outputview;

public class OutputView {
    private static final String MAIN_SCREEN = "## 메인 화면";
    private static final String PATH_INQUIRY = "1. 경로 조회";
    private static final String EXIT = "Q. 종료";
    public static final String SHORTEST_DISTANCE = "1. 최단 거리";
    public static final String MINIMUM_TIME = "2. 최소 시간";
    public static final String GO_BACK = "B. 돌아가기";



    public void displayPathServiceMenu(){
        System.out.println("## 경로 기준");
        System.out.println(SHORTEST_DISTANCE);
        System.out.println(MINIMUM_TIME);
        System.out.println(GO_BACK);
    }
    public void displayMainMenu(){
        System.out.println(MAIN_SCREEN);
        System.out.println(PATH_INQUIRY);
        System.out.println(EXIT);
    }


    public void displaySearchResult(){

    }
}
