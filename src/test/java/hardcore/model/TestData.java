package hardcore.model;

import java.util.Objects;

public class TestData {
    private String instances;
    private String software;
    private String machineClass;
    private String machineType;
    private String location;
    private String committedUsage;

    public TestData(String instances, String software, String machineClass, String machineType, String location, String committedUsage) {
        this.instances = instances;
        this.software = software;
        this.machineClass = machineClass;
        this.machineType = machineType;
        this.location = location;
        this.committedUsage = committedUsage;
    }

    public String getInstances() {
        return instances;
    }

    public void setInstances(String instances) {
        this.instances = instances;
    }

    public String getSoftware() {
        return software;
    }

    public void setSoftware(String software) {
        this.software = software;
    }

    public String getMachineClass() {
        return machineClass;
    }

    public void setMachineClass(String machineClass) {
        this.machineClass = machineClass;
    }

    public String getMachineType() {
        return machineType;
    }

    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCommittedUsage() {
        return committedUsage;
    }

    public void setCommittedUsage(String committedUsage) {
        this.committedUsage = committedUsage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TestData)) return false;
        TestData testData = (TestData) o;
        return Objects.equals(getInstances(), testData.instances) &&
                Objects.equals(getSoftware(), testData.software) &&
                Objects.equals(getMachineClass(), testData.machineClass) &&
                Objects.equals(getMachineType(), testData.machineType) &&
                Objects.equals(getLocation(), testData.location) &&
                Objects.equals(getCommittedUsage(), testData.committedUsage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getInstances(),
                getSoftware(),
                getMachineClass(),
                getMachineType(),
                getLocation(),
                getCommittedUsage());
    }

    @Override
    public String toString() {
        return instances + '\'' +
                software + '\'' +
                machineClass + '\'' +
                machineType + '\'' +
                location + '\'' +
                committedUsage;
    }
}
