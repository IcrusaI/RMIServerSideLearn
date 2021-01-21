import org.w3c.dom.*;

import java.rmi.RemoteException;

public class BookcaseValidatorImpl implements BookcaseValidator
{
    public int getCountPageInBook(Element book) throws RemoteException {
        NodeList chapters = book.getElementsByTagName("chapter");
        Element intro = (Element) book.getElementsByTagName("intro").item(0);

        int count = 0;

        for (int i = 0; i < chapters.getLength(); i++) {
            Element chapter = (Element) chapters.item(i);

            int pages = Integer.parseInt(chapter.getAttribute("pages"));

            count += pages;
        }

        int introPages = Integer.parseInt(intro.getAttribute("pages"));

        count += introPages;

        return count;
    }
}