package app.dao.api;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import app.model.Details;

@Repository
public interface DetailsRepository extends JpaRepository< Details, Integer> {	
	
	@Query("Select d from Details as d inner join d.accHeaderId as h where d.credit LIKE '%4531%' AND NOT (d.debit LIKE '%4532%' OR d.debit LIKE '%4538%')")
	List<Details> findDDSMistake();
	
	@Query("Select d from Details as d inner join d.accHeaderId as h where d.debit LIKE '%4532%' AND NOT (d.credit LIKE '%4531%' OR d.credit LIKE '%4539%')")
	List<Details> findDDSMistake2();
	
	@Query("Select d from Details as d inner join d.accHeaderId as h where d.credit LIKE '%60%' AND NOT (d.debit LIKE '%61%')")
	List<Details> findCostAccounts();
	
	@Query("Select d from Details as d inner join d.accHeaderId as h where d.credit LIKE '%61%' AND NOT (d.debit LIKE '%70%')")
	List<Details> findUnitCosts();
	
	@Query("Select d from Details as d inner join d.accHeaderId as h where d.credit LIKE '%30%' AND NOT (d.debit LIKE '%70%' OR d.debit LIKE '%60%')")
	List<Details> findExpensesMaterialAccounts();
	
	@Query("Select d from Details as d inner join d.accHeaderId as h where d.debit LIKE '%70%' AND NOT (d.credit LIKE '%20%' OR d.credit LIKE '%30%' OR d.credit LIKE '%61%')")
	List<Details> findSaleAccount();

}
