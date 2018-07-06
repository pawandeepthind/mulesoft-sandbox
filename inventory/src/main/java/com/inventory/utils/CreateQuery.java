package com.inventory.utils;

import java.util.ArrayList;
import java.util.LinkedList;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.mule.api.MuleEvent;
import org.mule.api.MuleException;
import org.mule.api.MuleMessage;
import org.mule.api.processor.MessageProcessor;
import org.mule.util.CaseInsensitiveHashMap;

public class CreateQuery implements MessageProcessor {
	final static Logger logger = Logger.getLogger(CreateQuery.class);
	final static String query = "SELECT store.id, store.name, store.address, store.city, store.zipcode, storeitemqty.itemid,  storeitemqty.qty  FROM storeitemqty, store WHERE store.id= storeitemqty.storeid and storeitemqty.storeid in (STOREIDS) and storeitemqty.itemid in (ITEMIDS)";

	@Override
	public MuleEvent process(MuleEvent event) throws MuleException {
		MuleMessage message = event.getMessage();
		String itemsids = (String) message.getInvocationProperty("itemids");
		LinkedList<CaseInsensitiveHashMap> closestStoreList = message.getInvocationProperty("closestStoreList");
		ArrayList<String> stores = new ArrayList<>();
		for (CaseInsensitiveHashMap store : closestStoreList) {
			stores.add(store.get("id").toString());
		}
		String storeids = StringUtils.join(stores, ",");
		String finalQuery = query.replace("ITEMIDS", itemsids).replace("STOREIDS", storeids);
		message.setInvocationProperty("query", finalQuery);
		return event;
	}

}
