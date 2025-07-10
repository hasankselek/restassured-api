package base;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import utils.ConfigurationReader;


import java.util.HashMap;
import java.util.Map;

public abstract class BaseTest {


	protected static Response response;

	protected static HashMap<String, Object> map;

	protected static JSONObject requestBody;

	protected static RequestSpecification requestSpec;

	public BaseTest() {
		requestBody = new JSONObject();
		map = new HashMap<>();
	}

}