package com.example.packathon.model;

import java.util.ArrayList;

// A class representing the box object which consists of a list of BoxItems
public class Box {
    private ArrayList<BoxItem> boxItems;
    private Gauge gaugeForWeight;
    private double totalWeightOfBox;
    private double weightCapacity;
    private String boxType;
    private int width;
    private int height;


    //EFFECTS: Constructs the empty Box with a default box type with specified parameters
    public Box(String boxType, int width, int height, double weightCapacity) {
        this.width = width;
        this.height = height;
        this.boxType = boxType;
        boxItems = new ArrayList<>();
        gaugeForWeight = new Gauge();
        totalWeightOfBox = 0;
        this.weightCapacity = weightCapacity;
    }

    public void setWeightCapacity(double weightCapacity) {
        this.weightCapacity = weightCapacity;
    }


    public double getTotalWeightOfBox() {
        return  totalWeightOfBox;
    }

    public double getWeightCapacity() {
        return weightCapacity;
    }

    public void setTotalWeightOfBox (double weight) {
        totalWeightOfBox = weight;
    }

    //EFFECTS: adds BoxItem to Box and then calculates the percent weight
    public void addBoxItemToBox(BoxItem boxItem) {
        checkIsBoxFull();
        boxItems.add(boxItem);
        totalWeightOfBox += boxItem.getWeight();
        calculatePercentWeight();
    }

    //EFFECTS: removes BoxItem from Box and then calculates the percent weight
    public void removeBoxItemFromBox(BoxItem boxItem) {
        boxItems.remove(boxItem);
        totalWeightOfBox -= boxItem.getWeight();
        calculatePercentWeight();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getBoxType() {
        return boxType;
    }

    public ArrayList<BoxItem> getBoxItems() {
        return  boxItems;
    }

    //EFFECTS: returns a boolean if the boxisFull; otherwise false
    public boolean checkIsBoxFull() {
        boolean fullBox = false;
        if (gaugeForWeight.getPercentFull() >= 100) {
            fullBox = true;
        }
        return fullBox;
    }

    public void calculatePercentWeight(){
        gaugeForWeight.calculatePercentFull(totalWeightOfBox, weightCapacity);
    }

    public double getPercentWeight() {
        return gaugeForWeight.getPercentFull();
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setBoxType(String boxType) {
        this.boxType = boxType;
    }

    public void setBoxPropertiesBasedOnBoxType(String boxType) {
        if (boxType.equals("default")) {
            setWidth(50);
            setHeight(50);
            setWeightCapacity(100);
            setTotalWeightOfBox(0);
        }
        if (boxType.equals("special")) {
            setWidth(50);
            setHeight(50);
            setWeightCapacity(200);
            setTotalWeightOfBox(0);
        }
        if (boxType.equals("hardcore")) {
            setWidth(50);
            setHeight(50);
            setWeightCapacity(50);
            setTotalWeightOfBox(0);
        }
        if (boxType.equals("party")) {
            setWidth(100);
            setHeight(100);
            setWeightCapacity(200);
            setTotalWeightOfBox(0);
        }
        if (boxType.equals("tryhard")) {
            setWidth(25);
            setHeight(25);
            setWeightCapacity(45);
            setTotalWeightOfBox(0);
        }

    }




}

