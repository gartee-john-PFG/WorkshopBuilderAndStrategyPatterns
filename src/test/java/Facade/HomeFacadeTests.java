package Facade;

import org.approvaltests.Approvals;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class HomeFacadeTests {
    @Test
    public void whatDoesInitialHomeFacadeLookLike(){
        HomeFacade homeFacade = new HomeFacade();
        Approvals.verify(homeFacade.toString());
    }
    @Test
    public void whatDoesPlayMovieOnNetflixLookLike(){
        HomeFacade homeFacade = new HomeFacade();
        homeFacade.playMovieOnNetflix("Star Wars: Episode IV A New Hope");
        Approvals.verify(homeFacade.toString());
    }

    @Test
    @Disabled
    public void whatDoesItLookLikeToCookPizzas(){
        //  generate a test to create two pepperoni and one sausage pizza and compare how it is called vs. what backend systems
        //  are exercised
    }
}
