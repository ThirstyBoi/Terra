package draedon.content;

import draedon.DraedonMain;

public class ArtemisUnit extends ExoTwinsTrailUnit {
    public float test = 0f;
    @Override
    public int classId(){
        return DraedonMain.artemisID;
    }
    public ApolloUnit apolloPair;
}
