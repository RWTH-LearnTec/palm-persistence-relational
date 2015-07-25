package de.rwth.i9.palm.persistence.relational;

import java.util.Collections;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import de.rwth.i9.palm.model.ExtractionService;
import de.rwth.i9.palm.persistence.ExtractionServiceDAO;

public class ExtractionServiceDAOHibernate extends GenericDAOHibernate<ExtractionService> implements ExtractionServiceDAO
{

	public ExtractionServiceDAOHibernate( SessionFactory sessionFactory )
	{
		super( sessionFactory );
	}

	@Override
	public List<ExtractionService> getAllActiveExtractionService()
	{
		Query query = getCurrentSession().createQuery( "FROM ExtractionService WHERE active IS true" );

		@SuppressWarnings( "unchecked" )
		List<ExtractionService> extractionServices = query.list();

		if ( extractionServices == null )
			return Collections.emptyList();

		return extractionServices;
	}

}
