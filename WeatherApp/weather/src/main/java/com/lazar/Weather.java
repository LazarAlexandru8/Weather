package com.lazar;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import java.net.http.HttpClient;
import java.io.IOException;
import java.awt.*;
import javax.swing.*;




public class Weather extends JFrame {

    JLabel gradeC;
    JLabel zona;

    public void GUI(){
        setTitle("Weather");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setLayout(new GridLayout(2,0));
        setSize(300,300);
        setLocationRelativeTo(null);
        
        
        // setExtendedState(java.awt.Frame.);
        ImageIcon poza = new ImageIcon("poza.jpg");
        JLabel pozaJ = new JLabel();
        pozaJ.setIcon(poza);
        // add(pozaJ);
        gradeC = new JLabel("Temperatura in grade C: ");
        add(gradeC);
        zona = new JLabel("Zona: ");
        add(zona);

        setVisible(true);
    }

    public String getWeather() {
        HttpRequest request = HttpRequest.newBuilder()
        // TODO sa generez vremea in functie de oras
				.uri(URI.create("//API for the weather"))
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
        gradeC.setText(gradeC.getText() + x);
    }

    public void setZ(String y){
        zona.setText(zona.getText() + y);
    }

}
