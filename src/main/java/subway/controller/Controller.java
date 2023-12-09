package subway.controller;
import subway.dto.InputFunctionNumberDto;
import subway.service.pathservice.DistanceCalculatorService;
import subway.service.pathservice.DistanceCalculatorService.DistanceInfo;
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
        InputFunctionNumberDto inputFunctionNumberDto = new InputFunctionNumberDto();
        inputFunctionNumberDto.transferViewToModel(InputMainMenu());


        if(inputFunctionNumberDto.getFunctionNumber() == 1) {
            int serviceNumber = inputChoosePathService();

            if (serviceNumber == 1) {
                String startStationName = inputDepartureStation();
                String endStationName = inputDestinationStation();
                DistanceInfo distanceInfo = DistanceCalculatorService.getDistanceInfo(startStationName,endStationName);

            }

            if(serviceNumber ==2) {

            }
        }
    }




    private int InputMainMenu(){
        outputView.displayMainMenu();
        String function = inputView.chooseFunctionMenu();

        if( function.equalsIgnoreCase("Q")){
            System.exit(0);
        }

        return Integer.parseInt(function);
    }

    private int inputChoosePathService() {
        outputView.displayPathServiceMenu();
        String function = inputView.chooseFunctionMenu();
        if (function.equalsIgnoreCase("B")) {
            System.exit(0);
        }
        return Integer.parseInt(function);
    }


    private String inputDepartureStation(){
        return inputView.DepartureStationInput();
    }

    private String inputDestinationStation(){
        return inputView.DestinationStationInput();
    }
}
