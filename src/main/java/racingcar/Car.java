package racingcar;

class Car {
    private String name;
    private String line = "";
    public Car(String name) {
        this.name = name;
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getLine() {return line;}
    public void setLine(String line) {this.line = line;}

    void isMove(int n) {
        this.line += n >= 4 ? "-" : "";
    }
}
