package sdm.shop;

public class TagNode {
    private final String name;
    private String value = "";
    private final StringBuilder attributes;

    public TagNode(String name) {
        this.name = name;
        attributes = new StringBuilder();
    }

    public void addValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "<" + name + attributes.toString() + ">" + 
                    value + 
                "</" + name + ">";
    }

    public void addAttribute(String attribute, String value) {
        attributes.append(" ");
        attributes.append(attribute);
        attributes.append("='");
        attributes.append(value);
        attributes.append("'");
    }
}
