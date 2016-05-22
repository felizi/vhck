package vhck.neighbors.jersey.translator;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import vhck.neighbors.entity.BuildEntity;
import vhck.neighbors.jersey.translator.constants.BasicConstants;

public class BuildingTranslator {
	public BuildEntity create(String contentRequest) {
		Map<Object, Object> map = new Gson().fromJson(contentRequest, new TypeToken<HashMap<Object, Object>>() {
		}.getType());

		String name = (String) map.get(BasicConstants.NAME);

		BuildEntity building = new BuildEntity();
		building.setName(name);

		return building;
	}
}
