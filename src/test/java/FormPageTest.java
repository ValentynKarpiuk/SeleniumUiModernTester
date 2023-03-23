import Pages.FormPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

public class FormPageTest extends TestBase{

    File file;

    FormPage formPage;

    @BeforeMethod
    public void testSetup(){
        driver.get("http://seleniumui.moderntester.pl/form.php");
        file = new File("src/main/resources/file.txt");
        formPage = new FormPage(driver);
    }

    @Test
    public void shouldFileFormWithSuccess() {
        Assert.assertEquals(
        formPage
                .setFirstName("Valentyn")
                .setLastName("Karpiuk")
                .setEmail("vk@gmail.com")
                .selectMaleGender()
                .setAge("35")
                .selectYearsOfExperience(4)
                .selectAutomationTester()
                .selectContinents("europe")
                .selectSeleniumCommands("switch-commands")
                .uploadFile(file)
                .setAdditionalInfo("Additional informations")
                .sendFormButton()
                .getValidatorMessage(), "Form send with success");

    }


}
