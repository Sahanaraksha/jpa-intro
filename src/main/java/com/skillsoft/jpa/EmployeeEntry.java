package com.skillsoft.jpa;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class EmployeeEntry {

    @EmbeddedId
    EmployeeEntryId employeePlusDate;
    LocalTime entryTime;

    public EmployeeEntry() {
    }

    public EmployeeEntry(int empId, LocalDate entryDate, LocalTime entryTime) {

        this.employeePlusDate = new EmployeeEntryId(empId, entryDate);
        this.entryTime = entryTime;
    }

    public EmployeeEntryId getEmployeePlusDate() {
        return employeePlusDate;
    }

    public void setEmployeePlusDate(EmployeeEntryId employeePlusDate) {
        this.employeePlusDate = employeePlusDate;
    }

    public LocalTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalTime entryTime) {
        this.entryTime = entryTime;
    }

    @Override
    public String toString() {

        return "EmployeeEntry{" +
                ", employeeId=" + employeePlusDate.getEmployeeId() +
                ", entryDate='" + employeePlusDate.getEntryDate() + '\'' +
                ", entryTime='" + entryTime +
                '}';
    }

}
