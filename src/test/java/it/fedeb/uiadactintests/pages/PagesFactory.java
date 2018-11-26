package it.fedeb.uiadactintests.pages;

import java.util.HashMap;
import java.util.Map;

public class PagesFactory {

    private static SearchHotelPage searchHotelPage;
    private static SelectHotelPage selectHotelPage;
    private static Map<String, Object> pages = new HashMap<>();


    public static Object getPage(String pageType) {
        if (!pages.containsKey(pageType)) {
            try {
                pages.put(pageType, Class.forName(pageType).newInstance());
            } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        return pages.get(pageType);
    }


    public static SearchHotelPage getSearchHotelPage() {
        if (searchHotelPage == null) {
            searchHotelPage = new SearchHotelPage();
        }
        return searchHotelPage;
    }

    public static SelectHotelPage getSelectHotelPage() {
        if (selectHotelPage == null) {
            selectHotelPage = new SelectHotelPage();
        }
        return selectHotelPage;
    }

}
