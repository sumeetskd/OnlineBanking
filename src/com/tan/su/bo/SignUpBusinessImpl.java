package com.tan.su.bo;

import com.tan.su.beans.SignUpCls;
import com.tan.su.dao.SignUpClsDaoInterface;

public class SignUpBusinessImpl implements SignUpBusinessInterface {
	private SignUpClsDaoInterface signUpDao;
	public void setSignUpDao(SignUpClsDaoInterface signUpDao) {
		this.signUpDao = signUpDao;
	}
	@Override
	public String save(SignUpCls signUpCls) {
		String s = signUpDao.insert(signUpCls);
		return s;
	}

}
