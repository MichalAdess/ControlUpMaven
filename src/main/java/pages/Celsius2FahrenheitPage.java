package pages;

import dtos.TestConvCelsius2FahrenheitDTO;
import infra.ui.AnswerWE;
import infra.ui.BaseWE;
import infra.ui.InputWE;

public class Celsius2FahrenheitPage extends BasePage {

    InputWE celsius = new InputWE("celsius", BaseWE.LocateBy.ID, "argumentConv");
    AnswerWE answer = new AnswerWE("result", BaseWE.LocateBy.ID, "answer");

    public Celsius2FahrenheitPage perform(TestConvCelsius2FahrenheitDTO dto) {
        celsius.sendKeys(dto.getCelsius());
        return this;
    }

    public Celsius2FahrenheitPage validate(TestConvCelsius2FahrenheitDTO dto) {
        answer.validateText(dto.getCelsius() + "\u00B0C= " + dto.getFahrenheit() + "\u00B0F");
        return this;
    }

    public Celsius2FahrenheitPage clear() {
        celsius.clear();
        return this;
    }

}
