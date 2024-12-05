package creational.abstractFactory.html;

import creational.abstractFactory.interfaces.Content;

public class HTMLContent implements Content {
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
