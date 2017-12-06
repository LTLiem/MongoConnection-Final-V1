package ups.mongo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ups.mongo.model.AutoTagOutput;
import ups.mongo.repository.ReconRepository;
import ups.mongo.service.AutoTagService;

@Service(value = "AutoTagService")
public class AutoTagServiceImpl extends AbstractReconService<AutoTagOutput> implements AutoTagService {

	public AutoTagServiceImpl(@Autowired ReconRepository<AutoTagOutput> reconRepository) {
		this.reconRepository = reconRepository;
	}
}
