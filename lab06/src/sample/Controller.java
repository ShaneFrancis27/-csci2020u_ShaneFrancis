package sample;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

public class Controller {

    @FXML
    Canvas mainCanvas;
    @FXML
    GraphicsContext gc;

    // Bar chart data
    private static double[] avgHousingPricesByYear = {
            247381.0, 264171.4, 287715.3, 294736.1, 308431.4, 322635.9, 340253.0, 363153.7
    };
    private static double[] avgCommercialPricesByYear = {
            1121585.3, 1219479.5, 1246354.2, 1295364.8, 1335932.6, 1472362.0, 1583521.9, 1613246.3
    };


    // Pie chart data
    private static String[] ageGroups = {
            "18-25", "26-35", "36-45", "46-55", "56-65", "65+"
    };
    private static int[] purchasesByAgeGroup = {
            648, 1021, 2453, 3173, 1868, 2247
    };
    private static Color[] pieColours = {
            Color.AQUA, Color.GOLD, Color.DARKORANGE, Color.DARKSALMON, Color.LAWNGREEN, Color.PLUM
    };


    @FXML
    private BarChart<Number, Number> barChart;

    @FXML
    private CategoryAxis years;

    @FXML
    private NumberAxis price;


    @FXML
    public void initialize() {

        gc = mainCanvas.getGraphicsContext2D();
        drawBChart(Controller.avgHousingPricesByYear, Controller.avgCommercialPricesByYear, 300, 150);
        drawPChart(1000,purchasesByAgeGroup,pieColours);

    }

    public void drawBChart(double[] housingData, double[] commercialData, int w, int h) {
        double dataPointOffset = 5.0;
        double xInc = (w / (housingData.length + commercialData.length + dataPointOffset)) / 2;


        double maxVal = housingData[0];
        double minVal = housingData[0];

        for (int i = 1; i < housingData.length; i++) {


            if (housingData[i] < minVal) {
                minVal = housingData[i];
            }

            if (commercialData[i] < minVal) {
                minVal = commercialData[i];
            }

            if (housingData[i] > maxVal) {


                maxVal = housingData[i];
            }

            if (commercialData[i] > maxVal) {
                maxVal = commercialData[i];
            }
        }

        double offset = 0.0;
        for (int i = 0; i < housingData.length; i++) {
            double height = (housingData[i] / maxVal) * h;
            double x = (xInc * 2) * i;
            gc.setFill(Color.RED);
            gc.fillRect(x + offset, (h - height), xInc, height);

            height = (commercialData[i] / maxVal) * h;
            gc.setFill(Color.BLUE);
            gc.fillRect(x + xInc + offset, (h - height), xInc, height);


            offset += dataPointOffset;
        }
    }

    public void drawPChart ( int x, int[]purchases,Color[]colors){


        double total = 0;
        int length = purchases.length;

        for (int i = 0; i < length; i++) {
            total = total + purchases[i];
        }


        double start = 0.0;
        for (int i = 0; i < length; i++) {

            gc.setFill(colors[i]);
            double newAngle = 360 * (purchases[i] / total);

            gc.fillArc(x / 2, 0, 300, 300, start, newAngle, ArcType.ROUND);

            start = start + newAngle;

        }
    }


}
