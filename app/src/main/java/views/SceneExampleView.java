
package views;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;

import com.huawei.hms.scene.sdk.SceneView;

public class SceneExampleView extends SceneView {

    private int id;

    public SceneExampleView(Context context, int id) {
        super(context);
        this.id = id;
    }

    public SceneExampleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        super.surfaceCreated(holder);

        loadScene(id + "_pl.gltf");

        loadSkyBox("skyboxTexture.dds");

        loadSpecularEnvTexture("specularEnvTexture.dds");

        loadDiffuseEnvTexture("diffuseEnvTexture.dds");
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        super.surfaceChanged(holder, format, width, height);
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        super.surfaceDestroyed(holder);
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}

