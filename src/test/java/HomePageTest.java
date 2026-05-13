import org.junit.jupiter.api.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HomePageTest {

    private static void clickAccordionWithJs(String xpath, String description) {
        BaseStep.scrollAndJsClick(xpath, description, TimeOut.LONG.value);
    }

    @Test
    @Order(1)
    @DisplayName("Tarayıcıyı Aç ve Landing Page'e Git")
    public void openBrowserAndNavigate() {
        LogTest.info("Tarayıcı açılıyor ve landing page'e gidiliyor");
        BaseStep.openChromeDriver();
        BaseStep.waitForPageLoad();
        LogTest.info("Landing page yüklendi");
    }

    @Test
    @Order(2)
    @DisplayName("Anasayfa navbar linkine tıkla")
    public void clickHomePageNavLink() {
        LogTest.info("Sayfa animasyonu için bekleniyor");
        BaseStep.waitSeconds(3);
        LogTest.info("Anasayfa navbar linkine tıklanıyor");
        WebElement homeNavLink = BaseStep.findElementXpathWithWait(
                "//*[@id=\"root\"]/div/nav/div[1]/div[1]/a[1]",
                TimeOut.LONG.value
        );
        BaseStep.jsClick(homeNavLink, "Anasayfa navbar linki");
        BaseStep.waitForPageLoad();
        LogTest.info("Anasayfa yüklendi");
    }

    @Test
    @Order(3)
    @DisplayName("Sayfa dilini İngilizceye çevir, bekle ve Türkçeye geri çevir")
    public void switchLanguageToEnglishAndBack() {
        LogTest.info("Dil dropdown butonuna tıklanıyor");
        WebElement langDropdownButton = BaseStep.findElementXpathWithWait(
                "//*[@id=\"root\"]/div/nav/div/div[2]/div/button",
                TimeOut.LONG.value
        );
        BaseStep.clickElement(langDropdownButton, "Dil dropdown butonu");
        BaseStep.waitSeconds(1);

        LogTest.info("English dil seçeneğine tıklanıyor");
        WebElement englishOption = BaseStep.findElementXpathWithWait(
                "//*[@id=\"root\"]/div/nav/div/div[2]/div/div/button[2]",
                TimeOut.LONG.value
        );
        BaseStep.clickElement(englishOption, "English dil seçeneği");
        LogTest.info("Sayfa İngilizceye çevrildi, 3 saniye bekleniyor");
        BaseStep.waitSeconds(3);

        LogTest.info("Dil dropdown butonuna tekrar tıklanıyor");
        WebElement langDropdownButtonAgain = BaseStep.findElementXpathWithWait(
                "//*[@id=\"root\"]/div/nav/div/div[2]/div/button",
                TimeOut.LONG.value
        );
        BaseStep.clickElement(langDropdownButtonAgain, "Dil dropdown butonu (tekrar)");
        BaseStep.waitSeconds(1);

        LogTest.info("Türkçe dil seçeneğine tıklanıyor");
        WebElement turkishOption = BaseStep.findElementXpathWithWait(
                "//*[@id=\"root\"]/div/nav/div/div[2]/div/div/button[1]",
                TimeOut.LONG.value
        );
        BaseStep.clickElement(turkishOption, "Türkçe dil seçeneği");
        BaseStep.waitSeconds(2);
        LogTest.info("Sayfa Türkçeye geri çevrildi");
    }

    @Test
    @Order(4)
    @DisplayName("Sayfa animasyonu beklendikten sonra Tanıtım Videosu butonuna tıkla ve 5 saniye bekle")
    public void clickDemoVideoButton() {
        LogTest.info("Sayfa animasyonu için bekleniyor");
        BaseStep.waitSeconds(3);
        LogTest.info("Tanıtım Videosu butonuna tıklanıyor");
        WebElement demoVideoButton = BaseStep.findElementXpathWithWait(
                "//*[@id=\"product\"]/div[1]/div[2]/div/div[1]/div[2]/div/div[1]/button",
                TimeOut.LONG.value
        );
        BaseStep.clickElement(demoVideoButton, "Tanıtım Videosu butonu");
        BaseStep.waitSeconds(5);
        LogTest.info("Tanıtım Videosu modalı 5 saniye görüntülendi");
    }

    @Test
    @Order(5)
    @DisplayName("Video modalını kapat")
    public void closeVideoModal() {
        LogTest.info("Video modalı kapatılıyor");
        WebElement videoCloseButton = BaseStep.findElementXpathWithWait(
                "//*[@id=\"product\"]/div[4]/div[2]/div/div[1]/button",
                TimeOut.LONG.value
        );
        BaseStep.clickElement(videoCloseButton, "Video modal kapat butonu");
        BaseStep.waitSeconds(2);
        LogTest.info("Video modalı kapatıldı");
    }

    @Test
    @Order(6)
    @DisplayName("Kişisel grid öğesine tıkla")
    public void clickPersonalGridItem() {
        LogTest.info("Kişisel grid öğesine tıklanıyor");
        WebElement personalGridItem = BaseStep.findElementXpathWithWait(
                "//*[@id=\"product\"]/div[1]/div[2]/div/div[2]/div[2]/div[2]/div[2]",
                TimeOut.LONG.value
        );
        BaseStep.clickElement(personalGridItem, "Kişisel grid öğesi");
        BaseStep.waitSeconds(1);
        LogTest.info("Kişisel grid öğesine tıklandı");
    }

    @Test
    @Order(7)
    @DisplayName("Bordro Yönetimi grid öğesine tıkla")
    public void clickPayrollManagementGridItem() {
        LogTest.info("Bordro Yönetimi grid öğesine tıklanıyor");
        WebElement payrollGridItem = BaseStep.findElementXpathWithWait(
                "//*[@id=\"product\"]/div[1]/div[2]/div/div[2]/div[2]/div[2]/div[3]",
                TimeOut.LONG.value
        );
        BaseStep.clickElement(payrollGridItem, "Bordro Yönetimi grid öğesi");
        BaseStep.waitSeconds(1);
        LogTest.info("Bordro Yönetimi grid öğesine tıklandı");
    }

    @Test
    @Order(8)
    @DisplayName("Dördüncü grid öğesine tıkla")
    public void clickFourthGridItem() {
        LogTest.info("Dördüncü grid öğesine tıklanıyor");
        WebElement fourthGridItem = BaseStep.findElementXpathWithWait(
                "//*[@id=\"product\"]/div[1]/div[2]/div/div[2]/div[2]/div[2]/div[4]",
                TimeOut.LONG.value
        );
        BaseStep.clickElement(fourthGridItem, "Dördüncü grid öğesi");
        BaseStep.waitSeconds(1);
        LogTest.info("Dördüncü grid öğesine tıklandı");
    }

    @Test
    @Order(9)
    @DisplayName("Demo için İletişime Geçin butonuna tıkla")
    public void clickDemoContactButton() {
        LogTest.info("Demo için İletişime Geçin butonuna tıklanıyor");
        WebElement demoContactButton = BaseStep.findElementXpathWithWait(
                "//*[@id=\"product\"]/div[1]/div[2]/div/div[1]/div[2]/div/div[1]/div/a",
                TimeOut.LONG.value
        );
        BaseStep.clickElement(demoContactButton, "Demo için İletişime Geçin butonu");
        BaseStep.waitForPageLoad();
        LogTest.info("İletişim sayfası yüklendi");
    }

    @Test
    @Order(10)
    @DisplayName("Ad Soyad alanını doldur")
    public void fillContactFullName() {
        LogTest.info("Ad Soyad alanı dolduruluyor");
        WebElement fullNameInput = BaseStep.findElementXpathWithWait(
                "//input[@name='name' and contains(@class,'contact__input')]",
                TimeOut.LONG.value
        );
        JavascriptExecutor js = (JavascriptExecutor) BaseStep.driver;
        js.executeScript(
                "arguments[0].scrollIntoView({block:'center', behavior:'instant'});" +
                "var nativeSetter = Object.getOwnPropertyDescriptor(window.HTMLInputElement.prototype, 'value').set;" +
                "nativeSetter.call(arguments[0], arguments[1]);" +
                "arguments[0].dispatchEvent(new Event('input', {bubbles:true}));" +
                "arguments[0].dispatchEvent(new Event('change', {bubbles:true}));",
                fullNameInput, "Test Otomasyonu"
        );
        BaseStep.waitSeconds(1);
        LogTest.info("Ad Soyad alanı dolduruldu: Test Otomasyonu");
    }

    @Test
    @Order(11)
    @DisplayName("E-Posta alanını doldur")
    public void fillContactEmail() {
        LogTest.info("E-Posta alanı dolduruluyor");
        WebElement emailInput = BaseStep.findElementXpathWithWait(
                "//input[@name='email' and contains(@class,'contact__input')]",
                TimeOut.LONG.value
        );
        BaseStep.clearAndType(emailInput, "test@example.com", "E-Posta input");
        BaseStep.waitSeconds(1);
        LogTest.info("E-Posta alanı dolduruldu: test@example.com");
    }

    @Test
    @Order(12)
    @DisplayName("Telefon alanını doldur")
    public void fillContactPhone() {
        LogTest.info("Telefon alanı dolduruluyor");
        WebElement phoneInput = BaseStep.findElementXpathWithWait(
                "//input[@name='phone' and contains(@class,'contact__input')]",
                TimeOut.LONG.value
        );
        BaseStep.clearAndType(phoneInput, "05001234567", "Telefon input");
        BaseStep.waitSeconds(1);
        LogTest.info("Telefon alanı dolduruldu: 05001234567");
    }

    @Test
    @Order(13)
    @DisplayName("Şirket Adı alanını doldur")
    public void fillContactCompany() {
        LogTest.info("Şirket Adı alanı dolduruluyor");
        WebElement companyInput = BaseStep.findElementXpathWithWait(
                "//input[@name='company' and contains(@class,'contact__input')]",
                TimeOut.LONG.value
        );
        BaseStep.clearAndType(companyInput, "Test Sirketi AS", "Şirket Adı input");
        BaseStep.waitSeconds(1);
        LogTest.info("Şirket Adı alanı dolduruldu: Test Sirketi AS");
    }

    @Test
    @Order(14)
    @DisplayName("Çalışan Sayısı Aralığını seç: 51-200")
    public void selectContactEmployeeRange() {
        LogTest.info("Çalışan Sayısı Aralığı seçiliyor: 51-200");
        WebElement employeeRangeDropdown = BaseStep.findElementXpathWithWait(
                "//select[@name='employees' and contains(@class,'contact__select')]",
                TimeOut.LONG.value
        );
        BaseStep.clickElement(employeeRangeDropdown, "Çalışan Sayısı dropdown - açılıyor");
        BaseStep.waitSeconds(1);
        WebElement employeeRangeOption = BaseStep.findElementXpathWithWait(
                "//select[@name='employees' and contains(@class,'contact__select')]/option[@value='51-200']",
                TimeOut.LONG.value
        );
        BaseStep.clickElement(employeeRangeOption, "Çalışan Sayısı - 51-200 seçiliyor");
        BaseStep.waitSeconds(1);
        LogTest.info("Çalışan Sayısı Aralığı seçildi: 51-200");
    }

    @Test
    @Order(15)
    @DisplayName("Mesaj alanını doldur")
    public void fillContactMessage() {
        LogTest.info("Mesaj alanı dolduruluyor");
        WebElement messageTextarea = BaseStep.findElementXpathWithWait(
                "//textarea[@name='message' and contains(@class,'contact__input')]",
                TimeOut.LONG.value
        );
        BaseStep.clearAndType(messageTextarea, "Bu bir otomatik test mesajidir. Lutfen dikkate almayiniz.", "Mesaj textarea");
        BaseStep.waitSeconds(1);
        LogTest.info("Mesaj alanı dolduruldu");
    }

    @Test
    @Order(16)
    @DisplayName("Mesaj Gönder butonu - otomasyonda gönderilmiyor")
    public void clickContactSubmitButton() {
        LogTest.info("Mesaj Gönder butonu yönetici isteğiyle tıklanmıyor - otomasyonda mail gönderilmiyor");
        // WebElement submitButton = BaseStep.findElementXpathWithWait(
        //         "//*[@id=\"root\"]/div/main/div/div/div/div/div[2]/div/form/button",
        //         TimeOut.LONG.value
        // );
        // BaseStep.clickElement(submitButton, "Mesaj Gönder butonu");
        // BaseStep.waitSeconds(2);
    }

    // ============================================================
    // ANASAYFA - NAVBAR'DAN GERİ DÖN VE MODÜL KARTLARI
    // ============================================================

    @Test
    @Order(17)
    @DisplayName("Formu doldurduktan sonra anasayfa navbar linkine tıkla")
    public void clickHomeNavAfterForm() {
        LogTest.info("Anasayfa navbar linkine tıklanıyor");
        WebElement homeNavLink = BaseStep.findElementXpathWithWait(
                "//*[@id=\"root\"]/div/nav/div[1]/div[1]/a[1]",
                TimeOut.LONG.value
        );
        BaseStep.clickElement(homeNavLink, "Anasayfa navbar linki");
        BaseStep.waitForPageLoad();
        LogTest.info("Anasayfa yüklendi");
    }

    @Test
    @Order(18)
    @DisplayName("Anasayfayı yumuşakça aşağı scroll et ve modül kartları bölümünü ekran ortasına al")
    public void smoothScrollDownOnHomePage() {
        LogTest.info("Sayfa yumuşakça aşağı kaydırılıyor");
        BaseStep.smoothScrollDown(800, 4);
        BaseStep.waitSeconds(1);
        LogTest.info("Modül kartları bölümü ekranın ortasına alınıyor");
        WebElement moduleCardsSection = BaseStep.findElementXpathWithWait(
                "//*[@id=\"module-cards\"]",
                TimeOut.LONG.value
        );
        ((JavascriptExecutor) BaseStep.driver).executeScript(
                "arguments[0].scrollIntoView({block: 'center', behavior: 'smooth'});",
                moduleCardsSection
        );
        BaseStep.waitSeconds(3);
        LogTest.info("Modül kartları bölümü ekranın ortasında konumlandırıldı");
    }

    @Test
    @Order(19)
    @DisplayName("Çalışan Yönetimi kartına tıkla")
    public void clickEmployeeManagementCard() {
        LogTest.info("Çalışan Yönetimi kartına tıklanıyor");
        WebElement employeeCard = BaseStep.findElementXpathWithWait(
                "//*[@id=\"module-cards\"]/div/div/div/div/div[14]",
                TimeOut.LONG.value
        );
        BaseStep.jsClick(employeeCard, "Çalışan Yönetimi kartı");
        BaseStep.waitSeconds(2);
        LogTest.info("Çalışan Yönetimi kartına tıklandı, popup açıldı");
    }

    @Test
    @Order(20)
    @DisplayName("Envanter Yönetimi popup'ını kapat")
    public void closeInventoryPopup() {
        LogTest.info("Envanter Yönetimi popup'ı kapatılıyor");
        WebElement closeButton = BaseStep.findElementXpathWithWait(
                "//*[@id=\"product\"]/div[4]/div/button",
                TimeOut.LONG.value
        );
        BaseStep.clickElement(closeButton, "Envanter Yönetimi popup kapat butonu");
        BaseStep.waitSeconds(2);
        LogTest.info("Envanter Yönetimi popup'ı kapatıldı");
    }

    @Test
    @Order(21)
    @DisplayName("Bordro Yönetimi kartına tıkla")
    public void clickPayrollModuleCard() {
        LogTest.info("Bordro Yönetimi kartına tıklanıyor");
        WebElement payrollCard = BaseStep.findElementXpathWithWait(
                "//*[@id=\"module-cards\"]/div/div/div/div/div[19]",
                TimeOut.LONG.value
        );
        BaseStep.jsClick(payrollCard, "Bordro Yönetimi kartı");
        BaseStep.waitSeconds(2);
        LogTest.info("Bordro Yönetimi kartına tıklandı, popup açıldı");
    }

    @Test
    @Order(22)
    @DisplayName("19. modül kartı popup'ını kapat")
    public void closeModuleCard19Popup() {
        LogTest.info("19. modül kartı popup'ı kapatılıyor");
        WebElement closeButton = BaseStep.findElementXpathWithWait(
                "//*[@id=\"product\"]/div[4]/div/button",
                TimeOut.LONG.value
        );
        BaseStep.clickElement(closeButton, "19. modül kartı popup kapat butonu");
        BaseStep.waitSeconds(2);
        LogTest.info("19. modül kartı popup'ı kapatıldı");
    }

    @Test
    @Order(23)
    @DisplayName("15. modül kartı overlay'ine tıkla")
    public void clickModuleCard15Overlay() {
        LogTest.info("15. modül kartı overlay'ine tıklanıyor");
        WebElement moduleCard15Overlay = BaseStep.findElementXpathWithWait(
                "//*[@id=\"module-cards\"]/div/div/div/div/div[15]/div[3]",
                TimeOut.LONG.value
        );
        BaseStep.jsClick(moduleCard15Overlay, "15. modül kartı overlay");
        BaseStep.waitSeconds(2);
        LogTest.info("15. modül kartı overlay'ine tıklandı, popup açıldı");
    }

    @Test
    @Order(24)
    @DisplayName("Modül Detaylarını Gör butonuna tıkla")
    public void clickModuleDetailsButton() {
        LogTest.info("Modül Detaylarını Gör butonuna tıklanıyor");
        WebElement moduleDetailsButton = BaseStep.findElementXpathWithWait(
                "//*[@id=\"product\"]/div[4]/div/div/div[2]/button",
                TimeOut.LONG.value
        );
        BaseStep.clickElement(moduleDetailsButton, "Modül Detaylarını Gör butonu");
        BaseStep.waitForPageLoad();
        LogTest.info("Modül sayfası yüklendi");
    }

    // ============================================================
    // MODÜL SAYFASI
    // ============================================================

    @Test
    @Order(25)
    @DisplayName("Modül sayfasında Hemen Başlayın butonuna tıkla")
    public void clickGetStartedButton() {
        LogTest.info("Hemen Başlayın butonuna tıklanıyor");
        WebElement getStartedButton = BaseStep.findElementXpathWithWait(
                "//*[@id=\"root\"]/div/main/div/section[1]/div[7]/div[2]/a",
                TimeOut.LONG.value
        );
        BaseStep.clickElement(getStartedButton, "Hemen Başlayın butonu");
        BaseStep.waitForPageLoad();
        LogTest.info("Hemen Başlayın butonuna tıklandı, iletişim sayfası yüklendi");
    }

    @Test
    @Order(26)
    @DisplayName("Modül sayfasına geri dön")
    public void navigateBackFromGetStarted() {
        LogTest.info("Bir önceki sayfaya gidiliyor");
        BaseStep.navigateBack();
        BaseStep.waitForPageLoad();
        LogTest.info("Modül sayfasına geri dönüldü");
    }

    @Test
    @Order(27)
    @DisplayName("Modül sayfasını yavaşça aşağı scroll et")
    public void smoothScrollDownOnModulePage() {
        LogTest.info("Modül sayfası yavaşça aşağı kaydırılıyor");
        BaseStep.smoothScrollDown(3000, 12);
        BaseStep.waitSeconds(2);
        LogTest.info("Modül sayfası yavaş scroll tamamlandı");
    }

    @Test
    @Order(28)
    @DisplayName("Modül sayfasında Demo Talebi Oluşturun butonuna tıkla")
    public void clickDemoRequestOnModulePage() {
        LogTest.info("Demo Talebi Oluşturun butonu aranıyor");
        WebElement demoRequestButton = BaseStep.findElementXpathWithWait(
                "//*[@id=\"root\"]/div/main/div/section[6]/div/div/a",
                TimeOut.LONG.value
        );
        ((JavascriptExecutor) BaseStep.driver).executeScript(
                "arguments[0].scrollIntoView({block: 'center', behavior: 'smooth'});",
                demoRequestButton
        );
        BaseStep.waitSeconds(2);
        BaseStep.jsClick(demoRequestButton, "Demo Talebi Oluşturun butonu");
        BaseStep.waitForPageLoad();
        LogTest.info("Demo Talebi Oluşturun butonuna tıklandı, form sayfası yüklendi");
    }

    @Test
    @Order(29)
    @DisplayName("Demo talep formundan modül sayfasına geri dön")
    public void navigateBackFromDemoRequest() {
        LogTest.info("Bir önceki sayfaya gidiliyor");
        BaseStep.navigateBack();
        BaseStep.waitForPageLoad();
        LogTest.info("Modül sayfasına geri dönüldü");
    }

    @Test
    @Order(30)
    @DisplayName("Modül sayfasını accordion bölümüne yavaşça scroll et")
    public void smoothScrollDownToAccordionsOnModulePage() {
        LogTest.info("Modül sayfası accordion bölümüne yavaşça kaydırılıyor");
        BaseStep.smoothScrollDown(2000, 8);
        BaseStep.waitSeconds(2);
        LogTest.info("Accordion bölümüne yavaş scroll tamamlandı");
    }

    @Test
    @Order(31)
    @DisplayName("Modül sayfası - Birinci accordion'u aç")
    public void openFirstAccordionOnModulePage() {
        LogTest.info("Modül sayfası birinci accordion açılıyor");
        clickAccordionWithJs(
                "//*[@id=\"root\"]/div/main/div/section[9]/div/div/div[2]/div[2]/button",
                "Modül sayfası birinci accordion butonu"
        );
        BaseStep.waitSeconds(2);
        LogTest.info("Modül sayfası birinci accordion açıldı");
    }

    @Test
    @Order(32)
    @DisplayName("Modül sayfası - Birinci accordion'u kapat")
    public void closeFirstAccordionOnModulePage() {
        LogTest.info("Modül sayfası birinci accordion kapatılıyor");
        clickAccordionWithJs(
                "//*[@id=\"root\"]/div/main/div/section[9]/div/div/div[2]/div[2]/button",
                "Modül sayfası birinci accordion butonu - kapatma"
        );
        BaseStep.waitSeconds(2);
        LogTest.info("Modül sayfası birinci accordion kapatıldı");
    }

    @Test
    @Order(33)
    @DisplayName("Modül sayfası - İkinci accordion'u aç")
    public void openSecondAccordionOnModulePage() {
        LogTest.info("Modül sayfası ikinci accordion açılıyor");
        clickAccordionWithJs(
                "//*[@id=\"root\"]/div/main/div/section[9]/div/div/div[2]/div[3]/button",
                "Modül sayfası ikinci accordion butonu"
        );
        BaseStep.waitSeconds(2);
        LogTest.info("Modül sayfası ikinci accordion açıldı");
    }

    @Test
    @Order(34)
    @DisplayName("Modül sayfası - İkinci accordion'u kapat")
    public void closeSecondAccordionOnModulePage() {
        LogTest.info("Modül sayfası ikinci accordion kapatılıyor");
        clickAccordionWithJs(
                "//*[@id=\"root\"]/div/main/div/section[9]/div/div/div[2]/div[3]/button",
                "Modül sayfası ikinci accordion butonu - kapatma"
        );
        BaseStep.waitSeconds(2);
        LogTest.info("Modül sayfası ikinci accordion kapatıldı");
    }

    @Test
    @Order(35)
    @DisplayName("Modül sayfası - Üçüncü accordion'u aç")
    public void openThirdAccordionOnModulePage() {
        LogTest.info("Modül sayfası üçüncü accordion açılıyor");
        clickAccordionWithJs(
                "//*[@id=\"root\"]/div/main/div/section[9]/div/div/div[2]/div[4]/button",
                "Modül sayfası üçüncü accordion butonu"
        );
        BaseStep.waitSeconds(2);
        LogTest.info("Modül sayfası üçüncü accordion açıldı");
    }

    @Test
    @Order(36)
    @DisplayName("Modül sayfası - Üçüncü accordion'u kapat")
    public void closeThirdAccordionOnModulePage() {
        LogTest.info("Modül sayfası üçüncü accordion kapatılıyor");
        clickAccordionWithJs(
                "//*[@id=\"root\"]/div/main/div/section[9]/div/div/div[2]/div[4]/button",
                "Modül sayfası üçüncü accordion butonu - kapatma"
        );
        BaseStep.waitSeconds(2);
        LogTest.info("Modül sayfası üçüncü accordion kapatıldı");
    }

    @Test
    @Order(37)
    @DisplayName("Modül sayfasındaki Bize Ulaşın butonuna tıkla")
    public void clickContactUsOnModulePage() {
        LogTest.info("Modül sayfasındaki Bize Ulaşın butonuna tıklanıyor");
        WebElement contactUsButton = BaseStep.findElementXpathWithWait(
                "//*[@id=\"root\"]/div/main/div/section[9]/div/div/div[1]/div[2]/a",
                TimeOut.LONG.value
        );
        BaseStep.clickElement(contactUsButton, "Bize Ulaşın butonu");
        BaseStep.waitForPageLoad();
        LogTest.info("Bize Ulaşın butonuna tıklandı, form sayfası yüklendi");
    }

    @Test
    @Order(38)
    @DisplayName("Bize Ulaşın formundan modül sayfasına geri dön")
    public void navigateBackFromContactUsOnModulePage() {
        LogTest.info("Bir önceki sayfaya gidiliyor");
        BaseStep.navigateBack();
        BaseStep.waitForPageLoad();
        LogTest.info("Modül sayfasına geri dönüldü");
    }

    @Test
    @Order(39)
    @DisplayName("Modül sayfasından anasayfaya geri dön")
    public void navigateBackToHomePage() {
        LogTest.info("Anasayfaya geri gidiliyor");
        BaseStep.navigateBack();
        BaseStep.waitForPageLoad();
        BaseStep.waitSeconds(3);
        LogTest.info("Anasayfaya geri dönüldü");
    }

    // ============================================================
    // ANASAYFA DEVAMI - SECTION 4 VE İK MODÜLÜ
    // ============================================================

    @Test
    @Order(40)
    @DisplayName("Anasayfada modüllerin kaydığı bölüme geri dön")
    public void scrollBackToModuleCardsOnHomePage() {
        LogTest.info("Modüllerin soldan sağa kaydığı bölüme geri dönülüyor");
        WebElement moduleCardsSection = BaseStep.findElementXpathWithWait(
                "//*[@id=\"module-cards\"]",
                TimeOut.LONG.value
        );
        ((JavascriptExecutor) BaseStep.driver).executeScript(
                "arguments[0].scrollIntoView({block: 'center', behavior: 'smooth'});",
                moduleCardsSection
        );
        BaseStep.waitSeconds(3);
        LogTest.info("Modül kartları bölümüne geri dönüldü");
    }

    @Test
    @Order(41)
    @DisplayName("DHR ile butonuna tıkla")
    public void clickSection4SecondButton() {
        LogTest.info("Section 4 bölümü ekrana getiriliyor");
        WebElement section4 = BaseStep.findElementXpathWithWait(
                "//*[@id=\"root\"]/div/main/div/section[4]",
                TimeOut.LONG.value
        );
        ((JavascriptExecutor) BaseStep.driver).executeScript(
                "arguments[0].scrollIntoView({block: 'center', behavior: 'smooth'});",
                section4
        );
        BaseStep.waitSeconds(3);
        LogTest.info("DHR ile butonu aranıyor");
        WebElement dhrButton = BaseStep.findElementXpathWithWait(
                "//*[@id=\"root\"]/div/main/div/section[4]/div/div[1]/div/div/button[2]",
                TimeOut.SHORT.value
        );
        BaseStep.jsClick(dhrButton, "DHR ile butonu");
        BaseStep.waitSeconds(2);
        LogTest.info("DHR ile butonuna tıklandı");
    }

    @Test
    @Order(42)
    @DisplayName("İK modülü linkine ulaşmak için daha aşağı scroll et")
    public void smoothScrollDownMoreOnHomePage() {
        LogTest.info("Sayfa daha aşağı kaydırılıyor");
        BaseStep.smoothScrollDown(1500, 5);
        LogTest.info("Scroll tamamlandı");
    }

    @Test
    @Order(43)
    @DisplayName("İK Modülünü İncele butonuna tıkla")
    public void clickHrModuleButton() {
        LogTest.info("İK Modülünü İncele butonuna tıklanıyor");
        WebElement hrModuleButton = BaseStep.findElementXpathWithWait(
                "//*[@id=\"root\"]/div/main/div/section[5]/div/div[2]/div[1]/div[1]/a",
                TimeOut.LONG.value
        );
        BaseStep.clickElement(hrModuleButton, "İK Modülünü İncele butonu");
        BaseStep.waitForPageLoad();
        LogTest.info("İK modülü sayfası yüklendi");
    }

    // ============================================================
    // İK MODÜLÜ SAYFASI
    // ============================================================

    @Test
    @Order(44)
    @DisplayName("İK modülünde Demo için İletişime Geçin butonuna tıkla")
    public void clickDemoContactOnHrModule() {
        LogTest.info("İK modülündeki Demo için İletişime Geçin butonuna tıklanıyor");
        WebElement demoContactButton = BaseStep.findElementXpathWithWait(
                "//*[@id=\"root\"]/div/main/div/section[1]/div[7]/div[2]/a",
                TimeOut.LONG.value
        );
        BaseStep.clickElement(demoContactButton, "İK modülü Demo için İletişime Geçin butonu");
        BaseStep.waitForPageLoad();
        LogTest.info("Form sayfası yüklendi");
    }

    @Test
    @Order(45)
    @DisplayName("Demo iletişim formundan İK modül sayfasına geri dön")
    public void navigateBackFromHrDemoContact() {
        LogTest.info("Bir önceki sayfaya gidiliyor");
        BaseStep.navigateBack();
        BaseStep.waitForPageLoad();
        LogTest.info("İK modül sayfasına geri dönüldü");
    }

    @Test
    @Order(46)
    @DisplayName("İK modül sayfasını yumuşakça aşağı scroll et")
    public void smoothScrollDownOnHrModulePage() {
        LogTest.info("İK modül sayfası yumuşakça aşağı kaydırılıyor");
        BaseStep.smoothScrollDown(1500, 5);
        LogTest.info("Scroll tamamlandı");
    }

    @Test
    @Order(47)
    @DisplayName("İK modülünde Demo Talep Edin butonuna tıkla")
    public void clickDemoRequestOnHrModule() {
        LogTest.info("İK modülündeki Demo Talep Edin butonu aranıyor");
        WebElement demoRequestButton = BaseStep.findElementXpathWithWait(
                "//*[@id=\"root\"]/div/main/div/section[6]/div/div/a",
                TimeOut.LONG.value
        );
        ((JavascriptExecutor) BaseStep.driver).executeScript(
                "arguments[0].scrollIntoView({block: 'center', behavior: 'smooth'});",
                demoRequestButton
        );
        BaseStep.waitSeconds(2);
        BaseStep.jsClick(demoRequestButton, "İK modülü Demo Talep Edin butonu");
        BaseStep.waitForPageLoad();
        LogTest.info("Demo Talep Edin butonuna tıklandı, form sayfası yüklendi");
    }

    @Test
    @Order(48)
    @DisplayName("Demo talep formundan İK modül sayfasına geri dön")
    public void navigateBackFromHrDemoRequest() {
        LogTest.info("Bir önceki sayfaya gidiliyor");
        BaseStep.navigateBack();
        BaseStep.waitForPageLoad();
        LogTest.info("İK modül sayfasına geri dönüldü");
    }

    @Test
    @Order(49)
    @DisplayName("İK modül sayfasını accordion bölümüne yavaşça scroll et")
    public void smoothScrollDownToAccordionsOnHrModulePage() {
        LogTest.info("İK modül sayfası accordion bölümüne yavaşça kaydırılıyor");
        BaseStep.smoothScrollDown(2000, 8);
        BaseStep.waitSeconds(2);
        LogTest.info("İK modül accordion bölümüne yavaş scroll tamamlandı");
    }

    @Test
    @Order(50)
    @DisplayName("İK modülü - Birinci accordion'u aç")
    public void openFirstAccordionOnHrModulePage() {
        LogTest.info("İK modülü birinci accordion açılıyor");
        clickAccordionWithJs(
                "//*[@id=\"root\"]/div/main/div/section[9]/div/div/div[2]/div[2]/button",
                "İK modülü birinci accordion butonu"
        );
        BaseStep.waitSeconds(2);
        LogTest.info("İK modülü birinci accordion açıldı");
    }

    @Test
    @Order(51)
    @DisplayName("İK modülü - Birinci accordion'u kapat")
    public void closeFirstAccordionOnHrModulePage() {
        LogTest.info("İK modülü birinci accordion kapatılıyor");
        clickAccordionWithJs(
                "//*[@id=\"root\"]/div/main/div/section[9]/div/div/div[2]/div[2]/button",
                "İK modülü birinci accordion butonu - kapatma"
        );
        BaseStep.waitSeconds(2);
        LogTest.info("İK modülü birinci accordion kapatıldı");
    }

    @Test
    @Order(52)
    @DisplayName("İK modülü - İkinci accordion'u aç")
    public void openSecondAccordionOnHrModulePage() {
        LogTest.info("İK modülü ikinci accordion açılıyor");
        clickAccordionWithJs(
                "//*[@id=\"root\"]/div/main/div/section[9]/div/div/div[2]/div[3]/button",
                "İK modülü ikinci accordion butonu"
        );
        BaseStep.waitSeconds(2);
        LogTest.info("İK modülü ikinci accordion açıldı");
    }

    @Test
    @Order(53)
    @DisplayName("İK modülü - İkinci accordion'u kapat")
    public void closeSecondAccordionOnHrModulePage() {
        LogTest.info("İK modülü ikinci accordion kapatılıyor");
        clickAccordionWithJs(
                "//*[@id=\"root\"]/div/main/div/section[9]/div/div/div[2]/div[3]/button",
                "İK modülü ikinci accordion butonu - kapatma"
        );
        BaseStep.waitSeconds(2);
        LogTest.info("İK modülü ikinci accordion kapatıldı");
    }

    @Test
    @Order(54)
    @DisplayName("İK modülü - Üçüncü accordion'u aç")
    public void openThirdAccordionOnHrModulePage() {
        LogTest.info("İK modülü üçüncü accordion açılıyor");
        clickAccordionWithJs(
                "//*[@id=\"root\"]/div/main/div/section[9]/div/div/div[2]/div[4]/button",
                "İK modülü üçüncü accordion butonu"
        );
        BaseStep.waitSeconds(2);
        LogTest.info("İK modülü üçüncü accordion açıldı");
    }

    @Test
    @Order(55)
    @DisplayName("İK modülü - Üçüncü accordion'u kapat")
    public void closeThirdAccordionOnHrModulePage() {
        LogTest.info("İK modülü üçüncü accordion kapatılıyor");
        clickAccordionWithJs(
                "//*[@id=\"root\"]/div/main/div/section[9]/div/div/div[2]/div[4]/button",
                "İK modülü üçüncü accordion butonu - kapatma"
        );
        BaseStep.waitSeconds(2);
        LogTest.info("İK modülü üçüncü accordion kapatıldı");
    }

    @Test
    @Order(56)
    @DisplayName("İK modülündeki Bize Ulaşın butonuna tıkla")
    public void clickContactUsOnHrModulePage() {
        LogTest.info("İK modülündeki Bize Ulaşın butonuna tıklanıyor");
        WebElement contactUsButton = BaseStep.findElementXpathWithWait(
                "//*[@id=\"root\"]/div/main/div/section[9]/div/div/div[1]/div[2]/a",
                TimeOut.LONG.value
        );
        BaseStep.clickElement(contactUsButton, "İK modülü Bize Ulaşın butonu");
        BaseStep.waitForPageLoad();
        LogTest.info("Bize Ulaşın butonuna tıklandı, form sayfası yüklendi");
    }

    @Test
    @Order(57)
    @DisplayName("Bize Ulaşın formundan İK modül sayfasına geri dön")
    public void navigateBackFromHrContactUs() {
        LogTest.info("Bir önceki sayfaya gidiliyor");
        BaseStep.navigateBack();
        BaseStep.waitForPageLoad();
        LogTest.info("İK modül sayfasına geri dönüldü");
    }

    @Test
    @Order(58)
    @DisplayName("İK modül sayfasından anasayfaya geri dön")
    public void navigateBackFromHrModuleToHome() {
        LogTest.info("Anasayfaya geri gidiliyor");
        BaseStep.navigateBack();
        BaseStep.waitForPageLoad();
        LogTest.info("Anasayfaya geri dönüldü");
    }

    // ============================================================
    // ANASAYFA - BİZE ULAŞIN FORMU
    // ============================================================

    @Test
    @Order(59)
    @DisplayName("Anasayfayı Bize Ulaşın bölümüne kadar yumuşakça scroll et")
    public void smoothScrollDownToContactSectionOnHomePage() {
        LogTest.info("Bize Ulaşın bölümüne yumuşakça kaydırılıyor");
        BaseStep.smoothScrollDown(3500, 9);
        LogTest.info("Bize Ulaşın bölümüne scroll tamamlandı");
    }

    @Test
    @Order(60)
    @DisplayName("Bize Ulaşın - Ad Soyad alanını doldur")
    public void fillHomeContactFullName() {
        LogTest.info("Bize Ulaşın Ad Soyad alanı dolduruluyor");
        WebElement fullNameInput = BaseStep.findElementXpathWithWait(
                "//input[@name='name' and contains(@id,'-name')]",
                TimeOut.LONG.value
        );
        JavascriptExecutor js = (JavascriptExecutor) BaseStep.driver;
        js.executeScript(
                "arguments[0].scrollIntoView({block:'center', behavior:'instant'});" +
                "var nativeSetter = Object.getOwnPropertyDescriptor(window.HTMLInputElement.prototype, 'value').set;" +
                "nativeSetter.call(arguments[0], arguments[1]);" +
                "arguments[0].dispatchEvent(new Event('input', {bubbles:true}));" +
                "arguments[0].dispatchEvent(new Event('change', {bubbles:true}));",
                fullNameInput, "Test Otomasyonu"
        );
        BaseStep.waitSeconds(1);
        LogTest.info("Bize Ulaşın Ad Soyad alanı dolduruldu: Test Otomasyonu");
    }

    @Test
    @Order(61)
    @DisplayName("Bize Ulaşın - E-Posta alanını doldur")
    public void fillHomeContactEmail() {
        LogTest.info("Bize Ulaşın E-Posta alanı dolduruluyor");
        WebElement emailInput = BaseStep.findElementXpathWithWait(
                "//input[@name='email' and contains(@id,'-email')]",
                TimeOut.LONG.value
        );
        BaseStep.clearAndType(emailInput, "test@example.com", "Bize Ulaşın E-Posta input");
        BaseStep.waitSeconds(1);
        LogTest.info("Bize Ulaşın E-Posta alanı dolduruldu: test@example.com");
    }

    @Test
    @Order(62)
    @DisplayName("Bize Ulaşın - Telefon alanını doldur")
    public void fillHomeContactPhone() {
        LogTest.info("Bize Ulaşın Telefon alanı dolduruluyor");
        WebElement phoneInput = BaseStep.findElementXpathWithWait(
                "//input[@name='phone' and contains(@id,'-phone')]",
                TimeOut.LONG.value
        );
        BaseStep.clearAndType(phoneInput, "05001234567", "Bize Ulaşın Telefon input");
        BaseStep.waitSeconds(1);
        LogTest.info("Bize Ulaşın Telefon alanı dolduruldu: 05001234567");
    }

    @Test
    @Order(63)
    @DisplayName("Bize Ulaşın - Şirket Adı alanını doldur")
    public void fillHomeContactCompany() {
        LogTest.info("Bize Ulaşın Şirket Adı alanı dolduruluyor");
        WebElement companyInput = BaseStep.findElementXpathWithWait(
                "//input[@name='company' and contains(@id,'-company')]",
                TimeOut.LONG.value
        );
        BaseStep.clearAndType(companyInput, "Test Sirketi AS", "Bize Ulaşın Şirket Adı input");
        BaseStep.waitSeconds(1);
        LogTest.info("Bize Ulaşın Şirket Adı alanı dolduruldu: Test Sirketi AS");
    }

    @Test
    @Order(64)
    @DisplayName("Bize Ulaşın - Çalışan Sayısı Aralığını seç: 51-200")
    public void selectHomeContactEmployeeRange() {
        LogTest.info("Bize Ulaşın Çalışan Sayısı Aralığı seçiliyor: 51-200");
        WebElement employeeRangeDropdown = BaseStep.findElementXpathWithWait(
                "//select[@name='employees' and contains(@id,'-employees')]",
                TimeOut.LONG.value
        );
        BaseStep.clickElement(employeeRangeDropdown, "Bize Ulaşın Çalışan Sayısı dropdown - açılıyor");
        BaseStep.waitSeconds(1);
        WebElement employeeRangeOption = BaseStep.findElementXpathWithWait(
                "//select[@name='employees' and contains(@id,'-employees')]/option[@value='51-200']",
                TimeOut.LONG.value
        );
        BaseStep.clickElement(employeeRangeOption, "Bize Ulaşın Çalışan Sayısı - 51-200 seçiliyor");
        BaseStep.waitSeconds(1);
        LogTest.info("Bize Ulaşın Çalışan Sayısı Aralığı seçildi: 51-200");
    }

    @Test
    @Order(65)
    @DisplayName("Bize Ulaşın - Mesaj alanını doldur")
    public void fillHomeContactMessage() {
        LogTest.info("Bize Ulaşın Mesaj alanı dolduruluyor");
        WebElement messageTextarea = BaseStep.findElementXpathWithWait(
                "//textarea[@name='message' and contains(@id,'-message')]",
                TimeOut.LONG.value
        );
        BaseStep.clearAndType(messageTextarea, "Bu bir otomatik test mesajidir. Lutfen dikkate almayiniz.", "Bize Ulaşın Mesaj textarea");
        BaseStep.waitSeconds(1);
        LogTest.info("Bize Ulaşın Mesaj alanı dolduruldu");
    }

    @Test
    @Order(66)
    @DisplayName("Bize Ulaşın - Mesaj Gönder butonu - otomasyonda gönderilmiyor")
    public void clickHomeContactSubmitButton() {
        LogTest.info("Bize Ulaşın Mesaj Gönder butonu yönetici isteğiyle tıklanmıyor - otomasyonda mail gönderilmiyor");
        // WebElement submitButton = BaseStep.findElementXpathWithWait(
        //         "//*[@id=\"contact\"]/div/div/div[2]/div/form/button",
        //         TimeOut.LONG.value
        // );
        // BaseStep.clickElement(submitButton, "Bize Ulaşın Mesaj Gönder butonu");
        // BaseStep.waitSeconds(2);
    }

    @Test
    @Order(67)
    @DisplayName("Tarayıcıyı Kapat")
    public void closeBrowser() {
        LogTest.info("Tarayıcı kapatılıyor");
        BaseStep.driverQuit();
        LogTest.info("Tarayıcı kapatıldı");
    }
}