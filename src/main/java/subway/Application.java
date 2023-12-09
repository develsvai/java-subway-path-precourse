package subway;

import java.util.Scanner;
import subway.controller.Controller;
import subway.view.inputview.InputView;
import subway.view.outputview.OutputView;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        InputView inputView = new InputView(scanner);
        OutputView outputView = new OutputView();

        Controller controller = new Controller(inputView,outputView);

        controller.startService();
    }
}
