package com.geektrust.backend.entities;

import java.time.LocalDate;

public class Subscription {

    private LocalDate startDate;
    private Status status=Status.NOT_STARTED;

    public Subscription(LocalDate startDate, Status status) {
        this.startDate = startDate;
        this.status = status;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }



}
