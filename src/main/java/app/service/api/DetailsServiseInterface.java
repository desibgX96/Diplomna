package app.service.api;

import java.util.List;

import app.model.Details;

public interface DetailsServiseInterface {

	public void save( Details object) ;

	List<Details> findDDSMistakenEntry();
	
	List<Details> findDDSMistakenSale();
}
