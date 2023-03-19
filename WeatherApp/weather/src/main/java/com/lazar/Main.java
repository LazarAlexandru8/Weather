package com.lazar;

import org.json.JSONObject;

public class Main {
    public static void main(String[] args) {
        Weather obj = new Weather();
        JSONObject jsonObj = new JSONObject(obj.getWeather());
        Float temp = jsonObj.getJSONObject("current").getFloat("temp_c");
        String temperatura = temp.toString();
        String zona = jsonObj.getJSONObject("location").getString("name");
        obj.GUI();
        obj.setC(temperatura);
        obj.setZ(zona);
    }
}