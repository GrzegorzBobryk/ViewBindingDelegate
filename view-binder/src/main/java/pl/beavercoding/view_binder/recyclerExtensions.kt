package pl.beavercoding.view_binder

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * Safe setting new [RecyclerView.Adapter] that is leak resistant
 */
fun <VH : RecyclerView.ViewHolder> RecyclerView.safeSetAdapter(
    adapter: RecyclerView.Adapter<VH>
) {
    this.adapter = adapter
    clearReferenceOnDetached()
}

private fun RecyclerView.clearReferenceOnDetached() {
    addOnAttachStateChangeListener(object : View.OnAttachStateChangeListener {
        override fun onViewAttachedToWindow(v: View) = Unit

        override fun onViewDetachedFromWindow(v: View) {
            adapter = null
        }
    })
}
