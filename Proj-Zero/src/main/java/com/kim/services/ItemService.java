package com.kim.services;

import com.kim.models.Item;
import com.kim.repositories.ItemDAO;
import com.kim.repositories.ItemPostgreSQL;
import com.kim.util.LogUtil;

public class ItemService {
	private ItemDAO itmDao = new ItemPostgreSQL();
	private ItemPostgreSQL ips = new ItemPostgreSQL();
	
	public ItemService() {
	}

	public boolean getItemDetails(Item nwItm, int dptNum) {
		if (dptNum == 1) nwItm.setDept("GROCERY");
		if (dptNum == 2) nwItm.setDept("PETS");
		if (dptNum == 3) nwItm.setDept("BABY");
		else nwItm.setDept("GARDEN");
		nwItm.setStatus_id(1);
		System.out.println(nwItm);
		int nwUsrId = -1;
		try{
			nwUsrId = ips.addItem(nwItm);
            if(nwUsrId == -1) throw new Exception();
        } catch(Exception e){
            LogUtil.descriptiveError("Registration failed for some reason. ");
            return false;
        }
        return true;
	}

	
}
