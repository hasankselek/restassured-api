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
public class Account extends BaseTest {

    String accountId = ConfigurationReader.get("account_id");
    Map<String, Object> pathParams = Map.of("account_id", accountId);

    @Test(priority = 1)
    public void getAccountDetails() {

        API_Methods.sendRequest("GET",null,"account/{account_id}",pathParams,null);
        API_Methods.statusCodeAssert(200);
        API_Methods.assertBody("id",accountId);
        API_Methods.assertBody("username",ConfigurationReader.get("username"));
    }

    @Test(priority = 2)
    public void postAddFavorite() {

        File addFavoritePayloads = new File("src/main/java/payloads/addFavorite.json");

        API_Methods.sendRequest("POST",addFavoritePayloads,"account/{account_id}/favorite",pathParams,null);
        API_Methods.statusCodeAssert(201);

    }

    @Test(priority = 3)
    public void postAddToWatchlist() {

        File addToWatchlistPayload = new File("src/main/java/payloads/addToWatchlist.json");

        API_Methods.sendRequest("POST",addToWatchlistPayload,"account/{account_id}/watchlist",pathParams,null);

        API_Methods.statusCodeAssert(201);
    }

    @Test(priority = 4)
    public void getFavoriteMovies(){

        API_Methods.sendRequest("GET",null,"account/{account_id}/favorite/movies",pathParams,null);

        API_Methods.statusCodeAssert(200);

        API_Methods.assertBody("results[0].id", "555");

    }

    @Test(priority = 5)
    public void getFavoriteTV(){

        API_Methods.sendRequest("GET",null,"account/{account_id}/favorite/tv",pathParams,null);

        API_Methods.statusCodeAssert(200);
    }

    @Test(priority = 6)
    public void getRatedMovies(){

        API_Methods.sendRequest("GET",null,"account/{account_id}/rated/movies",pathParams,null);

        API_Methods.statusCodeAssert(200);
    }

    @Test(priority = 7)
    public void getRatedTV(){

        API_Methods.sendRequest("GET",null,"account/{account_id}/rated/tv",pathParams,null);

        API_Methods.statusCodeAssert(200);
    }

    @Test(priority = 8)
    public void getWatchlistMovies(){

       API_Methods.sendRequest("GET", null, "account/{account_id}/watchlist/movies", pathParams,null);

       API_Methods.statusCodeAssert(200);

    }


}
