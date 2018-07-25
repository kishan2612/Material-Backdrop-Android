package com.evolve.backdroplibrary;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;

public class BackdropContainer extends FrameLayout {

    private Context context;
    private Toolbar toolbar;
    private ToolbarIconClick toolbarIconClick;
    private Drawable mMenuicon;
    private Drawable mCloseicon;
    int height;

    Interpolator interpolator;
    int duration;
    public BackdropContainer(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        this.context=context;

        TypedArray typedArray=context.obtainStyledAttributes(attrs,R.styleable.BackdropContainer,0,0);

        mMenuicon=typedArray.getDrawable(R.styleable.BackdropContainer_menuIcon);
        mCloseicon=typedArray.getDrawable(R.styleable.BackdropContainer_closeIcon);
        duration=typedArray.getInt(R.styleable.BackdropContainer_duration,1000);

        typedArray.recycle();

        DisplayMetrics metrics=new DisplayMetrics();
        ((Activity)context).getWindowManager().getDefaultDisplay().getMetrics(metrics);
        height=metrics.heightPixels;
    }


    public BackdropContainer attachToolbar(Toolbar toolbar){

        this.toolbar=toolbar;
        this.toolbar.setNavigationIcon(mMenuicon);

        return  this;
    }

    public BackdropContainer dropHeight(int peek){
        height=height-peek;
        return this;
    }

    public BackdropContainer dropInterpolator(Interpolator interpolator){
        this.interpolator=interpolator;
        return  this;
    }

    public void build(){



        if (checkTotalview()){


            toolbarIconClick =new ToolbarIconClick(context,getChildAt(1),getBackview(),mMenuicon,
                    mCloseicon,height,interpolator,duration);

            toolbar.setNavigationOnClickListener(toolbarIconClick);
        }else {

            throw new ArrayIndexOutOfBoundsException("Backdrop should contain only two child");
        }

    }

   public void showBackview(){

        toolbarIconClick.open();
    }


   public void closeBackview(){

        toolbarIconClick.close();
    }

    boolean checkTotalview(){
        if (getChildCount()>2){
            return false;
        }
        return true;
    }

    View getFrontview(){
       return getChildAt(1);
    }
    View getBackview(){
        return getChildAt(0);
    }


}
