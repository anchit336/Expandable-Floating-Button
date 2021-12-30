package rob.myappcompany.expandablefloatingactionbutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import rob.myappcompany.expandablefloatingactionbutton.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    Animation aniOpen, aniClose, rotateForward, rotateBackWord;
    boolean isOpen = false; //By default it is false

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Animation
        aniOpen = AnimationUtils.loadAnimation(this, R.anim.rotate_open_anim);
        aniClose = AnimationUtils.loadAnimation(this, R.anim.rotate_close_anim);

        rotateForward = AnimationUtils.loadAnimation(this, R.anim.from_bottom_anim);
        rotateBackWord = AnimationUtils.loadAnimation(this, R.anim.to_bottom_anim);

        binding.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animationFab();
            }
        });

        binding.editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Open Edit", Toast.LENGTH_SHORT).show();
            }
        });

        binding.imageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Open Gallery", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void animationFab() {
        if (isOpen)
        {
            binding.addBtn.startAnimation(rotateForward);
            binding.editBtn.startAnimation(aniClose);
            binding.imageBtn.startAnimation(aniClose);
            binding.editBtn.setClickable(false);
            binding.imageBtn.setClickable(false);
            isOpen = false;
        } else {
            binding.addBtn.startAnimation(rotateBackWord);
            binding.addBtn.startAnimation(aniOpen);
            binding.editBtn.startAnimation(aniOpen);
            binding.imageBtn.startAnimation(aniOpen);
            binding.editBtn.setClickable(true);
            binding.imageBtn.setClickable(true);
            isOpen = true;
        }
    }
}