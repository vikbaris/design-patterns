package creational.abstractFactory.html;

import creational.abstractFactory.interfaces.*;

public class HTMLDocumentFactory implements DocumentFactory {
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
