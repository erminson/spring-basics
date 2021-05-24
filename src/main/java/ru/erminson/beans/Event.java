package ru.erminson.beans;

import java.text.DateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Event {
    private static final AtomicInteger AUTO_ID = new AtomicInteger(0);

    private int id;
    private String msg;
    private Date date;

    private DateFormat dateFormat;

    public Event(int id, String msg, Date date) {
        this.id = id;
        this.msg = msg;
        this.date = date;
    }

    public Event(Date date, DateFormat dateFormat) {
        this.id = AUTO_ID.getAndIncrement();

        this.date = date;
        this.dateFormat = dateFormat;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setDateFormat(DateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    public int getId() {
        return id;
    }

    public String getMsg() {
        return msg;
    }

    public Date getDate() {
        return date;
    }

    public DateFormat getDateFormat() {
        return dateFormat;
    }

    @Override
    public String toString() {
        return "Event [" +
                "id=" + id +
                ", msg='" + msg + '\'' +
                ", date=" + dateFormat.format(date) +
                ']';
    }
}
