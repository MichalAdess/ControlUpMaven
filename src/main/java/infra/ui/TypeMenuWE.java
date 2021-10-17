package infra.ui;

import infra.enums.TypeMenuEnum;

public class TypeMenuWE extends BaseWE {

    public TypeMenuWE(String description, LocateBy selectBy, String selector) {
        super(description, selectBy, selector);
    }

    public void open(TypeMenuEnum typeMenu) {
        this.doIt("open type menu", typeMenu.name());
    }

    @Override
    protected void act(Object value) {
       this.getWe().click();
    }
}
