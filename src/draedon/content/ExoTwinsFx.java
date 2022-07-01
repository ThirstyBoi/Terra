package draedon.content;

import arc.graphics.Color;
import arc.graphics.g2d.Fill;
import arc.math.Rand;
import arc.math.geom.Vec2;
import mindustry.entities.Effect;
import mindustry.graphics.Pal;

import static arc.graphics.g2d.Draw.color;
import static arc.math.Angles.randLenVectors;

public class ExoTwinsFx {
    public static final Rand rand = new Rand();
    public static final Vec2 v = new Vec2();

    public static final Effect

    shootMagniFlame = new Effect(60f, 160f, e -> {
        color(Pal.berylShot, Pal.gray, Color.darkGray, e.fin());

        randLenVectors(e.id, 17, e.finpow() * 300f, e.rotation, 5f, (x, y) -> {
            Fill.circle(e.x + x, e.y + y, 2f + e.fout() * 4f);
        });
    });
}
