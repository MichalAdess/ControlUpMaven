package pages;

import infra.enums.TypeMenuEnum;
import infra.ui.BaseWE;
import infra.ui.TypeMenuWE;

public class HomePage extends BasePage {

    private TypeMenuWE tempMenu = new TypeMenuWE("Temperature menu", BaseWE.LocateBy.CSS, "#typeMenu a[href*='temperature']");
    private TypeMenuWE weightMenu = new TypeMenuWE("Weight menu", BaseWE.LocateBy.CSS, "#typeMenu a[href*='weight']");
    private TypeMenuWE lengthMenu = new TypeMenuWE("Length menu", BaseWE.LocateBy.CSS, "#typeMenu a[href*='length']");

    public HomePage selectTypeMenu(TypeMenuEnum typeMenu) {
        switch (typeMenu) {
            case Temperature:
                tempMenu.open(typeMenu);
                break;
            case Weight:
                weightMenu.open(typeMenu);
                break;
            case Length:
                lengthMenu.open(typeMenu);
                break;
        }
        return this;
    }

}
