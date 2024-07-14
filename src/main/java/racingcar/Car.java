package racingcar;

class Car {
    private String name;
    private String line = "";
    public Car(String name) {
        this.name = name;
        this.velidate();
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getLine() {return line;}
    public void setLine(String line) {this.line = line;}

    void isMove(int n) {
        this.line += n >= 4 ? "-" : "";
    }

    private void velidate() {
        if (this.name.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하여야 합니다.");
        }
    }
}
