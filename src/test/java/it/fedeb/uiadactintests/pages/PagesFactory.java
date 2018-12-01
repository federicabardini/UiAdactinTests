package it.fedeb.uiadactintests.pages;

import java.util.HashMap;
import java.util.Map;

public class PagesFactory {

    private static Map<Class, Object> pages = new HashMap<>();


    public static Object getPage(Class pageType) {
        if (!pages.containsKey(pageType)) {
            try {
                pages.put(pageType, pageType.newInstance());
            } catch (InstantiationException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return pages.get(pageType);
    }

    public static void destroyAllPages() {
        pages = new HashMap<>();
    }

}
