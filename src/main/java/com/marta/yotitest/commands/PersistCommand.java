package com.marta.yotitest.commands;

import java.sql.SQLException;

import com.marta.yotitest.domainbeans.HooverResponse;
import com.marta.yotitest.persitence.HooverResponsePersister;

public class PersistCommand implements Command<HooverResponse, HooverResponse> {

	@Override
	public HooverResponse execute(HooverResponse request) {

		HooverResponsePersister persister = HooverResponsePersister
				.getInstance();
		HooverResponse result = new HooverResponse();
		try {
			String key = persister.makeKey(request);

			result = persister.select(key);

			if (result == null) {
				result = persister.create(request);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return result;
		}
		return result;
	}

}
