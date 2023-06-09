package io.dustin.apps.common.utils;

import io.dustin.apps.common.provider.ApplicationContextProvider;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class CommonUtil {
    public String markdown(String markdown) {
        Parser parser = Parser.builder().build();
        Node document = parser.parse(markdown);
        HtmlRenderer renderer = HtmlRenderer.builder().build();
        return renderer.render(document);
    }

    public static <T> T getBean(String beanId, Class<T> clazz) {
        ApplicationContext applicationContext = ApplicationContextProvider.getApplicationContext();
        if(applicationContext == null) {
            throw new NullPointerException("Not Initialize Spring Container!");
        }
        return (T)applicationContext.getBean(beanId);
    }

}
