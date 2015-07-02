package test.cristian.lm;

import java.util.ArrayList;

/**
 * Created by cristian on 2/07/15.
 */
public class Datasource {

    public static final ArrayList<Menu> getOptionsMenu() {
        ArrayList<Menu> menus = new ArrayList<>();
        menus.add(new Menu("Mi cuenta", 0));
        menus.add(new Menu("Últimos movimientos", 0));
        menus.add(new Menu("Mis inversiones", 0));
        menus.add(new Menu("Rentabilidad", 0));
        menus.add(new Menu("Mis documentos", 0));
        menus.add(new Menu("Actualizar", 0));
        menus.add(new Menu("Suscripciones", 0));
        menus.add(new Menu("Noticias", 0));
        menus.add(new Menu("Estados de cuenta", 0));
        menus.add(new Menu("Mi asesor", 0));
        menus.add(new Menu("Cerrar sesión", 0));

        return menus;
    }
}
