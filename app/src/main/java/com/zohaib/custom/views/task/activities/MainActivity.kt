package com.zohaib.custom.views.task.activities

/**
 * @Author: Zohaib Islam
 * @Date: 12/12/2023
 */

import android.os.Bundle
import android.view.MenuItem
import android.widget.SeekBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.zohaib.custom.views.task.R
import com.zohaib.custom.views.task.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        // Set up toolbar
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.arrow_back)

        initPlayerControlPanel()

    }

    private fun initPlayerControlPanel() {

        binding.apply {
            controlPanelView.apply {

                setOnClickListener { showToast("Panel View Clicked") }

                setOnBtnPlayClick { showToast("Play Clicked") }

                setOnBtnNextIconClick { showToast("Next Clicked") }

                setOnBtnPreviousClick { showToast("Previous Clicked") }
            }

            volumeOptionsView.apply {

                setOnBtnMuteClick { showToast("Mute") }

                setOnBtn30Click { showToast("30%") }

                setOnBtn60Click { showToast("60%") }

                setOnBtn100Click { showToast("100%") }

                setOnBtn125Click { showToast("125%") }

                setOnBtn150Click { showToast("150%") }

                setOnBtn175Click { showToast("150%") }

                setOnBtnMaxClick { showToast("Max") }
            }

            seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(p0: SeekBar?, progress: Int, p2: Boolean) {
                    if (progress == 0) {
                        volumeIcon.setImageResource(R.drawable.ic_no_sound)
                    } else {
                        volumeIcon.setImageResource(R.drawable.ic_volume_up)
                    }
                }

                override fun onStartTrackingTouch(p0: SeekBar?) {
                }

                override fun onStopTrackingTouch(p0: SeekBar?) {
                }
            })
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressedDispatcher.onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}