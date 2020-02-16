package com.example.packathon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.graphics.Color;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.example.packathon.model.BoxItem;

import java.util.Random;

public class TurnActivity extends AppCompatActivity {
    private ImageView img1;
    private ImageView img2;
    private ImageView img3;
    private ImageView img4;
    private ImageView boxImg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turn);

        img1 = findViewById(R.id.imageView);
        img1.setTag("GameItemImg1");
        img2  = findViewById(R.id.imageView2);
        img2.setTag("GameItemImg2");
        img3  = findViewById(R.id.imageView3);
        img3.setTag("GameItemImg3");
        img4  = findViewById(R.id.imageView4);
        img4.setTag("GameItemImg4");
        initialize();

        boxImg = findViewById(R.id.boxImage);
        boxImg.setTag("BoxImage");
        setImageOnDragListener(img1);
        setImageOnTouchListener(img1);
        setImageOnDragListener(img2);
        setImageOnTouchListener(img2);
        setImageOnDragListener(img3);
        setImageOnTouchListener(img3);
        setImageOnDragListener(img4);
        setImageOnTouchListener(img4);

    }

    private void initialize() {
        int listOfColour[] = new int [11];
        listOfColour[0] = (Color.BLACK);
        listOfColour[1] = (Color.DKGRAY);
        listOfColour[2] = (Color.GRAY);
        listOfColour[3] = (Color.LTGRAY);
        listOfColour[4] = (Color.WHITE);
        listOfColour[5] = (Color.RED);
        listOfColour[6] = (Color.GREEN);
        listOfColour[7] = (Color.BLUE);
        listOfColour[8] = (Color.YELLOW);
        listOfColour[9] = (Color.CYAN);
        listOfColour[10] = (Color.MAGENTA);

        Random random = new Random();

        BoxItem itm1 = new BoxItem();
        BoxItem itm2 = new BoxItem();
        BoxItem itm3 = new BoxItem();
        BoxItem itm4 = new BoxItem();

        img1.setBackgroundColor(listOfColour[random.nextInt(10)]);
        img2.setBackgroundColor(listOfColour[random.nextInt(10)]);
        img3.setBackgroundColor(listOfColour[random.nextInt(10)]);
        img4.setBackgroundColor(listOfColour[random.nextInt(10)]);
    }


    protected void setImageOnDragListener(ImageView img) {
        img.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                switch (event.getAction()) {
                    case DragEvent.ACTION_DRAG_STARTED:
                        break;
                    case DragEvent.ACTION_DRAG_ENTERED:
                        break;
                    case DragEvent.ACTION_DRAG_EXITED:
                        break;
                    case DragEvent.ACTION_DROP:
                        double xcoord = event.getX();
                        double ycoord = event.getY();
                    case DragEvent.ACTION_DRAG_ENDED:
                    default:
                        break;
                }
                return true;
            }

        });
    }

    protected void setImageOnTouchListener(final ImageView img)  {
        img.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                ClipData data = ClipData.newPlainText("","");
                View.DragShadowBuilder shadow = new View.DragShadowBuilder(img);
                img.setVisibility(View.VISIBLE);
                v.startDragAndDrop(data, shadow, null, 0);
                return false;

            }
        });
    }








    // TODO:
    // If round is over, go to RoundActivity
    // Else InBetweenTurnsActivity
}
