package hardcore.service;

import hardcore.model.TestData;

public class TestDataCreator {
    public static final String TESTDATA_INSTANCES = "testdata.instances";
    public static final String TESTDATA_SOFTWARE = "testdata.software";
    public static final String TESTDATA_MACHINE_CLASS = "testdata.machine.class";
    public static final String TESTDATA_MACHINE_TYPE = "testdata.machine.type";
    public static final String TESTDATA_LOCATION = "testdata.location";
    public static final String TESTDATA_USAGE = "testdata.usage";

    public static TestData dropdownOptions(){
        return new TestData(TestDataReader.getTestData(TESTDATA_INSTANCES),
                TestDataReader.getTestData(TESTDATA_SOFTWARE),
                TestDataReader.getTestData(TESTDATA_MACHINE_CLASS),
                TestDataReader.getTestData(TESTDATA_MACHINE_TYPE),
                TestDataReader.getTestData(TESTDATA_LOCATION),
                TestDataReader.getTestData(TESTDATA_USAGE));
    }
}
