package com.tan.su.bo;

import com.tan.su.beans.OpenAccount;
import com.tan.su.dao.OpenAccountDaoInterfece;

public class OpenAccountBusinessImpl implements OpenAccountBusinessInterface {
	private OpenAccountDaoInterfece dao;
	public void setDao(OpenAccountDaoInterfece dao) {
		this.dao = dao;
	}
	@Override
	public long saveCustomerDetails(OpenAccount openAccount) {
		long i = dao.saveCustomerDetails(openAccount);
		return i;
	}

}
