package com.ea.seleniumdemo;

import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;
import com.ea.seleniumdemo.AllToolsPage; // Added import for the new Page Object

public class MainPageTest2 extends Base{

    @Test
    public void navigationToAllTools() {
        mainPage.clickSeeAllToolsButton(); // Changed to use method from MainPage

        AllToolsPage allToolsPage = new AllToolsPage(driver); // Instantiate new Page Object

        // Changed assertions to use AssertJ and methods from AllToolsPage
        assertThat(allToolsPage.isProductListDisplayed()).isTrue();
        assertThat(allToolsPage.getPageTitle()).isEqualTo("All Developer Tools and Products by JetBrains");
    }

}
