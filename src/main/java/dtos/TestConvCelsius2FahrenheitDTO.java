package dtos;

public class TestConvCelsius2FahrenheitDTO extends TestBeanBase {

    private String celsius;
    private String fahrenheit;

    public String getCelsius() {
        return celsius;
    }

    public String getFahrenheit() {
        return fahrenheit;
    }

    public void setFahrenheit(String fahrenheit) {
        this.fahrenheit = fahrenheit;
    }
}
