package org.mytests.tests.test.example;

import com.epam.jdi.light.elements.composite.Form;
import org.mytests.tests.test.TestsInit;
import org.mytests.tests.testng.TestNGListener;
import org.mytests.uiobjects.example.entities.Contacts;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.mytests.tests.test.states.States.shouldBeLoggedIn;
import static org.mytests.tests.test.states.States.shouldBeLoggedOut;
import static org.mytests.uiobjects.example.entities.Defaults.DEFAULT_CONTACT;
import static org.mytests.uiobjects.example.entities.Defaults.DEFAULT_USER;
import static org.mytests.uiobjects.example.site.SiteJdi.*;
import static org.mytests.uiobjects.example.site.pages.ContactFormPage.contactForm;

@Listeners(TestNGListener.class)
public class FormTests implements TestsInit {

    @Test
    public void loginTest() {
        shouldBeLoggedOut();
        userIcon.click();
        loginForm.loginAs(DEFAULT_USER);
        homePage.checkOpened();
    }

    @Test
    public void fillContactFormTest() {
        shouldBeLoggedIn();
        contactFormPage.shouldBeOpened();
        contactForm.submit(DEFAULT_CONTACT);
        contactForm.check(DEFAULT_CONTACT);
    }

    @Test
    public void fillContactsTest() {
        shouldBeLoggedIn();
        contactsPage.shouldBeOpened();
        Form<Contacts> contactFrom = contactsPage.asForm();
        contactFrom.submit(DEFAULT_CONTACT);
        contactFrom.check(DEFAULT_CONTACT);
    }
}
