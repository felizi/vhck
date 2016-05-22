package vhck.neighbors.jersey.translator;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import vhck.neighbors.entity.OccurrenceEntity;
import vhck.neighbors.entity.UserEntity;
import vhck.neighbors.enums.OccurrenceTypeEnum;
import vhck.neighbors.jersey.translator.constants.BasicConstants;
import vhck.neighbors.jersey.translator.constants.OccurrenceConstants;

public class OccurrenceTranslator {

	public OccurrenceEntity convertJson(String contentRequest, UserEntity owner) {
		Map<Object, Object> occurrence = new Gson().fromJson(contentRequest, new TypeToken<HashMap<Object, Object>>() {
		}.getType());

		String name = (String) occurrence.get(BasicConstants.NAME);
		String description = (String) occurrence.get(BasicConstants.DESCRIPTION);
		OccurrenceTypeEnum occurrenceType = OccurrenceTypeEnum.valueOf((String) occurrence.get(OccurrenceConstants.OCCURRENCE_TYPE));

		return new OccurrenceEntity(occurrenceType, name, owner, description);
	}
}
