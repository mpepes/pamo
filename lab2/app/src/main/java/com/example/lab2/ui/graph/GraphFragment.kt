package com.example.lab2.ui.graph

import androidx.fragment.app.Fragment
import com.example.lab2.databinding.FragmentGraphBinding
import com.jjoe64.graphview.GraphView

class GraphFragment : Fragment() {
    private var graphViewModel: GraphViewModel? = null
    private var binding: FragmentGraphBinding? = null
    var series: LineGraphSeries<DataPoint>? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        graphViewModel = ViewModelProvider(this).get<GraphViewModel>(GraphViewModel::class.java)
        binding = FragmentGraphBinding.inflate(inflater, container, false)
        val root: View = binding!!.root
        //        questionTextView = root.findViewById(R.id.question);
        var y: Double
        var x: Double
        x = 0.0
        y = 18.0
        val graph: GraphView = root.findViewById<View>(R.id.graph) as GraphView
        series = LineGraphSeries<DataPoint>()
        for (i in 0..4) {
            x = x + 1
            y = ThreadLocalRandom.current().nextInt(18, 30 + 1).toDouble()
            series.appendData(DataPoint(x, y), true, 100)
        }
        graph.addSeries(series)
        return root
    }
}