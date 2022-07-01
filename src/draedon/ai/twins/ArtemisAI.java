package draedon.ai.twins;

import arc.math.*;
import mindustry.ai.types.FlyingAI;

public class ArtemisAI extends FlyingAI {
    public float widthBounds = 300;
    public float heightBounds = 150;
    public boolean retarget(){
        return timer.get(timerTarget, 5); //or another interval in ticks
    }
    @Override
    public void updateUnit() {
        updateTargeting();
        if (target != null) {
            unit.x = Mathf.clamp(unit.x, target.x() - widthBounds, target.x() + widthBounds);
            unit.y = Mathf.clamp(unit.y, target.y() - heightBounds, target.y() + heightBounds);
            moveTo(target, unit.type.range * 0.8f, 60f, true, null);
            unit.lookAt(target);
        }
    }
}
