import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.util.List;
import org.junit.jupiter.api.Assertions;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DhrLandingAllPageTest extends BaseStep {

    @Test
    @Order(1)
    @DisplayName("Tarayıcıyı Aç ve Landing Page'e Git")
    public void openLandingPage() {
        LogTest.info("Tarayıcı açılıyor ve landing page'e gidiliyor");
        BaseStep.openChromeDriver();
        BaseStep.waitForPageLoad();
        LogTest.info("Landing page yüklendi");
    }

    @Test
    @Order(2)
    @DisplayName("Navbar Modüller Menüsü Testi")
    public void testNavbarModules() {
        LogTest.info("Navbar 'Modüller' menüsü kontrol ediliyor");
        WebElement modulesMenu = BaseStep.findElementXpathWithWait("//a[contains(text(), 'Modüller')]", TimeOut.SHORT.value);
        BaseStep.clickElement(modulesMenu, "Modüller menüsüne tıklandı");
        BaseStep.waitSeconds(1);
        LogTest.info("Modüller menüsü tıklandı");
    }

    @Test
    @Order(3)
    @DisplayName("Navbar Keşfet Menüsü Testi")
    public void testNavbarExplore() {
        LogTest.info("Navbar 'Keşfet' menüsü kontrol ediliyor");
        WebElement exploreMenu = BaseStep.findElementXpathWithWait("//a[contains(text(), 'Keşfet')]", TimeOut.SHORT.value);
        BaseStep.clickElement(exploreMenu, "Keşfet menüsüne tıklandı");
        BaseStep.waitSeconds(1);
        LogTest.info("Keşfet menüsü tıklandı");
    }

    @Test
    @Order(4)
    @DisplayName("Navbar Kaynaklar Menüsü Testi")
    public void testNavbarResources() {
        LogTest.info("Navbar 'Kaynaklar' menüsü kontrol ediliyor");
        WebElement resourcesMenu = BaseStep.findElementXpathWithWait("//a[contains(text(), 'Kaynaklar')]", TimeOut.SHORT.value);
        BaseStep.clickElement(resourcesMenu, "Kaynaklar menüsüne tıklandı");
        BaseStep.waitSeconds(1);
        LogTest.info("Kaynaklar menüsü tıklandı");
    }

    @Test
    @Order(5)
    @DisplayName("Hero Bölümü CTA Butonu Testi")
    public void testHeroCTA() {
        LogTest.info("Hero bölümündeki 'Demo için İletişime Geçin' butonu kontrol ediliyor");
        WebElement heroCTA = BaseStep.findElementXpathWithWait("//a[contains(text(), 'Demo için İletişime Geçin')]", TimeOut.SHORT.value);
        BaseStep.clickElement(heroCTA, "Hero CTA butonuna tıklandı");
        BaseStep.waitSeconds(2);
        LogTest.info("İletişim sayfasına yönlendirme başarılı (veya form açıldı)");
        BaseStep.navigateToUrl("https://dhr.d1-tech.com/");
        BaseStep.waitForPageLoad();
    }

    @Test
    @Order(6)
    @DisplayName("SSS Bölümü Toggle Testi")
    public void testFAQSection() {
        LogTest.info("SSS (FAQ) bölümü test ediliyor");
        WebElement faqSection = BaseStep.findElementXpathWithWait("//section[contains(@class, 'faq') or contains(., 'Sıkça Sorulan Sorular')]", TimeOut.SHORT.value);
        Actions actions = new Actions(driver);
        actions.moveToElement(faqSection).perform();
        
        List<WebElement> faqHeaders = BaseStep.findElements(By.xpath("//button[contains(@class, 'faq__header')]"));
        if (!faqHeaders.isEmpty()) {
            BaseStep.clickElement(faqHeaders.get(0), "İlk SSS sorusuna tıklandı");
            BaseStep.waitSeconds(1);
            LogTest.info("SSS sorusu açıldı/kapandı");
        } else {
            LogTest.info("SSS sorusu bulunamadı");
        }
    }

    @Test
    @Order(7)
    @DisplayName("İletişim Formu Alanları Testi")
    public void testContactFormFields() {
        LogTest.info("İletişim sayfasına gidiliyor");
        BaseStep.navigateToUrl("https://dhr.d1-tech.com/contact");
        BaseStep.waitForPageLoad();

        LogTest.info("Form alanları dolduruluyor");
        
        WebElement nameInput = BaseStep.findElementXpathWithWait("//input[@placeholder='Adınız Soyadınız']", TimeOut.SHORT.value);
        BaseStep.clearAndType(nameInput, "Test Kullanıcı", "Ad Soyad Alanı");

        WebElement emailInput = BaseStep.findElementXpathWithWait("//input[@placeholder='E-Posta']", TimeOut.SHORT.value);
        BaseStep.clearAndType(emailInput, "test@example.com", "E-posta Alanı");

        WebElement phoneInput = BaseStep.findElementXpathWithWait("//input[@placeholder='Telefon']", TimeOut.SHORT.value);
        BaseStep.clearAndType(phoneInput, "5551234567", "Telefon Alanı");

        WebElement companyInput = BaseStep.findElementXpathWithWait("//input[@placeholder='Şirket Adı']", TimeOut.SHORT.value);
        BaseStep.clearAndType(companyInput, "Test Şirketi", "Şirket Alanı");

        LogTest.info("Form alanları başarıyla dolduruldu");
    }

    @Test
    @Order(8)
    @DisplayName("Footer Görünürlüğü Testi")
    public void testFooterVisibility() {
        LogTest.info("Footer bölümü kontrol ediliyor");
        WebElement footer = BaseStep.findElementXpathWithWait("//footer", TimeOut.SHORT.value);
        Assertions.assertTrue(footer.isDisplayed(), "Footer görünür olmalı");
        LogTest.info("Footer görünür durumda");
    }

    @AfterAll
    public void tearDown() {
        LogTest.info("Testler tamamlandı, tarayıcı kapatılıyor");
        BaseStep.driverQuit();
    }
}
