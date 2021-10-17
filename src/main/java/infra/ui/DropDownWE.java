package infra.ui;

import org.openqa.selenium.support.ui.Select;

public class DropDownWE extends BaseWE {

    public DropDownWE(String description, LocateBy selectBy, String selector) {
        super(description, selectBy, selector);
    }

    public void select(String value) {
        this.doIt("select", value);
    }


    @Override
    protected void act(Object value) {
        String val = (String) value;
        new Select(this.findElement()).selectByVisibleText(val);
    }
}
