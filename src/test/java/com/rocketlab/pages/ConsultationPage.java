package com.rocketlab.pages;

import com.rocketlab.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConsultationPage {

    public ConsultationPage(){
        PageFactory.initElements(Driver.get(),this);
    }

   // @FindBy (xpath = "//span[contains(text(),'Free first consultation')]")
    @FindBy (xpath = "(//span[@class='elementor-button-text'])[2]")
    public WebElement consultation;

    @FindBy (xpath = "//span[contains(text(),'Remote Service')]")
    public WebElement scrollDown;
}
