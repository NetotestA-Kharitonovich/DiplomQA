package ru.iteco.fmhandroid.ui.applicationtest;

import static androidx.test.espresso.Espresso.pressBack;

import androidx.test.filters.LargeTest;

import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.basic.NewsFilterNewsSectionBasic;
import ru.iteco.fmhandroid.ui.pageobject.ButtonNewsSteps;
import ru.iteco.fmhandroid.ui.pageobject.InputNewNewsSteps;
import ru.iteco.fmhandroid.ui.pageobject.LogOutSteps;
import ru.iteco.fmhandroid.ui.pageobject.MoveThroughCategoryInFilterNewsSteps;
import ru.iteco.fmhandroid.ui.verificationpage.VerificationPage;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class NewsFilterNewsSectionTest extends NewsFilterNewsSectionBasic {

    MoveThroughCategoryInFilterNewsSteps throughCategory = new MoveThroughCategoryInFilterNewsSteps();
    ButtonNewsSteps buttonNewsSteps = new ButtonNewsSteps();
    LogOutSteps logOutSteps = new LogOutSteps();
    VerificationPage verificationPage = new VerificationPage();
    InputNewNewsSteps inputNewNewsSteps = new InputNewNewsSteps();

    @Test
    @DisplayName("Проверка поля Категория в разделе Фильтровать новости")
    @Description("Проверяем категории на выбираемость")
    public void newsCheckingControlPanelFilterNewsCheckCategory() {
        buttonNewsSteps.buttonEditNews();
        buttonNewsSteps.buttonFilterNews();
        verificationPage.checkTextFilterNews();
        throughCategory.moveThroughCategoryInFilterNews();
        buttonNewsSteps.buttonCancelNews();
        logOutSteps.logOut();

    }

    @Test
    @DisplayName("Проверяем поля в разделе Фильтровать новости")
    @Description("Проверяем заполнение полей. Проверяем Чек боксы на работоспособность")
    public void newsCheckingControlPanelFilterNews() {
        buttonNewsSteps.buttonEditNews();
        buttonNewsSteps.buttonFilterNews();
        verificationPage.checkTextFilterNews();
        inputNewNewsSteps.inputFilterValid();
        buttonNewsSteps.checkBoxFilterNewsActive();
        buttonNewsSteps.checkBoxFilterNewsActive();
        buttonNewsSteps.checkBoxFilterNewsInactive();
        buttonNewsSteps.checkBoxFilterNewsInactive();
        buttonNewsSteps.filterButton();
        verificationPage.checkTextControlPanel();
        logOutSteps.logOut();

    }

    @Test
    @DisplayName("Проверка раздела Фильтровать новости")
    @Description("Проверка полей на работоспособность")
    public void newsCheckingFilterNews() {
        buttonNewsSteps.buttonFilterNews();
        verificationPage.checkFilterNews();
        throughCategory.moveThroughCategoryInFilterNews();
        inputNewNewsSteps.inputFilterValid();
        buttonNewsSteps.filterButton();
        buttonNewsSteps.buttonFilterNews();
        buttonNewsSteps.buttonCancelNews();
        logOutSteps.logOut();

    }

    @Test
    @DisplayName("Раздел Новости проверка кнопок")
    @Description("В разделе Новости проверяем работоспособность кнопок и переход в разделы")

    public void newsCheckingTheNewsSectionTest() {
        verificationPage.checkTextNews();
        buttonNewsSteps.recyclerViewNews();
        buttonNewsSteps.buttonFilterNews();
        verificationPage.checkFilterNews();
        pressBack();
        buttonNewsSteps.buttonEditNews();
        verificationPage.checkNewsListRecycler();
        pressBack();
        buttonNewsSteps.buttonSortNews();
        buttonNewsSteps.buttonSortNews();
        logOutSteps.logOut();

    }
}
