package Facade;

import org.approvaltests.Approvals;
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
}
