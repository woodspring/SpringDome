package woodspring.springdome.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import woodspring.springdome.model.FlyData;
import woodspring.springdome.service.DomeService;

@RestController
@RequestMapping("/dome")
public class DomeController {
	private final static Logger logger = LoggerFactory.getLogger(DomeController.class);
	
	
	@Autowired
	@Qualifier("DomeSynch")
	DomeService synchDome;
	
	//@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping("/loop")
	public List<FlyData> dome(@RequestParam(value="num", required = false, defaultValue = "150") String num) {
	//public String dome(@RequestParam(required = false, defaultValue = "100") String loopNum) {
		logger.info("--> DomeController, num:{}", num);
		long runtime =  System.nanoTime();
		var ret = synchDome.buildModel(Integer.valueOf(num).intValue());
		
		logger.info("<--[{}]--  DomeController, num:{}, ret size:{}, ret:{}", ((System.nanoTime() - runtime) * 10E-10), ret.size(), ret.toString());
		return ret;
		
	}
	
	@GetMapping({"/action", "/action/{times}"})
	public List<FlyData> doAction(@PathVariable(required = false)int times) {
		logger.info("--> DomeController,ACTION times:{}", times);
		long runtime =  System.nanoTime();
		var ret = synchDome.buildModel(times);
		
		logger.info("<--[{}]--  DomeController ACTION END for , times:{}", ((System.nanoTime() - runtime) * 10E-10), ret.size());
		return ret;
	}
	
	@GetMapping({"/action", "/actionTime/{ind}"})
	public String doActionTime(@PathVariable(required = true)int ind) {
		int times = 100;
		StringBuffer strBuf = new StringBuffer();
		logger.info("--> DomeController,{} ACTION {} times:", ind, times);
		strBuf.append(String.format("--> DomeController, %d ACTION %d times:", ind, times));
		long runtime =  System.nanoTime();
		var ret = synchDome.buildModel(times);
		strBuf.append(String.format("<--[%d] time: [%15.8f]--  DomeController ACTION END for , size:%d",ind, ((System.nanoTime() - runtime) * 10E-10), ret.size()));
		logger.info("<--[{}] time: [{}]--  DomeController ACTION END for , size:{}",ind, ((System.nanoTime() - runtime) * 10E-10), ret.size());
		return strBuf.toString();
	}
		

}
