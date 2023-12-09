package subway.controller;

import java.util.List;
import subway.view.inputview.InputView;
import subway.view.outputview.OutputView;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;


    public Controller(InputView inputView, OutputView outputView ){
        this.inputView = inputView;
        this.outputView = outputView;
    }


    public void startService(){
        InputMainMenu();

    }


    private int InputMainMenu(){
        return inputView.chooseFunctionMenu();
    }



    private String InputDepartureStation(){
        return inputView.DepartureStationInput();


    }
}
