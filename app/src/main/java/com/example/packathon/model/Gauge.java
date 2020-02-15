package com.example.packathon.model;

// A class that represents a Gauge object with the status of the gauge, and  indicates what
// level of capacity the box is current at in terms of percentage and the specific stage/status
public class Gauge {
    //Status are as follows: empty, almost_empty, moderate, partly_full, moderately_full,
    // insanely_full, full
    private String status;
    private double percentFull;
    private boolean isFull;

    //EFFECTS: Constructs a Gauge with a percentFull value of 0, and status of empty
    public Gauge() {
        status = "empty";
        percentFull = 0;
        isFull = false;
    }

    public String getStatus() {
        return status;
    }

    public double getPercentFull() {
        return percentFull;
    }

    public boolean getIsFull() {
        return isFull;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPercentFull(double percentFull) {
        this.percentFull = percentFull;
    }

    public void checkStatus(double percentFull) {
        if (percentFull <= 20 && percentFull > 0) {
            setStatus("almost_empty");
        }
        if (percentFull == 0) {
            setStatus("empty");
        }
        if (percentFull > 20 && percentFull <= 40 ) {
            setStatus(("moderate"));
        }
        if (percentFull >40 && percentFull <= 60) {
            setStatus("partly_full");
        }
        if (percentFull >60 && percentFull <=80) {
            setStatus(("moderately_full"));
        }
        if (percentFull >80 && percentFull <= 90) {
            setStatus("insanely_full");
        }
        if (percentFull >90 && percentFull <= 100) {
            setStatus("full");
            isFull = true;
        }
    }

    public void calculatePercentFull(double weightIn, double capacity) {
        percentFull = (weightIn / capacity) * 100;
    }


}
