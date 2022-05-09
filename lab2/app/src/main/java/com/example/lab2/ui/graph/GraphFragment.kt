package com.example.lab2.ui.graph;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.lab2.R;
import com.example.lab2.databinding.FragmentGraphBinding;
import com.example.lab2.ui.graph.GraphViewModel;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import java.util.concurrent.ThreadLocalRandom;

public class GraphFragment extends Fragment {

    private GraphViewModel graphViewModel;
    private FragmentGraphBinding binding;
    LineGraphSeries<DataPoint> series;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        graphViewModel =
                new ViewModelProvider(this).get(GraphViewModel.class);

        binding = FragmentGraphBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
//        questionTextView = root.findViewById(R.id.question);
        double y,x;
        x = 0.0;
        y = 18.0;

        GraphView graph = (GraphView) root.findViewById(R.id.graph);
        series = new LineGraphSeries<DataPoint>();
        for(int i =0; i<5; i++) {
            x = x + 1;
            y = ThreadLocalRandom.current().nextInt(18, 30 + 1);;
            series.appendData(new DataPoint(x, y), true, 100);
        }
        graph.addSeries(series);

        return root;
    }
}
