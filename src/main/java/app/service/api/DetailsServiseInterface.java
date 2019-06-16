package app.service.api;

import java.util.List;

import app.model.Details;

public interface DetailsServiseInterface {

	public void save(Details object);

	List<Details> findDDSMistakenEntry();

	List<Details> findDDSMistakenSale();

	List<Details> findMistakeInCostAccounts();

	List<Details> findMistakeInUnitCosts();

	List<Details> findMistakeInExpensesMaterialAccounts();

	List<Details> findMistakeInSaleAccount();
	
	List<Details> findCustomDetail(String credit, String debit);
}
