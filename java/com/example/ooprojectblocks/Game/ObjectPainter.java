package com.example.ooprojectblocks.Game;

import android.app.Activity;
import android.support.constraint.ConstraintLayout;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

import com.example.ooprojectblocks.R;

import java.util.List;

public class ObjectPainter {

    private Activity activity;
    ConstraintLayout layout;
    boolean colorBlind;

    public ObjectPainter(Activity activity, ConstraintLayout layout, boolean colorBlind) {
        this.activity = activity;
        this.layout = layout;
        this.colorBlind = colorBlind;
    }

    public void paint(List<Object> objects) {
        for (Object o : objects) {
            if (!colorBlind) {
                if (o.getState() == 0) {
                    o.image = new ImageView(activity);
                    if (o.getType().equals("block")) {
                        if (o.getColor().equals("blue")) {
                            o.image.setImageResource(R.drawable.blueblock);
                        } else if (o.getColor().equals("brown")) {
                            o.image.setImageResource(R.drawable.brownblock);
                        } else if (o.getColor().equals("green")) {
                            o.image.setImageResource(R.drawable.greenblock);
                        } else if (o.getColor().equals("red")) {
                            o.image.setImageResource(R.drawable.redblock);
                        } else if (o.getColor().equals("yellow")) {
                            o.image.setImageResource(R.drawable.yellowblock);
                        }
                    } else if (o.getType().equals("bar")) {
                        if (o.getColor().equals("blue")) {
                            o.image.setImageResource(R.drawable.bluebar);
                        } else if (o.getColor().equals("brown")) {
                            o.image.setImageResource(R.drawable.brownbar);
                        } else if (o.getColor().equals("green")) {
                            o.image.setImageResource(R.drawable.greenbar);
                        } else if (o.getColor().equals("red")) {
                            o.image.setImageResource(R.drawable.redbar);
                        } else if (o.getColor().equals("yellow")) {
                            o.image.setImageResource(R.drawable.yellowbar);
                        }
                    } else if (o.getType().equals("goldenSnitch"))
                        o.image.setImageResource(R.drawable.goldensnitch);
                    else if (o.getType().equals("randomBar"))
                        o.image.setImageResource(R.drawable.whitebar);
                    else if (o.getType().equals("troubleMaker"))
                        o.image.setImageResource(R.drawable.troublemaker);
                    ConstraintLayout.LayoutParams para = new ConstraintLayout.LayoutParams(o.getWidth(), o.getHeight());
                    o.image.setLayoutParams(para);
                    o.image.setX(o.getX());
                    o.image.setY(o.getY());
                    layout.addView(o.image);
                    o.setState(1);
                }
                if (o.getState() == 1) {
                    if (o.getType().equals("block")) {
                        if (o.getColor().equals("blue")) {
                            o.image.setImageResource(R.drawable.blueblock);
                        } else if (o.getColor().equals("brown")) {
                            o.image.setImageResource(R.drawable.brownblock);
                        } else if (o.getColor().equals("green")) {
                            o.image.setImageResource(R.drawable.greenblock);
                        } else if (o.getColor().equals("red")) {
                            o.image.setImageResource(R.drawable.redblock);
                        } else if (o.getColor().equals("yellow")) {
                            o.image.setImageResource(R.drawable.yellowblock);
                        }
                    } else if (o.getType().equals("bar")) {
                        if (o.getColor().equals("blue")) {
                            o.image.setImageResource(R.drawable.bluebar);
                        } else if (o.getColor().equals("brown")) {
                            o.image.setImageResource(R.drawable.brownbar);
                        } else if (o.getColor().equals("green")) {
                            o.image.setImageResource(R.drawable.greenbar);
                        } else if (o.getColor().equals("red")) {
                            o.image.setImageResource(R.drawable.redbar);
                        } else if (o.getColor().equals("yellow")) {
                            o.image.setImageResource(R.drawable.yellowbar);
                        }
                    }
                }
            }
            else {
                if (o.getState() == 0) {
                    o.image = new ImageView(activity);
                    if (o.getType().equals("block")) {
                        if (o.getColor().equals("blue")) {
                            o.image.setImageResource(R.drawable.blindblueblock);
                        } else if (o.getColor().equals("brown")) {
                            o.image.setImageResource(R.drawable.blindbrownblock);
                        } else if (o.getColor().equals("green")) {
                            o.image.setImageResource(R.drawable.blindgreenblock);
                        } else if (o.getColor().equals("red")) {
                            o.image.setImageResource(R.drawable.blindredblock);
                        } else if (o.getColor().equals("yellow")) {
                            o.image.setImageResource(R.drawable.blindyellowblock);
                        }
                    } else if (o.getType().equals("bar")) {
                        if (o.getColor().equals("blue")) {
                            o.image.setImageResource(R.drawable.blindbluebar);
                        } else if (o.getColor().equals("brown")) {
                            o.image.setImageResource(R.drawable.blindbrownbar);
                        } else if (o.getColor().equals("green")) {
                            o.image.setImageResource(R.drawable.blindgreenbar);
                        } else if (o.getColor().equals("red")) {
                            o.image.setImageResource(R.drawable.blindredbar);
                        } else if (o.getColor().equals("yellow")) {
                            o.image.setImageResource(R.drawable.blindyellowbar);
                        }
                    } else if (o.getType().equals("goldenSnitch"))
                        o.image.setImageResource(R.drawable.goldensnitch);
                    else if (o.getType().equals("randomBar"))
                        o.image.setImageResource(R.drawable.whitebar);
                    else if (o.getType().equals("troubleMaker"))
                        o.image.setImageResource(R.drawable.troublemaker);
                    ConstraintLayout.LayoutParams para = new ConstraintLayout.LayoutParams(o.getWidth(), o.getHeight());
                    o.image.setLayoutParams(para);
                    o.image.setX(o.getX());
                    o.image.setY(o.getY());
                    layout.addView(o.image);
                    o.setState(1);
                }
                if (o.getState() == 1) {
                    if (o.getType().equals("block")) {
                        if (o.getColor().equals("blue")) {
                            o.image.setImageResource(R.drawable.blindblueblock);
                        } else if (o.getColor().equals("brown")) {
                            o.image.setImageResource(R.drawable.blindbrownblock);
                        } else if (o.getColor().equals("green")) {
                            o.image.setImageResource(R.drawable.blindgreenblock);
                        } else if (o.getColor().equals("red")) {
                            o.image.setImageResource(R.drawable.blindredblock);
                        } else if (o.getColor().equals("yellow")) {
                            o.image.setImageResource(R.drawable.blindyellowblock);
                        }
                    } else if (o.getType().equals("bar")) {
                        if (o.getColor().equals("blue")) {
                            o.image.setImageResource(R.drawable.blindbluebar);
                        } else if (o.getColor().equals("brown")) {
                            o.image.setImageResource(R.drawable.blindbrownbar);
                        } else if (o.getColor().equals("green")) {
                            o.image.setImageResource(R.drawable.blindgreenbar);
                        } else if (o.getColor().equals("red")) {
                            o.image.setImageResource(R.drawable.blindredbar);
                        } else if (o.getColor().equals("yellow")) {
                            o.image.setImageResource(R.drawable.blindyellowbar);
                        }
                    }
                }
            }
        }
    }
}
