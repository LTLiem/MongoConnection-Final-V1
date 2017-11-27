package ups.mongo.repository.impl;

import org.springframework.stereotype.Repository;

import ups.mongo.model.ReconOutput;
import ups.mongo.repository.ReconOutputRepository;

@Repository(value="ReconOutputRepository")
public class ReconOutputRepositoryImpl extends AbstractReconRepository<ReconOutput> implements ReconOutputRepository {

}
