package creational.abstractFactory.pdf;

import creational.abstractFactory.interfaces.Header;

public class PDFHeader implements Header {
    @Override
    public void generateHeader(String title, String date) {
        System.out.println("PDF Başlık: " + title);
        System.out.println("PDF Tarih: " + date);
        System.out.println("PDF başlığı için özel font ve stil uygulandı");
    }
}
