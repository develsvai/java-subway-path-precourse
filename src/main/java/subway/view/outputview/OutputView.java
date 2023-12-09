package subway.view.outputview;

public class OutputView {
    private static final String MAIN_SCREEN = "## 메인 화면";
    private static final String PATH_INQUIRY = "1. 경로 조회";
    private static final String EXIT = "Q. 종료";

    public void displayMainMenu(){
        System.out.println(MAIN_SCREEN);
        System.out.println(PATH_INQUIRY);
        System.out.println(EXIT);
    }


    public void displaySearchResult(){

    }
}
