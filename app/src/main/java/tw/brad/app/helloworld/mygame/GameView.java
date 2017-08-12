package tw.brad.app.helloworld.mygame;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.View;

public class GameView extends View {
    private Bitmap bmpBall;
    private Resources res;
    private Paint paintBall;
    private boolean isInit;
    private int viewW, viewH;
    private float ballW, ballH;
    private Matrix matrix;

    public GameView(Context context) {
        super(context);
        setBackgroundResource(R.drawable.bg);
        res = context.getResources();
        bmpBall = BitmapFactory.decodeResource(res,R.drawable.ball);
        paintBall = new Paint();
        paintBall.setAlpha(255);

        matrix = new Matrix();
    }
    private void init(){
        isInit = true;
        viewW = getWidth(); viewH = getHeight();
        ballW = viewW / 12f; ballH = ballW;

        matrix.reset();
        matrix.postScale(ballW / bmpBall.getWidth(), ballH / bmpBall.getHeight());
        bmpBall = Bitmap.createBitmap(bmpBall,0,0,
                bmpBall.getWidth(),bmpBall.getHeight(),
                matrix, false);


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInit) init();

        canvas.drawBitmap(bmpBall,0,0,paintBall);

    }
}
