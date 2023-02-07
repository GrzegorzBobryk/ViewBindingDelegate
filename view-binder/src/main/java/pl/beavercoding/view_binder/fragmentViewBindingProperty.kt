package pl.beavercoding.view_binder

import android.os.Looper
import android.view.View
import androidx.annotation.MainThread
import androidx.annotation.UiThread
import androidx.fragment.app.Fragment
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

/**
 * Property that create, hold and destroy binder object. It must be used from ui thread.
 * Remember to <strong>not</strong> call binder object from [onDestroyView()] event because it will cause recreation and memory leak.
 */
class FragmentViewBindingProperty<T : ViewBinding>(
    private val viewBinder: ViewBinder<T>
) : ReadOnlyProperty<Fragment, T> {
    private var viewBinding: T? = null

    @UiThread
    override fun getValue(thisRef: Fragment, property: KProperty<*>): T {
        assertMainThread()
        viewBinding?.let { return it }
        val view = thisRef.requireView()
        thisRef.viewLifecycleOwner.lifecycle.addObserver(BindingLifecycleObserver())
        return viewBinder.bind(view).also { vb -> viewBinding = vb }
    }

    private fun notMainThread() = Looper.getMainLooper().thread !== Thread.currentThread()

    private fun assertMainThread() {
        if (notMainThread()) {
            throw RuntimeException("View binder called outside of mine thread!")
        }
    }

    private inner class BindingLifecycleObserver : DefaultLifecycleObserver {

        @MainThread
        override fun onDestroy(owner: LifecycleOwner) {
            viewBinding = null
        }
    }
}

fun interface ViewBinder<T : ViewBinding> {
    fun bind(view: View): T
}

/**
 * Lazy create new [ViewBinding] associated with the [Fragment][this] via delegate without any reflection.
 */
@Suppress("unused")
inline fun <reified T : ViewBinding> Fragment.viewBinding(vb: ViewBinder<T>): ReadOnlyProperty<Fragment, T> =
    FragmentViewBindingProperty(vb)

