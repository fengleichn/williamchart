package com.db.williamchartdemo

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.db.williamchart.slidertooltip.SliderTooltip
import com.db.williamchartdemo.databinding.FramentChartBinding

class ChartFragment : Fragment() {

    private var _binding: FramentChartBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FramentChartBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, saveInstanceState: Bundle?) {


        binding.lineChart.gradientFillColors =
            intArrayOf(
                Color.parseColor("#81FFFFFF"),
                Color.TRANSPARENT
            )
        binding.lineChart.animation.duration = animationDuration
        binding.lineChart.tooltip =
            SliderTooltip().also {
                it.color = Color.WHITE
            }
        binding.lineChart.onDataPointTouchListener = { index, _, _ ->
            binding.lineChartValue.text =
                lineSet.toList()[index]
                    .second
                    .toString()
        }
        binding.lineChart.animate(lineSet)


        binding.barChart.animation.duration = animationDuration
        binding.barChart.animate(barSet)

        binding.donutChart.donutColors = intArrayOf(
            Color.parseColor("#FFFFFF"),
            Color.parseColor("#9EFFFFFF"),
            Color.parseColor("#8DFFFFFF")
        )
        binding.donutChart.animation.duration = animationDuration
        binding.donutChart.animate(donutSet)


        binding.horizontalBarChart.animation.duration = animationDuration
        binding.horizontalBarChart.animate(horizontalBarSet)
    }

    companion object {
        private val lineSet = listOf(
            "label1" to 5f,
            "label2" to 4.5f,
            "label3" to 4.7f,
            "label4" to 3.5f,
            "label5" to 3.6f,
            "label6" to 7.5f,
            "label7" to 7.5f,
            "label8" to 10f,
            "label9" to 5f,
            "label10" to 6.5f,
            "label11" to 3f,
            "label12" to 4f
        )

        private val barSet = listOf(
            "JAN" to 4F,
            "FEB" to 7F,
            "MAR" to 2F,
            "MAY" to 2.3F,
            "APR" to 5F,
            "JUN" to 4F
        )

        private val horizontalBarSet = listOf(
            "PORRO" to 5F,
            "FUSCE" to 6.4F,
            "EGET" to 3F
        )

        private val donutSet = listOf(
            20f,
            80f,
            100f
        )

        private const val animationDuration = 1000L
    }
}
