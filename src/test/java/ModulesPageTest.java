import org.junit.jupiter.api.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ModulesPageTest {

    private static final String MODULES_NAVBAR_XPATH =
            "//*[@id=\"root\"]/div/nav/div[1]/div[1]/div[1]/a";

    private static void clickFaqWithJs(String xpath, String description) {
        BaseStep.scrollAndJsClick(xpath, description, TimeOut.LONG.value);
    }

    private static void openModulesNavbarDropdown() {
        WebElement modulesNavbar = BaseStep.findElementXpathWithWait(
                MODULES_NAVBAR_XPATH,
                TimeOut.LONG.value
        );
        BaseStep.clickElement(modulesNavbar, "Modüller navbar linki");
        LogTest.info("Modüller dropdown açıldı, seçim öncesi 3 sn bekleniyor");
        BaseStep.waitSeconds(3);
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

    // ============================================================
    // CALENDAR MANAGEMENT (Takvim Yönetimi)
    // ============================================================

    @Test
    @Order(2)
    @DisplayName("Modüller navbar dropdown'unu aç")
    public void openModulesDropdownForCalendar() {
        LogTest.info("Sayfa animasyonu için bekleniyor");
        BaseStep.waitSeconds(2);
        LogTest.info("Modüller navbar linkine tıklanıyor, dropdown açılıyor");
        openModulesNavbarDropdown();
        LogTest.info("Modüller dropdown menüsü açıldı");
    }

    @Test
    @Order(3)
    @DisplayName("Dropdown'dan Takvim Yönetimi linkine tıkla")
    public void clickCalendarManagementLink() {
        LogTest.info("Takvim Yönetimi linkine tıklanıyor");
        WebElement calendarLink = BaseStep.findElementXpathWithWait(
                "//*[@id=\"root\"]/div/nav/div[2]/div/div[1]/div[1]/div[3]/a[3]",
                TimeOut.LONG.value
        );
        BaseStep.clickElement(calendarLink, "Takvim Yönetimi mega menü linki");
        BaseStep.waitForPageLoad();
        BaseStep.waitSeconds(2);
        LogTest.info("Takvim Yönetimi sayfası yüklendi");
    }

    @Test
    @Order(4)
    @DisplayName("Takvim Yönetimi - Demoyu İncele butonuna tıkla")
    public void clickCalendarDemoButton() {
        LogTest.info("Takvim Yönetimi sayfasında Demoyu İncele butonuna tıklanıyor");
        WebElement demoButton = BaseStep.findElementXpathWithWait(
                "//*[@id=\"root\"]/div/main/div/section[1]/div[7]/div[2]/a",
                TimeOut.LONG.value
        );
        BaseStep.clickElement(demoButton, "Takvim Yönetimi Demoyu İncele butonu");
        BaseStep.waitForPageLoad();
        BaseStep.waitSeconds(2);
        LogTest.info("İletişim formu sayfası yüklendi (form doldurulmayacak)");
    }

    @Test
    @Order(5)
    @DisplayName("Form sayfasından Takvim Yönetimi sayfasına geri dön")
    public void navigateBackToCalendarFromDemo() {
        LogTest.info("Bir önceki sayfaya gidiliyor");
        BaseStep.navigateBack();
        BaseStep.waitForPageLoad();
        BaseStep.waitSeconds(2);
        LogTest.info("Takvim Yönetimi sayfasına geri dönüldü");
    }

    @Test
    @Order(6)
    @DisplayName("Takvim Yönetimi sayfasını yumuşakça aşağı scroll et")
    public void smoothScrollDownOnCalendarPage() {
        LogTest.info("Takvim Yönetimi sayfası yumuşakça aşağı kaydırılıyor");
        BaseStep.smoothScrollDown(2500, 8);
        BaseStep.waitSeconds(1);
        LogTest.info("Takvim Yönetimi scroll tamamlandı");
    }

    @Test
    @Order(7)
    @DisplayName("Takvim Yönetimi - Takvimi İncele butonuna tıkla")
    public void clickReviewCalendarButton() {
        LogTest.info("Takvimi İncele butonuna tıklanıyor");
        WebElement reviewCalendarButton = BaseStep.findElementXpathWithWait(
                "//*[@id=\"root\"]/div/main/div/section[6]/div/div/a",
                TimeOut.LONG.value
        );
        BaseStep.scrollIntoCenter(reviewCalendarButton);
        BaseStep.waitSeconds(1);
        BaseStep.jsClick(reviewCalendarButton, "Takvimi İncele butonu");
        BaseStep.waitForPageLoad();
        BaseStep.waitSeconds(2);
        LogTest.info("İletişim formu sayfası yüklendi (form doldurulmayacak)");
    }

    @Test
    @Order(8)
    @DisplayName("Form sayfasından Takvim Yönetimi sayfasına (aynı yere) geri dön")
    public void navigateBackToCalendarFromReview() {
        LogTest.info("Bir önceki sayfaya gidiliyor");
        BaseStep.navigateBack();
        BaseStep.waitForPageLoad();
        BaseStep.waitSeconds(2);
        LogTest.info("Takvim Yönetimi sayfasına aynı yere geri dönüldü");
    }

    @Test
    @Order(9)
    @DisplayName("Takvim Yönetimi sayfasını tekrar yumuşakça aşağı scroll et")
    public void smoothScrollDownOnCalendarPageAgain() {
        LogTest.info("Takvim Yönetimi sayfası tekrar yumuşakça aşağı kaydırılıyor");
        BaseStep.smoothScrollDown(2000, 6);
        BaseStep.waitSeconds(1);
        LogTest.info("Takvim Yönetimi tekrar scroll tamamlandı");
    }

    // ============================================================
    // STOCK MANAGEMENT (Stok Yönetimi)
    // ============================================================

    @Test
    @Order(10)
    @DisplayName("Modüller navbar dropdown'unu Stok Yönetimi için aç")
    public void openModulesDropdownForStock() {
        LogTest.info("Modüller navbar linkine tıklanıyor, dropdown açılıyor");
        openModulesNavbarDropdown();
        LogTest.info("Modüller dropdown menüsü açıldı");
    }

    @Test
    @Order(11)
    @DisplayName("Dropdown'dan Stok Yönetimi linkine tıkla")
    public void clickStockManagementLink() {
        LogTest.info("Stok Yönetimi linkine tıklanıyor");
        WebElement stockLink = BaseStep.findElementXpathWithWait(
                "//*[@id=\"root\"]/div/nav/div[2]/div/div[1]/div[1]/div[3]/a[4]",
                TimeOut.LONG.value
        );
        BaseStep.clickElement(stockLink, "Stok Yönetimi mega menü linki");
        BaseStep.waitForPageLoad();
        BaseStep.waitSeconds(2);
        LogTest.info("Stok Yönetimi sayfası yüklendi");
    }

    @Test
    @Order(12)
    @DisplayName("Stok Yönetimi - Demo İçin İletişime Geçin butonuna tıkla")
    public void clickStockContactDemoButton() {
        LogTest.info("Stok Yönetimi - Demo İçin İletişime Geçin butonuna tıklanıyor");
        WebElement contactDemoButton = BaseStep.findElementXpathWithWait(
                "//*[@id=\"root\"]/div/main/div/section[1]/div[6]/div[2]/a",
                TimeOut.LONG.value
        );
        BaseStep.clickElement(contactDemoButton, "Stok Yönetimi Demo İçin İletişime Geçin butonu");
        BaseStep.waitForPageLoad();
        BaseStep.waitSeconds(2);
        LogTest.info("İletişim formu sayfası yüklendi (form doldurulmayacak)");
    }

    @Test
    @Order(13)
    @DisplayName("Form sayfasından Stok Yönetimi sayfasına geri dön")
    public void navigateBackToStockFromContactDemo() {
        LogTest.info("Bir önceki sayfaya gidiliyor");
        BaseStep.navigateBack();
        BaseStep.waitForPageLoad();
        BaseStep.waitSeconds(2);
        LogTest.info("Stok Yönetimi sayfasına geri dönüldü");
    }

    @Test
    @Order(14)
    @DisplayName("Stok Yönetimi sayfasını yumuşakça aşağı scroll et")
    public void smoothScrollDownOnStockPage() {
        LogTest.info("Stok Yönetimi sayfası yumuşakça aşağı kaydırılıyor");
        BaseStep.smoothScrollDown(2500, 8);
        BaseStep.waitSeconds(1);
        LogTest.info("Stok Yönetimi scroll tamamlandı");
    }

    @Test
    @Order(15)
    @DisplayName("Stok Yönetimi - Çalışan Yönetimi diğer modül kartına tıkla")
    public void clickEmployeeManagementOtherModuleCard() {
        LogTest.info("Çalışan Yönetimi diğer modül kartına tıklanıyor");
        WebElement employeeCard = BaseStep.findElementXpathWithWait(
                "//*[@id=\"root\"]/div/main/div/section[8]/div/div[2]/a[1]",
                TimeOut.LONG.value
        );
        BaseStep.scrollIntoCenter(employeeCard);
        BaseStep.waitSeconds(1);
        BaseStep.jsClick(employeeCard, "Çalışan Yönetimi diğer modül kart linki");
        BaseStep.waitForPageLoad();
        BaseStep.waitSeconds(2);
        LogTest.info("Çalışan Yönetimi modül sayfası yüklendi");
    }

    @Test
    @Order(16)
    @DisplayName("Çalışan Yönetimi sayfasından Stok Yönetimi sayfasına geri dön")
    public void navigateBackToStockFromEmployeeManagement() {
        LogTest.info("Bir önceki sayfaya gidiliyor");
        BaseStep.navigateBack();
        BaseStep.waitForPageLoad();
        BaseStep.waitSeconds(2);
        LogTest.info("Stok Yönetimi sayfasına geri dönüldü");
    }

    @Test
    @Order(17)
    @DisplayName("Stok Yönetimi sayfasını FAQ bölümüne kadar yavaşça scroll et")
    public void smoothScrollDownToStockFaqs() {
        LogTest.info("Stok Yönetimi FAQ bölümüne kaydırılıyor");
        BaseStep.smoothScrollDown(2000, 6);
        BaseStep.waitSeconds(1);
        ((JavascriptExecutor) BaseStep.driver).executeScript(
                "window.scrollTo({top: document.body.scrollHeight, behavior: 'smooth'});"
        );
        BaseStep.waitSeconds(3);
        LogTest.info("FAQ bölümüne scroll tamamlandı");
    }

    @Test
    @Order(18)
    @DisplayName("Stok FAQ - 'Mevcut Excel stok listemi taşıyabilir miyim?' başlığına tıkla")
    public void clickStockFaqFirstQuestion() {
        LogTest.info("'Mevcut Excel stok listemi taşıyabilir miyim?' başlığına tıklanıyor");
        clickFaqWithJs(
                "//*[@id=\"root\"]/div/main/div/section[9]/div/div/div[2]/div[2]/button",
                "'Mevcut Excel stok listemi taşıyabilir miyim?' FAQ başlığı"
        );
        BaseStep.waitSeconds(2);
        LogTest.info("FAQ açıklaması açıldı");
    }

    @Test
    @Order(19)
    @DisplayName("Stok FAQ - 'Stokta azalan ürünü ben fark etmeden sistem uyarır mı?' başlığına tıkla")
    public void clickStockFaqSecondQuestion() {
        LogTest.info("'Stokta azalan ürünü ben fark etmeden sistem uyarır mı?' başlığına tıklanıyor");
        clickFaqWithJs(
                "//*[@id=\"root\"]/div/main/div/section[9]/div/div/div[2]/div[3]/button",
                "'Stokta azalan ürünü ben fark etmeden sistem uyarır mı?' FAQ başlığı"
        );
        BaseStep.waitSeconds(2);
        LogTest.info("FAQ açıklaması açıldı");
    }

    // ============================================================
    // PERFORMANCE (Performans)
    // ============================================================

    @Test
    @Order(20)
    @DisplayName("Modüller navbar dropdown'unu Performans için aç")
    public void openModulesDropdownForPerformance() {
        LogTest.info("Modüller navbar linkine tıklanıyor, dropdown açılıyor");
        openModulesNavbarDropdown();
        LogTest.info("Modüller dropdown menüsü açıldı");
    }

    @Test
    @Order(21)
    @DisplayName("Dropdown'dan Performans linkine tıkla")
    public void clickPerformanceLink() {
        LogTest.info("Performans linkine tıklanıyor");
        WebElement performanceLink = BaseStep.findElementXpathWithWait(
                "//*[@id=\"root\"]/div/nav/div[2]/div/div[1]/div[1]/div[3]/a[7]",
                TimeOut.LONG.value
        );
        BaseStep.clickElement(performanceLink, "Performans mega menü linki");
        BaseStep.waitForPageLoad();
        BaseStep.waitSeconds(2);
        LogTest.info("Performans sayfası yüklendi");
    }

    // ============================================================
    // SHIFT (Vardiya)
    // ============================================================

    @Test
    @Order(22)
    @DisplayName("Modüller navbar dropdown'unu Vardiya için aç")
    public void openModulesDropdownForShift() {
        LogTest.info("Modüller navbar linkine tıklanıyor, dropdown açılıyor");
        openModulesNavbarDropdown();
        LogTest.info("Modüller dropdown menüsü açıldı");
    }

    @Test
    @Order(23)
    @DisplayName("Dropdown'dan Vardiya linkine tıkla")
    public void clickShiftLink() {
        LogTest.info("Vardiya linkine tıklanıyor");
        WebElement shiftLink = BaseStep.findElementXpathWithWait(
                "//*[@id=\"root\"]/div/nav/div[2]/div/div[1]/div[1]/div[3]/a[8]",
                TimeOut.LONG.value
        );
        BaseStep.clickElement(shiftLink, "Vardiya mega menü linki");
        BaseStep.waitForPageLoad();
        BaseStep.waitSeconds(2);
        LogTest.info("Vardiya sayfası yüklendi");
    }

    // ============================================================
    // QR PDKS
    // ============================================================

    @Test
    @Order(24)
    @DisplayName("Modüller navbar dropdown'unu QR PDKS için aç")
    public void openModulesDropdownForQrPdks() {
        LogTest.info("Modüller navbar linkine tıklanıyor, dropdown açılıyor");
        openModulesNavbarDropdown();
        LogTest.info("Modüller dropdown menüsü açıldı");
    }

    @Test
    @Order(25)
    @DisplayName("Dropdown'dan QR PDKS linkine tıkla")
    public void clickQrPdksLink() {
        LogTest.info("QR PDKS linkine tıklanıyor");
        WebElement qrPdksLink = BaseStep.findElementXpathWithWait(
                "//*[@id=\"root\"]/div/nav/div[2]/div/div[1]/div[2]/div[3]/a[1]",
                TimeOut.LONG.value
        );
        BaseStep.clickElement(qrPdksLink, "QR PDKS mega menü linki");
        BaseStep.waitForPageLoad();
        BaseStep.waitSeconds(2);
        LogTest.info("QR PDKS sayfası yüklendi");
    }

    @Test
    @Order(26)
    @DisplayName("QR PDKS sayfasını yumuşakça aşağı scroll et")
    public void smoothScrollDownOnQrPdksPage() {
        LogTest.info("QR PDKS sayfası yumuşakça aşağı kaydırılıyor");
        BaseStep.smoothScrollDown(2000, 6);
        BaseStep.waitSeconds(1);
        LogTest.info("QR PDKS scroll tamamlandı");
    }

    // ============================================================
    // LEAVE MANAGEMENT (İzin Yönetimi) - no scroll
    // ============================================================

    @Test
    @Order(27)
    @DisplayName("Modüller navbar dropdown'unu İzin Yönetimi için aç")
    public void openModulesDropdownForLeave() {
        LogTest.info("Modüller navbar linkine tıklanıyor, dropdown açılıyor");
        openModulesNavbarDropdown();
        LogTest.info("Modüller dropdown menüsü açıldı");
    }

    @Test
    @Order(28)
    @DisplayName("Dropdown'dan İzin Yönetimi linkine tıkla")
    public void clickLeaveManagementLink() {
        LogTest.info("İzin Yönetimi linkine tıklanıyor");
        WebElement leaveLink = BaseStep.findElementXpathWithWait(
                "//*[@id=\"root\"]/div/nav/div[2]/div/div[1]/div[2]/div[3]/a[3]",
                TimeOut.LONG.value
        );
        BaseStep.clickElement(leaveLink, "İzin Yönetimi mega menü linki");
        BaseStep.waitForPageLoad();
        BaseStep.waitSeconds(2);
        LogTest.info("İzin Yönetimi sayfası yüklendi (scroll yapılmayacak)");
    }

    // ============================================================
    // ONBOARDING (İşe Giriş Yönetimi) - no scroll
    // ============================================================

    @Test
    @Order(29)
    @DisplayName("Modüller navbar dropdown'unu İşe Giriş Yönetimi için aç")
    public void openModulesDropdownForOnboarding() {
        LogTest.info("Modüller navbar linkine tıklanıyor, dropdown açılıyor");
        openModulesNavbarDropdown();
        LogTest.info("Modüller dropdown menüsü açıldı");
    }

    @Test
    @Order(30)
    @DisplayName("Dropdown'dan İşe Giriş Yönetimi linkine tıkla")
    public void clickOnboardingLink() {
        LogTest.info("İşe Giriş Yönetimi linkine tıklanıyor");
        WebElement onboardingLink = BaseStep.findElementXpathWithWait(
                "//*[@id=\"root\"]/div/nav/div[2]/div/div[1]/div[2]/div[3]/a[4]",
                TimeOut.LONG.value
        );
        BaseStep.clickElement(onboardingLink, "İşe Giriş Yönetimi mega menü linki");
        BaseStep.waitForPageLoad();
        BaseStep.waitSeconds(2);
        LogTest.info("İşe Giriş Yönetimi sayfası yüklendi (scroll yapılmayacak)");
    }

    @Test
    @Order(31)
    @DisplayName("Tarayıcıyı Kapat")
    public void closeBrowser() {
        LogTest.info("Tarayıcı kapatılıyor");
        BaseStep.driverQuit();
        LogTest.info("Tarayıcı kapatıldı");
    }
}
