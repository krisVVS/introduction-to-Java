package com.onto.javacourse.objectsinjava.drawers;
import com.onto.javacourse.objectsinjava.hierachyoffigures.*;
import com.onto.javacourse.objectsinjava.interfaces.Drawer;
import java.util.HashMap;
import java.util.Map;

/**
 * The {@code DrawerFactory} class provides a mechanism to obtain
 * the appropriate {@code Drawer} implementation for different {@code Figure} types.
 * This class uses a static map to associate figure classes with their corresponding drawers.
 */
public class DrawerFactory {

    private static final Map<Class<?>, Drawer<?>> drawerMap = new HashMap<>();

    static {
        drawerMap.put(Point.class, new DrawerPoint());
        drawerMap.put(Line.class, new DrawerLine());
        drawerMap.put(Rectangle.class, new DrawerRectangle());
        drawerMap.put(Square.class, new DrawerSquare());
    }

    /**
     * Returns the appropriate {@code Drawer} for the specified figure.
     *
     * @param figure the {@code Figure} for which to obtain a {@code Drawer}
     * @param <T> the type of the figure extending {@code Figure}
     * @return the corresponding {@code Drawer} for the specified figure
     * @throws IllegalArgumentException if no drawer is found for the figure's class
     */
    @SuppressWarnings("unchecked")
    public static <T extends Figure> Drawer<T> getDrawer(T figure) {
        Drawer<T> drawer = (Drawer<T>) drawerMap.get(figure.getClass());
        if (drawer == null) {
            throw new IllegalArgumentException("No drawer found for figure: " + figure.getClass().getSimpleName());
        }
        return drawer;
    }
}
