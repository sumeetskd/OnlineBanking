package com.tan.su.dao;

import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.tan.su.beans.SignUpCls;

public class SignUpClsDaoImpl implements SignUpClsDaoInterface {
	private HibernateTemplate hibernateTemplate;
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	@Transactional
	@Override
	public String insert(SignUpCls signUpCls) {
		String  i =  (String) hibernateTemplate.save(signUpCls);
		return i;
		
	}

}
