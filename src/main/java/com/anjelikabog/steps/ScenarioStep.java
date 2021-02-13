package com.anjelikabog.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ScenarioStep {

    PersonStep personStep = new PersonStep();
    InsuranceSectionStep insuranceSectionStep = new InsuranceSectionStep();
    InsuranceStep insuranceStep = new InsuranceStep();
    CheckoutStep checkoutStep = new CheckoutStep();

    @When("^На верхней панели меню выбран раздел \"(.+)\"$")
    public void selectMenu(String menuName) {
        personStep.selectMenu(menuName);
    }

    @When("^В меню раздела выбран пункт \"(.+)\"$")
    public void selectSubMenu(String menuName) {
        personStep.selectSubMenu(menuName);
    }

    @When("^Выбран раздел продуктов \"(.+)\"$")
    public void selectSection(String sectionName) {
        insuranceSectionStep.selectSection(sectionName);
    }

    @When("^Выбран вид страховки \"(.+)\"$")
    public void selectTypeOfInsurance(String typeOfInsurance) {
        insuranceSectionStep.choose(typeOfInsurance);
    }

    @Then("^Заголовок страницы содержит \"(.+)\"$")
    public void checkTitle(String topic) {
        insuranceStep.checkTitle(topic);
    }

    @Then("^Переходим к оформлению онлаин заявки$")
    public void goToRegistration() {
        insuranceStep.goToRegistration();
    }

    @When("Выбрали минимальную страховку и переходим к заполнению данных")
    public void proceed() {
        checkoutStep.waitButtonIssueToBeClickable();
    }

    @When("^Заполняются данные:$")
    public void fillFields(DataTable personData) {
        personData.asMap(String.class, String.class).forEach(
                (field, value) -> checkoutStep.fillField(field, value));
    }

    @Then("^Значения полей равны:$")
    public void checkFillFields(DataTable personData) {
        personData.asMap(String.class, String.class).forEach(
                (field, value) -> checkoutStep.checkFillField(field, value));
    }

    @When("^Нажимаем на кнопку \"Продолжить\"$")
    public void clickButtonContinue() {
        checkoutStep.clickButtonContinue();
    }

    @Then("^Получаем ошибку с содержанием \"(.+)\"$")
    public void checkError(String expectedError) {
        checkoutStep.checkError(expectedError);
    }
}
