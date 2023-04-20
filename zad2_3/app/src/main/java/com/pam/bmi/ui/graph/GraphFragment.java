package com.pam.bmi.ui.graph;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pam.bmi.R;

import androidx.fragment.app.Fragment;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;

public class GraphFragment extends Fragment {

    LineChart lineChart;
    LineData lineData;
    LineDataSet lineDataSet;
    ArrayList<Entry> lineEntries;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_graph, container, false);

        lineChart = view.findViewById(R.id.lineChart);
        lineChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        lineChart.getAxisLeft().setDrawGridLines(false);
        lineChart.getAxisRight().setDrawGridLines(false);
        lineChart.getDescription().setText("BMI/Months");

        getEntries();

        lineDataSet = new LineDataSet(lineEntries, "history bmi values");
        lineDataSet.setColor(Color.GREEN);
        lineDataSet.setLineWidth(2f);
        lineDataSet.setValueTextColor(Color.BLACK);

        lineData = new LineData(lineDataSet);
        lineChart.setData(lineData);
        lineChart.invalidate();
        lineDataSet.setValueTextColor(Color.BLACK);
        lineDataSet.setValueTextSize(17f);

        return view;
    }

    private void getEntries() {
        lineEntries = new ArrayList<>();
        lineEntries.add(new Entry(1, 16.6f));
        lineEntries.add(new Entry(2, 15.7f));
        lineEntries.add(new Entry(3, 16.5f));
        lineEntries.add(new Entry(4, 16.9f));
        lineEntries.add(new Entry(5, 17.5f));
        lineEntries.add(new Entry(6, 18.5f));
        lineEntries.add(new Entry(7, 19.1f));
        lineEntries.add(new Entry(8, 20.7f));
        lineEntries.add(new Entry(9, 21.3f));
        lineEntries.add(new Entry(10, 18.5f));
        lineEntries.add(new Entry(11, 19.4f));
        lineEntries.add(new Entry(12, 17.1f));
    }
}