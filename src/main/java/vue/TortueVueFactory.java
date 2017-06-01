package vue;

import model.Tortue;
import vue.tortue.TortueTriangleVue;
import vue.tortue.TortueVue;

import java.lang.reflect.InvocationTargetException;

public class TortueVueFactory {

    TortueVue construire(Tortue tortue) {
        String className = tortue.getClass().getName().substring(13);
        System.out.println(className);
        System.out.println(TortueVue.class.getName());
        try {
            Class<? extends TortueVue> classe = Class.forName("vue.tortue." + className + "Vue")
                    .asSubclass(TortueVue.class);
            return classe.getConstructor(Tortue.class).newInstance(tortue);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            System.out.println(String.format("Classe non supportée \"%s\"", className));
            return new TortueTriangleVue(tortue);
        }
    }
}
