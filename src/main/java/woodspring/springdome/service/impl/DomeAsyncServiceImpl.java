package woodspring.springdome.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import woodspring.springdome.actions.BlueJay;
import woodspring.springdome.model.FlyData;
import woodspring.springdome.service.DomeService;


@Service
@Qualifier("DomeAsync")
public class DomeAsyncServiceImpl implements DomeService {
	private static final Logger logger = LoggerFactory.getLogger(DomeAsyncServiceImpl.class);


	@Async
	@Override
	public List<FlyData> buildModel(int pId) {
		List<FlyData> fList = new ArrayList<>();
		for (int item=1; item < (pId+1); item++) {
			BlueJay blueJay = new BlueJay( pId, item);
			FlyData flyData = blueJay.flying( item);
			fList.add( flyData);
		}
		return fList;
	}

}
