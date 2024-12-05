package creational.abstractFactory;

import creational.abstractFactory.interfaces.*;

public class ReportGenerator {
    private final Header header;
    private final Content content;
    private final Footer footer;

    public ReportGenerator(DocumentFactory factory) {
        this.header = factory.createHeader();
        this.content = factory.createContent();
        this.footer = factory.createFooter();
    }

    public void generateFinancialReport(String companyName, String[][] financialData) {
        header.generateHeader(companyName + " Finansal Rapor", "10.11.2024");
        
        content.addParagraph("Aşağıdaki tablo " + companyName + " şirketinin finansal verilerini göstermektedir.");
        content.addTable(financialData);
        content.addParagraph("Bu rapor otomatik olarak oluşturulmuştur.");
        
        footer.addMetadata("Finans Departmanı", companyName);
        footer.addPageNumber(1);
    }
}
