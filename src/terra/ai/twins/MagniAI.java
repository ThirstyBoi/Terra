package terra.ai.twins;

import arc.math.*;
import mindustry.ai.types.FlyingAI;

public class MagniAI extends FlyingAI {
    public float widthBounds = 600;
    public float heightBounds = 50;

    @Override
    public void updateUnit() {
        updateTargeting();
        if (target != null) {
            unit.x = Mathf.clamp(unit.x, target.x() - widthBounds, target.x() + widthBounds);
            unit.y = Mathf.clamp(unit.y, target.y() - heightBounds, target.y() + heightBounds);
            moveTo(target, unit.type.range * 0.8f, 5f, true, null);
            unit.lookAt(target);
        }
    }
}