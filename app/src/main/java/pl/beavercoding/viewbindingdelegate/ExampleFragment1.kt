package pl.beavercoding.viewbindingdelegate

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import pl.beavercoding.viewbinder.viewBinding
import pl.beavercoding.viewbindingdelegate.databinding.FragmentExample1Binding

class ExampleFragment1 : Fragment(R.layout.fragment_example_1) {

    private val binding by viewBinding(FragmentExample1Binding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.helloWorld.text = "Hello world"
    }
}
