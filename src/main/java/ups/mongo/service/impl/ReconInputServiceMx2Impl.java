package ups.mongo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ups.mongo.model.ReconInputMx2;
import ups.mongo.repository.ReconRepository;
import ups.mongo.service.ReconInputServiceMx2;

@Service("ReconInputServiceMx2")
public class ReconInputServiceMx2Impl extends AbstractReconService<ReconInputMx2> implements ReconInputServiceMx2 {
	
	public ReconInputServiceMx2Impl(@Autowired ReconRepository<ReconInputMx2> reconRepository) {
		this.reconRepository = reconRepository;
	}
}
