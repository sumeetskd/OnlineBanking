package com.tan.su.dao;

import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.tan.su.beans.OpenAccount;

public class OpenAccountDaoImpl implements OpenAccountDaoInterfece {
	private HibernateTemplate hibernateTemplate;
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	@Transactional
	@Override
	public long saveCustomerDetails(OpenAccount openAccount) {
		long i = (long) hibernateTemplate.save(openAccount);
		return i;
	}

}
