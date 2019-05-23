package app.dao.api;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import app.model.Details;

@Repository
public interface DetailsRepository extends JpaRepository< Details, Integer> {	
	
	@Query("Select d from Details as d where d.credit LIKE '4531'  AND d.debit NOT LIKE '4532' OR d.debit NOT LIKE '4538'")
	List<Details> findDDSMistake();
	/*
	//List<Photographer> findAllOrderByFirstNameAscLastNameDesc();
	
	//@Query("Select firstName,lastName,primaryCamera,COUNT(l.lenses) from Photographer as p inner join p.Lens as l where p.id = l.owner.id, p.primaryCamera LIKE 'DSLR' AND l.focalLength<=30 ORDER BY firstName")
	@Query("Select p from Photographer as p  inner join p.primaryCamera as c  where c.maxShutterSpeed IS NOT NULL ORDER BY p.firstName")
     List<Details> findPhotographer2();
	
	@Query("Select p from Photographer as p inner join p.primaryCamera as pc inner join p.secondaryCamera as sc inner join p.lenses as l where pc.make LIKE sc.make  AND l IS NOT NULL")
    List<Details> findPhotographer3();
	
	Details findByFirstNameAndLastName(String fn,String ln);*/
}
