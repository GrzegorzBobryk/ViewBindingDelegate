package pl.beavercoding.viewbindingdelegate

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import pl.beavercoding.viewbindingdelegate.databinding.RowExampleBinding

private typealias OnExampleClicked = (Example) -> Unit

internal class ExampleAdapter(
    private val onExampleClicked: OnExampleClicked,
) : ListAdapter<Example, ExampleAdapter.ExampleViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ExampleViewHolder.create(parent, onExampleClicked)

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) = holder.bind(getItem(position))

    internal class ExampleViewHolder private constructor(
        private val binding: RowExampleBinding,
        private val onExampleClicked: OnExampleClicked,
    ) : RecyclerView.ViewHolder(binding.root) {

        internal fun bind(example: Example) {
            binding.apply {
                title.text = example.title
                root.setOnClickListener {
                    onExampleClicked(example)
                }
            }
        }

        companion object {
            internal fun create(
                parent: ViewGroup,
                onExampleClicked: OnExampleClicked,
            ): ExampleViewHolder {
                val binding = RowExampleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return ExampleViewHolder(binding, onExampleClicked)
            }
        }
    }

    private class DiffCallback : DiffUtil.ItemCallback<Example>() {

        override fun areItemsTheSame(oldItem: Example, newItem: Example) = oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Example, newItem: Example) = oldItem == newItem
    }
}
