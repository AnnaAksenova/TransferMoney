package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class DashboardTopUpCards {
    private SelenideElement sumField = $("[class=input__control]");
    private SelenideElement cardField = $("[type=tel]");
    private SelenideElement replenishButton = $("[class=button__text]");
    private SelenideElement heading = $("[data-test-id=dashboard]");

    public DashboardTopUpCards() {
        heading.shouldBe(visible);
    }

    public DashboardCards replenish(String sum, DataHelper.CardsInfo cardsInfo, int number) {
        sumField.setValue(sum);
        if (number != 1) {
            cardField.setValue(cardsInfo.getFirst());
        } else {
            cardField.setValue(cardsInfo.getSecond());
        }
        replenishButton.click();
        return new DashboardCards();
    }

}
