package com.apap.tutorial5.service;

import java.util.List;
import java.util.Optional;

import com.apap.tutorial5.model.DealerModel;

/**
 * 
 * @author faisalridwan
 * DealerService
 */
public interface DealerService {
	Optional<DealerModel> getDealerDetailById(Long id);
	void addDealer(DealerModel dealer);
	void editDealer(DealerModel dealer, Long id);
	void deleteDealer(long dealerId);
	List<DealerModel> getAllDealer();
}
