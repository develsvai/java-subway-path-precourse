package subway.view.inputview;

import java.util.Scanner;

public class InputView {
    static final String MENU_PROMPT = "## 원하는 기능을 선택하세요.";
    static final String DEPARTURESTATION = "## 출발역을 입력하세요. ";
    static final String DESTINATIONSTATION = "## 도착역을 입력하세요. ";
    private final Scanner scanner;
    public InputView(Scanner scanner){
        this.scanner = scanner;
    }

    public String chooseFunctionMenu(){
        System.out.println(MENU_PROMPT);
        return scanner.nextLine();
    }

    public String DepartureStationInput(){
        System.out.println(DEPARTURESTATION);
        return scanner.nextLine();
    }

    public String DestinationStationInput(){
        System.out.println(DESTINATIONSTATION);
        return scanner.nextLine();
    }


}
