package app.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

//https://stackoverflow.com/questions/41143913/sql-jpa-multiple-columns-as-primary-key
//https://coderanch.com/t/217911/databases/JPA-mark-fields-Id-annotation  
//org.hibernate.AnnotationException: No identifier specified for entity:Details
@Embeddable
public class CompositeKey implements Serializable{

	@NotNull
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinColumn(name = "ACC_HEADER_ID")
    private Header accHeaderId;
	
	@NotNull
	@Column(name = "LINE")
    private int line;
    
}
