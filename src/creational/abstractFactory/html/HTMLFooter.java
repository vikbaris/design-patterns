package creational.abstractFactory.html;

import creational.abstractFactory.interfaces.Footer;

public class HTMLFooter implements Footer {
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
