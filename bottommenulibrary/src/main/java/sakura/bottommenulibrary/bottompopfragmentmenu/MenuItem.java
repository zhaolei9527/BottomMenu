package sakura.bottommenulibrary.bottompopfragmentmenu;

public class MenuItem {
    public MenuItem() {

    }

    /**
     * @param _item_name               菜单项名称
     * @param _text                    菜单项显示内容
     * @param _style                   菜单类型
     */
    public MenuItem(String _item_name, String _text, MenuItemStyle _style) {
        this.item_name = _item_name;
        this.text = _text;
        this.style = _style;
    }

    public MenuItem(String _text, MenuItemStyle _style) {
        this.text = _text;
        this.style = _style;
    }

    public MenuItem(String _text) {
        this.text = _text;
    }

    private String item_name;
    private String text;
    private MenuItemStyle style = MenuItemStyle.COMMON;

    public String getItem_name() {
        return item_name;
    }

    public String getText() {
        return text;
    }

    public MenuItemStyle getStyle() {
        return style;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public void setText(String text) {
        this.text = text;
    }

    /**
     * @param style 菜单类型
     */
    public void setStyle(MenuItemStyle style) {
        this.style = style;
    }

    public enum MenuItemStyle {
        COMMON, STRESS
    }

}
