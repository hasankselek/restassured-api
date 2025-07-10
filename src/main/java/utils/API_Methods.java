package utils;

import base.BaseTest;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.io.File;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class API_Methods extends BaseTest {
	private static final Logger log = LoggerFactory.getLogger(API_Methods.class);

	// Tek seferlik spec kurulum
	static {
		RestAssured.baseURI = "https://api.themoviedb.org/3/";
		requestSpec = new RequestSpecBuilder()
				.setContentType(ContentType.JSON)
				.addHeader("Authorization", "Bearer " + ConfigurationReader.get("token"))
				.build();
	}

	/**
	 * @param httpMethod  GET, POST, PUT, PATCH, DELETE
	 * @param requestBody JSON payload dosyası (File) veya null
	 * @param endpoint    Örnek: "account/{account_id}/watchlist/movies"
	 * @param pathParams  Placeholder → değer map’i, örn. Map.of("account_id", 123)
	 * @param queryParams Query string’e eklenecek parametreler, örn. Map.of("page",1,"size",20)
	 */
	public static Response sendRequest(
			String httpMethod,
			File requestBody,
			String endpoint,
			Map<String, ?> pathParams,
			Map<String, ?> queryParams
	) {
		// 0) Payload dosya yolunu logla
		if (requestBody != null) {
			log.info(requestBody.getPath());
		}

		// 1) İstek başlığı
		log.info("→ REQUEST: {} {}", httpMethod, endpoint);
		if (pathParams != null && !pathParams.isEmpty()) {
			log.info("   Path Params: {}", pathParams);
		}
		if (queryParams != null && !queryParams.isEmpty()) {
			log.info("   Query Params: {}", queryParams);
		}

		// 2) RestAssured ile request’i inşa et
		RequestSpecification req = given().spec(requestSpec);
		if (pathParams != null && !pathParams.isEmpty()) {
			req = req.pathParams(pathParams);
		}
		if (queryParams != null && !queryParams.isEmpty()) {
			req = req.queryParams(queryParams);
		}
		if (requestBody != null) {
			req = req.body(requestBody);
		}

		// 3) İsteği gönder ve response al
		Response resp = req
				.when()
				.request(httpMethod, endpoint);

		// 4) Response’un özetini logla
		log.info("← RESPONSE: status={} time={}ms", resp.getStatusCode(), resp.time());
		log.info("   Content-Type={}", resp.getHeader("Content-Type"));

		// GET ise gövdeyi de logla
		if ("GET".equalsIgnoreCase(httpMethod)) {
			log.info("   Body:\n{}", resp.getBody().asPrettyString());
		}

		// 5) Statik response alanına ata
		API_Methods.response = resp;
		return resp;
	}

	/** Son response’un status kodunu assert eder */
	public static void statusCodeAssert(int statusCode) {
		log.info("→ ASSERT status == {}", statusCode);
		response.then().assertThat().statusCode(statusCode);
	}

	/** JSONPath ile çekilen alanın beklenen değeri içerip içermediğini assert eder */
	public static void assertBody(String jsonPath, String expectedValue) {
		String actual = response.jsonPath().getString(jsonPath);
		log.info("→ ASSERT body[{}] == {}", jsonPath, expectedValue);
		Assert.assertEquals(actual, expectedValue);
	}

	/** Verilen dizi alanının (JSON array) varlığını ve boş olmadığını assert eder */
	public static void assertContainArray(String arrayField) {
		boolean exists = response.jsonPath().getList(arrayField).size() > 0;
		log.info("→ ASSERT array[{}] exists & non-empty: {}", arrayField, exists);
		Assert.assertTrue(exists, arrayField + " array is not present or is empty");
	}
}