package com.pam.bmi.ui.graph

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.pam.bmi.R

class GraphFragment : Fragment() {
    private var lineChart: LineChart? = null
    private var lineData: LineData? = null
    private var lineDataSet: LineDataSet? = null
    private var lineEntries: ArrayList<Entry>? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_graph, container, false)
        lineChart = view.findViewById(R.id.lineChart)
        lineChart?.xAxis?.position = XAxis.XAxisPosition.BOTTOM
        lineChart?.axisLeft?.setDrawGridLines(false)
        lineChart?.axisRight?.setDrawGridLines(false)
        lineChart?.description?.text = "BMI/Months"
        generateEntries()
        lineDataSet = LineDataSet(lineEntries, "history bmi values")
        lineDataSet?.color = Color.GREEN
        lineDataSet?.lineWidth = 2f
        lineDataSet?.valueTextColor = Color.BLACK
        lineData = LineData(lineDataSet)
        lineChart?.data = lineData
        lineChart?.invalidate()
        lineDataSet?.valueTextColor = Color.BLACK
        lineDataSet?.valueTextSize = 17f
        return view
    }

    private fun generateEntries() {
        lineEntries = ArrayList()
        lineEntries?.apply {
            add(Entry(1f, 16.6f))
            add(Entry(2f, 15.7f))
            add(Entry(3f, 16.5f))
            add(Entry(4f, 16.9f))
            add(Entry(5f, 17.5f))
            add(Entry(6f, 18.5f))
            add(Entry(7f, 19.1f))
            add(Entry(8f, 20.7f))
            add(Entry(9f, 21.3f))
            add(Entry(10f, 18.5f))
            add(Entry(11f, 19.4f))
            add(Entry(12f, 17.1f))
        }
    }
}
