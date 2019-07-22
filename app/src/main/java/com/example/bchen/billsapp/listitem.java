package com.example.bchen.billsapp;

public class listitem {
    private String listText;

    public listitem(final String simpleText) {
        setListItem(simpleText);
    }

    public String getListItem() {
        return listText;
    }

    public void setListItem(final String simpleText) {
        this.listText = simpleText;
    }
}
