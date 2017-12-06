package ups.mongo.repository.impl;

import org.springframework.stereotype.Repository;

import ups.mongo.model.ClusterOutput;
import ups.mongo.repository.ClusterOutputRepository;

@Repository(value = "ClusterOutputRepository")
public class ClusterOutputRepositoryImpl extends AbstractReconRepository<ClusterOutput>
		implements ClusterOutputRepository {

}
