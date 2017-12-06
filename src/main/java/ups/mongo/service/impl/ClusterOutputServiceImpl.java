package ups.mongo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ups.mongo.model.ClusterOutput;
import ups.mongo.repository.ReconRepository;
import ups.mongo.service.ClusterOutputService;

@Service(value = "ClusterOutputService")
public class ClusterOutputServiceImpl extends AbstractReconService<ClusterOutput> implements ClusterOutputService {
	public ClusterOutputServiceImpl(@Autowired ReconRepository<ClusterOutput> clusterOutputRepository) {
		this.reconRepository = clusterOutputRepository;
	}
}
