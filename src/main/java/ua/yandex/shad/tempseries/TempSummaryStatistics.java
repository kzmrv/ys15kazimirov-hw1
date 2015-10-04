package ua.yandex.shad.tempseries;

public class TempSummaryStatistics {
	public final double avgTemp;
	public final double devTemp;
	public final double minTemp;
	public final double maxTemp;
	public TempSummaryStatistics(double _avgTemp, double _devTemp, double _minTemp, double _maxTemp){
		avgTemp = _avgTemp;
		devTemp = _devTemp;
		minTemp = _minTemp;
		maxTemp = _maxTemp;
	}
	
}
