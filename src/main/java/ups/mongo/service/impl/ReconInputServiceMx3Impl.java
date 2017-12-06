package ups.mongo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ups.mongo.model.ReconInputMx3;
import ups.mongo.repository.ReconRepository;
import ups.mongo.service.ReconInputServiceMx3;

@Service(value = "ReconInputServiceMx3")
public class ReconInputServiceMx3Impl extends AbstractReconService<ReconInputMx3> implements ReconInputServiceMx3 {

	public ReconInputServiceMx3Impl(@Autowired ReconRepository<ReconInputMx3> reconRepository) {
		this.reconRepository = reconRepository;
	}
}
