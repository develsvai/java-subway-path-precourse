package subway.dto;

public class InputFunctionNumberDto {
    private Integer functionNumber;

    public void transferViewToModel( int functionNumber) {
        this.functionNumber = functionNumber;
    }

    public Integer getFunctionNumber(){
        return functionNumber;
    }
}
