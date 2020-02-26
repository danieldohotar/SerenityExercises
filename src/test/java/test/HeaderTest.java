package test;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.jsoup.Connection;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.HeaderSteps;

@RunWith(SerenityRunner.class)
public class HeaderTest extends BaseTest {

    @Steps
    HeaderSteps headerSteps;

    @Test
    public void getPageTitleTest(){
        headerSteps.showPageTitle("Madison Island");
    }

    @Test
    public void getPageUrlTest(){
        headerSteps.showWebUrl("http://qa2.dev.evozon.com/");
    }

    @Test
    public void showClickLogoTest(){
        headerSteps.showLogo("http://qa2.dev.evozon.com/");
    }

    @Test
    public void seeIfAccountIsDisplayedTest(){
        headerSteps.checkIfAccountIsDisplayed();
    }

    @Test
    public void changeLanguageTest(){
        headerSteps.checkIfLanguageChanged();
    }

    @Test
    public void languageListSizeTest(){
        headerSteps.checkIfLanguageListSizeCorrect(3);
    }

    @Test
    public void searchedWordIsCorrectText(){
        headerSteps.checkIfSearchdWordIsCorrect();
    }
}
