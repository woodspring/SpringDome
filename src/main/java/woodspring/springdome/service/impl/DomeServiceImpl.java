package woodspring.springdome.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import woodspring.springdome.actions.BlueJay;
import woodspring.springdome.service.DomeService;


@Service
@Qualifier("DomeSynch")
public class DomeServiceImpl implements DomeService {
	
	private static final Logger logger = LoggerFactory.getLogger(DomeServiceImpl.class);

	final static Integer LOOP_NUM = 100;

	@Override
	public String buildModel(int pId) {
		
		List<String> ret = IntStream.rangeClosed(1, LOOP_NUM)
							.mapToObj( item -> {
									BlueJay blueJay = new BlueJay( pId, item);
									String retStr = blueJay.flying( pId);
									return retStr;
								})
							.collect(Collectors.toList());
		StringBuffer strB = new StringBuffer();
		ret.stream().forEachOrdered(item -> strB.append( pId+"  "+ item));
		return strB.toString();
	}


}
