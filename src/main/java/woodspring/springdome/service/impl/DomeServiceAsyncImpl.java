package woodspring.springdome.service.impl;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import woodspring.springdome.actions.Hummingbird;
import woodspring.springdome.service.DomeService;

@Service
@Qualifier("AsyncDome")
public class DomeServiceAsyncImpl implements DomeService {
	private static final Logger logger = LoggerFactory.getLogger(DomeServiceAsyncImpl.class);

	final static Integer LOOP_NUM = 100;
	@Override
	public String buildModel(int pId) {
		ExecutorService exSrv = Executors.newFixedThreadPool(4);
		List<Future> result = IntStream.rangeClosed(1,  LOOP_NUM)
							.mapToObj( itm -> {
			var bird = new Hummingbird( pId);
			Future<String> ret = exSrv.submit( bird);
			return ret;
			//CompletableFeature.supplyAsync(exSrv.submit( bird);
		}).collect(Collectors.toList());
StringBuffer strB = new StringBuffer();
		result.stream().forEachOrdered(item -> {
			try {
				strB.append(item.get() );
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} );
		return strB.toString();
	}

}
