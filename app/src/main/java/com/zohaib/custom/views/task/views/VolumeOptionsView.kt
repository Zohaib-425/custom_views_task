package com.zohaib.custom.views.task.views

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.Gravity
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.constraintlayout.widget.ConstraintSet.BOTTOM
import androidx.constraintlayout.widget.ConstraintSet.END
import androidx.constraintlayout.widget.ConstraintSet.PARENT_ID
import androidx.constraintlayout.widget.ConstraintSet.START
import androidx.constraintlayout.widget.ConstraintSet.TOP
import com.zohaib.custom.views.task.R

/**
 * @Author: Zohaib Islam
 * @Date: 13/12/2023
 */

class VolumeOptionsView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : ConstraintLayout(context, attrs) {

    private val backgroundImage: ImageView

    private val btnMute: TextView
    private var onBtnMuteClick: (() -> Unit)? = null

    private val btn30: TextView
    private var onBtn30Click: (() -> Unit)? = null

    private val btn60: TextView
    private var onBtn60Click: (() -> Unit)? = null

    private val btn100: TextView
    private var onBtn100Click: (() -> Unit)? = null

    private val btn125: TextView
    private var onBtn125Click: (() -> Unit)? = null

    private val btn150: TextView
    private var onBtn150Click: (() -> Unit)? = null

    private val btn175: TextView
    private var onBtn175Click: (() -> Unit)? = null

    private val btnMax: TextView
    private var onBtnMaxClick: (() -> Unit)? = null

    init {
        backgroundImage = AppCompatImageView(context).apply {
            layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
            scaleType = ImageView.ScaleType.FIT_CENTER

            id = generateViewId()
            setImageResource(R.drawable.bg_volume_options)
            addView(this)
        }

        btnMute = AppCompatTextView(context).apply {
            layoutParams = LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT
            ).apply {
                setMargins(
                    resources.getDimensionPixelSize(com.intuit.sdp.R.dimen._8sdp),
                    0, 0, 0
                )
            }

            id = generateViewId()
            textSize = resources.getDimension(com.intuit.ssp.R.dimen._4ssp)
            gravity = Gravity.CENTER

            setBackgroundResource(R.drawable.bg_volume_item)
            setOnClickListener { onBtnMuteClick?.invoke() }

            text = context.getString(R.string.mute)
            setTextColor(Color.WHITE)
            addView(this)
        }

        btn30 = AppCompatTextView(context).apply {
            layoutParams = LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT
            ).apply { setMargins(0, 0, 0, 0) }

            id = generateViewId()
            textSize = resources.getDimension(com.intuit.ssp.R.dimen._4ssp)
            gravity = Gravity.CENTER

            setBackgroundResource(R.drawable.bg_volume_item)
            setOnClickListener { onBtn30Click?.invoke() }

            text = context.getString(R.string._30_percent)
            setTextColor(Color.WHITE)
            addView(this)
        }

        btn60 = AppCompatTextView(context).apply {
            layoutParams = LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT
            ).apply { setMargins(0, 0, 0, 0) }

            id = generateViewId()
            textSize = resources.getDimension(com.intuit.ssp.R.dimen._4ssp)
            gravity = Gravity.CENTER

            setBackgroundResource(R.drawable.bg_volume_item)
            setOnClickListener { onBtn60Click?.invoke() }

            text = context.getString(R.string._60_percent)
            setTextColor(Color.WHITE)
            addView(this)
        }

        btn100 = AppCompatTextView(context).apply {
            layoutParams = LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT
            ).apply {
                setMargins(
                    0,
                    0,
                    resources.getDimensionPixelSize(com.intuit.sdp.R.dimen._8sdp),
                    0
                )
            }

            id = generateViewId()
            textSize = resources.getDimension(com.intuit.ssp.R.dimen._4ssp)
            gravity = Gravity.CENTER

            setBackgroundResource(R.drawable.bg_volume_item)
            setOnClickListener { onBtn100Click?.invoke() }

            text = context.getString(R.string._100_percent)
            setTextColor(Color.WHITE)
            addView(this)
        }

        btn125 = AppCompatTextView(context).apply {
            layoutParams = LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT
            ).apply {
                setMargins(
                    resources.getDimensionPixelSize(com.intuit.sdp.R.dimen._8sdp),
                    0, 0, 0
                )
            }

            id = generateViewId()
            textSize = resources.getDimension(com.intuit.ssp.R.dimen._4ssp)
            gravity = Gravity.CENTER

            setBackgroundResource(R.drawable.bg_volume_item)
            setOnClickListener { onBtn125Click?.invoke() }

            text = context.getString(R.string._125_percent)
            setTextColor(Color.WHITE)
            addView(this)
        }

        btn150 = AppCompatTextView(context).apply {
            layoutParams = LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT
            ).apply { setMargins(0, 0, 0, 0) }

            id = generateViewId()
            textSize = resources.getDimension(com.intuit.ssp.R.dimen._4ssp)
            gravity = Gravity.CENTER

            setBackgroundResource(R.drawable.bg_volume_item)
            setOnClickListener { onBtn150Click?.invoke() }

            text = context.getString(R.string._150_percent)
            setTextColor(Color.WHITE)
            addView(this)
        }

        btn175 = AppCompatTextView(context).apply {
            layoutParams = LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT
            ).apply { setMargins(0, 0, 0, 0) }

            id = generateViewId()
            textSize = resources.getDimension(com.intuit.ssp.R.dimen._4ssp)
            gravity = Gravity.CENTER

            setBackgroundResource(R.drawable.bg_volume_item)
            setOnClickListener { onBtn175Click?.invoke() }

            text = context.getString(R.string._175_percent)
            setTextColor(Color.WHITE)
            addView(this)
        }

        btnMax = AppCompatTextView(context).apply {
            layoutParams = LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT
            ).apply {
                setMargins(
                    0,
                    0,
                    resources.getDimensionPixelSize(com.intuit.sdp.R.dimen._8sdp),
                    0
                )
            }

            id = generateViewId()
            textSize = resources.getDimension(com.intuit.ssp.R.dimen._4ssp)
            gravity = Gravity.CENTER

            setBackgroundResource(R.drawable.bg_volume_item)
            setOnClickListener { onBtnMaxClick?.invoke() }

            text = context.getString(R.string.max)
            setTextColor(Color.WHITE)
            addView(this)
        }

        applyConstraints()
    }

    private fun applyConstraints() {
        val constraints = ConstraintSet()
        constraints.clone(this)

        constraints.apply {

            connect(btnMute.id, TOP, PARENT_ID, TOP)
            connect(btnMute.id, START, PARENT_ID, START)
            connect(btnMute.id, END, btn30.id, START)
            connect(btnMute.id, BOTTOM, btn125.id, TOP)

            connect(btn125.id, TOP, btnMute.id, BOTTOM)
            connect(btn125.id, START, PARENT_ID, START)
            connect(btn125.id, BOTTOM, PARENT_ID, BOTTOM)

            connect(btn30.id, TOP, PARENT_ID, TOP)
            connect(btn30.id, START, btnMute.id, END)
            connect(btn30.id, END, btn60.id, START)
            connect(btn30.id, BOTTOM, btn150.id, TOP)

            connect(btn60.id, TOP, PARENT_ID, TOP)
            connect(btn60.id, START, btn30.id, END)
            connect(btn60.id, END, btn100.id, START)
            connect(btn60.id, BOTTOM, btn175.id, TOP)

            connect(btn100.id, TOP, PARENT_ID, TOP)
            connect(btn100.id, START, btn60.id, END)
            connect(btn100.id, END, PARENT_ID, END)
            connect(btn100.id, BOTTOM, btnMax.id, TOP)

            connect(btn125.id, TOP, btnMute.id, BOTTOM)
            connect(btn125.id, START, PARENT_ID, START)
            connect(btn125.id, END, btn150.id, START)
            connect(btn125.id, BOTTOM, PARENT_ID, BOTTOM)

            connect(btn150.id, TOP, btnMute.id, BOTTOM)
            connect(btn150.id, START, PARENT_ID, START)
            connect(btn150.id, END, btn150.id, START)
            connect(btn150.id, BOTTOM, PARENT_ID, BOTTOM)

            connect(btn175.id, TOP, btn60.id, BOTTOM)
            connect(btn175.id, START, btn150.id, END)
            connect(btn175.id, END, btnMax.id, START)
            connect(btn175.id, BOTTOM, PARENT_ID, BOTTOM)

            connect(btnMax.id, TOP, btn100.id, BOTTOM)
            connect(btnMax.id, START, btn175.id, END)
            connect(btnMax.id, END, PARENT_ID, END)
            connect(btnMax.id, BOTTOM, PARENT_ID, BOTTOM)

            applyTo(this@VolumeOptionsView)
        }
    }

    fun setOnBtnMuteClick(onClick: () -> Unit) {
        onBtnMuteClick = onClick
    }

    fun setOnBtn30Click(onClick: () -> Unit) {
        onBtn30Click = onClick
    }

    fun setOnBtn60Click(onClick: () -> Unit) {
        onBtn60Click = onClick
    }

    fun setOnBtn100Click(onClick: () -> Unit) {
        onBtn100Click = onClick
    }

    fun setOnBtn125Click(onClick: () -> Unit) {
        onBtn125Click = onClick
    }

    fun setOnBtn150Click(onClick: () -> Unit) {
        onBtn150Click = onClick
    }

    fun setOnBtn175Click(onClick: () -> Unit) {
        onBtn175Click = onClick
    }

    fun setOnBtnMaxClick(onClick: () -> Unit) {
        onBtnMaxClick = onClick
    }
}