package ua.yandex.shad.tempseries;

import static org.junit.Assert.*;
import org.junit.Test;
import java.lang.IllegalArgumentException;
import java.util.InputMismatchException;

public class TemperatureSeriesAnalysisTest {
	@Test(expected = IllegalArgumentException.class)
	public void testAverage_failOnEmpty() {
		double[] temperatureSeries = {};
		TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		double result = seriesAnalysis.average();

	}
    @Test
    public void testAverage_testResult() {
        double[] temperatureSeries = {1.0, -10.0, -1.0, 5.0, 60};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 11.0;
        double actualResult = seriesAnalysis.average();
        assertEquals(expResult, actualResult, 0.00001);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testDeviation_failOnEmpty(){
    	double[] temperatureSeries = {};
    	TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		double actualResult = seriesAnalysis.deviation();
    }
    @Test
    public void testDeviation_manyElements(){
    	double[] temperatureSeries = {-15.0,10.0,20.0};
    	TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		double actualResult = seriesAnalysis.deviation();
		double expResult = Math.sqrt(650/3.0);
		assertEquals(expResult,actualResult,0.00001);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testMin_failOnEmpty() {
    	double[] temperatureSeries = {};
    	TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		double result = seriesAnalysis.min();
    	
    }
    @Test
    public void testMin_testResult() {
    	double[] temperatureSeries = {2.0,10.0,100.0,-2.0,-10.0,0.0};
    	TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -10.0;
        double actualResult = seriesAnalysis.min();
        assertEquals(expResult, actualResult, 0.00001);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testMax_failOnEmpty() {
    	double[] temperatureSeries = {};
    	TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		double result = seriesAnalysis.max();
    	
    }
    @Test
    public void testMax_testResult() {
    	double[] temperatureSeries = {2.0,10.0,100.0,-2.0,-10.0,0.0};
    	TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 100;
        double actualResult = seriesAnalysis.max();
        assertEquals(expResult, actualResult, 0.00001);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testFindTempClosestToZero_failOnEmpty(){
    	double[] temperatureSeries = {};
    	TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
    	double expResult = seriesAnalysis.findTempClosestToZero();
    }

    @Test
    public void testFindTempClosestToZero_oneElement(){
    	double[] temperatureSeries = {-4.0};
    	TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
    	double expResult = -4.0;
    	double actualResult = seriesAnalysis.findTempClosestToZero();
    	assertEquals(expResult,actualResult,0.00001);    	
    }
    
    @Test 
    public void testFindTempClosestToZero_testWithZero(){
    	double[] temperatureSeries = {9.5, 0.0 ,-10.0, -0.5};
    	TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
    	double expResult = 0.0;
    	double actualResult = seriesAnalysis.findTempClosestToZero();
    	assertEquals(expResult,actualResult,0.00001);
    }
    
    @Test
    public void testFindTempClosestToZero_manyElements(){
    	double[] temperatureSeries = {9.5, 25.0 ,-10.0, -4.5,99.0};
    	TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
    	double expResult = -4.5;
    	double actualResult = seriesAnalysis.findTempClosestToZero();
    	assertEquals(expResult,actualResult,0.00001);
    }
    
    @Test
    public void testFindTempClosestToZero_equalModule(){
    	double[] temperatureSeries = {9.5, 25.0, -10.0, -4.5, 99.0, 4.5, 9.0};
    	TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
    	double expResult = 4.5;
    	double actualResult = seriesAnalysis.findTempClosestToZero();
    	assertEquals(expResult,actualResult,0.00001);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testFindTempClosestToValue_failOnEmpty(){
    	double[] temperatureSeries = {};
    	TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
    	double actualResult = seriesAnalysis.findTempClosestToValue(0.0);
    }
    
    @Test
    public void testFindTempClosestToValue_oneElement(){
    	double[] temperatureSeries = {15.0};
    	TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
    	double actualResult = seriesAnalysis.findTempClosestToValue(10.0);
    	double expResult = 15.0;
    	assertEquals(expResult,actualResult,0.00001);
    }
    
    @Test
    public void testFindTempClosestToValue_manyElements(){
    	double[] temperatureSeries = {15.0,0.0,-10.0,-1.0,9.0,5.0,2.0};
    	TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
    	double actualResult = seriesAnalysis.findTempClosestToValue(4.0);
    	double expResult = 5.0;
    	assertEquals(expResult,actualResult,0.00001);
    }
    
    @Test
    public void testFindTempClosestToValue_equalModule(){
    	double[] temperatureSeries = {15.0,-5.0,-10.0,9.0,5.0};
    	TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
    	double actualResult = seriesAnalysis.findTempClosestToValue(0.0);
    	double expResult = 5.0;
    	assertEquals(expResult,actualResult,0.00001);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testFindTempsLessThan_failOnEmpty(){
    	double[] temperatureSeries = {};
    	TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
    	double[] actualResult = seriesAnalysis.findTempsLessThan(1.0);
    }
    
    @Test
    public void testFindTempsLessThan_oneElement(){
    	double[] temperatureSeries = {5};
    	TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
    	double[] actualResult = seriesAnalysis.findTempsLessThan(1.0);
    	double[] expResult  = {};
    	assertArrayEquals(expResult,actualResult,0.00001);
    }
    
    @Test
    public void testFindTempsLessThan_manyElements(){
    	double[] temperatureSeries = {5.0, 9.0, -10.0, -12.0, 2.0, 20.0};
    	TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
    	double[] actualResult = seriesAnalysis.findTempsLessThan(5.0);
    	double[] expResult  = {-10.0, -12.0, 2.0};
    	assertArrayEquals(expResult,actualResult,0.00001);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testFindTempsGreaterThan_failOnEmpty(){
    	double[] temperatureSeries = {};
    	TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
    	double[] actualResult = seriesAnalysis.findTempsGreaterThan(1.0);
    }
    
    @Test
    public void testFindTempsGreaterThan_oneElement(){
    	double[] temperatureSeries = {-2.0};
    	TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
    	double[] actualResult = seriesAnalysis.findTempsGreaterThan(1.0);
    	double[] expResult  = {};
    	assertArrayEquals(expResult,actualResult,0.00001);
    }
    
    @Test
    public void testFindTempsGreaterThan_manyElements(){
    	double[] temperatureSeries = {5.0, 9.0, -10.0, -12.0, -5.0, 2.0, 20.0};
    	TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
    	double[] actualResult = seriesAnalysis.findTempsGreaterThan(-5.0);
    	double[] expResult  = {5.0,9.0,-5.0,2.0,20.0};
    	assertArrayEquals(expResult,actualResult,0.00001);
    }
    @Test
    public void testSummaryStatistics_testAverageValue(){
    	double[] temperatureSeries = {1.0, -10.0, -1.0, 5.0, 60};
    	TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
    	TempSummaryStatistics statistics = seriesAnalysis.summaryStatistics();
    	assertEquals(statistics.avgTemp, 11.0, 0.0001);
    }
    @Test(expected=InputMismatchException.class)
    public void testAddTemps_testOnLessThanAbsoluteMin(){
    	double[] temperatureSeries = {};
    	double[] newTempSeries = {4.2,5.0, -273.0, -274.0};
    	TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
    	seriesAnalysis.addTemps(newTempSeries);
    }
    @Test
    public void testAddTemps_needToResize(){
    	double[] temperatureSeries = {2.0,6.0,8.0,0.0};
    	double[] newTempSeries = {4.2, 5.0,-50.0};
    	TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
    	seriesAnalysis.addTemps(newTempSeries);
    	double[] actualResult = seriesAnalysis.values;
    	double[] expResult = {2.0,6.0,8.0,0.0,4.2,5.0,-50.0,0.0};
    	assertArrayEquals(expResult,actualResult,0.00001);
    }
    @Test
    public void testAddTemps_multupleAdding(){
    	double[] temperatureSeries = {2.0};
    	double[] newTempSeries = {4.0, 5.0,-50.0,4.0};
    	double[] extraTempSeries = {6.0};
    	TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
    	seriesAnalysis.addTemps(newTempSeries);
    	seriesAnalysis.addTemps(extraTempSeries);
    	double[] actualResult = seriesAnalysis.values;
    	double[] expResult = {2.0,4.0, 5.0,-50.0,4.0,6.0,0.0,0.0};
    	assertArrayEquals(expResult,actualResult,0.00001);
    	
    }
    @Test
    public void testAddTemps_addToEmpty(){
    	double[] temperatureSeries = {};
    	double[] newTempSeries = {4.2, 5.0,-50.0};
    	double[] extraTempSeries = {6.0,9.0};
    	TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
    	seriesAnalysis.addTemps(newTempSeries);
    	seriesAnalysis.addTemps(extraTempSeries);
    	double[] actualResult = seriesAnalysis.values;
    	double[] expResult = {4.2,5.0,-50.0,6.0,9.0,0.0};
    	assertArrayEquals(expResult,actualResult,0.00001);
    }
    @Test
    public void testAddTemps_checkArrayLen(){
    	double[] temperatureSeries = {};
    	double[] newTempSeries = {4.2, 5.0,-50.0};
    	double[] extraTempSeries = {6.0};
    	TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
    	seriesAnalysis.addTemps(newTempSeries);
    	int actualResult = seriesAnalysis.addTemps(extraTempSeries);
    	int expResult = 4;
    	assertEquals(expResult,actualResult);
    }

    
}
