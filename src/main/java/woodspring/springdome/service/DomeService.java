package woodspring.springdome.service;


import java.util.List;

import woodspring.springdome.model.FlyData;
public interface DomeService {
	
	public List<FlyData> buildModel(int pId);

}
