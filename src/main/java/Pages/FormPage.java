package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.List;

public class FormPage {

    public FormPage(WebDriver driver) {
        PageFactory.initElements(driver, this);

        //The initElements method is used to initialize web elements.
    }

    @FindBy(id = "inputFirstName3")
    public WebElement firstName;

    @FindBy(id = "inputLastName3")
    private WebElement lastName;

    @FindBy(id = "inputEmail3")
    private WebElement eMail;

    @FindBy(name = "gridRadiosSex")
    private List<WebElement> sexOptions;

    @FindBy(id = "inputAge3")
    private WebElement age;

    @FindBy(name = "gridRadiosExperience")
    private List<WebElement> experienceOptions;

    @FindBy(name = "gridCheckboxProfession")
    private WebElement profession;

    @FindBy(id = "selectContinents")
    private WebElement continents;

    @FindBy(id = "selectSeleniumCommands")
    private WebElement seleniumCommands;

    @FindBy(id = "chooseFile")
    private WebElement chooseFile;

    @FindBy(className = "form-control")
    private WebElement addInfo;

    @FindBy(className = "btn-primary")
    private WebElement sendFormButton;

    @FindBy(id = "validator-message")
    private WebElement validatorMessage;


    public FormPage setFirstName(String name){
        firstName.sendKeys(name);
        return this;
    }

    public FormPage setLastName(String lastName){
        this.lastName.sendKeys(lastName);
        return this;
    }

    public FormPage setEmail(String mail){
        eMail.sendKeys(mail);
        return this;
    }

    public FormPage selectMaleGender(){
        sexOptions.get(0).click();
        return this;
    }

    public FormPage setAge(String age){
       this.age.sendKeys(age);
        return this;
    }

    public FormPage selectYearsOfExperience(int yearsOfExperience) {
        experienceOptions.get(yearsOfExperience-1).click();
        return this;
    }

    public FormPage selectAutomationTester() {
        profession.click();
        return this;
    }

    public FormPage selectContinents(String optionValue){ //<option value="europe">Europe</option> in elements /bookmarks/ DevTools
        new Select(continents).selectByValue(optionValue);
        return this;
    }

    public FormPage selectSeleniumCommands(String optionValue) {
        new Select(seleniumCommands).selectByValue(optionValue);
        return this;
    }

    public FormPage uploadFile(File file){
        chooseFile.sendKeys(file.getAbsolutePath());
        return this;
    }

    public FormPage setAdditionalInfo(String info){
        addInfo.sendKeys(info);
        return this;
    }

    public FormPage sendFormButton(){
        sendFormButton.click();
        return this;
    }

    public String getValidatorMessage(){
        return validatorMessage.getText();

    }


}
