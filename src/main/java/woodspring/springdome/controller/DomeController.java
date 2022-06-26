package woodspring.springdome.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import woodspring.springdome.model.FlyData;
import woodspring.springdome.service.DomeService;

@RestController
public class DomeController {
	private final static Logger logger = LoggerFactory.getLogger(DomeController.class);
	
	
	@Autowired
	@Qualifier("DomeSynch")
	DomeService synchDome;
	
	//@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping("/dome")
	public List<FlyData> dome(@RequestParam(value="num", required = false, defaultValue = "100") String num) {
	//public String dome(@RequestParam(required = false, defaultValue = "100") String loopNum) {
		var ret = synchDome.buildModel(Integer.valueOf(num).intValue());
		return ret;
		
	}

}
