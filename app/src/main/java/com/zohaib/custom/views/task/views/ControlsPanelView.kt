package com.zohaib.custom.views.task.views

/**
 * @Author: Zohaib Islam
 * @Date: 12/12/2023
 */

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.Gravity
import android.widget.ImageView
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

class ControlsPanelView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : ConstraintLayout(context, attrs) {

    private val backgroundImage: AppCompatImageView
    private val panelText: AppCompatTextView

    private val btnPlay: AppCompatImageView
    private var btnPrevious: AppCompatImageView
    private var btnNext: AppCompatImageView

    private var onBtnPlayClick: (() -> Unit)? = null
    private var onBtnPreviousClick: (() -> Unit)? = null
    private var onBtnNextIconClick: (() -> Unit)? = null

    init {
        backgroundImage = AppCompatImageView(context).apply {
            layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
            scaleType = ImageView.ScaleType.FIT_CENTER

            id = generateViewId()
            setImageResource(R.drawable.bg_controls)
            addView(this)
        }

        panelText = AppCompatTextView(context).apply {
            layoutParams = LayoutParams(
                LayoutParams.MATCH_CONSTRAINT,
                LayoutParams.WRAP_CONTENT
            ).apply {
                setMargins(
                    resources.getDimensionPixelSize(com.intuit.sdp.R.dimen._16sdp),
                    0, 0, 0
                )
            }

            id = generateViewId()
            textSize = resources.getDimension(com.intuit.ssp.R.dimen._4ssp)
            gravity = Gravity.CENTER_VERTICAL

            text = context.getString(R.string.tap_to_open_your_music_player)
            setTextColor(Color.WHITE)
            addView(this)
        }

        val btnWidth = resources.getDimensionPixelSize(com.intuit.sdp.R.dimen._24sdp)
        val btnHeight = resources.getDimensionPixelSize(com.intuit.sdp.R.dimen._24sdp)

        btnPlay = AppCompatImageView(context).apply {
            layoutParams = LayoutParams(btnWidth, btnHeight).apply {
                setMargins(
                    0, 0,
                    resources.getDimensionPixelSize(com.intuit.sdp.R.dimen._16sdp), 0
                )
            }

            setImageResource(R.drawable.ic_play)
            id = generateViewId()
            setOnClickListener { onBtnPlayClick?.invoke() }

            addView(this)
        }

        btnPrevious = AppCompatImageView(context).apply {
            layoutParams = LayoutParams(btnWidth, btnHeight).apply {
                setMargins(
                    0,
                    0,
                    resources.getDimensionPixelSize(com.intuit.sdp.R.dimen._16sdp),
                    0
                )
            }

            setImageResource(R.drawable.ic_skip_previous)
            id = generateViewId()
            setOnClickListener { onBtnPreviousClick?.invoke() }

            addView(this)
        }

        btnNext = AppCompatImageView(context).apply {
            layoutParams = LayoutParams(btnWidth, btnHeight).apply {
                setMargins(
                    0,
                    0,
                    resources.getDimensionPixelSize(com.intuit.sdp.R.dimen._16sdp),
                    0
                )
            }

            setImageResource(R.drawable.ic_skip_next)
            id = generateViewId()
            setOnClickListener { onBtnNextIconClick?.invoke() }

            addView(this)
        }

        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.ControlsPanelView)

        typedArray.getDrawable(R.styleable.ControlsPanelView_iconPlay)?.let {
            btnPlay.setImageDrawable(it)
        }

        typedArray.getDrawable(R.styleable.ControlsPanelView_iconPrevious)?.let {
            btnPrevious.setImageDrawable(it)
        }

        typedArray.getDrawable(R.styleable.ControlsPanelView_iconNext)?.let {
            btnNext.setImageDrawable(it)
        }

        typedArray.getString(R.styleable.ControlsPanelView_text)?.let {
            panelText.text = it
        }

        typedArray.recycle()

        applyConstraints()
    }

    private fun applyConstraints() {
        val constraints = ConstraintSet()
        constraints.clone(this)

        constraints.apply {
            // text constraint
            connect(panelText.id, TOP, PARENT_ID, TOP)
            connect(panelText.id, START, PARENT_ID, START)
            connect(panelText.id, BOTTOM, PARENT_ID, BOTTOM)
            connect(panelText.id, END, btnPrevious.id, START)

            // Next Button constraints
            connect(btnNext.id, END, PARENT_ID, END)
            connect(btnNext.id, BOTTOM, PARENT_ID, BOTTOM)
            connect(btnNext.id, TOP, PARENT_ID, TOP)

            // Play Button constraints
            connect(btnPlay.id, END, btnNext.id, START)
            connect(btnPlay.id, BOTTOM, PARENT_ID, BOTTOM)
            connect(btnPlay.id, TOP, PARENT_ID, TOP)

            // Previous Button constraints
            connect(btnPrevious.id, END, btnPlay.id, START)
            connect(btnPrevious.id, BOTTOM, PARENT_ID, BOTTOM)
            connect(btnPrevious.id, TOP, PARENT_ID, TOP)

            applyTo(this@ControlsPanelView)
        }
    }

    fun setPanelText(text: String) {
        panelText.text = text
    }

    fun setOnBtnPlayClick(onClick: () -> Unit) {
        onBtnPlayClick = onClick
    }

    fun setOnBtnPreviousClick(onClick: () -> Unit) {
        onBtnPreviousClick = onClick
    }

    fun setOnBtnNextIconClick(onClick: () -> Unit) {
        onBtnNextIconClick = onClick
    }
}
