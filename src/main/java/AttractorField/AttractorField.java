package AttractorField;

import processing.core.PApplet;

import java.util.ArrayList;
import java.util.List;

public class AttractorField {
    List<Attractor> attractors;

    public AttractorField(PApplet applet, int attractorCount) {
        attractors = new ArrayList<>();

        for (int i = 0; i < attractorCount; i++) {
            attractors.add(new Attractor(applet));
        }
    }

    public List<Attractor> getAttractors() {
        return attractors;
    }
}
