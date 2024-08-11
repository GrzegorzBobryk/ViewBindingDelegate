package pl.beavercoding.viewbindingdelegate

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import pl.beavercoding.viewBinder.safeSetAdapter
import pl.beavercoding.viewBinder.viewBinding
import pl.beavercoding.viewbindingdelegate.databinding.FragmentExample1Binding

internal class ExampleFragment1 : Fragment(R.layout.fragment_example_1) {

    private val binding by viewBinding(FragmentExample1Binding::bind)
    private val adapter by lazy { ExampleAdapter(::handleExampleClick) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.list.safeSetAdapter(adapter)
        val list = listOf(
            Example(R.id.first, getString(R.string.example_1)),
            Example(R.id.second, getString(R.string.example_1)),
            Example(R.id.third, getString(R.string.example_1)),
        )
        adapter.submitList(list)

        binding.button.setOnClickListener {
            val action = ExampleFragment1Directions.toExampleFragment2()
            findNavController().navigate(action)
        }
    }

    private fun handleExampleClick(example: Example) {
        Toast.makeText(requireContext(), example.toString(), Toast.LENGTH_LONG).show()
    }
}
