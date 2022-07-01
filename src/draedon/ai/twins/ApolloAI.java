package draedon.ai.twins;

import arc.math.*;
import arc.util.Time;
import mindustry.ai.types.FlyingAI;
import draedon.content.ApolloUnit;
import draedon.content.ArtemisUnit;

public class ApolloAI extends FlyingAI {
    public float widthBounds = 400;
    public float heightBounds = 200;
    public float regroupCooldown = 0;

    public boolean retarget(){
        return timer.get(timerTarget, 2); //or another interval in ticks
    }
    @Override
    public void updateUnit() {
        ArtemisUnit apollo = ((ApolloUnit)unit).artemisPair;
        updateTargeting();
        //clamps to his target
        if (target != null) {
            unit.x = Mathf.clamp(unit.x, target.x() - widthBounds, target.x() + widthBounds);
            unit.y = Mathf.clamp(unit.y, target.y() - heightBounds, target.y() + heightBounds);
            moveTo(target, unit.type.range * 0.9f, 120f, false, null);
            unit.lookAt(target);
            regroupCooldown = 300;
        }
        //regroups with artemis
        else if((regroupCooldown = Math.max(regroupCooldown - Time.delta, 0f)) == 0f) {
            moveTo(apollo, unit.type.range, 80f, true, null);
            if(apollo != null){
                unit.lookAt(apollo);
            }
        }
    }
}