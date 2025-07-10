package tests;

import base.BaseTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.API_Methods;
import utils.ConfigurationReader;
import utils.TestListener;

import java.io.File;
import java.util.Map;

@Listeners(TestListener.class)
public class Movie extends BaseTest {

    Map<String,Integer> movie_id = Map.of("movie_id",5);
    Map<String,Integer> list_id = Map.of("list_id",5);
    Map<String,Object> session_id = Map.of("session_id", ConfigurationReader.get("account_id"));

    @Test(priority = 1)
    public void getDetails(){
        API_Methods.sendRequest("GET",null,"movie/{movie_id}",movie_id,null);
        API_Methods.statusCodeAssert(200);
    }

    @Test(priority = 2)
    public void getList(){
        API_Methods.sendRequest("GET",null,"movie/{movie_id}/lists",movie_id,null);
        API_Methods.statusCodeAssert(200);
    }

    @Test(priority = 3)
    public void postAddRating(){
        File ratingPayloads = new File("src/main/java/payloads/rating.json");
        API_Methods.sendRequest("POST",ratingPayloads,"movie/{movie_id}/rating",movie_id,null);
        API_Methods.statusCodeAssert(201);
    }

    @Test(priority = 4)
    public void deleteRating(){
        API_Methods.sendRequest("DELETE",null,"movie/{movie_id}/rating",movie_id,null);
        API_Methods.statusCodeAssert(200);
    }

    @Test(priority = 5)
    public void postAddMovie(){
        API_Methods.sendRequest("POST",null,"list/{list_id}/add_item",list_id,session_id);
        API_Methods.statusCodeAssert(401);
    }
}
