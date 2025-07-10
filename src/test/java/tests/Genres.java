package tests;

import base.BaseTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.API_Methods;
import utils.TestListener;

@Listeners(TestListener.class)
public class Genres extends BaseTest {

    @Test(priority = 1)
    public void getMovieList(){

        API_Methods.sendRequest("GET",null,"genre/movie/list",null,null);

        API_Methods.statusCodeAssert(200);
    }

    @Test(priority = 2)
    public void getTVList(){

        API_Methods.sendRequest("GET",null,"genre/tv/list",null,null);

        API_Methods.statusCodeAssert(200);
    }
}
