package com.zohaib.custom.views.task.views

import android.content.Context
import android.graphics.Matrix
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.GestureDetector
import android.view.LayoutInflater
import android.view.MotionEvent
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.core.view.GestureDetectorCompat
import com.zohaib.custom.views.task.R

/**
 * @Author: Zohaib Islam
 * @Date: 12/12/2023
 */

class KnobView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr), GestureDetector.OnGestureListener {

    private val knobImageView: ImageView

    private val gestureDetector: GestureDetectorCompat
    private var maxValue = 99
    private var minValue = 0
    var listener: RotaryKnobListener? = null
    var value = 50
    private var knobDrawable: Drawable? = null
    private var divider = 300f / (maxValue - minValue)

    init {
        this.maxValue = maxValue + 1

        LayoutInflater.from(context).inflate(R.layout.rotary_knob_view, this, true)
        knobImageView = this.findViewById(R.id.knobImageView)

        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.RotaryKnobView,
            0,
            0
        ).apply {
            try {
                minValue = getInt(R.styleable.RotaryKnobView_minValue, 0)
                maxValue = getInt(R.styleable.RotaryKnobView_maxValue, 100) + 1
                divider = 300f / (maxValue - minValue)
                value = getInt(R.styleable.RotaryKnobView_initialValue, 50)

                knobDrawable = getDrawable(R.styleable.RotaryKnobView_knobDrawable)

                knobImageView.setImageDrawable(knobDrawable)
            } finally {
                recycle()
            }
        }

        gestureDetector = GestureDetectorCompat(context, this)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        return if (gestureDetector.onTouchEvent(event)) true
        else super.onTouchEvent(event)
    }

    override fun onDown(event: MotionEvent): Boolean {
        return true
    }

    override fun onSingleTapUp(e: MotionEvent): Boolean {
        return false
    }

    override fun onScroll(e1: MotionEvent?, e2: MotionEvent, p2: Float, p3: Float): Boolean {
        val rotationDegrees = calculateAngle(e2.x, e2.y)

        if (rotationDegrees >= -150 && rotationDegrees <= 150) {
            setKnobPosition(rotationDegrees)

            val valueRangeDegrees = rotationDegrees + 150
            value = ((valueRangeDegrees / divider) + minValue).toInt()
            if (listener != null) listener!!.onRotate(value)
        }

        return true
    }

    private fun calculateAngle(x: Float, y: Float): Float {
        val px = (x / width.toFloat()) - 0.5
        val py = (1 - y / height.toFloat()) - 0.5
        var angle = -(Math.toDegrees(kotlin.math.atan2(py, px))).toFloat() + 90
        if (angle > 180) angle -= 360
        return angle
    }

    private fun setKnobPosition(angle: Float) {
        val matrix = Matrix()
        knobImageView.scaleType = ImageView.ScaleType.MATRIX
        matrix.postRotate(angle, width.toFloat() / 2, height.toFloat() / 2)
        knobImageView.imageMatrix = matrix
    }

    override fun onFling(p0: MotionEvent?, p1: MotionEvent, p2: Float, p3: Float): Boolean {
        return false
    }

    override fun onLongPress(e: MotionEvent) {}

    override fun onShowPress(e: MotionEvent) {}

    interface RotaryKnobListener {
        fun onRotate(value: Int)
    }
}
