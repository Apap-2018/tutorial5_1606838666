package com.apap.tutorial5.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apap.tutorial5.model.DealerModel;
import com.apap.tutorial5.repository.DealerDB;

/**
 * 
 * @author faisalridwan
 * DealerServiceImpl
 */
@Service
@Transactional
public class DealerServiceImpl implements DealerService {
	@Autowired
	private DealerDB dealerDb;

	@Override
	public Optional<DealerModel> getDealerDetailById(Long id) {
		// TODO Auto-generated method stub
		return dealerDb.findById(id);
	}

	@Override
	public void addDealer(DealerModel dealer) {
		// TODO Auto-generated method stub
		dealerDb.save(dealer);
	}

	@Override
	public void deleteDealer(long dealerId) {
		// TODO Auto-generated method stub
		dealerDb.deleteById(dealerId);
	}

	@Override
	public List<DealerModel> getAllDealer() {
		// TODO Auto-generated method stub
		return dealerDb.findAll();
	}

	@Override
	public void editDealer(DealerModel dealer, Long id) {
		// TODO Auto-generated method stub
		DealerModel updatedDealer = dealerDb.getOne(id);
		updatedDealer.setAlamat(dealer.getAlamat());
		updatedDealer.setNoTelp(dealer.getNoTelp());
		dealerDb.save(updatedDealer);
	}
}
