package com.epam.autotesting.service;

import com.epam.autotesting.model.Computer;

public class ComputerRenter {
    public static final String TESTDATA_INSTANCES = "testdata.engine.instances";
    public static final String TESTDATA_OS = "testdata.engine.os";
    public static final String TESTDATA_VM_CLASS = "testdata.engine.vmClass";
    public static final String TESTDATA_SERIES = "testdata.engine.series";
    public static final String TESTDATA_MACHINE_TYPE = "testdata.engine.machineType";
    public static final String TESTDATA_NUMBER_GPU = "testdata.engine.numberGPU";
    public static final String TESTDATA_TYPE_GPU = "testdata.engine.typeGPU";
    public static final String TESTDATA_LOCAL_SSD = "testdata.engine.localSSD";
    public static final String TESTDATA_DATA_CENTRE_LOCATION = "testdata.engine.dataCentreLocation";
    public static final String TESTDATA_USAGE = "testdata.engine.usage";

    public static Computer withCredentialsFromProperty() {
        return new Computer(TestDataReader.getTestData(TESTDATA_INSTANCES),
                TestDataReader.getTestData(TESTDATA_OS),
                TestDataReader.getTestData(TESTDATA_VM_CLASS),
                TestDataReader.getTestData(TESTDATA_SERIES),
                TestDataReader.getTestData(TESTDATA_MACHINE_TYPE),
                TestDataReader.getTestData(TESTDATA_NUMBER_GPU),
                TestDataReader.getTestData(TESTDATA_TYPE_GPU),
                TestDataReader.getTestData(TESTDATA_LOCAL_SSD),
                TestDataReader.getTestData(TESTDATA_DATA_CENTRE_LOCATION),
                TestDataReader.getTestData(TESTDATA_USAGE));
    }
}