package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CommonPage {
    public CommonPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (id = "hero")
    public WebElement commonPage;

    @FindBy (xpath = "//a[@class='appointment-btn scrollto']")
    public WebElement makeAnAppointmentButton;

    @FindBy (id = "appoDate")
    public WebElement date;

    @FindBy (xpath = "//span[@style='color: red; font-size: 12px; border-color: red;']")
    public WebElement notBePastDate;

}
