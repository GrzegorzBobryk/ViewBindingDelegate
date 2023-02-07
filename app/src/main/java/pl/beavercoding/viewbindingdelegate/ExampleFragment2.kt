package pl.beavercoding.viewbindingdelegate

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import pl.beavercoding.view_binder.viewBinding
import pl.beavercoding.viewbindingdelegate.databinding.FragmentExample2Binding

class ExampleFragment2 : Fragment(R.layout.fragment_example_2) {

    private val binding by viewBinding {
        FragmentExample2Binding.bind(it).also { binding ->
            binding.text = "Hello world"
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener {
            Toast.makeText(view.context, "toast", Toast.LENGTH_LONG).show()
        }
    }


}
