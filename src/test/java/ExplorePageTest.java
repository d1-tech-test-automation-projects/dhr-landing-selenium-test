import org.junit.jupiter.api.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.Set;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ExplorePageTest {

    private static String mainWindowHandle;

    private static void clickFaqWithJs(String xpath, String description) {
        BaseStep.scrollAndJsClick(xpath, description, TimeOut.LONG.value);
    }

    /**
     * Yeni sekmede açılan harici linki kapatıp ana sekmeye geri döner.
     * d1-tech.com ve omt.d1-tech.com gibi target="_blank" linkler için.
     */
    private static void closeNewTabAndReturnToMain() {
        LogTest.info("Yeni sekme aranıyor");
        Set<String> handles = BaseStep.driver.getWindowHandles();
        for (String handle : handles) {
            if (!handle.equals(mainWindowHandle)) {
                BaseStep.driver.switchTo().window(handle);
                LogTest.info("Yeni sekmeye geçildi, URL: " + BaseStep.driver.getCurrentUrl());
                BaseStep.waitSeconds(2);
                BaseStep.driver.close();
                LogTest.info("Yeni sekme kapatıldı");
                break;
            }
        }
        BaseStep.driver.switchTo().window(mainWindowHandle);
        LogTest.info("Ana sekmeye (Hakkımızda sayfasına) geri dönüldü");
        BaseStep.waitSeconds(1);
    }

    @Test
    @Order(1)
    @DisplayName("Tarayıcıyı Aç ve Landing Page'e Git")
    public void openBrowserAndNavigate() {
        LogTest.info("Tarayıcı açılıyor ve landing page'e gidiliyor");
        BaseStep.openChromeDriver();
        BaseStep.waitForPageLoad();
        mainWindowHandle = BaseStep.driver.getWindowHandle();
        LogTest.info("Landing page yüklendi, ana sekme handle kaydedildi");
    }

    @Test
    @Order(2)
    @DisplayName("Navbar Keşfet dropdown'una tıkla")
    public void clickExploreDropdown() {
        LogTest.info("Sayfa animasyonu için bekleniyor");
        BaseStep.waitSeconds(2);
        LogTest.info("Navbar Keşfet linkine tıklanıyor");
        WebElement exploreDropdown = BaseStep.findElementXpathWithWait(
                "//*[@id=\"root\"]/div/nav/div[1]/div[1]/div[2]/a",
                TimeOut.LONG.value
        );
        BaseStep.clickElement(exploreDropdown, "Navbar Keşfet linki");
        BaseStep.waitSeconds(1);
        LogTest.info("Keşfet dropdown menüsü açıldı");
    }

    @Test
    @Order(3)
    @DisplayName("Keşfet dropdown'undan Hakkımızda linkine tıkla")
    public void clickAboutLink() {
        LogTest.info("Hakkımızda linkine tıklanıyor");
        WebElement aboutLink = BaseStep.findElementXpathWithWait(
                "//*[@id=\"root\"]/div/nav/div[1]/div[1]/div[2]/div/a[1]",
                TimeOut.LONG.value
        );
        BaseStep.clickElement(aboutLink, "Hakkımızda linki");
        BaseStep.waitForPageLoad();
        BaseStep.waitSeconds(2);
        LogTest.info("Hakkımızda sayfası yüklendi");
    }

    @Test
    @Order(4)
    @DisplayName("Hakkımızda sayfasını yumuşakça aşağı scroll et")
    public void smoothScrollDownOnAboutPage() {
        LogTest.info("Hakkımızda sayfası yumuşakça aşağı kaydırılıyor");
        BaseStep.smoothScrollDown(2500, 8);
        BaseStep.waitSeconds(1);
        LogTest.info("Hakkımızda sayfası scroll tamamlandı");
    }

    @Test
    @Order(5)
    @DisplayName("d1-tech.com adresine gidin butonuna tıkla")
    public void clickD1TechButton() {
        LogTest.info("d1-tech.com adresine gidin butonu aranıyor");
        WebElement d1TechButton = BaseStep.findElementXpathWithWait(
                "//*[@id=\"about\"]/div[7]/div/div[1]/a",
                TimeOut.LONG.value
        );
        BaseStep.scrollIntoCenter(d1TechButton);
        BaseStep.waitSeconds(1);
        BaseStep.clickElement(d1TechButton, "d1-tech.com adresine gidin butonu");
        BaseStep.waitSeconds(3);
        LogTest.info("d1-tech.com sayfası yeni sekmede açıldı");
    }

    @Test
    @Order(6)
    @DisplayName("d1-tech.com sekmesini kapat ve Hakkımızda sayfasına geri dön")
    public void closeD1TechTabAndReturn() {
        LogTest.info("d1-tech.com sekmesi kapatılıyor");
        closeNewTabAndReturnToMain();
        LogTest.info("Hakkımızda sayfasına geri dönüldü");
    }

    @Test
    @Order(7)
    @DisplayName("OMT'yi İnceleyin butonuna tıkla")
    public void clickOmtButton() {
        LogTest.info("OMT'yi İnceleyin butonu aranıyor");
        WebElement omtButton = BaseStep.findElementXpathWithWait(
                "//*[@id=\"about\"]/div[7]/div/div[2]/a",
                TimeOut.LONG.value
        );
        BaseStep.scrollIntoCenter(omtButton);
        BaseStep.waitSeconds(1);
        BaseStep.clickElement(omtButton, "OMT'yi İnceleyin butonu");
        BaseStep.waitSeconds(3);
        LogTest.info("OMT sayfası yeni sekmede açıldı");
    }

    @Test
    @Order(8)
    @DisplayName("OMT sekmesini kapat ve Hakkımızda sayfasına geri dön")
    public void closeOmtTabAndReturn() {
        LogTest.info("OMT sekmesi kapatılıyor");
        closeNewTabAndReturnToMain();
        LogTest.info("Hakkımızda sayfasına geri dönüldü");
    }

    @Test
    @Order(9)
    @DisplayName("İletişime Geç butonuna tıkla")
    public void clickContactButton() {
        LogTest.info("İletişime Geç butonu aranıyor");
        WebElement contactButton = BaseStep.findElementXpathWithWait(
                "//*[@id=\"about\"]/div[8]/div[2]/div/a",
                TimeOut.LONG.value
        );
        BaseStep.scrollIntoCenter(contactButton);
        BaseStep.waitSeconds(1);
        BaseStep.clickElement(contactButton, "İletişime Geç butonu");
        BaseStep.waitForPageLoad();
        BaseStep.waitSeconds(2);
        LogTest.info("İletişim formu sayfası yüklendi (form doldurulmayacak)");
    }

    @Test
    @Order(10)
    @DisplayName("Form doldurmadan Navbar Keşfet dropdown'una tekrar tıkla")
    public void clickExploreDropdownAgain() {
        LogTest.info("Form doldurulmadan Navbar Keşfet linkine tekrar tıklanıyor");
        WebElement exploreDropdown = BaseStep.findElementXpathWithWait(
                "//*[@id=\"root\"]/div/nav/div[1]/div[1]/div[2]/a",
                TimeOut.LONG.value
        );
        BaseStep.clickElement(exploreDropdown, "Navbar Keşfet linki");
        BaseStep.waitSeconds(1);
        LogTest.info("Keşfet dropdown menüsü tekrar açıldı");
    }

    @Test
    @Order(11)
    @DisplayName("Keşfet dropdown'undan SSS linkine tıkla")
    public void clickFaqLink() {
        LogTest.info("SSS linkine tıklanıyor");
        WebElement faqLink = BaseStep.findElementXpathWithWait(
                "//*[@id=\"root\"]/div/nav/div[1]/div[1]/div[2]/div/a[2]",
                TimeOut.LONG.value
        );
        BaseStep.clickElement(faqLink, "SSS linki");
        BaseStep.waitForPageLoad();
        BaseStep.waitSeconds(2);
        LogTest.info("SSS sayfası yüklendi");
    }

    @Test
    @Order(12)
    @DisplayName("SSS sayfasını yumuşakça aşağı scroll et")
    public void smoothScrollDownOnFaqPage() {
        LogTest.info("SSS sayfası yumuşakça aşağı kaydırılıyor");
        BaseStep.smoothScrollDown(800, 4);
        BaseStep.waitSeconds(1);
        LogTest.info("SSS sayfası scroll tamamlandı");
    }

    @Test
    @Order(13)
    @DisplayName("SSS - 'Hangi şirketler için uygundur?' başlığına tıkla")
    public void clickFaqFirstQuestion() {
        LogTest.info("'Hangi şirketler için uygundur?' başlığına tıklanıyor");
        clickFaqWithJs(
                "//*[@id=\"faq\"]/div/div/div[2]/div[2]/button",
                "'Hangi şirketler için uygundur?' SSS başlığı"
        );
        BaseStep.waitSeconds(2);
        LogTest.info("'Hangi şirketler için uygundur?' açıklaması açıldı");
    }

    @Test
    @Order(14)
    @DisplayName("SSS - 'Hangi araçlarda çalışır?' başlığına tıkla")
    public void clickFaqSecondQuestion() {
        LogTest.info("'Hangi araçlarda çalışır?' başlığına tıklanıyor");
        clickFaqWithJs(
                "//*[@id=\"faq\"]/div/div/div[2]/div[3]/button",
                "'Hangi araçlarda çalışır?' SSS başlığı"
        );
        BaseStep.waitSeconds(2);
        LogTest.info("'Hangi araçlarda çalışır?' açıklaması açıldı");
    }

    @Test
    @Order(15)
    @DisplayName("Tarayıcıyı Kapat")
    public void closeBrowser() {
        LogTest.info("Tarayıcı kapatılıyor");
        BaseStep.driverQuit();
        LogTest.info("Tarayıcı kapatıldı");
    }
}
