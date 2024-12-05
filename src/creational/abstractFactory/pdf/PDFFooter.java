package creational.abstractFactory.pdf;

import creational.abstractFactory.interfaces.Footer;

public class PDFFooter implements Footer {
    @Override
    public void addPageNumber(int pageNumber) {
        System.out.println("PDF Sayfa numarası eklendi: " + pageNumber);
    }

    @Override
    public void addMetadata(String author, String company) {
        System.out.println("PDF Metadata eklendi: Yazar=" + author + ", Şirket=" + company);
    }
}
