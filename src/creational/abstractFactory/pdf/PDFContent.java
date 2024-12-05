package creational.abstractFactory.pdf;

import creational.abstractFactory.interfaces.Content;

public class PDFContent implements Content {
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
