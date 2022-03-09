package com.skillsoft.jpa;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@IdClass(EmployeeEntryId.class)
public class EmployeeEntry1 {

    @Id
    private int employeeId;
    @Id
    private LocalDate entryDate;

    LocalTime entryTime;

    public EmployeeEntry1() {
    }

    public EmployeeEntry1(int empId, LocalDate entryDate, LocalTime entryTime) {

        this.employeeId = empId;
        this.entryDate = entryDate;
        this.entryTime = entryTime;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
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
                ", employeeId=" + getEmployeeId() +
                ", entryDate='" + getEntryDate() + '\'' +
                ", entryTime='" + getEntryTime() +
                '}';
    }

}