package sdm.shop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TagTests {

    @Test
    void simpleEmptyTag() {
        assertEquals("<price></price>", new TagNode("price").toString());
    }

    @Test
    void simpleTagWithValue() {
        TagNode tag = new TagNode("price");
        tag.addValue("1.99");
        assertEquals("<price>1.99</price>", tag.toString());
    }

    @Test
    void simpleTagWithAttributesAndValue() {
        TagNode tag = new TagNode("price");
        tag.addAttribute("currency", "USD");
        tag.addValue("8.95");

        String expected =
                "<price currency='USD'>" +
                        "8.95" +
                "</price>";
        
        assertEquals(expected, tag.toString());
    }
}
