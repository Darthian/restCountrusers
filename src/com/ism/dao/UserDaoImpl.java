package com.ism.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ism.entity.Country;
import com.ism.entity.User;

@Transactional
@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public void save(User user) {
		getSession().save(user);
	}

	@Override
	public List<User> findAll(Country country) {
		Criteria cr = getSession().createCriteria(User.class)
				.setFetchMode("country", FetchMode.JOIN)
				.add(Restrictions.eq("country.idCountry", country.getIdCountry()))
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return cr.list();
	}

	@Override
	public User findById(int id) {
		Criteria cri = getSession().createCriteria(User.class);
		cri.add(Restrictions.eq("idUser", id));
		return (User) cri.uniqueResult();
	}

	@Override
	public List<User> findByName(String name) {
		Criteria cri = getSession().createCriteria(User.class);
		cri.add(Restrictions.like("name","%"+ name + "%"));
		return cri.list();
	}

	@Override
	public void update(User user) {
		getSession().update(user);
	}

	@Override
	public void delete(User user) {
		getSession().delete(user);
	}
}
