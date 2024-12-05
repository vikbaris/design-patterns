package creational;

/*
 * Abstract Factory ve Factory Method Arasındaki Temel Fark

- Abstract Factory: Bir ürün ailesi için bir fabrikadır. Birden fazla ürün tipi oluşturmak için birden fazla factory metoduna sahiptir.
- Factory Method: Tek bir ürün tipi için bir fabrikadır. Her fabrika, bir ürün oluşturmak için tek bir factory metoduna sahiptir.
 */

// Document Components (Abstract Products)
interface Header {
    void generateHeader(String title, String date);
}

interface Content {
    void addParagraph(String text);
    void addTable(String[][] data);
}

interface Footer {
    void addPageNumber(int pageNumber);
    void addMetadata(String author, String company);
}

// PDF Components (Concrete Products)
class PDFHeader implements Header {
    @Override
    public void generateHeader(String title, String date) {
        System.out.println("PDF Başlık: " + title);
        System.out.println("PDF Tarih: " + date);
        System.out.println("PDF başlığı için özel font ve stil uygulandı");
    }
}

class PDFContent implements Content {
    @Override
    public void addParagraph(String text) {
        System.out.println("PDF Paragraf eklendi: " + text);
        System.out.println("PDF metin formatı ve sayfa düzeni ayarlandı");
    }

    @Override
    public void addTable(String[][] data) {
        System.out.println("PDF Tablo eklendi");
        System.out.println("PDF tablo gridleri ve hücre stilleri ayarlandı");
    }
}

class PDFFooter implements Footer {
    @Override
    public void addPageNumber(int pageNumber) {
        System.out.println("PDF Sayfa numarası eklendi: " + pageNumber);
    }

    @Override
    public void addMetadata(String author, String company) {
        System.out.println("PDF Metadata eklendi: Yazar=" + author + ", Şirket=" + company);
    }
}

// HTML Components (Concrete Products)
class HTMLHeader implements Header {
    @Override
    public void generateHeader(String title, String date) {
        System.out.println("<header>");
        System.out.println("  <h1>" + title + "</h1>");
        System.out.println("  <div class='date'>" + date + "</div>");
        System.out.println("</header>");
    }
}

class HTMLContent implements Content {
    @Override
    public void addParagraph(String text) {
        System.out.println("<p>" + text + "</p>");
    }

    @Override
    public void addTable(String[][] data) {
        System.out.println("<table>");
        for (String[] row : data) {
            System.out.println("  <tr>");
            for (String cell : row) {
                System.out.println("    <td>" + cell + "</td>");
            }
            System.out.println("  </tr>");
        }
        System.out.println("</table>");
    }
}

class HTMLFooter implements Footer {
    @Override
    public void addPageNumber(int pageNumber) {
        System.out.println("<footer>");
        System.out.println("  <div class='page-number'>Sayfa " + pageNumber + "</div>");
        System.out.println("</footer>");
    }

    @Override
    public void addMetadata(String author, String company) {
        System.out.println("<meta name='author' content='" + author + "'>");
        System.out.println("<meta name='company' content='" + company + "'>");
    }
}

// Abstract Factory
interface DocumentFactory {
    Header createHeader();
    Content createContent();
    Footer createFooter();
}

// Concrete Factories
class PDFDocumentFactory implements DocumentFactory {
    @Override
    public Header createHeader() {
        return new PDFHeader();
    }

    @Override
    public Content createContent() {
        return new PDFContent();
    }

    @Override
    public Footer createFooter() {
        return new PDFFooter();
    }
}

class HTMLDocumentFactory implements DocumentFactory {
    @Override
    public Header createHeader() {
        return new HTMLHeader();
    }

    @Override
    public Content createContent() {
        return new HTMLContent();
    }

    @Override
    public Footer createFooter() {
        return new HTMLFooter();
    }
}


// Document Generator (Client)
class ReportGenerator {
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

// Usage Example
class AbstractFactory {
    public static void main(String[] args) {
        String[][] financialData = {
            {"Ocak", "100.000 TL", "80.000 TL"},
            {"Şubat", "120.000 TL", "85.000 TL"},
            {"Mart", "140.000 TL", "90.000 TL"}
        };

        System.out.println("PDF Rapor Oluşturuluyor...");
        System.out.println("========================");
        ReportGenerator pdfReport = new ReportGenerator(new PDFDocumentFactory());
        pdfReport.generateFinancialReport("Acme Ltd.", financialData);

        System.out.println("\nHTML Rapor Oluşturuluyor...");
        System.out.println("=========================");
        ReportGenerator htmlReport = new ReportGenerator(new HTMLDocumentFactory());
        htmlReport.generateFinancialReport("Acme Ltd.", financialData);
    }
}
