import dtos.TestBeanBase;
import dtos.TestConvMeters2FeetDTO;
import infra.enums.TypeMenuEnum;
import infra.enums.UnitsEnum;
import interfaces.IConversion;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LengthConversionPage;
import pages.Meters2FeetPage;

import java.util.Iterator;

public class TestConvMeters2Feet extends BaseTest implements IConversion {

    @BeforeClass
    @Override
    public void beforeClass() {
        super.beforeClass();
        new HomePage().selectTypeMenu(TypeMenuEnum.Length);
        new LengthConversionPage().conversion(this);
    }

    @Override
    @Test(dataProvider = "testConvMeters2Feet")
    protected void test(TestBeanBase dto) {
        TestConvMeters2FeetDTO tcDto = (TestConvMeters2FeetDTO) dto;
        this.formula(tcDto);
        new Meters2FeetPage().perform(tcDto).validate(tcDto).clear();
    }

    @DataProvider(name = "testConvMeters2Feet")
    public Iterator<Object[]> dataProvider() {
        return super.getDataProvider();
    }

    @Override
    protected TestBeanBase getTestBeanBase() {
        return new TestConvMeters2FeetDTO();
    }

    @Override
    public UnitsEnum convertFrom() {
        return UnitsEnum.Meters;
    }

    @Override
    public UnitsEnum convertTo() {
        return UnitsEnum.Feet;
    }

    @Override
    public void formula(TestBeanBase dto) {
        TestConvMeters2FeetDTO tcDto = (TestConvMeters2FeetDTO) dto;
        double result = (Float.parseFloat(tcDto.getMeters()) * 3.280840);
        tcDto.setFeet(String.format(tcDto.getFormattedCalc(result), result));
    }
}
