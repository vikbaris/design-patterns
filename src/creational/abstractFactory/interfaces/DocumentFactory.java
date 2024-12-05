package creational.abstractFactory.interfaces;

public interface DocumentFactory {
    Header createHeader();
    Content createContent();
    Footer createFooter();
}
