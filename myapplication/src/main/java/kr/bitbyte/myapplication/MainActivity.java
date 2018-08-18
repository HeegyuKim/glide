package kr.bitbyte.myapplication;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

public class MainActivity
    extends Activity
{
  class GifListener implements RequestListener<GifDrawable> {

    int fps;

    public GifListener(int fps) {
      this.fps = fps;
    }

    @Override
    public boolean onLoadFailed(@Nullable GlideException e, Object model,
        Target<GifDrawable> target,
        boolean isFirstResource) {
      return false;
    }

    @Override
    public boolean onResourceReady(GifDrawable resource, Object model, Target<GifDrawable> target,
        DataSource dataSource, boolean isFirstResource) {
      resource.setFramePerSecond(fps);
      return false;
    }
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);


//    String url = "https://media1.giphy.com/media/gGGYRTQOaNauY/giphy.gif";
    String url = "https://media1.tenor.com/images/7cf033d5b2ee8939ea6c4a47e9b571d4/tenor.gif";
    ImageView iv1 = findViewById(R.id.iv_1);
    ImageView iv2 = findViewById(R.id.iv_2);

    RequestManager glide = Glide.with(this);
    glide.asGif().load(url).listener(
        new GifListener(GifDrawable.SOURCE_FRAME)
    ).into(iv1);
    glide.asGif().load(url).listener(
        new GifListener(5)
    ).into(iv2);
  }
}
