package com.anjelikabog.steps;


import com.anjelikabog.pages.InsuranceSectionPage;
import ru.yandex.qatools.allure.annotations.Step;

public class InsuranceSectionStep{
    InsuranceSectionPage insuranceSectionPage = new InsuranceSectionPage();

    @Step("Выбран раздел продуктов {0}")
    public void selectSection(String name){
        insuranceSectionPage.selectSection(name);
    }

    @Step("Выбран вид страховки {0}")
    public void choose(String name){
        insuranceSectionPage.choose(name);
    }
}
