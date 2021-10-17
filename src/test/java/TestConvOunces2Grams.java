import dtos.TestBeanBase;
import dtos.TestConvOunces2GramsDTO;
import infra.enums.TypeMenuEnum;
import infra.enums.UnitsEnum;
import interfaces.IConversion;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.Ounces2GramsPage;
import pages.WeightConversionPage;

import java.util.Iterator;

public class TestConvOunces2Grams extends BaseTest implements IConversion {

    @BeforeClass
    @Override
    public void beforeClass() {
        super.beforeClass();
        new HomePage().selectTypeMenu(TypeMenuEnum.Weight);
        new WeightConversionPage().conversion(this);
    }

    @Override
    @Test(dataProvider = "testConvOunces2Grams")
    protected void test(TestBeanBase dto) {
        TestConvOunces2GramsDTO tcDto = (TestConvOunces2GramsDTO) dto;
        this.formula(tcDto);
        new Ounces2GramsPage().perform(tcDto).validate(tcDto).clear();
    }

    @DataProvider(name = "testConvOunces2Grams")
    public Iterator<Object[]> dataProvider() {
        return super.getDataProvider();
    }

    @Override
    protected TestBeanBase getTestBeanBase() {
        return new TestConvOunces2GramsDTO();
    }

    @Override
    public UnitsEnum convertFrom() {
        return UnitsEnum.Ounces;
    }

    @Override
    public UnitsEnum convertTo() {
        return UnitsEnum.Grams;
    }

    @Override
    public void formula(TestBeanBase dto) {
        TestConvOunces2GramsDTO tcDto = (TestConvOunces2GramsDTO) dto;
        double result = (Float.parseFloat(tcDto.getOunces()) * 28.34952);
        tcDto.setGrams(String.format(tcDto.getFormattedCalc(result), result));
    }
}
