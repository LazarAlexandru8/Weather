package com.lazar;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import java.net.http.HttpClient;
import java.io.IOException;
import java.awt.*;
import javax.swing.*;

import org.json.JSONObject;




public class Weather extends JFrame {

    JLabel gradeC;
    JLabel zona;
    JButton button;
    JTextField field;
    String temperatura;

    public void GUI(){
        setTitle("Weather");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setLayout(new GridLayout(4,0));
        setSize(300,300);
        setLocationRelativeTo(null);
        
        

        gradeC = new JLabel("Temperatura in grade C: ");
        add(gradeC);
        zona = new JLabel("Zona: ");
        add(zona);
        field = new JTextField();
        add(field);
        button = new JButton("ENTER");
        add(button);
        button.addActionListener((e)-> {
            String city = field.getText();
            setZ(city);
            JSONObject jsonObj = new JSONObject(getWeather(city));
            Float temp = jsonObj.getJSONObject("current").getFloat("temp_c");
            String temperatura = temp.toString();
            setC(temperatura);

        });
        setVisible(true);
    }

    public String getWeather(String city) {
        HttpRequest request = HttpRequest.newBuilder()
        // TODO sa generez vremea in functie de oras
				.uri(URI.create("http://api.weatherapi.com/v1/current.json?key="The key of the API"="+ city + "&aqi=no")) // Add API key
                .method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
        HttpResponse<String> response = null;
        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return response == null ? "Failure" : response.body();
    }

    public void setC(String x){
        gradeC.setText("Temperatura in grade C: " + x);
    }

    public void setZ(String y){
        zona.setText("Zona: " + y);
    }

}
