package ua.yandex.shad.tempseries;
import java.math.*;
import java.util.InputMismatchException;

public class TemperatureSeriesAnalysis {
	public static final double absolute_minimum = -273.0;
	public double[] values;
	public int arrayLength;
	
    public TemperatureSeriesAnalysis() {
    	values = new double[0];
    	arrayLength = 0;
    }
    
    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
    	arrayLength = temperatureSeries.length;
        this.values = new double [arrayLength];
        for(int i=0;i<temperatureSeries.length;i++){
        	values[i] = temperatureSeries[i];
        }
    }
    
    public double average(){
    	if(arrayLength == 0)
    		throw new IllegalArgumentException();
    	double sum=0;
    	for(int i=0;i<arrayLength;i++){
    		sum+=values[i];
    	}
    	return sum/arrayLength;
    }    
    
    public double deviation(){
    	double average = this.average();
    	double sum = 0;
    	for(int i=0;i<arrayLength;i++){
    		sum+=(values[i]-average)*(values[i]-average);
    	}
    	sum/=arrayLength; 
    	return Math.sqrt(sum);
    }
    
    public double min(){
        if(arrayLength == 0)
        	throw new IllegalArgumentException();
        double minTemp = values[0];
        for(int i=0;i<arrayLength;i++){
        	if(values[i]<minTemp)
        		minTemp = values[i];
        }
        return minTemp;
    }
     
    public double max(){
    	if(arrayLength == 0)
        	throw new IllegalArgumentException();
        double maxTemp = values[0];
        for(int i=1;i<arrayLength;i++){
        	if(values[i]>maxTemp)
        		maxTemp = values[i];
        }
        return maxTemp;
    }
    
    public double findTempClosestToZero(){
    	if(arrayLength == 0)
    		throw new IllegalArgumentException();
    	double minModule = Math.abs(values[0]);
    	double result = values[0];
        for(int i=1;i<arrayLength;i++){
        	double element = values[i];
        	if(Math.abs(element)<minModule){
        		minModule = Math.abs(element);
        		result = element;
        	}
        	if((Math.abs(element)==minModule)&&(result<0)){
        		result = element;
        	}
        }
        return result;
    }
    
    public double findTempClosestToValue(double tempValue){
    	if(arrayLength == 0)
    		throw new IllegalArgumentException();
    	double minModule = Math.abs(values[0]-tempValue);
    	double result = values[0];
        for(int i=1;i<arrayLength;i++){
        	double element = values[i];
        	if(Math.abs(element-tempValue)<minModule){
        		minModule = Math.abs(element-tempValue);
        		result = element;
        	}
        	if((Math.abs(element-tempValue)==minModule)&&(result<0)){
        		result = element;
        	}
        }
        return result;
    }
    
    public double[] findTempsLessThan(double tempValue){
    	if(arrayLength == 0)
    		throw new IllegalArgumentException();
    	double[] temporary = new double[arrayLength];
    	int count=0;
    	for(int i=0;i<arrayLength;i++){
    		if(values[i]<tempValue){
    			temporary[count] = values[i];
    			count++;    			
    		}
    	}
    	double[] result = new double[count]; 
    	for(int i=0;i<count;i++)
    	{
    		result[i] = temporary[i];
    	}    		
        return result;
    }
    
    public double[] findTempsGreaterThan(double tempValue){
    	if(arrayLength == 0)
    		throw new IllegalArgumentException();
    	double[] temporary = new double[arrayLength];
    	int count=0;
    	for(int i=0;i<arrayLength;i++){
    		if(values[i]>=tempValue){
    			temporary[count] = values[i];
    			count++;    			
    		}
    	}
    	double[] result = new double[count]; 
    	for(int i=0;i<count;i++)
    	{
    		result[i] = temporary[i];
    	}    		
        return result;
    }
    
    public TempSummaryStatistics summaryStatistics(){
        return new TempSummaryStatistics(average(),deviation(),min(),max());
    }
    
    public int addTemps(double ... temps){
    	for(int i=0;i<temps.length;i++){
    		if(temps[i]<absolute_minimum){
    			throw new InputMismatchException();
    		}
    	}
    	System.out.println("Arr" + arrayLength);
    	System.out.println("Len" + temps.length);
    	int expectedLength = values.length;
    	System.out.println("ExpLen" + expectedLength);
    	if(expectedLength == 0)
    		expectedLength = temps.length;
    	while(temps.length+arrayLength>expectedLength)
    		expectedLength*=2;
    	System.out.println("ExpLen" + expectedLength);
    	double[] result = new double [expectedLength];
    	for(int i=0;i<arrayLength;i++){
    		result[i] = values[i];
    	}
    	for(int i=arrayLength;i<arrayLength+temps.length;i++){
    		result[i] = temps[i-arrayLength];
    	}
    	this.arrayLength += temps.length;
    	this.values = result;
        return arrayLength;
    }
}
