package infra.ui;

import org.openqa.selenium.WebElement;

public class InputWE extends BaseWE {

    public InputWE(String description, LocateBy selectBy, String selector) {
        super(description, selectBy, selector);
    }

    public void sendKeys(String value) {
        this.action = 1;
        this.doIt("type", value);
    }

    public void clear() {
        this.action = 2;
        this.doIt("clear", null);
    }

    @Override
    protected void act(Object value) {
        WebElement element = this.findElement();
        switch (action) {
            case 1:
                String val = (String) value;
                element.sendKeys(val);
                break;
            case 2:
                element.clear();
                break;

        }

    }
}
