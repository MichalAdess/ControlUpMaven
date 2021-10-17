package pages;

import infra.enums.UnitsEnum;
import infra.ui.BaseWE;
import infra.ui.PopLinkWE;
import interfaces.IConversion;

public class WeightConversionPage extends BasePage {

    PopLinkWE ounces2Grams = new PopLinkWE("Ounces to Grams", BaseWE.LocateBy.CSS, "[href*='ounces-to-grams']");

    public WeightConversionPage conversion(IConversion convert) {
        if (convert.convertFrom() == UnitsEnum.Ounces && convert.convertTo() == UnitsEnum.Grams) {
            this.ounces2Grams.conversion(convert);
        }//here you can support the other Weight conversion options
        return this;
    }

}
