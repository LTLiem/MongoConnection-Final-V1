package ups.mongo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ups.mongo.model.ReconOutput;
import ups.mongo.repository.ReconRepository;
import ups.mongo.service.ReconOutputService;

@Service("ReconOutputService")
public class ReconOutputServiceImpl extends AbstractReconService<ReconOutput> implements ReconOutputService {
	
	public ReconOutputServiceImpl(@Autowired ReconRepository<ReconOutput> reconRepository) {
		this.reconRepository = reconRepository;
	}
}
