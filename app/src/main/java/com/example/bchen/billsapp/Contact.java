package com.example.bchen.billsapp;

public class Contact {
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
