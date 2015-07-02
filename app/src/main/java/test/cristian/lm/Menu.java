package test.cristian.lm;

/**
 * Created by cristian on 2/07/15.
 */
public class Menu {

    private String name;
    private int icon;

    public Menu() {
    }

    public Menu(String name, int icon) {
        this.name = name;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}

