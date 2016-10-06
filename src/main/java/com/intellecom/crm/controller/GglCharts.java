package com.intellecom.crm.controller;

import static com.googlecode.charts4j.Color.*;
import static com.googlecode.charts4j.UrlUtil.normalize;

import java.util.Arrays;

import com.googlecode.charts4j.AxisLabels;
import com.googlecode.charts4j.AxisLabelsFactory;
import com.googlecode.charts4j.AxisStyle;
import com.googlecode.charts4j.AxisTextAlignment;
import com.googlecode.charts4j.Color;
import com.googlecode.charts4j.Data;
import com.googlecode.charts4j.DataUtil;
import com.googlecode.charts4j.Fills;
import com.googlecode.charts4j.GCharts;
import com.googlecode.charts4j.Line;
import com.googlecode.charts4j.LineChart;
import com.googlecode.charts4j.LineStyle;
import com.googlecode.charts4j.LinearGradientFill;
import com.googlecode.charts4j.Plots;
import com.googlecode.charts4j.Shape;



import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Arrays;

/**
 * Created by MKrasnyi on 16.08.2016.
 */
@Controller
@RequestMapping("/gcharts")
public class GglCharts {
    @RequestMapping(value="/pie",method = RequestMethod.GET)
    public String drawPiechart(ModelMap model){

        final double[] sp500 = { 62.960, 74.560, 84.300, 92.200, 95.890, 103.800, 91.600, 92.270, 96.870, 116.930, 97.540, 67.160, 89.770, 106.880, 94.750, 96.280, 107.840, 135.330, 122.300, 140.340, 164.860, 166.260, 210.680, 243.370,
                247.840, 277.080, 350.680, 328.710, 415.140, 438.820, 468.660, 460.920, 614.120, 753.850, 970.840, 1231.93, 1464.47, 1334.22, 1161.02, 879.390, 1109.64, 1213.55, 1258.17, 1424.71, 1475.25 };
        final double INFLATION = 0.035;

        final double[] inflation = new double[sp500.length];
        inflation[0] = sp500[0];
        for (int i = 1; i < inflation.length; i++) {
            inflation[i] = inflation[i-1] *INFLATION + inflation[i-1];
        }

        Line line1 = Plots.newLine(DataUtil.scaleWithinRange(0,1500,sp500), YELLOW, "S & P 500");
        line1.setLineStyle(LineStyle.newLineStyle(3, 1, 0));
        line1.addShapeMarkers(Shape.CIRCLE, YELLOW, 10);
        line1.addShapeMarkers(Shape.CIRCLE, BLACK, 7);
        line1.addShapeMarker(Shape.VERTICAL_LINE_PARTIAL, BLUE,3,8);
        line1.addShapeMarker(Shape.VERTICAL_LINE_PARTIAL, BLUE,3,17);
        line1.addShapeMarker(Shape.VERTICAL_LINE_PARTIAL, BLUE,3,24);
        line1.addShapeMarker(Shape.VERTICAL_LINE_PARTIAL, BLUE,3,40);
        line1.setFillAreaColor(LIGHTYELLOW);

        Line line2 = Plots.newLine(DataUtil.scaleWithinRange(0,1500,inflation), LIMEGREEN, "Inflation");
        line2.setLineStyle(LineStyle.newLineStyle(3, 1, 0));
        line2.addShapeMarkers(Shape.CIRCLE, LIME, 10);
        line2.addShapeMarkers(Shape.CIRCLE, BLACK, 7);
        line2.setFillAreaColor(LIGHTGREEN);


        // Defining chart.
        LineChart chart = GCharts.newLineChart(line1,line2);
        chart.setSize(600, 450);
        chart.setTitle("S & P 500|1962 - 2008", WHITE, 14);

        // Defining axis info and styles
        AxisStyle axisStyle = AxisStyle.newAxisStyle(WHITE, 12, AxisTextAlignment.CENTER);
        AxisLabels yAxis = AxisLabelsFactory.newNumericRangeAxisLabels(0, sp500[sp500.length-1]);
        yAxis.setAxisStyle(axisStyle);
        AxisLabels xAxis1 = AxisLabelsFactory.newAxisLabels(Arrays.asList("Fed Chiefs:","Burns","Volcker","Greenspan","Bernanke"), Arrays.asList(5,18,39,55,92));
        xAxis1.setAxisStyle(axisStyle);
        AxisLabels xAxis2 = AxisLabelsFactory.newNumericRangeAxisLabels(1962, 2008);
        xAxis2.setAxisStyle(axisStyle);
        AxisLabels xAxis3 = AxisLabelsFactory.newAxisLabels("Year", 50.0);
        xAxis3.setAxisStyle(AxisStyle.newAxisStyle(WHITE, 14, AxisTextAlignment.CENTER));

        // Adding axis info to chart.
        chart.addYAxisLabels(yAxis);
        chart.addXAxisLabels(xAxis1);
       // chart.addXAxisLabels(xAxis2);
      //  chart.addXAxisLabels(xAxis3);
        chart.setGrid(100, 6.78, 5, 0);

        //

        // Defining background and chart fills.
       // chart.setBackgroundFill(Fills.newSolidFill(Color.BLACK));
       // chart.setAreaFill(Fills.newSolidFill(Color.newColor("708090")));
        String url = chart.toURLString();

        model.addAttribute("PieUrl", url);
        return "GPieChart";
    }
}
