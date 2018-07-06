package com.inventory.utils;

import org.mule.api.MuleEvent;
import org.mule.api.MuleException;
import org.mule.api.MuleMessage;
import org.mule.api.processor.MessageProcessor;

import com.inventory.model.GeocodeResponse;

public class RaiseException implements MessageProcessor {

	@Override
	public MuleEvent process(MuleEvent event) throws MuleException {
		MuleMessage message = event.getMessage();
		GeocodeResponse geocodeRespose = message.getInvocationProperty("geocodeRespose");
		throw new RuntimeException("Upstream service status not Ok. It returned: " + geocodeRespose.getStatus());
	}

}
