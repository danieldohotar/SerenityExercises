package page;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.junit.Assert;

import java.time.Duration;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;

@DefaultUrl("http://qa2.dev.evozon.com/")
public class HeaderPage extends AbstractPage{

    @FindBy(css="p.welcome-msg")
    private WebElementFacade greetMessage;

    @FindBy(css="head > title")
    private WebElementFacade pageTitle;

    @FindBy(css=".logo")
    private WebElementFacade pageLogo;

    @FindBy(css=".skip-account")
    private WebElementFacade accountDropdownButton;

    @FindBy(css="#header-account")
    private WebElementFacade accountDropdownList;

    @FindBy(id="select-language")
    private WebElementFacade languageDropdown;

    @FindBy(css="#select-language > option")
    private List<WebElementFacade> languageListSize;

    @FindBy(css="#search")
    private WebElementFacade searchBar;

    @FindBy(css=".search-button")
    private WebElementFacade searchButton;

    @FindBy(css=".page-title")
    private WebElementFacade pageTitileString;

    public String getGreetMessage(){
       withTimeoutOf(Duration.ofSeconds(5)).waitFor(greetMessage);
        return greetMessage.getText();
    }
    public String getPageTile(){
        return getDriver().getTitle();
    }
    public String getSiteUrl(){
        return getDriver().getCurrentUrl();
    }
    public boolean seeIfLogoIsDisplayed(){
        return pageLogo.isDisplayed();
    }
    public void clickOnLogo(){
        pageLogo.click();
    }
    public void clickOnAccountDropdown(){
        accountDropdownButton.click();
    }
    public boolean seeIfAccountListIsDIsplayed() {
       return accountDropdownList.isDisplayed();
    }
    public String seeAccount(){
        return accountDropdownButton.getText();
    }
    public void selectLanguageValue(){
         languageDropdown.selectByVisibleText("French");
        Assert.assertThat(languageDropdown.getSelectedVisibleTextValue(), is("French"));
    }
    public int languageListSize(){
        return languageListSize.size();
    }
    public String searchForKeyword(){
       searchBar.sendKeys("WOMEN");
       return  searchBar.getText();
    }

    public void clickOnSearchButton(){
        searchButton.click();
    }
    public String pageTitleText(){
        return pageTitileString.getText().toUpperCase();
    }

}
