package com.example.packathon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.example.packathon.model.BoxItem;

import java.util.Random;

import static android.view.View.GONE;

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
        img2 = findViewById(R.id.imageView2);
        img2.setTag("GameItemImg2");
        img3 = findViewById(R.id.imageView3);
        img3.setTag("GameItemImg3");
        img4 = findViewById(R.id.imageView4);
        img4.setTag("GameItemImg4");
        initialize();

        boxImg = findViewById(R.id.boxImage);
        boxImg.setTag("BoxImage");

        boxImg.setOnDragListener(new BoxDragListener(
                R.drawable.box1,
                R.drawable.box2));

        boxImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img1.setVisibility(View.VISIBLE);
                img2.setVisibility(View.VISIBLE);
                img3.setVisibility(View.VISIBLE);
                img4.setVisibility(View.VISIBLE);
            }
        });
        setItOnClickListener(img1);
        setItOnClickListener(img2);
        setItOnClickListener(img3);
        setItOnClickListener(img4);

    }

    private void setItOnClickListener(ImageView img) {
        img.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                ClipData data = ClipData.newPlainText("", "");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
                view.startDrag(data, shadowBuilder, view, 0);
                view.setVisibility(View.VISIBLE);
                return false;
            }

        });
            }

//    private void setItOnLongClickListener(ImageView img) {
//        img.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View view) {
//
//                ClipData data = ClipData.newPlainText("", "");
//                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
//                view.startDrag(data, shadowBuilder, view, 0);
//                view.setVisibility(View.VISIBLE);
//                return true;
//            }
//        });
//    }

    private void initialize() {
        int listOfColour[] = new int[11];
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

    private static class BoxDragListener implements View.OnDragListener {
        private static final String TAG = "BoxDragListener";

        private int enterShape;
        private int normalShape;
        private boolean hit;

        public BoxDragListener(int enterShape, int normalShape) {
            this.enterShape = enterShape;
            this.normalShape = normalShape;
        }

        @Override
        public boolean onDrag(View v, DragEvent event) {
            final ImageView containerView = (ImageView) v;
            final ImageView draggedView = (ImageView) event.getLocalState();
            switch (event.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    Log.d(TAG, "onDrag: ACTION_DRAG_STARTED");
                    hit = false;
                    return true;
                case DragEvent.ACTION_DRAG_ENTERED:
                    Log.d(TAG, "onDrag: ACTION_DRAG_ENTERED");
                    containerView.setImageResource(enterShape);
                    return true;
                case DragEvent.ACTION_DRAG_EXITED:
                    Log.d(TAG, "onDrag: ACTION_DRAG_EXITED");
                    containerView.setImageResource(normalShape);
                    return true;
                case DragEvent.ACTION_DROP:
                    Log.d(TAG, "onDrag: ACTION_DROP");
                    hit = true;
                    draggedView.post(new Runnable() {
                        @Override
                        public void run() {
                            draggedView.setVisibility(View.GONE);
                        }
                    });
                    return true;
                case DragEvent.ACTION_DRAG_ENDED:
                    Log.d(TAG, "onDrag: ACTION_DRAG_ENDED");
                    containerView.setImageResource(normalShape);
                    v.setVisibility(View.VISIBLE);
                    if (!hit) {
                        draggedView.post(new Runnable() {
                            @Override
                            public void run() {
                                draggedView.setVisibility(View.VISIBLE);
                            }
                        });
                    }
                    return true;
                default:
                    return true;
            }
        }
    }


    // TODO:
    // If round is over, go to RoundActivity
    // Else InBetweenTurnsActivity
}
