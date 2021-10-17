package pages;

import infra.enums.UnitsEnum;
import infra.ui.BaseWE;
import infra.ui.PopLinkWE;
import interfaces.IConversion;

public class LengthConversionPage extends BasePage {

    PopLinkWE meters2Feet = new PopLinkWE("Meters to Feet", BaseWE.LocateBy.CSS, "[href*='meters-to-feet']");

    public LengthConversionPage conversion(IConversion convert) {
        if (convert.convertFrom() == UnitsEnum.Meters && convert.convertTo() == UnitsEnum.Feet) {
            this.meters2Feet.conversion(convert);
        }//here you can support the other length conversion options
        return this;
    }

}
