package AdminPages.RuleEngine;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class RuleEngine_Common {
    SHAFT.GUI.WebDriver driver;

    private final By btn_RuleEngine = By.xpath("//a[@id='p-tabpanel-3-label']");

                               ///////////////subs//////////////
    private final By btn_Markup = By.xpath("//a[@href='/rule-engine/markup']");
    private final By btn_Discount = By.xpath("//a[@href='/rule-engine/discount']");
    private final By btn_ServiceCharge = By.xpath("//a[@href='/rule-engine/service-charge']");
    private final By btn_CancellationCharge = By.xpath("//a[@href='/rule-engine/cancellation-charge']");
    private final By btn_FareRuleMaster = By.xpath("//a[@href='/rule-engine/rule-master']");
    private final By btn_OfferPricing = By.xpath("//a[@href='/rule-engine/pricing']");
    private final By btn_TermsAndConditions = By.xpath("//a[@href='/rule-engine/terms']");
    private final By btn_RuleHistory = By.xpath("//a[@href='/rule-engine/rules-history']");

    public RuleEngine_Common(SHAFT.GUI.WebDriver driver){
        this.driver=driver;
    }

    public RuleEngine_Common clickRuleEngine(){
        driver.element().click(btn_RuleEngine);
        return this;
    }
    public RuleEngine_Common clickDiscount(){
        driver.element().click(btn_Discount);
        return this;
    }
    public RuleEngine_Common clickMarkup (){
        driver.element().click(btn_Markup );
        return this;
    }
    public RuleEngine_Common clickServiceCharge(){
        driver.element().click(btn_ServiceCharge);
        return this;
    }
    public RuleEngine_Common clickCancellationCharge(){
        driver.element().click(btn_CancellationCharge);
        return this;
    }
    public RuleEngine_Common clickFareRuleMaster(){
        driver.element().click(btn_FareRuleMaster);
        return this;
    }
    public RuleEngine_Common clickOfferPricing(){
        driver.element().click(btn_OfferPricing);
        return this;
    }
    public RuleEngine_Common clickTermsAndConditions(){
        driver.element().click(btn_TermsAndConditions);
        return this;
    }
    public RuleEngine_Common clickRuleHistory(){
        driver.element().click(btn_RuleHistory);
        return this;
    }
}