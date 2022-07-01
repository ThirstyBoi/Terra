package draedon.ai.twins;

import arc.math.*;
import arc.util.Time;
import draedon.content.ApolloUnit;
import draedon.content.ArtemisUnit;
import mindustry.ai.types.FlyingAI;

public class ArtemisAI extends FlyingAI {


    public float widthBounds = 600;
    public float heightBounds = 600;

    public boolean retarget(){
        return timer.get(timerTarget, 5); //or another interval in ticks
    }
    @Override
    public void updateUnit() {
        updateTargeting();
        if (target != null) {
            //unit.x = Mathf.clamp(unit.x, target.x() - widthBounds, target.x() + widthBounds);
            //unit.y = Mathf.clamp(unit.y, target.y() - heightBounds, target.y() + heightBounds);
            circleAttack(unit.type.range * 0.9f);
            unit.lookAt(target);
        }
    }
}
