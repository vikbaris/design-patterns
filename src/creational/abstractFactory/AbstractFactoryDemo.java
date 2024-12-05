package creational.abstractFactory;

public class AbstractFactoryDemo {
    public static void main(String[] args) {
        String[][] financialData = {
            {"Ocak", "100.000 TL", "80.000 TL"},
            {"Şubat", "120.000 TL", "85.000 TL"},
            {"Mart", "140.000 TL", "90.000 TL"}
        };

        System.out.println("PDF Rapor Oluşturuluyor...");
        System.out.println("========================");
        ReportGenerator pdfReport = new ReportGenerator(new creational.abstractFactory.pdf.PDFDocumentFactory());
        pdfReport.generateFinancialReport("Acme Ltd.", financialData);

        System.out.println("\nHTML Rapor Oluşturuluyor...");
        System.out.println("=========================");
        ReportGenerator htmlReport = new ReportGenerator(new creational.abstractFactory.html.HTMLDocumentFactory());
        htmlReport.generateFinancialReport("Acme Ltd.", financialData);
    }
}
