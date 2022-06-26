package woodspring.springdome.actions;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import woodspring.springdome.model.FlyData;


//@Component
public class BlueJay {
private static final Logger logger = LoggerFactory.getLogger( BlueJay.class);
	
	private final static Integer R_NUMBER = 100;
	
	private int prodId=0;
	private int loopId = 0;
	private Random  rand;
	public BlueJay( int prodId, int loopId) {
		this.prodId = prodId;
		this.loopId = loopId;
		rand =  new Random ( prodId+loopId);
	}
	
	public FlyData flying(int proId) {
		long startTime = System.nanoTime();
		FlyData flyData = new FlyData();
		flyData.setPId( proId);
		flyData.setLId( this.loopId);
		//Random  rand =  new Random ( proId);
		double[] numbers = IntStream.rangeClosed(1, R_NUMBER)
				.mapToDouble(ind -> 
					rand.nextGaussian()
				).toArray();
				
		double mean = Arrays.stream(numbers).average().getAsDouble();
		double variance = Arrays.stream( numbers).map(ind -> ind - mean)
				.map( ind -> ind*ind)
				.map( ind -> ind).average().orElse( numbers[0]);
		double sDerivation = Math.sqrt(variance);
		double alpha = (1 - 0.99) / 2;
		int n = numbers.length;
		double value = alpha*sDerivation/Math.sqrt(n);
		flyData.setMean( mean).setVariance(variance).setsD(sDerivation)
		.setConfd99Low( mean - value).setConfd99Up( mean + value)
		.setpTime( System.nanoTime() - startTime);
		
		return flyData;
	}
	
	
}
