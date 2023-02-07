package pl.beavercoding.viewbindingdelegate

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import pl.beavercoding.view_binder.viewBinding
import pl.beavercoding.viewbindingdelegate.databinding.FragmentExample1Binding

class ExampleFragment1 : Fragment(R.layout.fragment_example_1) {

    private val binding by viewBinding(FragmentExample1Binding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.helloWorld.text = getString(R.string.example_1)
        binding.button.setOnClickListener {
            val action = ExampleFragment1Directions.toExampleFragment2()
            findNavController().navigate(action)
        }
    }
}
