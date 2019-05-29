package app.serrvice.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dao.api.DetailsRepository;
import app.model.Details;
import app.service.api.DetailsServiseInterface;


@Transactional
@Service
public class DetailsService implements DetailsServiseInterface {

	@Autowired
	private DetailsRepository detailsRepository;
	

	@Override
	public void save(Details object) {
		detailsRepository.save(object);
		
	}
	
	 @Override
	 public List<Details> findDDSMistakenEntry() {
	 return detailsRepository.findDDSMistake();
	 }
	 
	 @Override
	 public List<Details> findDDSMistakenSale() {
	 return detailsRepository.findDDSMistake2();
	 }
	
		
	 @Override
	 public List<Details> findMistakeInCostAccounts() {
	 return detailsRepository.findCostAccounts();
	 }
	 
	 @Override
	 public List<Details> findMistakeInUnitCosts() {
	 return detailsRepository.findUnitCosts();
	 }
	
		
	 @Override
	 public List<Details> findMistakeInExpensesMaterialAccounts() {
	 return detailsRepository.findExpensesMaterialAccounts();
	 }
	 
	 @Override
	 public List<Details> findMistakeInSaleAccount() {
	 return detailsRepository.findSaleAccount();
	 }
	
}
