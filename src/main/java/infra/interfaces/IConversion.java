package infra.interfaces;

import dtos.TestBeanBase;
import infra.enums.UnitsEnum;

public interface IConversion {

    UnitsEnum from = null;
    UnitsEnum to = null;

    UnitsEnum convertFrom();

    UnitsEnum convertTo();

    void formula(TestBeanBase dto);


}
