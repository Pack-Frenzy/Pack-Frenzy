package com.example.packathon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.packathon.model.BombItem;
import com.example.packathon.model.Box;
import com.example.packathon.model.BoxItem;
import com.example.packathon.model.Gauge;
import com.example.packathon.model.LightenLoadItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TurnActivity extends AppCompatActivity {

    private ImageView img1;
    private ImageView img2;
    private ImageView img3;
    private ImageView img4;
    private ImageView gaugeImg;
    private ImageView boxImg;
    private BoxItem itm1;
    private BoxItem itm2;
    private BoxItem itm3;
    private BoxItem itm4;
    private Box box;
    private Gauge gauge;
    private int listOfDrawable[];
    private int listOfGauges[];
    private Random random;
    private Object imageTag1;
    private Object imageTag2;
    private Object imageTag3;
    private Object imageTag4;
    private EditText nameTag;
    private int playerIndex;
    private ArrayList<String> listOfPlayer;
    private TextView w1;
    private TextView w2;
    private TextView w3;
    private TextView w4;
    private double wn1;
    private double wn2;
    private double wn3;
    private double wn4;
    private int itemType1; // keep track of the item type; 1 = bomb, 2 = feather, 3 = classic
    private int itemType2;
    private int itemType3;
    private int itemType4;
    private int nextInt1;
    private int nextInt2;
    private int nextInt3;
    private int nextInt4;
    private int numCurrentRound;

    private ArrayList<ImageView> listOfDroppedItems;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turn);
        random = new Random();
        itemType1 = 3;
        itemType2 = 3;
        itemType3 = 3;
        itemType4 = 3;

        listOfPlayer = new ArrayList<>();
        listOfDroppedItems = new ArrayList<>();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            numCurrentRound = extras.getInt("currentRound");
            for (int i = 0; i < extras.size() - 1; i++) {
                String playerName = extras.getString(String.valueOf(i));
                if (playerName != null) {
                    listOfPlayer.add(playerName);
                }
            }
        }

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
        gaugeImg = findViewById(R.id.gaugeImage);
        gaugeImg.setTag("gaugeImageTag");

        nameTag = findViewById(R.id.Player_Name);

        //Linking to the weight text field
        w1 = findViewById(R.id.w1);
        w2 = findViewById(R.id.w2);
        w3 = findViewById(R.id.w3);
        w4 = findViewById(R.id.w4);


        int value = random.nextInt(20);
        String str = String.valueOf(value);
        w1.setText(str, TextView.BufferType.EDITABLE);
        wn1 = value;

        value = random.nextInt(20);
        str = String.valueOf(value);
        w2.setText(str, TextView.BufferType.EDITABLE);
        wn2 = value;

        value = random.nextInt(20);
        str = String.valueOf(value);
        w3.setText(str, TextView.BufferType.EDITABLE);
        wn3 = value;

        value = random.nextInt(20);
        str = String.valueOf(value);
        w4.setText(str, TextView.BufferType.EDITABLE);
        wn4 = value;


        playerIndex = 0;
        nameTag.setText(listOfPlayer.get(playerIndex), TextView.BufferType.EDITABLE);

        initialize();

        boxImg = findViewById(R.id.boxImage);
        boxImg.setTag("BoxImage");

        boxImg.setOnDragListener(new BoxDragListener(
                R.drawable.boxbrown,
                R.drawable.boxbrown));

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
        listOfDrawable = new int[6];
        listOfDrawable[0] = R.drawable.boxblue;
        listOfDrawable[1] = R.drawable.boxbrown;
        listOfDrawable[2] = R.drawable.boxgreen;
        listOfDrawable[3] = R.drawable.boxorange;
        listOfDrawable[4] = R.drawable.boxpurple;
        listOfDrawable[5] = R.drawable.boxred;

        listOfGauges = new int[6];
        listOfGauges[0] = R.drawable.gauge;
        listOfGauges[1] = R.drawable.gauge1;
        listOfGauges[2] = R.drawable.gauge2;
        listOfGauges[3] = R.drawable.gauge3;
        listOfGauges[4] = R.drawable.gauge4;
        listOfGauges[5] = R.drawable.gauge5;

        itm1 = new BoxItem();
        itm2 = new BoxItem();
        itm3 = new BoxItem();
        itm4 = new BoxItem();
        box = new Box(4);
        gauge = new Gauge();
        gauge.setPercentFull(0);

        nextInt1 = random.nextInt(6);
        nextInt2 = random.nextInt(6);
        nextInt3 = random.nextInt(6);
        nextInt4 = random.nextInt(6);
        img1.setImageResource(listOfDrawable[nextInt1]);
        img2.setImageResource(listOfDrawable[nextInt2]);
        img3.setImageResource(listOfDrawable[nextInt3]);
        img4.setImageResource(listOfDrawable[nextInt4]);

        gaugeImg.setImageResource(listOfGauges[0]);
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

    // TODO: @scott we need to redirect the user if this is going to be the last round. we need you
    //       to set up a new activity
    public void openGameOverActivity(String name) {
        Intent intent = new Intent (this, EndOfRoundActivity.class);
        int counter = 0;
        for (String n: listOfPlayer) {
            if (!name.equals(n)) {
                String count = Integer.toString(counter);
                intent.putExtra(count, n);
                counter++;
            }
        }

        String loserIndex = Integer.toString(listOfPlayer.size() - 1);
        intent.putExtra(loserIndex, name);
        intent.putExtra("currentRound", numCurrentRound);
        startActivity(intent);
    }


    private class BoxDragListener implements View.OnDragListener {
        private static final String TAG = "BoxDragListener";
        private static final String TAG2 = "Box Weight";

        private int enterShape;
        private int normalShape;
        private boolean hit;

        public BoxDragListener(int enterShape, int normalShape) {
            this.enterShape = enterShape;
            this.normalShape = normalShape;
        }

        public void changeGaugeImage(String status) {
            if (status.equals("empty")) {
                gaugeImg.setImageResource(listOfGauges[0]);
            }
            else if (status.equals("moderate")) {
                gaugeImg.setImageResource(listOfGauges[1]);
            }
            else if (status.equals("partly_full")) {
                gaugeImg.setImageResource(listOfGauges[2]);
            }
            else if (status.equals("moderately_full")) {
                gaugeImg.setImageResource(listOfGauges[3]);
            }
            else if (status.equals(("insanely_full"))) {
                gaugeImg.setImageResource(listOfGauges[4]);
            }
            else {
                gaugeImg.setImageResource(listOfGauges[5]);
                if (playerIndex == 0) {
                    openGameOverActivity(listOfPlayer.get(listOfPlayer.size()-1));
                } else {
                    openGameOverActivity(listOfPlayer.get(playerIndex - 1));
                }
            }
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
                            if ((playerIndex + 1) >= listOfPlayer.size()) {
                                playerIndex = 0;
                            } else {
                                playerIndex++;
                            }

                            if (imageTag1 == draggedView.getTag()) {

                                checkItemType(itemType1, itm1, wn1);

                                int itemRandomizer = random.nextInt(100);

                                if (0 <= itemRandomizer && itemRandomizer < 50) {
                                    itm1 = new BombItem();
                                    wn1 = itm1.getWeight();
                                    w1.setText(String.valueOf(wn1), TextView.BufferType.EDITABLE);
                                    img1.setImageResource(R.drawable.bomb);
                                    itemType1 = 1;

                                } else if (50 <= itemRandomizer && itemRandomizer < 100) {
                                    itm1 = new LightenLoadItem();
                                    wn1 = itm1.getWeightDouble();
                                    w1.setText(String.valueOf(wn1), TextView.BufferType.EDITABLE);
                                    img1.setImageResource(R.drawable.feather);
                                    itemType1 = 2;


                                } else {
                                    itm1 = new BoxItem();
                                    int value = random.nextInt(20);
                                    String str = String.valueOf(value);
                                    w1.setText(str, TextView.BufferType.EDITABLE);
                                    wn1 = value;
                                    img1.setImageResource(listOfDrawable[random.nextInt(6)]);
                                    itemType1 = 3;


                                }

                                gauge.setPercentFull(gauge.calculatePercentFull(box.getWeight(), box.getWeightCapacity()));
                                changeGaugeImage(gauge.checkAndReturnStatus(gauge.getPercentFull()));

                                Log.d(TAG2, gauge.checkAndReturnStatus(gauge.getPercentFull()));
                                Log.d(TAG2, String.valueOf(box.getWeight()));
                                Log.d(TAG2, String.valueOf(gauge.getPercentFull()));

                                ImageView nextImage = new ImageView(getApplicationContext());
                                nextImage.setImageResource(listOfDrawable[nextInt1]);

                                listOfDroppedItems.add(nextImage);
                                Log.d(TAG2, listOfDroppedItems.toString());

                                nameTag.setText(listOfPlayer.get(playerIndex), TextView.BufferType.EDITABLE);


                            } else if (imageTag2 == draggedView.getTag()) {

                                checkItemType(itemType2, itm2, wn2);

                                int itemRandomizer = random.nextInt(100);

                                if (0 <= itemRandomizer && itemRandomizer < 50) {
                                    itm2 = new BombItem();
                                    wn2 = itm2.getWeight();
                                    w2.setText(String.valueOf(wn2), TextView.BufferType.EDITABLE);
                                    img2.setImageResource(R.drawable.bomb);
                                    itemType2 = 1;

                                } else if (50 <= itemRandomizer && itemRandomizer < 100) {
                                    itm2 = new LightenLoadItem();
                                    wn2 = itm2.getWeightDouble();
                                    w2.setText(String.valueOf(wn2), TextView.BufferType.EDITABLE);
                                    img2.setImageResource(R.drawable.feather);
                                    itemType2 = 2;


                                } else {
                                    itm2 = new BoxItem();
                                    int value = random.nextInt(20);
                                    String str = String.valueOf(value);
                                    w2.setText(str, TextView.BufferType.EDITABLE);
                                    wn2 = value;
                                    img2.setImageResource(listOfDrawable[random.nextInt(6)]);
                                    itemType2 = 3;


                                }

                                gauge.setPercentFull(gauge.calculatePercentFull(box.getWeight(), box.getWeightCapacity()));
                                changeGaugeImage(gauge.checkAndReturnStatus(gauge.getPercentFull()));

                                Log.d(TAG2, gauge.checkAndReturnStatus(gauge.getPercentFull()));
                                Log.d(TAG2, String.valueOf(box.getWeight()));
                                Log.d(TAG2, String.valueOf(gauge.getPercentFull()));

                                ImageView nextImage = new ImageView(getApplicationContext());
                                nextImage.setImageResource(listOfDrawable[nextInt2]);

                                listOfDroppedItems.add(nextImage);
                                Log.d(TAG2, listOfDroppedItems.toString());
                                nameTag.setText(listOfPlayer.get(playerIndex), TextView.BufferType.EDITABLE);


                            } else if (imageTag3 == draggedView.getTag()) {

                                checkItemType(itemType3, itm3, wn3);

                                int itemRandomizer = random.nextInt(100);

                                if (0 <= itemRandomizer && itemRandomizer < 50) {
                                    itm3 = new BombItem();
                                    wn3 = itm3.getWeight();
                                    w3.setText(String.valueOf(wn3), TextView.BufferType.EDITABLE);
                                    img3.setImageResource(R.drawable.bomb);
                                    itemType3 = 1;

                                } else if (50 <= itemRandomizer && itemRandomizer < 100) {
                                    itm3 = new LightenLoadItem();
                                    wn3 = itm3.getWeightDouble();
                                    w3.setText(String.valueOf(wn3), TextView.BufferType.EDITABLE);
                                    img3.setImageResource(R.drawable.feather);
                                    itemType3 = 2;


                                } else {
                                    itm3 = new BoxItem();
                                    int value = random.nextInt(20);
                                    String str = String.valueOf(value);
                                    w3.setText(str, TextView.BufferType.EDITABLE);
                                    wn3 = value;
                                    img3.setImageResource(listOfDrawable[random.nextInt(6)]);
                                    itemType3 = 3;


                                }
                                gauge.setPercentFull(gauge.calculatePercentFull(box.getWeight(), box.getWeightCapacity()));
                                changeGaugeImage(gauge.checkAndReturnStatus(gauge.getPercentFull()));

                                Log.d(TAG2, gauge.checkAndReturnStatus(gauge.getPercentFull()));
                                Log.d(TAG2, String.valueOf(box.getWeight()));
                                Log.d(TAG2, String.valueOf(gauge.getPercentFull()));


                                ImageView nextImage = new ImageView(getApplicationContext());
                                nextImage.setImageResource(listOfDrawable[nextInt3]);

                                listOfDroppedItems.add(nextImage);
                                Log.d(TAG2, listOfDroppedItems.toString());


                                nameTag.setText(listOfPlayer.get(playerIndex), TextView.BufferType.EDITABLE);


                            } else if (imageTag4 == draggedView.getTag()) {
                                checkItemType(itemType4, itm4, wn4);
                                int itemRandomizer = random.nextInt(100);

                                if (0 <= itemRandomizer && itemRandomizer < 50) {
                                    itm4 = new BombItem();
                                    wn4 = itm4.getWeight();
                                    w4.setText(String.valueOf(wn4), TextView.BufferType.EDITABLE);
                                    img4.setImageResource(R.drawable.bomb);
                                    itemType4 = 1;

                                } else if (50 <= itemRandomizer && itemRandomizer < 100) {
                                    itm4 = new LightenLoadItem();
                                    wn4 = itm4.getWeightDouble();
                                    w4.setText(String.valueOf(wn4), TextView.BufferType.EDITABLE);
                                    img4.setImageResource(R.drawable.feather);
                                    itemType4 = 2;


                                } else {
                                    itm4 = new BoxItem();
                                    int value = random.nextInt(20);
                                    String str = String.valueOf(value);
                                    w4.setText(str, TextView.BufferType.EDITABLE);
                                    wn4 = value;
                                    img4.setImageResource(listOfDrawable[random.nextInt(6)]);
                                    itemType4 = 3;


                                }


                                gauge.setPercentFull(gauge.calculatePercentFull(box.getWeight(), box.getWeightCapacity()));

                                changeGaugeImage(gauge.checkAndReturnStatus(gauge.getPercentFull()));

                                Log.d(TAG2, gauge.checkAndReturnStatus(gauge.getPercentFull()));
                                Log.d(TAG2, String.valueOf(box.getWeight()));
                                Log.d(TAG2, String.valueOf(gauge.getPercentFull()));

                                ImageView nextImage = new ImageView(getApplicationContext());
                                nextImage.setImageResource(listOfDrawable[nextInt4]);

                                listOfDroppedItems.add(nextImage);
                                Log.d(TAG2, listOfDroppedItems.toString());

                                nameTag.setText(listOfPlayer.get(playerIndex), TextView.BufferType.EDITABLE);

                            }
                        }
                    });
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

    private void makeNextItem(int itemType, BoxItem item, double weight, ImageView imageView, TextView textView) {
        int itemRandomizer = random.nextInt(100);
        if (0 <= itemRandomizer && itemRandomizer < 50) {
            item = new BombItem();
            weight = item.getWeight();
            textView.setText(String.valueOf(weight), TextView.BufferType.EDITABLE);
            imageView.setImageResource(R.drawable.bomb);
            itemType = 1;

        } else if (50 <= itemRandomizer && itemRandomizer < 100) {
            item = new LightenLoadItem();
            weight = item.getWeightDouble();
            textView.setText(String.valueOf(weight), TextView.BufferType.EDITABLE);
            imageView.setImageResource(R.drawable.feather);
            itemType = 2;


        } else {
            item = new BoxItem();
            int value = random.nextInt(20);
            String str = String.valueOf(value);
            textView.setText(str, TextView.BufferType.EDITABLE);
            weight = value;
            imageView.setImageResource(listOfDrawable[random.nextInt(6)]);
            itemType = 3;


        }
    }

    private void checkItemType(int itemType, BoxItem item, double weight) {
        if (itemType == 1) {
            box.setWeight(box.getWeight()/weight);
            // TODO: loop to take half the items out of the list
        } else if (itemType == 2) {
            box.setWeight(box.getWeight() * (weight/100));
        } else {
            box.addBoxItemToBox(item);
            box.addWeight(weight);
        }
    }

}
