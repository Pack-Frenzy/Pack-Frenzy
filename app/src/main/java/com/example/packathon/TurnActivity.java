package com.example.packathon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.packathon.model.Box;
import com.example.packathon.model.BoxItem;

import java.util.ArrayList;
import java.util.Random;

public class TurnActivity extends AppCompatActivity {
    private ImageView img1;
    private ImageView img2;
    private ImageView img3;
    private ImageView img4;
    private ImageView boxImg;
    private BoxItem itm1;
    private BoxItem itm2;
    private BoxItem itm3;
    private BoxItem itm4;
    private Box box;
    private int listOfColour[];
    private Random random;
    private Object imageTag1;
    private Object imageTag2;
    private Object imageTag3;
    private Object imageTag4;
    private ArrayList<String> listOfPlayers;
    private EditText nameTag;
    private int playerIndex;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turn);

        img1 = findViewById(R.id.imageView);
        img1.setTag("GameItemImg1");
        imageTag1 = img1.getTag();
        img2 = findViewById(R.id.imageView2);
        img2.setTag("GameItemImg2");
        imageTag2 = img2.getTag();
        img3 = findViewById(R.id.imageView3);
        img3.setTag("GameItemImg3");
        imageTag3 = img3.getTag();
        img4 = findViewById(R.id.imageView4);
        img4.setTag("GameItemImg4");
        imageTag4 = img4.getTag();
        nameTag = findViewById(R.id.Player_Name);

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

    private void initialize() {
        listOfColour = new int[11];
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

        random = new Random();

        itm1 = new BoxItem();
        itm2 = new BoxItem();
        itm3 = new BoxItem();
        itm4 = new BoxItem();
        // TODO: put in variable for # of players
        box = new Box(4);

        img1.setBackgroundColor(listOfColour[random.nextInt(10)]);
        img2.setBackgroundColor(listOfColour[random.nextInt(10)]);
        img3.setBackgroundColor(listOfColour[random.nextInt(10)]);
        img4.setBackgroundColor(listOfColour[random.nextInt(10)]);
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



    private class BoxDragListener implements View.OnDragListener {
        private static final String TAG = "BoxDragListener";

        private int enterShape;
        private int normalShape;
        private boolean hit;

        public BoxDragListener(int enterShape, int normalShape) {
            this.enterShape = enterShape;
            this.normalShape = normalShape;
        }

        @Override
        public boolean onDrag(final View v, DragEvent event) {
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
                            if (playerIndex ++ >= listOfPlayers.size()) {
                                playerIndex = 0;
                            } else {
                                playerIndex++;
                            }

                            if (imageTag1 == draggedView.getTag()) {
                                box.addBoxItemToBox(itm1);
                                itm1 = new BoxItem();
                                img1.setBackgroundColor(listOfColour[random.nextInt(10)]);
                                nameTag.setText(listOfPlayers.get(playerIndex), TextView.BufferType.EDITABLE);
                            } else if (imageTag2 == draggedView.getTag()) {
                                box.addBoxItemToBox(itm2);
                                itm2 = new BoxItem();
                                img2.setBackgroundColor(listOfColour[random.nextInt(10)]);
                                nameTag.setText(listOfPlayers.get(playerIndex), TextView.BufferType.EDITABLE);
                            } else if (imageTag3 == draggedView.getTag()) {
                                box.addBoxItemToBox(itm3);
                                itm3 = new BoxItem();
                                img3.setBackgroundColor(listOfColour[random.nextInt(10)]);
                                nameTag.setText(listOfPlayers.get(playerIndex), TextView.BufferType.EDITABLE);
                            } else if (imageTag4 == draggedView.getTag()) {
                                box.addBoxItemToBox(itm4);
                                itm4 = new BoxItem();
                                img4.setBackgroundColor(listOfColour[random.nextInt(10)]);
                                nameTag.setText(listOfPlayers.get(playerIndex), TextView.BufferType.EDITABLE);
                            }
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
