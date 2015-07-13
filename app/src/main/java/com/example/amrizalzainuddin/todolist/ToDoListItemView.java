package com.example.amrizalzainuddin.todolist;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by amrizal.zainuddin on 13/7/2015.
 */
public class ToDoListItemView extends TextView {

    private Paint marginPaint;
    private Paint linePaint;
    private int paperColor;
    private float margin;

    public ToDoListItemView(Context context) {
        super(context);
        init();
    }

    private void init() {
        Resources myResources = getResources();

        marginPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        marginPaint.setColor(myResources.getColor(R.color.notepad_margin));
        linePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        linePaint.setColor(myResources.getColor(R.color.notepad_lines));

        paperColor = myResources.getColor(R.color.notepad_paper);
        margin = myResources.getDimension(R.dimen.notepad_margin);
    }

    public ToDoListItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ToDoListItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {

        //color as paper
        canvas.drawColor(paperColor);

        //draw ruled lines
        canvas.drawLine(0,0,0, getMeasuredHeight(), linePaint);
        canvas.drawLine(0, getMeasuredHeight(), getMeasuredWidth(), getMeasuredHeight(), linePaint);

        //draw margin
        canvas.drawLine(margin, 0, margin, getMeasuredHeight(), marginPaint);

        //move the text accross from the margin
        canvas.save();
        canvas.translate(margin, 0);

        //use the TextView to render the text
        super.onDraw(canvas);
        canvas.restore();
    }
}
