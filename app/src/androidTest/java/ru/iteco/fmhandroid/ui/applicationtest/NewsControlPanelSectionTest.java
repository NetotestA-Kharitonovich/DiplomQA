package ru.iteco.fmhandroid.ui.applicationtest;

import static androidx.test.espresso.Espresso.pressBack;

import androidx.test.filters.LargeTest;

import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.basic.NewsControlPanelSectionBasic;
import ru.iteco.fmhandroid.ui.data.DataHelper;
import ru.iteco.fmhandroid.ui.pageobject.ButtonNewsSteps;
import ru.iteco.fmhandroid.ui.pageobject.LogOutSteps;
import ru.iteco.fmhandroid.ui.verificationpage.VerificationPage;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class NewsControlPanelSectionTest extends NewsControlPanelSectionBasic {

    ButtonNewsSteps buttonNewsSteps = new ButtonNewsSteps();
    LogOutSteps logOutSteps = new LogOutSteps();
    VerificationPage verificationPage = new VerificationPage();
    DataHelper dataHelper = new DataHelper();

    @Test
    @DisplayName("В разделе Новости -> Панель управления проверяется удаление сообщения")
    @Description("Удаление сообщения и проверка предупреждающих сообщений")
    public void newsCheckingControlPanelDeleteMessage() {
        dataHelper.buttonDeleteExperiment();
        buttonNewsSteps.buttonCancelAlert();
        dataHelper.buttonDeleteExperiment();
        verificationPage.checkTextAlertDeleteTheDocument();
        buttonNewsSteps.buttonOkAlert();
        verificationPage.checkTextControlPanel();
        logOutSteps.logOut();
    }

    @Test
    @DisplayName("Проверка кнопки Отмена, удаление сообщения в разделе Панель управления")
    @Description("Проверка кнопки Отмена в разделе Панель управления Удаление сообщения.")
    public void DeleteMessage() {
        dataHelper.clickEditNews();
        buttonNewsSteps.buttonCancelNews();
        buttonNewsSteps.buttonCancelAlert();
        buttonNewsSteps.buttonCancelNews();
        verificationPage.checkTextAlertLogOut();
        buttonNewsSteps.buttonOkAlert();
        dataHelper.buttonDeleteExperiment();
        verificationPage.checkTextAlertDeleteTheDocument();
        buttonNewsSteps.buttonCancelAlert();
        dataHelper.buttonDeleteExperiment();
        buttonNewsSteps.buttonOkAlert();
        logOutSteps.logOut();
    }

    @Test
    @DisplayName("Раздел Панель управления Проверка кнопок в сообщении")
    @Description("Проверка работоспособность кнопок в сообщении - переходы по разделам")
    public void newsCheckingControlPanelMessagesSection() {
        buttonNewsSteps.recyclerViewDoubleTapNews();
        dataHelper.buttonDeleteExperiment();
        verificationPage.checkTextAlertDeleteTheDocument();
        buttonNewsSteps.buttonCancelAlert();
        dataHelper.clickEditNews();
        verificationPage.checkTextEditing();
        pressBack();
        logOutSteps.logOut();
    }

    @Test
    @DisplayName("Проверяем раздел Панель управления")
    @Description("В разделе Панель управления проверяем переходы в подразделы")
    public void newsCheckingControlPanel() {
        verificationPage.checkNewsListRecycler();
        buttonNewsSteps.buttonSortNews();
        buttonNewsSteps.buttonSortNews();
        buttonNewsSteps.buttonFilterNews();
        verificationPage.checkFilterNews();
        buttonNewsSteps.buttonCancelNews();
        dataHelper.buttonDeleteExperiment();
        buttonNewsSteps.buttonCancelAlert();
        dataHelper.clickEditNews();
        verificationPage.checkTextEditing();
        pressBack();
        buttonNewsSteps.buttonAddNews();
        verificationPage.checkAppBar();
        buttonNewsSteps.buttonCancelNews();
        buttonNewsSteps.buttonOkAlert();
        logOutSteps.logOut();
    }
}
