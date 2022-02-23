package AttractorField;

import processing.core.PApplet;
import processing.core.PVector;

public class Attractor {
    PVector position;
    float strength;

    public Attractor(PApplet applet) {
        position = new PVector(applet.random(applet.width), applet.random(applet.height));

        strength = .1f;
    }

    public void update() {

    }

    public void show() {

    }
}
