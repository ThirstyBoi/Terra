package draedon.content;

import draedon.DraedonMain;

public class ArtemisUnit extends ExoTwinsTrailUnit {
    @Override
    public int classId(){
        return DraedonMain.artemisID;
    }
    public ApolloUnit apolloPair;
}
