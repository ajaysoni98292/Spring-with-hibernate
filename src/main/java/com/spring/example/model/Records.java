package com.spring.example.model;

/**
 * Created by insys on 12/29/2014.
 */
public class Records {
    private long totalNumberOfRecords;
    private Object listOfRecords;

    public long getTotalNumberOfRecords() {
        return totalNumberOfRecords;
    }

    public void setTotalNumberOfRecords(long totalNumberOfRecords) {
        this.totalNumberOfRecords = totalNumberOfRecords;
    }

    public Object getListOfRecords() {
        return listOfRecords;
    }

    public void setListOfRecords(Object listOfRecords) {
        this.listOfRecords = listOfRecords;
    }
}
