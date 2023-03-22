package com.app.entity;

import jakarta.persistence.Entity;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity

public class Flight {

    private String Flightnumber;
    public String getFlightnumber() {
        return Flightnumber;
    }
    public void setFlightnumber(String newFlightnumber) {
        this.Flightnumber = newFlightnumber;
    }
    private String Departueplace;
    public String getDepartueplace() {
        return Departueplace;
    }
    public void setDepartueplace(String newDepartueplace) {
        this.Departueplace = newDepartueplace;
    }
    private String Arrivalplace;
    public String getArrivalplace() {
        return Arrivalplace;
    }
    public void setArrivalplace(String newArrivalplace) {
        this.Arrivalplace = newArrivalplace;
    }
    private LocalDate Departuedate;
    public LocalDate getDeparuedate() {
        return Departuedate;
    }
    public void setDepartuedate(LocalDate newDepartuedate) {
        this.Departuedate = newDepartuedate;
    }

    private LocalTime Arrivaltime;

    public LocalTime getArrivaltime() {
        return Arrivaltime;
    }
public void setArrivaltime(LocalTime newArrivaltime) {
        this.Arrivaltime = newArrivaltime;
}
    private String Flightstatus;
    public String getFlightstatus() {
        return Flightstatus;
    }
    public void setFlightstatus(String newFlightstatus) {
        this.Flightstatus = newFlightstatus;
    }


}
