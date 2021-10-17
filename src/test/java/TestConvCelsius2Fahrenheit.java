import dtos.TestBeanBase;
import dtos.TestConvCelsius2FahrenheitDTO;
import infra.enums.TypeMenuEnum;
import infra.enums.UnitsEnum;
import interfaces.IConversion;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.Celsius2FahrenheitPage;
import pages.HomePage;
import pages.TemperatureConversionPage;

import java.util.Iterator;

public class TestConvCelsius2Fahrenheit extends BaseTest implements IConversion {

    @BeforeClass
    @Override
    public void beforeClass() {
        super.beforeClass();
        new HomePage().selectTypeMenu(TypeMenuEnum.Temperature);
        new TemperatureConversionPage().conversion(this);
    }

    @Override
    @Test(dataProvider = "testConvCelsius2Fahrenheit")
    protected void test(TestBeanBase dto) {
        TestConvCelsius2FahrenheitDTO tcDto = (TestConvCelsius2FahrenheitDTO) dto;
        this.formula(tcDto);
        new Celsius2FahrenheitPage().perform(tcDto).validate(tcDto).clear();
    }

    @DataProvider(name = "testConvCelsius2Fahrenheit")
    public Iterator<Object[]> dataProvider() {
        return super.getDataProvider();
    }

    @Override
    protected TestBeanBase getTestBeanBase() {
        return new TestConvCelsius2FahrenheitDTO();
    }


    @Override
    public UnitsEnum convertFrom() {
        return UnitsEnum.Celsius;
    }

    @Override
    public UnitsEnum convertTo() {
        return UnitsEnum.Fahrenheit;
    }

    @Override
    public void formula(TestBeanBase dto) {
        TestConvCelsius2FahrenheitDTO tcDto = (TestConvCelsius2FahrenheitDTO) dto;
        float result = (Float.parseFloat(tcDto.getCelsius()) * 9) / 5 + 32;
        tcDto.setFahrenheit(String.format(tcDto.getFormattedCalc(result), result));
    }
}
