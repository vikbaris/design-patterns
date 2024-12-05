package creational.abstractFactory.html;

import creational.abstractFactory.interfaces.Header;

public class HTMLHeader implements Header {
    @Override
    public void generateHeader(String title, String date) {
        System.out.println("<header>");
        System.out.println("  <h1>" + title + "</h1>");
        System.out.println("  <div class='date'>" + date + "</div>");
        System.out.println("</header>");
    }
}
