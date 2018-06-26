package test;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class FunctionalTest {
	private final String baseUrl = "http://jsonplaceholder.typicode.com";

	@Test
	public void Solution() {

		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = baseUrl;
		io.restassured.path.json.JsonPath jsonpath = RestAssured.get("/comments?postId=40").body().jsonPath();
         //get the jsonResponse list
		List<Object> jsonResponse = jsonpath.getList("$");

		assertEquals(jsonResponse.size(), 5);
        // put the elemnts with the corresponding name in a map
		Map<String, String> aMap = jsonpath.getMap("find {it.name == 'pariatur aspernatur nam atque quis'}");

		Assert.assertTrue(aMap.containsKey("id"));
		Assert.assertTrue(aMap.containsKey("email"));
		Assert.assertTrue(aMap.containsKey("body"));
		Assert.assertTrue(aMap.containsKey("name"));

		assertEquals(aMap.get("id"), 199);
		assertEquals(aMap.get("name"), "pariatur aspernatur nam atque quis");
		assertEquals(aMap.get("email"), "Cooper_Boehm@damian.biz");
		assertEquals(aMap.get("body"),
				"veniam eos ab voluptatem in fugiat ipsam quis\nofficiis non qui\nquia ut id voluptates et a molestiae commodi quam\ndolorem enim soluta impedit autem nulla");

	}
}
