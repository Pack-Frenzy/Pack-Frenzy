package com.example.packathon.model;

import java.util.ArrayList;

// A class representing the box object which consists of a list of BoxItems
public class Box {
    private ArrayList<BoxItem> boxItems;
    private Gauge gaugeForWeight;
    private double totalWeightOfBox;
    private double weightCapacity;
    private String boxType;

    //EFFECTS: Constructs the empty Box with a default box type with specified parameters
    public Box(int numOfPlayers) {
        this.totalWeightOfBox = 0;
        boxItems = new ArrayList<>();
        gaugeForWeight = new Gauge();

        if (numOfPlayers == 4) {
            this.boxType = "party";
            this.weightCapacity = 200;
        } else if (numOfPlayers == 3) {
            this.boxType = "special";
            this.weightCapacity = 100;
        } else if (numOfPlayers == 2) {
            boxType = "hardcore";
            this.weightCapacity = 50;
        }
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

    public String getBoxType() {
        return boxType;
    }

    public ArrayList<BoxItem> getBoxItems() {
        return boxItems;
    }

    public void setWeightCapacity(double weightCapacity) {
        this.weightCapacity = weightCapacity;
    }

    public void setTotalWeightOfBox (double weight) {
        totalWeightOfBox = weight;
    }

    public void setBoxType(String boxType) {
        if (boxType.equals("default")) {
            setWeightCapacity(100);
        }
        if (boxType.equals("special")) {
            setWeightCapacity(200);
        }
        if (boxType.equals("hardcore")) {
            setWeightCapacity(50);
        }
        if (boxType.equals("party")) {
            setWeightCapacity(200);
        }
        if (boxType.equals("tryhard")) {
            setWeightCapacity(45);
        }
    }

}

