package prefixaverage;
	
import java.util.Arrays;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,500,500);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());		
			
			final NumberAxis xAxis = new NumberAxis();
	        final NumberAxis yAxis = new NumberAxis();
	        
	        xAxis.setLabel("Array Size");
	        yAxis.setLabel("Time");
			
	        final LineChart<Number,Number> lineChart = 
	                new LineChart<Number,Number>(xAxis,yAxis);
	        
	        lineChart.setTitle("Prefix Average");
	        
	        XYChart.Series series1 = new XYChart.Series();
	        XYChart.Series series2 = new XYChart.Series();
	        series1.setName("O(n\u00B2)");
	        series2.setName("O(n)");
	        
	        for(int i=0;i<11;i+=1) {
	        	double[] x=new double[i];
	        	series1.getData().add(new XYChart.Data(x.length,3*x.length*x.length+5*x.length+4));
	        	series2.getData().add(new XYChart.Data(x.length,7*x.length+5));
	        }
	        
	        lineChart.getData().add(series1);
	        lineChart.getData().add(series2);
	        
	        root.setCenter(lineChart);
	        
	        primaryStage.setScene(scene);
			primaryStage.show();
	        
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public static double[] prefixAverage1(double[] x) {
		int n=x.length;
		double[] a=new double[n];
		for(int j=0;j<n;j++) {
			double total=0;
			for(int i=0;i<=j;i++) {
				total+=x[i];
				a[j]=total/(j+1);
			}
		}
		return a;
	}
	
	public static double[] prefixAverage2(double[] x) {
		int n=x.length;
		double[] a=new double[n];
		double total=0;
		for(int j=0;j<n;j++) {
			total+=x[j];
			a[j]=total/(j+1);
		}		
		return a;
	}	
}
