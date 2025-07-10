package tests;

import base.BaseTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.API_Methods;
import utils.TestListener;

@Listeners(TestListener.class)
public class MovieList extends BaseTest {

    @Test(priority = 1)
    public void getNowPlaying(){
        API_Methods.sendRequest("GET",null,"movie/now_playing",null,null);
        API_Methods.statusCodeAssert(200);
    }

    @Test(priority = 2)
    public void getPopular(){
        API_Methods.sendRequest("GET",null,"movie/popular",null,null);
        API_Methods.statusCodeAssert(200);
    }

    @Test(priority = 3)
    public void getTopRated(){
        API_Methods.sendRequest("GET",null,"movie/top_rated",null,null);
        API_Methods.statusCodeAssert(200);
    }

    @Test(priority = 4)
    public void getUpcoming(){
        API_Methods.sendRequest("GET",null,"movie/upcoming",null,null);
        API_Methods.statusCodeAssert(200);
    }


}
