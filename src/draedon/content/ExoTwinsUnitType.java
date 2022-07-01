package draedon.content;

import arc.graphics.g2d.Draw;
import mindustry.gen.*;
import mindustry.graphics.Layer;
import mindustry.type.unit.*;

public class ExoTwinsUnitType extends ErekirUnitType{
    public ExoTwinsUnitType(String name){
        super(name);
        constructor = ExoTwinsTrailUnit::new;

        trailLength = 1; //Trick the game into running drawTrail().
        engineSize = -1; //Don't make center engine by default. Chances are, it's gonna be a drift trail engine instead.

        circleTarget = true;
    }

    @Override
    public void init(){
        super.init();
        EntityMapping.nameMap.put(name, constructor);
    }



    @Override
    public void drawTrail(Unit unit){
        ExoTwinsTrailUnit d = (ExoTwinsTrailUnit)unit;
        float z = Draw.z();
        Draw.z(Layer.bullet - 0.01f);
        if(d.driftTrails != null){
            d.driftTrails.each(t -> t.draw(engineColor == null ? d.team.color : engineColor, 1f));
        }
        Draw.z(z);
    }
}