package woodspring.springdome.model;

public class FlyData {
	int pId;
	int lId;
	double mean;
	double variance;
	double sD;
	double confd99Up;
	double confd99Low;
	double pTime;
	public FlyData setPId(int proId) {
		this.pId = proId;
		return this;		
	}
	public int getpId() {
		return pId;
	}
	public FlyData setpId(int pId) {
		this.pId = pId;
		return this;
	}
	public FlyData setLId(int loopId) {
		this.lId = loopId;
		return this;		
	}
	public int getLoopId() {
		return lId;
	}
	public double getMean() {
		return mean;
	}
	public FlyData setMean(double mean) {
		this.mean = mean;
		return this;
	}
	public double getVariance() {
		return variance;
	}
	public FlyData setVariance(double variance) {
		this.variance = variance;
		return this;
	}
	public double getsD() {
		return sD;
	}
	public FlyData setsD(double sD) {
		this.sD = sD;
		return this;
	}
	public double getConfd99Up() {
		return confd99Up;
	}
	public FlyData setConfd99Up(double conf95) {
		this.confd99Up = conf95;
		return this;
	}
	public double getConfd99Low() {
		return confd99Low;
	}
	public FlyData setConfd99Low(double confd99) {
		this.confd99Low = confd99;
		return this;
	}
	public double getpTime() {
		return pTime;
	}
	public void setpTime(double pTime) {
		this.pTime = pTime;
	}
	
	//@Override
	//public String toString() {
	//	return "FlyData [pId=" + pId + ", lId=" + lId + ", mean=" + mean + ", variance=" + variance + ", sD=" + sD
	//			+ ", confd99Up=" + confd99Up + ", confd99Low=" + confd99Low + ", pTime=" + pTime + "]";
	//}

	
}
