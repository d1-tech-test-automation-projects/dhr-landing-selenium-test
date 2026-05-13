import org.junit.jupiter.api.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ResourcesPageTest {

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
    @DisplayName("Kaynaklar sekmesine tıkla")
    public void clickResourcesTab() {
        LogTest.info("Kaynaklar sekmesine tıklanıyor");
        WebElement resourcesTab = BaseStep.findElementXpathWithWait(
                "//*[@id=\"root\"]/div/nav/div[1]/div[1]/div[3]/a",
                TimeOut.LONG.value
        );
        BaseStep.clickElement(resourcesTab, "Kaynaklar sekmesi");
        LogTest.info("Kaynaklar dropdown açıldı, seçim öncesi 3 sn bekleniyor");
        BaseStep.waitSeconds(3);
        LogTest.info("Kaynaklar dropdown menüsü açıldı");
    }

    @Test
    @Order(3)
    @DisplayName("Fazla Mesai Ücreti Hesaplama linkine tıkla")
    public void clickOvertimeCalculatorLink() {
        LogTest.info("Fazla Mesai Ücreti Hesaplama linkine tıklanıyor");
        WebElement overtimeCalculatorLink = BaseStep.findElementXpathWithWait(
                "//*[@id=\"root\"]/div/nav/div[1]/div[1]/div[3]/div/div/div[2]/ul/li[1]/a",
                TimeOut.LONG.value
        );
        BaseStep.clickElement(overtimeCalculatorLink, "Fazla Mesai Ücreti Hesaplama linki");
        BaseStep.waitForPageLoad();
        LogTest.info("Fazla Mesai Ücreti Hesaplama sayfası yüklendi");
    }

    @Test
    @Order(4)
    @DisplayName("Aylık Brüt Maaş alanını doldur")
    public void fillMonthlyGrossSalary() {
        LogTest.info("Aylık Brüt Maaş alanı dolduruluyor");
        WebElement monthlySalaryInput = BaseStep.findElementXpathWithWait(
                "//*[@id=\"fazla-mesai-monthlyGrossSalary\"]",
                TimeOut.LONG.value
        );
        BaseStep.clearAndType(monthlySalaryInput, "30000", "Aylık Brüt Maaş input");
        BaseStep.waitSeconds(1);
        LogTest.info("Aylık Brüt Maaş alanı dolduruldu: 30000");
    }

    @Test
    @Order(5)
    @DisplayName("Haftalık Çalışma Saati Modunu seç: 45 Saatin Altında")
    public void selectWeeklyHoursMode() {
        LogTest.info("Haftalık Çalışma Saati Modu seçiliyor: 45 Saatin Altında");
        WebElement weeklyHoursModeDropdown = BaseStep.findElementXpathWithWait(
                "//*[@id=\"fazla-mesai-weeklyHoursMode\"]",
                TimeOut.LONG.value
        );
        BaseStep.clickElement(weeklyHoursModeDropdown, "Haftalık Çalışma Saati Modu dropdown - açılıyor");
        BaseStep.waitSeconds(1);
        WebElement weeklyHoursModeOption = BaseStep.findElementXpathWithWait(
                "//*[@id=\"fazla-mesai-weeklyHoursMode\"]/option[normalize-space(text())='45 Saatin Altında']",
                TimeOut.LONG.value
        );
        BaseStep.clickElement(weeklyHoursModeOption, "Haftalık Çalışma Saati Modu - 45 Saatin Altında seçiliyor");
        BaseStep.waitSeconds(1);
        LogTest.info("Haftalık Çalışma Saati Modu seçildi: 45 Saatin Altında");
    }

    @Test
    @Order(6)
    @DisplayName("Haftalık Çalışma Saatini doldur")
    public void fillWeeklyWorkingHours() {
        LogTest.info("Haftalık Çalışma Saati alanı dolduruluyor");
        WebElement weeklyHoursInput = BaseStep.findElementXpathWithWait(
                "//*[@id=\"fazla-mesai-weeklyWorkingHours\"]",
                TimeOut.LONG.value
        );
        BaseStep.clearAndType(weeklyHoursInput, "40", "Haftalık Çalışma Saati input");
        BaseStep.waitSeconds(1);
        LogTest.info("Haftalık Çalışma Saati alanı dolduruldu: 40");
    }

    @Test
    @Order(7)
    @DisplayName("Fazla Çalışma Saatini doldur")
    public void fillOvertimeHours() {
        LogTest.info("Fazla Çalışma Saati alanı dolduruluyor");
        WebElement overtimeHoursInput = BaseStep.findElementXpathWithWait(
                "//*[@id=\"fazla-mesai-overtimeWithExtraHours\"]",
                TimeOut.LONG.value
        );
        BaseStep.clearAndType(overtimeHoursInput, "8", "Fazla Çalışma Saati input");
        BaseStep.waitSeconds(1);
        LogTest.info("Fazla Çalışma Saati alanı dolduruldu: 8");
    }

    @Test
    @Order(8)
    @DisplayName("HESAPLA butonuna tıkla")
    public void clickCalculateButton() {
        LogTest.info("HESAPLA butonuna tıklanıyor");
        WebElement calculateButton = BaseStep.findElementXpathWithWait(
                "//*[@id=\"calc-body-fazla-mesai\"]/div[2]/button",
                TimeOut.LONG.value
        );
        BaseStep.clickElement(calculateButton, "HESAPLA butonu");
        BaseStep.waitSeconds(2);
        LogTest.info("Hesaplama tamamlandı");
    }

    @Test
    @Order(9)
    @DisplayName("Kapat butonuna tıkla")
    public void clickCloseButton() {
        LogTest.info("Kapat butonuna tıklanıyor");
        WebElement closeButton = BaseStep.findElementXpathWithWait(
                "/html/body/div[2]/div/header/button",
                TimeOut.LONG.value
        );
        BaseStep.clickElement(closeButton, "Kapat butonu");
        BaseStep.waitSeconds(2);
        LogTest.info("Kapat butonuna tıklandı");
    }

    @Test
    @Order(10)
    @DisplayName("Gelir Vergisi Hesaplama bölümüne tıkla")
    public void clickIncomeTaxSection() {
        LogTest.info("Gelir Vergisi Hesaplama bölümüne tıklanıyor");
        WebElement incomeTaxSection = BaseStep.findElementXpathWithWait(
                "//*[@id=\"gelir-vergisi\"]",
                TimeOut.LONG.value
        );
        BaseStep.clickElement(incomeTaxSection, "Gelir Vergisi Hesaplama bölümü");
        BaseStep.waitSeconds(2);
        LogTest.info("Gelir Vergisi Hesaplama bölümüne tıklandı");
    }

    @Test
    @Order(11)
    @DisplayName("Gelir türünü seç: Ücret Geliri")
    public void selectIncomeType() {
        LogTest.info("Gelir türü seçiliyor: Ücret Geliri");
        WebElement incomeTypeDropdown = BaseStep.findElementXpathWithWait(
                "//*[@id=\"gelir-vergisi-incomeType\"]",
                TimeOut.LONG.value
        );
        BaseStep.clickElement(incomeTypeDropdown, "Gelir Türü dropdown - açılıyor");
        BaseStep.waitSeconds(1);
        WebElement incomeTypeOption = BaseStep.findElementXpathWithWait(
                "//*[@id=\"gelir-vergisi-incomeType\"]/option[normalize-space(text())='Ücret geliri']",
                TimeOut.LONG.value
        );
        BaseStep.clickElement(incomeTypeOption, "Gelir Türü - Ücret geliri seçiliyor");
        BaseStep.waitSeconds(1);
        LogTest.info("Gelir türü seçildi: Ücret Geliri");
    }

    @Test
    @Order(12)
    @DisplayName("Vergi Matrahı alanını doldur")
    public void fillTaxBase() {
        LogTest.info("Vergi Matrahı alanı dolduruluyor");
        WebElement taxBaseInput = BaseStep.findElementXpathWithWait(
                "//*[@id=\"gelir-vergisi-taxBase\"]",
                TimeOut.LONG.value
        );
        BaseStep.clearAndType(taxBaseInput, "70000", "Vergi Matrahı input");
        BaseStep.waitSeconds(1);
        LogTest.info("Vergi Matrahı alanı dolduruldu: 70000");
    }

    @Test
    @Order(13)
    @DisplayName("Kümülatif Matrah alanını doldur")
    public void fillCumulativeTaxBase() {
        LogTest.info("Kümülatif Matrah alanı dolduruluyor");
        WebElement cumulativeTaxBaseInput = BaseStep.findElementXpathWithWait(
                "//*[@id=\"gelir-vergisi-cumulativeTaxBase\"]",
                TimeOut.LONG.value
        );
        BaseStep.clearAndType(cumulativeTaxBaseInput, "200000", "Kümülatif Matrah input");
        BaseStep.waitSeconds(1);
        LogTest.info("Kümülatif Matrah alanı dolduruldu: 200000");
    }

    @Test
    @Order(14)
    @DisplayName("Asgari Ücret İstisnası uygula kutusuna tıkla")
    public void clickMinWageExemptionCheckbox() {
        LogTest.info("Asgari Ücret İstisnası uygula kutusuna tıklanıyor");
        WebElement minWageExemptionCheckbox = BaseStep.findElementXpathWithWait(
                "//*[@id=\"gelir-vergisi-applyMinWageExemption\"]",
                TimeOut.LONG.value
        );
        BaseStep.clickElement(minWageExemptionCheckbox, "Asgari Ücret İstisnası checkbox");
        BaseStep.waitSeconds(1);
        LogTest.info("Asgari Ücret İstisnası uygula kutusuna tıklandı");
    }

    @Test
    @Order(15)
    @DisplayName("Gelir Vergisi HESAPLA butonuna tıkla")
    public void clickIncomeTaxCalculateButton() {
        LogTest.info("Gelir Vergisi HESAPLA butonuna tıklanıyor");
        WebElement incomeTaxCalculateButton = BaseStep.findElementXpathWithWait(
                "//*[@id=\"calc-body-gelir-vergisi\"]/div[2]/button",
                TimeOut.LONG.value
        );
        BaseStep.clickElement(incomeTaxCalculateButton, "Gelir Vergisi HESAPLA butonu");
        BaseStep.waitSeconds(2);
        LogTest.info("Gelir Vergisi hesaplama tamamlandı");
    }

    @Test
    @Order(16)
    @DisplayName("Gelir Vergisi sonuç popup'ını kapat")
    public void closeIncomeTaxResultPopup() {
        LogTest.info("Gelir Vergisi sonuç popup'ı kapatılıyor");
        WebElement incomeTaxCloseButton = BaseStep.findElementXpathWithWait(
                "/html/body/div[2]/div/header/button",
                TimeOut.LONG.value
        );
        BaseStep.clickElement(incomeTaxCloseButton, "Gelir Vergisi popup kapat butonu");
        BaseStep.waitSeconds(2);
        LogTest.info("Gelir Vergisi sonuç popup'ı kapatıldı");
    }

    @Test
    @Order(17)
    @DisplayName("İşveren Maliyeti bölümüne tıkla")
    public void clickEmployerCostSection() {
        LogTest.info("İşveren Maliyeti bölümüne tıklanıyor");
        WebElement employerCostSection = BaseStep.findElementXpathWithWait(
                "//*[@id=\"isveren-maliyeti\"]",
                TimeOut.LONG.value
        );
        BaseStep.clickElement(employerCostSection, "İşveren Maliyeti bölümü");
        BaseStep.waitSeconds(2);
        LogTest.info("İşveren Maliyeti bölümüne tıklandı");
    }

    @Test
    @Order(18)
    @DisplayName("Çalışan türünü seç: Normal çalışan")
    public void selectEmployeeType() {
        LogTest.info("Çalışan türü seçiliyor: Normal çalışan");
        WebElement employeeTypeDropdown = BaseStep.findElementXpathWithWait(
                "//*[@id=\"isveren-maliyeti-employeeType\"]",
                TimeOut.LONG.value
        );
        BaseStep.clickElement(employeeTypeDropdown, "Çalışan Türü dropdown - açılıyor");
        BaseStep.waitSeconds(1);
        WebElement employeeTypeOption = BaseStep.findElementXpathWithWait(
                "//*[@id=\"isveren-maliyeti-employeeType\"]/option[normalize-space(text())='Normal çalışan']",
                TimeOut.LONG.value
        );
        BaseStep.clickElement(employeeTypeOption, "Çalışan Türü - Normal çalışan seçiliyor");
        BaseStep.waitSeconds(1);
        LogTest.info("Çalışan türü seçildi: Normal çalışan");
    }

    @Test
    @Order(19)
    @DisplayName("Aylık Brüt Maaş Tutarı alanını doldur")
    public void fillEmployerGrossSalary() {
        LogTest.info("Aylık Brüt Maaş Tutarı alanı dolduruluyor");
        WebElement employerGrossSalaryInput = BaseStep.findElementXpathWithWait(
                "//*[@id=\"isveren-maliyeti-grossSalary\"]",
                TimeOut.LONG.value
        );
        BaseStep.clearAndType(employerGrossSalaryInput, "30000", "Aylık Brüt Maaş Tutarı input");
        BaseStep.waitSeconds(1);
        LogTest.info("Aylık Brüt Maaş Tutarı alanı dolduruldu: 30000");
    }

    @Test
    @Order(20)
    @DisplayName("Hazine Desteği Uygula kutusuna tıkla")
    public void clickTreasurySupportCheckbox() {
        LogTest.info("Hazine Desteği Uygula kutusuna tıklanıyor");
        WebElement treasurySupportCheckbox = BaseStep.findElementXpathWithWait(
                "//*[@id=\"isveren-maliyeti-applyTreasurySupport\"]",
                TimeOut.LONG.value
        );
        BaseStep.clickElement(treasurySupportCheckbox, "Hazine Desteği checkbox");
        BaseStep.waitSeconds(1);
        LogTest.info("Hazine Desteği Uygula kutusuna tıklandı");
    }

    @Test
    @Order(21)
    @DisplayName("İşveren Maliyeti HESAPLA butonuna tıkla")
    public void clickEmployerCostCalculateButton() {
        LogTest.info("İşveren Maliyeti HESAPLA butonuna tıklanıyor");
        WebElement employerCostCalculateButton = BaseStep.findElementXpathWithWait(
                "//*[@id=\"calc-body-isveren-maliyeti\"]/div[2]/button",
                TimeOut.LONG.value
        );
        BaseStep.clickElement(employerCostCalculateButton, "İşveren Maliyeti HESAPLA butonu");
        BaseStep.waitSeconds(2);
        LogTest.info("İşveren Maliyeti hesaplama tamamlandı");
    }

    @Test
    @Order(22)
    @DisplayName("İşveren Maliyeti sonuç popup'ını kapat")
    public void closeEmployerCostResultPopup() {
        LogTest.info("İşveren Maliyeti sonuç popup'ı kapatılıyor");
        WebElement employerCostCloseButton = BaseStep.findElementXpathWithWait(
                "/html/body/div[2]/div/header/button",
                TimeOut.LONG.value
        );
        BaseStep.clickElement(employerCostCloseButton, "İşveren Maliyeti popup kapat butonu");
        BaseStep.waitSeconds(2);
        LogTest.info("İşveren Maliyeti sonuç popup'ı kapatıldı");
    }

    @Test
    @Order(23)
    @DisplayName("Kıdem Tazminatı bölümüne tıkla")
    public void clickSeverancePaySection() {
        LogTest.info("Kıdem Tazminatı bölümüne tıklanıyor");
        WebElement severancePaySection = BaseStep.findElementXpathWithWait(
                "//*[@id=\"kidem-tazminati\"]",
                TimeOut.LONG.value
        );
        BaseStep.clickElement(severancePaySection, "Kıdem Tazminatı bölümü");
        BaseStep.waitSeconds(2);
        LogTest.info("Kıdem Tazminatı bölümüne tıklandı");
    }

    @Test
    @Order(24)
    @DisplayName("İşe giriş tarihini doldur")
    public void fillStartDate() {
        LogTest.info("İşe giriş tarihi dolduruluyor");
        WebElement startDateInput = BaseStep.findElementXpathWithWait(
                "//*[@id=\"kidem-tazminati-startDate\"]",
                TimeOut.LONG.value
        );
        BaseStep.clearAndType(startDateInput, "2020-01-01", "İşe giriş tarihi input");
        BaseStep.waitSeconds(1);
        LogTest.info("İşe giriş tarihi dolduruldu: 2020-01-01");
    }

    @Test
    @Order(25)
    @DisplayName("İşten çıkış tarihini doldur")
    public void fillEndDate() {
        LogTest.info("İşten çıkış tarihi dolduruluyor");
        WebElement endDateInput = BaseStep.findElementXpathWithWait(
                "//*[@id=\"kidem-tazminati-endDate\"]",
                TimeOut.LONG.value
        );
        BaseStep.clearAndType(endDateInput, "2026-05-12", "İşten çıkış tarihi input");
        BaseStep.waitSeconds(1);
        LogTest.info("İşten çıkış tarihi dolduruldu: 2026-05-12");
    }

    @Test
    @Order(26)
    @DisplayName("Brüt Maaş alanını doldur")
    public void fillSeveranceGrossSalary() {
        LogTest.info("Brüt Maaş alanı dolduruluyor");
        WebElement severanceGrossSalaryInput = BaseStep.findElementXpathWithWait(
                "//*[@id=\"kidem-tazminati-grossSalary\"]",
                TimeOut.LONG.value
        );
        BaseStep.clearAndType(severanceGrossSalaryInput, "30000", "Brüt Maaş input");
        BaseStep.waitSeconds(1);
        LogTest.info("Brüt Maaş alanı dolduruldu: 30000");
    }

    @Test
    @Order(27)
    @DisplayName("Yol Yardımı alanını doldur")
    public void fillRoadAllowance() {
        LogTest.info("Yol Yardımı alanı dolduruluyor");
        WebElement roadAllowanceInput = BaseStep.findElementXpathWithWait(
                "//*[@id=\"kidem-tazminati-monthlyRoadAllowance\"]",
                TimeOut.LONG.value
        );
        BaseStep.clearAndType(roadAllowanceInput, "500", "Yol Yardımı input");
        BaseStep.waitSeconds(1);
        LogTest.info("Yol Yardımı alanı dolduruldu: 500");
    }

    @Test
    @Order(28)
    @DisplayName("Yemek Yardımı alanını doldur")
    public void fillMealAllowance() {
        LogTest.info("Yemek Yardımı alanı dolduruluyor");
        WebElement mealAllowanceInput = BaseStep.findElementXpathWithWait(
                "//*[@id=\"kidem-tazminati-monthlyMealAllowance\"]",
                TimeOut.LONG.value
        );
        BaseStep.clearAndType(mealAllowanceInput, "1000", "Yemek Yardımı input");
        BaseStep.waitSeconds(1);
        LogTest.info("Yemek Yardımı alanı dolduruldu: 1000");
    }

    @Test
    @Order(29)
    @DisplayName("Aylık Düzenli İkramiye alanını doldur")
    public void fillMonthlyRegularBonus() {
        LogTest.info("Aylık Düzenli İkramiye alanı dolduruluyor");
        WebElement monthlyRegularBonusInput = BaseStep.findElementXpathWithWait(
                "//*[@id=\"kidem-tazminati-monthlyRegularBonus\"]",
                TimeOut.LONG.value
        );
        BaseStep.clearAndType(monthlyRegularBonusInput, "2000", "Aylık Düzenli İkramiye input");
        BaseStep.waitSeconds(1);
        LogTest.info("Aylık Düzenli İkramiye alanı dolduruldu: 2000");
    }

    @Test
    @Order(30)
    @DisplayName("Kıdem Tazminatı HESAPLA butonuna tıkla")
    public void clickSeveranceCalculateButton() {
        LogTest.info("Kıdem Tazminatı HESAPLA butonuna tıklanıyor");
        WebElement severanceCalculateButton = BaseStep.findElementXpathWithWait(
                "//*[@id=\"calc-body-kidem-tazminati\"]/div[2]/button",
                TimeOut.LONG.value
        );
        BaseStep.clickElement(severanceCalculateButton, "Kıdem Tazminatı HESAPLA butonu");
        BaseStep.waitSeconds(2);
        LogTest.info("Kıdem Tazminatı hesaplama tamamlandı");
    }

    @Test
    @Order(31)
    @DisplayName("Kıdem Tazminatı sonuç popup'ını kapat")
    public void closeSeverancePayResultPopup() {
        LogTest.info("Kıdem Tazminatı sonuç popup'ı kapatılıyor");
        WebElement severanceCloseButton = BaseStep.findElementXpathWithWait(
                "/html/body/div[2]/div/header/button",
                TimeOut.LONG.value
        );
        BaseStep.clickElement(severanceCloseButton, "Kıdem Tazminatı popup kapat butonu");
        BaseStep.waitSeconds(2);
        LogTest.info("Kıdem Tazminatı sonuç popup'ı kapatıldı");
    }

    @Test
    @Order(32)
    @DisplayName("Maaş Zammı bölümüne tıkla")
    public void clickSalaryRaiseSection() {
        LogTest.info("Maaş Zammı bölümüne tıklanıyor");
        WebElement salaryRaiseSection = BaseStep.findElementXpathWithWait(
                "//*[@id=\"maas-zammi\"]",
                TimeOut.LONG.value
        );
        BaseStep.clickElement(salaryRaiseSection, "Maaş Zammı bölümü");
        BaseStep.waitSeconds(2);
        LogTest.info("Maaş Zammı bölümüne tıklandı");
    }

    @Test
    @Order(33)
    @DisplayName("Zam Tutarı ile Hesapla radio butonuna tıkla")
    public void clickRaiseAmountRadioButton() {
        LogTest.info("Zam Tutarı ile Hesapla radio butonuna tıklanıyor");
        WebElement raiseAmountRadioButton = BaseStep.findElementXpathWithWait(
                "//*[@id=\"maas-zammi-calcTypeAmount\"]",
                TimeOut.LONG.value
        );
        BaseStep.clickElement(raiseAmountRadioButton, "Zam Tutarı ile Hesapla radio butonu");
        BaseStep.waitSeconds(1);
        LogTest.info("Zam Tutarı ile Hesapla radio butonuna tıklandı");
    }

    @Test
    @Order(34)
    @DisplayName("Net Maaş alanını doldur")
    public void fillCurrentSalary() {
        LogTest.info("Net Maaş alanı dolduruluyor");
        WebElement currentSalaryInput = BaseStep.findElementXpathWithWait(
                "//*[@id=\"maas-zammi-currentSalary\"]",
                TimeOut.LONG.value
        );
        BaseStep.clearAndType(currentSalaryInput, "30000", "Net Maaş input");
        BaseStep.waitSeconds(1);
        LogTest.info("Net Maaş alanı dolduruldu: 30000");
    }

    @Test
    @Order(35)
    @DisplayName("Zam Tutarı alanını doldur")
    public void fillRaiseAmount() {
        LogTest.info("Zam Tutarı alanı dolduruluyor");
        WebElement raiseAmountInput = BaseStep.findElementXpathWithWait(
                "//*[@id=\"maas-zammi-raiseAmount\"]",
                TimeOut.LONG.value
        );
        BaseStep.clearAndType(raiseAmountInput, "5000", "Zam Tutarı input");
        BaseStep.waitSeconds(1);
        LogTest.info("Zam Tutarı alanı dolduruldu: 5000");
    }

    @Test
    @Order(36)
    @DisplayName("Maaş Zammı HESAPLA butonuna tıkla")
    public void clickSalaryRaiseCalculateButton() {
        LogTest.info("Maaş Zammı HESAPLA butonuna tıklanıyor");
        WebElement salaryRaiseCalculateButton = BaseStep.findElementXpathWithWait(
                "//*[@id=\"calc-body-maas-zammi\"]/div[2]/button",
                TimeOut.LONG.value
        );
        BaseStep.clickElement(salaryRaiseCalculateButton, "Maaş Zammı HESAPLA butonu");
        BaseStep.waitSeconds(2);
        LogTest.info("Maaş Zammı hesaplama tamamlandı");
    }

    @Test
    @Order(38)
    @DisplayName("Maaş Zammı sonuç popup'ını kapat")
    public void closeSalaryRaiseResultPopup() {
        LogTest.info("Maaş Zammı sonuç popup'ı kapatılıyor");
        WebElement salaryRaiseCloseButton = BaseStep.findElementXpathWithWait(
                "/html/body/div[2]/div/header/button",
                TimeOut.LONG.value
        );
        BaseStep.clickElement(salaryRaiseCloseButton, "Maaş Zammı popup kapat butonu");
        BaseStep.waitSeconds(2);
        LogTest.info("Maaş Zammı sonuç popup'ı kapatıldı");
    }

    @Test
    @Order(39)
    @DisplayName("Kurumlar Vergisi bölümüne tıkla")
    public void clickCorporateTaxSection() {
        LogTest.info("Kurumlar Vergisi bölümüne tıklanıyor");
        WebElement corporateTaxSection = BaseStep.findElementXpathWithWait(
                "//*[@id=\"kurumlar-vergisi\"]",
                TimeOut.LONG.value
        );
        BaseStep.clickElement(corporateTaxSection, "Kurumlar Vergisi bölümü");
        BaseStep.waitSeconds(2);
        LogTest.info("Kurumlar Vergisi bölümüne tıklandı");
    }

    @Test
    @Order(40)
    @DisplayName("Vergi dönemini seç: 2025")
    public void selectCorporateTaxYear() {
        LogTest.info("Vergi dönemi yılı seçiliyor: 2025");
        WebElement taxYearDropdown = BaseStep.findElementXpathWithWait(
                "//*[@id=\"kurumlar-vergisi-taxYear\"]",
                TimeOut.LONG.value
        );
        BaseStep.clickElement(taxYearDropdown, "Vergi Dönemi Yıl dropdown - açılıyor");
        BaseStep.waitSeconds(1);
        WebElement taxYearOption = BaseStep.findElementXpathWithWait(
                "//*[@id=\"kurumlar-vergisi-taxYear\"]/option[normalize-space(text())='2025']",
                TimeOut.LONG.value
        );
        BaseStep.clickElement(taxYearOption, "Vergi Dönemi - 2025 seçiliyor");
        BaseStep.waitSeconds(1);
        LogTest.info("Vergi dönemi yılı seçildi: 2025");
    }

    @Test
    @Order(41)
    @DisplayName("Vergi Matrahı alanını doldur")
    public void fillCorporateTaxableProfit() {
        LogTest.info("Vergi Matrahı alanı dolduruluyor");
        WebElement taxableProfitInput = BaseStep.findElementXpathWithWait(
                "//*[@id=\"kurumlar-vergisi-taxableProfit\"]",
                TimeOut.LONG.value
        );
        BaseStep.clearAndType(taxableProfitInput, "1000000", "Vergi Matrahı input");
        BaseStep.waitSeconds(1);
        LogTest.info("Vergi Matrahı alanı dolduruldu: 1000000");
    }

    @Test
    @Order(42)
    @DisplayName("Sektör türünü seç: Genel")
    public void selectCorporateSectorType() {
        LogTest.info("Sektör türü seçiliyor: Genel");
        WebElement sectorTypeDropdown = BaseStep.findElementXpathWithWait(
                "//*[@id=\"kurumlar-vergisi-sectorType\"]",
                TimeOut.LONG.value
        );
        BaseStep.clickElement(sectorTypeDropdown, "Sektör Türü dropdown - açılıyor");
        BaseStep.waitSeconds(1);
        WebElement sectorTypeOption = BaseStep.findElementXpathWithWait(
                "//*[@id=\"kurumlar-vergisi-sectorType\"]/option[normalize-space(text())='Genel']",
                TimeOut.LONG.value
        );
        BaseStep.clickElement(sectorTypeOption, "Sektör Türü - Genel seçiliyor");
        BaseStep.waitSeconds(1);
        LogTest.info("Sektör türü seçildi: Genel");
    }

    @Test
    @Order(43)
    @DisplayName("Kurumlar Vergisi HESAPLA butonuna tıkla")
    public void clickCorporateTaxCalculateButton() {
        LogTest.info("Kurumlar Vergisi HESAPLA butonuna tıklanıyor");
        WebElement corporateTaxCalculateButton = BaseStep.findElementXpathWithWait(
                "//*[@id=\"calc-body-kurumlar-vergisi\"]/div[2]/button",
                TimeOut.LONG.value
        );
        BaseStep.clickElement(corporateTaxCalculateButton, "Kurumlar Vergisi HESAPLA butonu");
        BaseStep.waitSeconds(2);
        LogTest.info("Kurumlar Vergisi hesaplama tamamlandı");
    }

    @Test
    @Order(44)
    @DisplayName("Kurumlar Vergisi sonuç popup'ını kapat")
    public void closeCorporateTaxResultPopup() {
        LogTest.info("Kurumlar Vergisi sonuç popup'ı kapatılıyor");
        WebElement corporateTaxCloseButton = BaseStep.findElementXpathWithWait(
                "/html/body/div[2]/div/header/button",
                TimeOut.LONG.value
        );
        BaseStep.clickElement(corporateTaxCloseButton, "Kurumlar Vergisi popup kapat butonu");
        BaseStep.waitSeconds(2);
        LogTest.info("Kurumlar Vergisi sonuç popup'ı kapatıldı");
    }

    @Test
    @Order(45)
    @DisplayName("Yemek Ücreti bölümüne tıkla")
    public void clickMealAllowanceSection() {
        LogTest.info("Yemek Ücreti bölümüne tıklanıyor");
        WebElement mealAllowanceSection = BaseStep.findElementXpathWithWait(
                "//*[@id=\"yemek-ucreti\"]",
                TimeOut.LONG.value
        );
        BaseStep.clickElement(mealAllowanceSection, "Yemek Ücreti bölümü");
        BaseStep.waitSeconds(2);
        LogTest.info("Yemek Ücreti bölümüne tıklandı");
    }

    @Test
    @Order(46)
    @DisplayName("Ödeme türünü seç: Yemek Kartı (Restoran/Yemek)")
    public void selectMealPaymentType() {
        LogTest.info("Ödeme türü seçiliyor: Yemek Kartı (Restoran/Yemek)");
        WebElement paymentTypeDropdown = BaseStep.findElementXpathWithWait(
                "//*[@id=\"yemek-ucreti-paymentType\"]",
                TimeOut.LONG.value
        );
        BaseStep.clickElement(paymentTypeDropdown, "Ödeme Türü dropdown - açılıyor");
        BaseStep.waitSeconds(1);
        WebElement paymentTypeOption = BaseStep.findElementXpathWithWait(
                "//*[@id=\"yemek-ucreti-paymentType\"]/option[normalize-space(text())='Yemek Kartı (Restoran/Yemek)']",
                TimeOut.LONG.value
        );
        BaseStep.clickElement(paymentTypeOption, "Ödeme Türü - Yemek Kartı (Restoran/Yemek) seçiliyor");
        BaseStep.waitSeconds(1);
        LogTest.info("Ödeme türü seçildi: Yemek Kartı (Restoran/Yemek)");
    }

    @Test
    @Order(47)
    @DisplayName("Ödeme şeklini seç: Brüt")
    public void selectMealPaymentForm() {
        LogTest.info("Ödeme şekli seçiliyor: Brüt");
        WebElement paymentFormDropdown = BaseStep.findElementXpathWithWait(
                "//*[@id=\"yemek-ucreti-paymentForm\"]",
                TimeOut.LONG.value
        );
        BaseStep.clickElement(paymentFormDropdown, "Ödeme Şekli dropdown - açılıyor");
        BaseStep.waitSeconds(1);
        WebElement paymentFormOption = BaseStep.findElementXpathWithWait(
                "//*[@id=\"yemek-ucreti-paymentForm\"]/option[normalize-space(text())='Brüt']",
                TimeOut.LONG.value
        );
        BaseStep.clickElement(paymentFormOption, "Ödeme Şekli - Brüt seçiliyor");
        BaseStep.waitSeconds(1);
        LogTest.info("Ödeme şekli seçildi: Brüt");
    }

    @Test
    @Order(48)
    @DisplayName("Günlük yemek ücretini doldur")
    public void fillDailyMealAllowance() {
        LogTest.info("Günlük yemek ücreti dolduruluyor");
        WebElement dailyAllowanceInput = BaseStep.findElementXpathWithWait(
                "//*[@id=\"yemek-ucreti-dailyAllowance\"]",
                TimeOut.LONG.value
        );
        BaseStep.clearAndType(dailyAllowanceInput, "330", "Günlük Yemek Ücreti input");
        BaseStep.waitSeconds(1);
        LogTest.info("Günlük yemek ücreti dolduruldu: 330");
    }

    @Test
    @Order(49)
    @DisplayName("Çalışılan gün sayısını doldur")
    public void fillWorkingDays() {
        LogTest.info("Çalışılan gün sayısı dolduruluyor");
        WebElement paidDaysInput = BaseStep.findElementXpathWithWait(
                "//*[@id=\"yemek-ucreti-paidDays\"]",
                TimeOut.LONG.value
        );
        BaseStep.clearAndType(paidDaysInput, "22", "Çalışılan Gün Sayısı input");
        BaseStep.waitSeconds(1);
        LogTest.info("Çalışılan gün sayısı dolduruldu: 22");
    }

    @Test
    @Order(50)
    @DisplayName("KDV durumunu seç: %10 KDV dahil")
    public void selectVatMode() {
        LogTest.info("KDV durumu seçiliyor: %10 KDV dahil");
        WebElement vatModeDropdown = BaseStep.findElementXpathWithWait(
                "//*[@id=\"yemek-ucreti-vatMode\"]",
                TimeOut.LONG.value
        );
        BaseStep.clickElement(vatModeDropdown, "KDV Durumu dropdown - açılıyor");
        BaseStep.waitSeconds(1);
        WebElement vatModeOption = BaseStep.findElementXpathWithWait(
                "//*[@id=\"yemek-ucreti-vatMode\"]/option[normalize-space(text())='%10 KDV dahil']",
                TimeOut.LONG.value
        );
        BaseStep.clickElement(vatModeOption, "KDV Durumu - %10 KDV dahil seçiliyor");
        BaseStep.waitSeconds(1);
        LogTest.info("KDV durumu seçildi: %10 KDV dahil");
    }

    @Test
    @Order(51)
    @DisplayName("Yemek Ücreti HESAPLA butonuna tıkla")
    public void clickMealAllowanceCalculateButton() {
        LogTest.info("Yemek Ücreti HESAPLA butonuna tıklanıyor");
        WebElement mealAllowanceCalculateButton = BaseStep.findElementXpathWithWait(
                "//*[@id=\"calc-body-yemek-ucreti\"]/div[2]/button",
                TimeOut.LONG.value
        );
        BaseStep.clickElement(mealAllowanceCalculateButton, "Yemek Ücreti HESAPLA butonu");
        BaseStep.waitSeconds(2);
        LogTest.info("Yemek Ücreti hesaplama tamamlandı");
    }

    @Test
    @Order(52)
    @DisplayName("Yemek Ücreti sonuç popup'ını kapat")
    public void closeMealAllowanceResultPopup() {
        LogTest.info("Yemek Ücreti sonuç popup'ı kapatılıyor");
        WebElement mealAllowanceCloseButton = BaseStep.findElementXpathWithWait(
                "/html/body/div[2]/div/header/button",
                TimeOut.LONG.value
        );
        BaseStep.clickElement(mealAllowanceCloseButton, "Yemek Ücreti popup kapat butonu");
        BaseStep.waitSeconds(2);
        LogTest.info("Yemek Ücreti sonuç popup'ı kapatıldı");
    }

    @Test
    @Order(53)
    @DisplayName("İhbar Tazminatı bölümüne tıkla")
    public void clickNoticePeriodSection() {
        LogTest.info("İhbar Tazminatı bölümüne tıklanıyor");
        WebElement noticePeriodSection = BaseStep.findElementXpathWithWait(
                "//*[@id=\"ihbar-tazminati\"]",
                TimeOut.LONG.value
        );
        BaseStep.clickElement(noticePeriodSection, "İhbar Tazminatı bölümü");
        BaseStep.waitSeconds(2);
        LogTest.info("İhbar Tazminatı bölümüne tıklandı");
    }

    @Test
    @Order(54)
    @DisplayName("İşe giriş tarihini doldur")
    public void fillNoticePeriodStartDate() {
        LogTest.info("İşe giriş tarihi dolduruluyor");
        WebElement startDateInput = BaseStep.findElementXpathWithWait(
                "//*[@id=\"ihbar-tazminati-startDate\"]",
                TimeOut.LONG.value
        );
        BaseStep.clearAndType(startDateInput, "2020-01-01", "İşe Giriş Tarihi input");
        BaseStep.waitSeconds(1);
        LogTest.info("İşe giriş tarihi dolduruldu: 2020-01-01");
    }

    @Test
    @Order(55)
    @DisplayName("İşten çıkış tarihini doldur")
    public void fillNoticePeriodEndDate() {
        LogTest.info("İşten çıkış tarihi dolduruluyor");
        WebElement endDateInput = BaseStep.findElementXpathWithWait(
                "//*[@id=\"ihbar-tazminati-endDate\"]",
                TimeOut.LONG.value
        );
        BaseStep.clearAndType(endDateInput, "2026-05-12", "İşten Çıkış Tarihi input");
        BaseStep.waitSeconds(1);
        LogTest.info("İşten çıkış tarihi dolduruldu: 2026-05-12");
    }

    @Test
    @Order(56)
    @DisplayName("Aylık Brüt Maaş Tutarı alanını doldur")
    public void fillNoticePeriodGrossSalary() {
        LogTest.info("Aylık Brüt Maaş Tutarı alanı dolduruluyor");
        WebElement grossSalaryInput = BaseStep.findElementXpathWithWait(
                "//*[@id=\"ihbar-tazminati-lastGrossSalary\"]",
                TimeOut.LONG.value
        );
        BaseStep.clearAndType(grossSalaryInput, "30000", "Aylık Brüt Maaş Tutarı input");
        BaseStep.waitSeconds(1);
        LogTest.info("Aylık Brüt Maaş Tutarı alanı dolduruldu: 30000");
    }

    @Test
    @Order(57)
    @DisplayName("K.G.V.M alanını doldur")
    public void fillNoticePeriodCumulativeTaxBase() {
        LogTest.info("K.G.V.M alanı dolduruluyor");
        WebElement cumulativeTaxBaseInput = BaseStep.findElementXpathWithWait(
                "//*[@id=\"ihbar-tazminati-cumulativeTaxBase\"]",
                TimeOut.LONG.value
        );
        BaseStep.clearAndType(cumulativeTaxBaseInput, "200000", "K.G.V.M input");
        BaseStep.waitSeconds(1);
        LogTest.info("K.G.V.M alanı dolduruldu: 200000");
    }

    @Test
    @Order(58)
    @DisplayName("İhbar Tazminatı HESAPLA butonuna tıkla")
    public void clickNoticePeriodCalculateButton() {
        LogTest.info("İhbar Tazminatı HESAPLA butonuna tıklanıyor");
        WebElement noticePeriodCalculateButton = BaseStep.findElementXpathWithWait(
                "//*[@id=\"calc-body-ihbar-tazminati\"]/div[2]/button",
                TimeOut.LONG.value
        );
        BaseStep.clickElement(noticePeriodCalculateButton, "İhbar Tazminatı HESAPLA butonu");
        BaseStep.waitSeconds(2);
        LogTest.info("İhbar Tazminatı hesaplama tamamlandı");
    }

    @Test
    @Order(59)
    @DisplayName("İhbar Tazminatı sonuç popup'ını kapat")
    public void closeNoticePeriodResultPopup() {
        LogTest.info("İhbar Tazminatı sonuç popup'ı kapatılıyor");
        WebElement noticePeriodCloseButton = BaseStep.findElementXpathWithWait(
                "/html/body/div[2]/div/header/button",
                TimeOut.LONG.value
        );
        BaseStep.clickElement(noticePeriodCloseButton, "İhbar Tazminatı popup kapat butonu");
        BaseStep.waitSeconds(2);
        LogTest.info("İhbar Tazminatı sonuç popup'ı kapatıldı");
    }

    @Test
    @Order(60)
    @DisplayName("Yavaşça aşağı scroll et ve Demo Talep Edin butonuna tıkla")
    public void clickDemoRequestButton() {
        LogTest.info("İhbar Tazminatı sonrası sayfa yavaşça aşağı kaydırılıyor");
        BaseStep.smoothScrollDown(1500, 8);
        BaseStep.waitSeconds(2);
        LogTest.info("Demo Talep Edin butonuna tıklanıyor");
        WebElement demoRequestButton = BaseStep.findElementXpathWithWait(
                "//*[@id=\"root\"]/div/main/div/section[3]/div/div/div[1]/a",
                TimeOut.LONG.value
        );
        BaseStep.scrollIntoCenter(demoRequestButton);
        BaseStep.clickElement(demoRequestButton, "Demo Talep Edin butonu");
        BaseStep.waitForPageLoad();
        LogTest.info("Demo Talep Edin butonuna tıklandı, iletişim sayfası yüklendi");
    }

    @Test
    @Order(61)
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
    @Order(62)
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
    @Order(63)
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
    @Order(64)
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
    @Order(65)
    @DisplayName("Çalışan Sayısı Aralığını seç: 51-200")
    public void selectContactEmployeeRange() {
        LogTest.info("Çalışan Sayısı Aralığı seçiliyor: 51-200");
        WebElement employeeRangeDropdown = BaseStep.findElementXpathWithWait(
                "//select[@name='employees' and contains(@class,'contact__select')]",
                TimeOut.LONG.value
        );
        BaseStep.clickElement(employeeRangeDropdown, "Çalışan Sayısı Aralığı dropdown - açılıyor");
        BaseStep.waitSeconds(1);
        WebElement employeeRangeOption = BaseStep.findElementXpathWithWait(
                "//select[@name='employees' and contains(@class,'contact__select')]/option[@value='51-200']",
                TimeOut.LONG.value
        );
        BaseStep.clickElement(employeeRangeOption, "Çalışan Sayısı Aralığı - 51-200 seçiliyor");
        BaseStep.waitSeconds(1);
        LogTest.info("Çalışan Sayısı Aralığı seçildi: 51-200");
    }

    @Test
    @Order(66)
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
    @Order(67)
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

    @Test
    @Order(68)
    @DisplayName("Tarayıcıyı Kapat")
    public void closeBrowser() {
        LogTest.info("Tarayıcı kapatılıyor");
        BaseStep.driverQuit();
        LogTest.info("Tarayıcı kapatıldı");
    }

}
