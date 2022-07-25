package woodspring.springdome.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import woodspring.springdome.actions.BlueJay;
import woodspring.springdome.model.FlyData;
import woodspring.springdome.service.DomeService;


@Service
@Qualifier("DomeSynch")
public class DomeServiceImpl implements DomeService {
	
	private static final Logger logger = LoggerFactory.getLogger(DomeServiceImpl.class);

	final static Integer LOOP_NUM = 1001;

	@Override
	public List<FlyData> buildModel(int pId) {
		List<FlyData> fList = new ArrayList<>();
		for (int item=1; item < (pId+1); item++) {
			BlueJay blueJay = new BlueJay( pId, item);
			FlyData flyData = blueJay.flying( item);
			fList.add( flyData);
		}
		
		//List<FlyData> ret = IntStream.rangeClosed(1, LOOP_NUM)
		//List<String> ret = IntStream.rangeClosed(1, LOOP_NUM)
		//					.mapToObj( item -> {
		//							BlueJay blueJay = new BlueJay( pId, item);
		//							FlyData flyData = blueJay.flying( pId);
		//							return retStr;
		//						})
		//					.collect(Collectors.toList());
		//StringBuffer strB = new StringBuffer();
		//ret.stream().forEachOrdered(item -> strB.append( pId+"  "+ item));
		return fList;
	}


}
