package tw.brad.app.helloworld.mygame;

import android.content.Context;
import android.graphics.Color;
import android.view.View;

public class GameView extends View {
    public GameView(Context context) {
        super(context);
        setBackgroundColor(Color.YELLOW);
    }
}
