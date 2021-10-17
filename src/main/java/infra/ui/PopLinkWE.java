package infra.ui;


import infra.interfaces.IConversion;

public class PopLinkWE extends BaseWE {

    public PopLinkWE(String description, LocateBy selectBy, String selector) {
        super(description, selectBy, selector);
    }

    public void conversion(IConversion convert) {
        this.doIt("conversion", convert.convertFrom().name() + " to " + convert.convertTo().name());
    }

    @Override
    protected void act(Object value) {
        this.getWe().click();
    }
}
