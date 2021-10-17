package pages;

import dtos.TestConvOunces2GramsDTO;
import infra.ui.AnswerWE;
import infra.ui.BaseWE;
import infra.ui.InputWE;

public class Ounces2GramsPage extends BasePage {

    InputWE ounces = new InputWE("ounces", BaseWE.LocateBy.ID, "argumentConv");
    AnswerWE answer = new AnswerWE("result", BaseWE.LocateBy.ID, "answer");

    public Ounces2GramsPage perform(TestConvOunces2GramsDTO dto) {
        this.ounces.sendKeys(dto.getOunces());
        return this;
    }

    public Ounces2GramsPage validate(TestConvOunces2GramsDTO dto) {
        answer.validateText(dto.getOunces() + "oz= " + dto.getGrams() + "g");
        return this;
    }

    public Ounces2GramsPage clear() {
        ounces.clear();
        return this;
    }

}
