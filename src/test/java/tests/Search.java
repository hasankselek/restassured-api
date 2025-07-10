package tests;

import base.BaseTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.API_Methods;
import utils.TestListener;

import java.util.Map;

@Listeners(TestListener.class)
public class Search extends BaseTest {

    @Test(priority = 1)
    public void getMovie(){

        Map<String, String> queryMovie = Map.of("query", "The Godfather");

        API_Methods.sendRequest("GET",null,"search/movie",null,queryMovie);

        API_Methods.statusCodeAssert(200);
    }

    @Test(priority = 2)
    public void getTV(){

        Map<String, String> queryTV = Map.of("query", "Breaking Bad");

        API_Methods.sendRequest("GET",null,"search/tv",null,queryTV);

        API_Methods.statusCodeAssert(200);
    }

    @Test(priority = 3)
    public void getPerson(){

        Map<String, String> queryPerson = Map.of("query", "Cillian Murphy");

        API_Methods.sendRequest("GET",null,"search/tv",null,queryPerson);

        API_Methods.statusCodeAssert(200);
    }

    @Test(priority = 4)
    public void getKeyword(){

        Map<String, String> queryKeyword = Map.of("query", "Movie");

        API_Methods.sendRequest("GET",null,"search/keyword",null,queryKeyword);

        API_Methods.statusCodeAssert(200);
    }
}
