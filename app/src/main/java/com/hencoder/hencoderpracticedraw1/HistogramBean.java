package com.hencoder.hencoderpracticedraw1;

public class HistogramBean {
    public HistogramBean() {
    }

    public HistogramBean(String itemName, int itemCount) {
        ItemName = itemName;
        ItemCount = itemCount;
    }

    private String ItemName;
    private int ItemCount;

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public int getItemCount() {
        return ItemCount;
    }

    public void setItemCount(int itemCount) {
        ItemCount = itemCount;
    }
}
