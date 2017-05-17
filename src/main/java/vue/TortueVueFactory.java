package vue;

import model.Tortue;
import model.Visualisable;

import java.lang.reflect.InvocationTargetException;

public class TortueVueFactory {

    TortueVue construire(Tortue t) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        return (TortueVue) t.getVisualiseur().getConstructor(Tortue.class).newInstance(t);
    }
}
