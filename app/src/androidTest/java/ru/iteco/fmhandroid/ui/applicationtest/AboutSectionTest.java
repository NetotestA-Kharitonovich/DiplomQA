package ru.iteco.fmhandroid.ui.applicationtest;

import androidx.test.filters.LargeTest;

import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.basic.BasicClass;
import ru.iteco.fmhandroid.ui.pageobject.AboutSteps;
import ru.iteco.fmhandroid.ui.pageobject.ButtonMainSteps;
import ru.iteco.fmhandroid.ui.pageobject.GoToMainMenuSteps;
import ru.iteco.fmhandroid.ui.pageobject.LogOutSteps;
import ru.iteco.fmhandroid.ui.verificationpage.VerificationPage;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class AboutSectionTest extends BasicClass {

    GoToMainMenuSteps goToMainMenuSteps = new GoToMainMenuSteps();
    LogOutSteps logOutSteps = new LogOutSteps();
    AboutSteps aboutSteps = new AboutSteps();
    VerificationPage verificationPage = new VerificationPage();
    ButtonMainSteps buttonMainSteps = new ButtonMainSteps();

    @Test
    @DisplayName("В разделе О приложении проверяем переход по ссылке, Политика конфиденциальности.")
    @Description("Переход по ссылке на сторонний ресурс Политика конфиденциальности. Окрывается в браузере")
    public void aboutPrivacyPolicyTest() {
        goToMainMenuSteps.goToAbout();
        verificationPage.idCheckAboutPrivacyPolicy();
        aboutSteps.clickUrlPrivacyPolicyIntents();
        aboutSteps.switchingFromBrowserToApp();
        buttonMainSteps.buttonBackAbout();
        logOutSteps.logOut();
    }


    @Test
    @DisplayName("В разделе About проверяем переход по ссылке, Пользовательское соглашение.")
    @Description("Переход по ссылке на сторонний ресурс Пользовательское соглашение. Открывается в браузере")
    public void aboutTermsOfUseTest() {
        goToMainMenuSteps.goToAbout();
        verificationPage.idCheckAboutTermsOfUse();
        aboutSteps.clickUrlTermsOfUseAndIntents();
        aboutSteps.switchingFromBrowserToApp();
        buttonMainSteps.buttonBackAbout();
        logOutSteps.logOut();
    }

    @Test
    @DisplayName("В разделе О приложении проверяем кнопку, назад")
    @Description("После нажатия кнопки назад, переходим в раздел Главная")
    public void checkButtonBack() {
        goToMainMenuSteps.goToAbout();
        buttonMainSteps.buttonBackAbout();
        logOutSteps.logOut();
    }

}
