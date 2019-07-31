package dev.terrylabs.lottiepractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import com.airbnb.lottie.LottieDrawable;

import dev.terrylabs.lottiepractice.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private boolean isOn = true; // Initial Switch Value is ON
    private ActivityMainBinding binding;
    private final int entireFrame = 106;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setActivity(this);

        binding.lottieAnimationView    .setAnimation("animation.json");
        binding.lottieAnimationViewDuck.setAnimation("ducks_animation.json");
        binding.lottieAnimationViewDuck.setRepeatCount(LottieDrawable.INFINITE);
        binding.lottieAnimationViewDuck.playAnimation();
        //binding.lottieAnimationView.loop(true); // Deprecated
    }

    public void onClickSwitch(View view) {
        this. isOn       = !isOn;
        int   startFrame = isOn ? 50 : 0;
        int   endFrame   = isOn ? 70 : 30;
        float startPoint = (float) startFrame / entireFrame;

        binding.lottieAnimationView.setMaxFrame(endFrame);
        binding.lottieAnimationView.playAnimation();
        binding.lottieAnimationView.setProgress(startPoint);
    }
}
