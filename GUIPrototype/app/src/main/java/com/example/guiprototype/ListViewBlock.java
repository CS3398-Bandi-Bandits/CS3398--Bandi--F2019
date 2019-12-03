package com.example.guiprototype;

public class ListViewBlock {

    private String name;
    private String setData;

    public ListViewBlock(String name, String setData){
        this.name = name;
        this.setData = setData;
    }

    public String getName() {
        return name;
    }

    public String getSetData() {
        return setData;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSetData(String setData) {
        this.setData = setData;
    }
}
