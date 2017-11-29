package ups.mongo.repository.impl;

import org.springframework.stereotype.Repository;

import ups.mongo.model.AutoTagOutput;
import ups.mongo.repository.AutoTagRepository;

@Repository("AutoTagRepository")
public class AutoTagRepositoryImpl extends AbstractReconRepository<AutoTagOutput> implements AutoTagRepository {

}
