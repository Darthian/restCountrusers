package com.ism.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ism.entity.Country;

@Transactional
@Repository
public class CountryDaoImpl implements CountryDao {

	@Autowired
	SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public void save(Country country) {
		getSession().save(country);
	}

	@Override
	public List<Country> findAll() {
		Query query = getSession().createQuery("from Country");
		return query.list();
	}

	@Override
	public Country findById(int id) {
		Criteria criteria = getSession().createCriteria(Country.class);
		criteria.add(Restrictions.eq("idCountry", id));
		return (Country) criteria.uniqueResult();
	}

	@Override
	public List<Country> findByName(String name) {
		Criteria criteria = getSession().createCriteria(Country.class);
		criteria.add(Restrictions.like("name", "%" + name + "%"));
		return criteria.list();
	}

	@Override
	public void update(Country country) {
		getSession().update(country);
	}

	@Override
	public void delete(Country country) {
		getSession().delete(country);
	}

}
