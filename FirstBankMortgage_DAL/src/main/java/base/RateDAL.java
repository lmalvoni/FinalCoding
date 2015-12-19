package base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.apache.poi.ss.formula.functions.Rate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.annotations.*;
import org.hibernate.cfg.AnnotationConfiguration;

import domain.RateDomainModel;
import util.HibernateUtil;

import ch.makery.address.model.*;

public class RateDAL {


	public static double getRate(int GivenCreditScore) {
		SessionFactory factory; 
	
	factory = new AnnotationConfiguration(). 
			configure().addAnnotatedClass(Rate.class).
			buildSessionFactory();
	
		Session session = factory.openSession();
		Transaction tx = null;
			tx = session.beginTransaction();
			Rate rate = (Rate) session.get(Rate.class, GivenCreditScore);
			session.close();
	return (rate.getDouble());
		
	}

}