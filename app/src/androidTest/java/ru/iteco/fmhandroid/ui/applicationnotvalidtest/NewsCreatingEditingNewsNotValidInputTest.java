package ru.iteco.fmhandroid.ui.applicationnotvalidtest;


import androidx.test.filters.LargeTest;

import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.data.DataHelper;
import ru.iteco.fmhandroid.ui.basic.NewsCreatingEditingNewsNotValidInputBasic;
import ru.iteco.fmhandroid.ui.pageobject.ButtonNewsSteps;
import ru.iteco.fmhandroid.ui.pageobject.InputNewNewsSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class NewsCreatingEditingNewsNotValidInputTest extends NewsCreatingEditingNewsNotValidInputBasic {

    ButtonNewsSteps buttonNewsSteps = new ButtonNewsSteps();
    InputNewNewsSteps inputNewNewsSteps = new InputNewNewsSteps();
    DataHelper dataHelper = new DataHelper();

    @Test
    @DisplayName("Проверка раздела Создание новости, ввод не валидных значений")
    @Description("Ввод не валидных значений в поля")
    public void newsCreatingNewsNotValidInput() {
        buttonNewsSteps.buttonAddNews();
        buttonNewsSteps.buttonSaveNews();
        inputNewNewsSteps.inputCreatingNewsNotValidComplex();
    }

    @Test
    @DisplayName("Проверка раздела Редактирование новости, ввод не валидных значений")
    @Description("Ввод не валидных значений в поля")
    public void newsEditingNewsNotValidInput() {
        dataHelper.clickEditNews();
        inputNewNewsSteps.inputEditingNewsNotValidComplex();
        buttonNewsSteps.buttonCancelNews();
        buttonNewsSteps.buttonOkAlert();
    }

}
