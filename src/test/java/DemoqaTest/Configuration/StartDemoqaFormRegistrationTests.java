package DemoqaTest.Configuration;

import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StartDemoqaFormRegistrationTests {
    @Test
    void successTest() {

       // DemoqaPageObject demoqaPageObject = new DemoqaPageObject();
       // demoqaPageObject.openUrl();

       open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Kristina");
        $("#lastName").setValue("Karabetskai");
        $("#userEmail").setValue("425875@mail.ru");
        $(by("for" ,  "gender-radio-3")).click();
        $("#userNumber").setValue("89780382764");
        $("#dateOfBirthInput").click();
        $(by("value","5")).click();
        $(by("value","1991")).click();
        $(by("aria-label","Choose Thursday, June 27th, 1991")).click();
        $("#subjectsInput").setValue("Arts").pressEnter();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $(by("for" , "hobbies-checkbox-3")).click();
        $(by("for" , "hobbies-checkbox-1")).scrollTo().click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/i.jpg"));
        $("#currentAddress").setValue("Simferopol");
        $("#state").click();
        $(byText("Haryana")).click();
        $("#city").click();
        $(byText("Karnal")).click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldBe(visible);

        $(".modal-body").shouldHave(
                (text("Kristina")),
                (text("Karabetskai")),
                (text("425875@mail.ru")),
                (text("Other")),
                (text("8978038276")),
                (text("27 June,1991")),
                (text("Arts, Maths")),
                (text("Music, Sport")),
                (text("i.jpg")),
                (text("Simferopol")),
                (text("Haryana Karnal")));
    }
}
