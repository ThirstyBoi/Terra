package draedon.util;

import mindustry.entities.*;
import mindustry.graphics.*;
import draedon.graphics.ExoTwinsTrail;

import static mindustry.Vars.*;

public class UtilFx{
    public static Effect

    driftTrailFade = new Effect(400f, e -> {
        if(!(e.data instanceof ExoTwinsTrail trail)) return;
        //lifetime is how many frames it takes to fade out the trail
        e.lifetime = trail.length * 1.4f;

        if(!state.isPaused()){
            trail.shorten();
            trail.drift();
        }
        trail.drawCap(e.color, e.rotation);
        trail.draw(e.color, e.rotation);
    }),

    driftTrailEngineFade = new Effect(400f, e -> {
        if(!(e.data instanceof ExoTwinsTrail trail)) return;
        //lifetime is how many frames it takes to fade out the trail
        e.lifetime = trail.length * 1.4f;

        if(!state.isPaused()){
            trail.shorten();
            trail.drift();
        }
        trail.drawCap(e.color, e.rotation);
        trail.draw(e.color, e.rotation);
    }).layer(Layer.flyingUnitLow);
}