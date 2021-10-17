package pages;

import dtos.TestConvMeters2FeetDTO;
import infra.ui.AnswerWE;
import infra.ui.BaseWE;
import infra.ui.DropDownWE;
import infra.ui.InputWE;

public class Meters2FeetPage extends BasePage {

    InputWE meters = new InputWE("meters", BaseWE.LocateBy.ID, "argumentConv");
    AnswerWE answer = new AnswerWE("result", BaseWE.LocateBy.ID, "answer");
    DropDownWE format = new DropDownWE("format", BaseWE.LocateBy.ID, "format");

    public Meters2FeetPage perform(TestConvMeters2FeetDTO dto) {
        this.meters.sendKeys(dto.getMeters());
        //in real life should be taken from csv
        this.format.select("Decimal");
        return this;
    }

    public Meters2FeetPage validate(TestConvMeters2FeetDTO dto) {
        answer.validateText(dto.getMeters() + "m= " + dto.getFeet() + "ft");
        return this;
    }

    public Meters2FeetPage clear() {
        meters.clear();
        return this;
    }

}
