package pages;

import infra.enums.UnitsEnum;
import infra.ui.BaseWE;
import infra.ui.PopLinkWE;
import interfaces.IConversion;

public class TemperatureConversionPage extends BasePage {

    PopLinkWE celsius2Fahrenheit = new PopLinkWE("Celsius to Fahrenheit", BaseWE.LocateBy.CSS, "[href*='celsius-to-fahrenheit']");

    public TemperatureConversionPage conversion(IConversion convert) {
        if (convert.convertFrom() == UnitsEnum.Celsius && convert.convertTo() == UnitsEnum.Fahrenheit) {
            this.celsius2Fahrenheit.conversion(convert);
        }//here you can support the other temperature conversion options
        return this;
    }

}
