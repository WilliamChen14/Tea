package com.example.bchen.billsapp;

import java.util.List;

public class Contact {

    private int key;
    private String name;
    private String birthday;
    private String phonenumber;
    private List<String> extra;
    private String listText;

    public Contact(final String simpleText) {
        setListItem(simpleText);
    }

    public String getListItem() {
        return listText;
    }

    public void setListItem(final String simpleText) {
        this.listText = simpleText;
    }
}
