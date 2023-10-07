package pl.beavercoding.viewbindingdelegate

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import pl.beavercoding.viewBinder.viewBinding
import pl.beavercoding.viewbindingdelegate.databinding.FragmentExample3Binding

class ExampleFragment3 : Fragment(R.layout.fragment_example_3) {

    private val binding by viewBinding(FragmentExample3Binding::bind)

    /* If you want to add something in [onCreateView] event,
        you can leave return of super method and use apply for additional code.*/
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState).apply {
            // very important code
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.helloWorld.text = getString(R.string.example_3)
    }
}
