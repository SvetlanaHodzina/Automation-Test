package com.epam.autotesting.model;

import java.util.Objects;

public class Computer {

    private String instances;
    private String os;
    private String vmClass;
    private String series;
    private String machineType;
    private String numberGPU;
    private String typeGPU;
    private String localSSD;
    private String dataCentreLocation;
    private String usage;

    public Computer(String instances, String os,
                    String vmClass, String series,
                    String machineType, String numberGPU,
                    String typeGPU, String localSSD,
                    String dataCentreLocation, String usage)
    {
        this.instances = instances;
        this.os = os;
        this.vmClass = vmClass;
        this.series = series;
        this.machineType = machineType;
        this.numberGPU = numberGPU;
        this.typeGPU = typeGPU;
        this.localSSD = localSSD;
        this.dataCentreLocation = dataCentreLocation;
        this.usage = usage;
    }

    public String getInstances() { return instances;}
    public void setInstances(String instances) {
        this.instances = instances;
    }

    public String getOs() {
        return os;
    }
    public void setOs(String os) {
        this.os = os;
    }

    public String getVmClass() {
        return vmClass;
    }
    public void setVmClass(String vmClass) {
        this.vmClass = vmClass;
    }

    public String getSeries() {
        return series;
    }
    public void setSeries(String os) {
        this.series = series;
    }

    public String getMachineType() {
        return machineType;
    }
    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }

    public String getNumberGPU() {
        return numberGPU;
    }
    public void setNumberGPU(String numberGPU) {
        this.numberGPU = numberGPU;
    }

    public String getTypeGPU() {
        return typeGPU;
    }
    public void setTypeGPU(String typeGPU) {
        this.typeGPU = typeGPU;
    }

    public String getLocalSSD() {
        return localSSD;
    }
    public void setLocalSSD(String localSSD) {
        this.localSSD = localSSD;
    }

    public String getDataCentreLocation() {
        return dataCentreLocation;
    }
    public void setDataCentreLocation(String dataCentreLocation) {
        this.dataCentreLocation = dataCentreLocation;
    }

    public String getUsage() {
        return usage;
    }
    public void setUsage(String usage) {
        this.usage = usage;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "instances='" + instances + '\'' +
                ", vmClasss='" + vmClass + '\'' +
                ", series='" + series + '\'' +
                ", machineType='" + machineType + '\'' +
                ", numberGPU='" + numberGPU + '\'' +
                ", typeGPU='" + typeGPU + '\'' +
                ", localSSD='" + localSSD + '\'' +
                ", dataCentreLocation='" + dataCentreLocation + '\'' +
                ", usage='" + usage + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Computer)) return false;
        Computer engine = (Computer) o;
        return Objects.equals(getInstances(), engine.getInstances()) &&
                Objects.equals(getOs(), engine.getOs()) &&
                Objects.equals(getVmClass(), engine.getVmClass()) &&
                Objects.equals(getSeries(), engine.getSeries()) &&
                Objects.equals(getMachineType(), engine.getMachineType())&&
                Objects.equals(getNumberGPU(), engine.getNumberGPU())&&
                Objects.equals(getTypeGPU(), engine.getTypeGPU())&&
                Objects.equals(getLocalSSD(), engine.getLocalSSD())&&
                Objects.equals(getDataCentreLocation(), engine.getDataCentreLocation())&&
                Objects.equals(getUsage(), engine.getUsage());
    }
    @Override
    public int hashCode() {
        return Objects.hash(getInstances(), getOs());
    }
}