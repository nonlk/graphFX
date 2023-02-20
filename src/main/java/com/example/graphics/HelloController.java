package com.example.graphics;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    LineChart<Number, Number> lineChart;

    SearchABC searchABC = new SearchABC();
    private double [] x = searchABC.getX();
    private double [] y = searchABC.getY();
    private double [] yCalc = searchABC.getY();

    private double a = searchABC.searchArg(1);
    private double b = searchABC.searchArg(2);
    private double c = searchABC.searchArg(3);

    private double [] calculationY (double [] y, double [] x) {
        for (int i = 0; i < 20; i++) {
            y[i] = a * x[i] * x[i] + b * x[i] + c;
        }
        return y;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        XYChart.Series<Number, Number> firstSeries = new XYChart.Series<>();
        XYChart.Series<Number, Number> searchSeries = new XYChart.Series<>();
        searchSeries.setName("Искомый график");
        firstSeries.setName("Начальный график");
        for (int i = 0; i < 20; i++) {
            firstSeries.getData().add(new XYChart.Data(x[i], y[i]));
        }
        yCalc = calculationY(yCalc, x);
        for (int i = 0; i < 20; i++) {
            searchSeries.getData().add(new XYChart.Data(x[i], yCalc[i]));
        }
        lineChart.getData().addAll(firstSeries, searchSeries);
    }

}