package domain;

public class Calculator {

    String shownNumber;
    int inputNumber;
    int appendedNumber;
    int memoryNumber;

    public Calculator(){
        this("", 0, 0);
    }

    public Calculator(String shownNumber, int memoryNumber, int appendedNumber){
        this.shownNumber = shownNumber;
        this.memoryNumber = memoryNumber;
        this.appendedNumber = appendedNumber;
    }

    public void clearCalculator(){
        shownNumber = "";
        inputNumber = 0;
        appendedNumber = 0;
    }

    public void addMemoryNumber(int memNumber){
        memoryNumber = memoryNumber + memNumber;
    }

    public void subtractMemoryNumber(int memNumber){
        memoryNumber = memoryNumber - memNumber;
    }

    public int getMemoryNumber(){
        return(memoryNumber);
    }

    public void clearMemoryNumber(){
        memoryNumber = 0;
    }

    public String getShownNumber() {
        return shownNumber;
    }

    public void setShownNumber(String shownNumber) {
        this.shownNumber = shownNumber;
    }

    public int getInputNumber() {
        return inputNumber;
    }

    public void setInputNumber(int inputNumber) {
        this.inputNumber = inputNumber;
    }

    public int getAppendedNumber() {
        return appendedNumber;
    }

    public void setAppendedNumber(int appendedNumber) {
        this.appendedNumber = appendedNumber;
    }
}
