package pl.beavercoding.viewbindingdelegate

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import pl.beavercoding.viewBinder.viewBinding
import pl.beavercoding.viewbindingdelegate.databinding.FragmentExample2Binding

internal class ExampleFragment2 : Fragment(R.layout.fragment_example_2) {

    private val binding by viewBinding {
        FragmentExample2Binding.bind(it).also { binding ->
            // if you don't want to set it here that's fine, you can do it later
            binding.text = getString(R.string.example_2)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener {
            val action = ExampleFragment2Directions.toExampleFragment3()
            findNavController().navigate(action)
        }
    }
}
