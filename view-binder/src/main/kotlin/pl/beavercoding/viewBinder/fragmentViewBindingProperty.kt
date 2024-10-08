@file:Suppress("Filename")

package pl.beavercoding.viewBinder

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
 * Lazy create new [ViewBinding] associated with the [Fragment][this] via delegate without any reflection.
 */
@OptIn(BinderInternalApi::class)
@Suppress("UnusedReceiverParameter")
inline fun <reified T : ViewBinding> Fragment.viewBinding(vb: ViewBinder<T>): ReadOnlyProperty<Fragment, T> =
    FragmentViewBindingProperty(vb)

fun interface ViewBinder<T : ViewBinding> {
    fun bind(view: View): T
}

/**
 * Property that create, hold and destroy binder object. It must be used from ui thread.
 * Remember to <strong>not</strong> call binder object from [onDestroyView()] event
 * because it will cause recreation and memory leak.
 */
@BinderInternalApi
class FragmentViewBindingProperty<T : ViewBinding>(
    private val viewBinder: ViewBinder<T>,
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

    private fun assertMainThread() {
        check(isMainThread()) { "View binder called outside of main thread!" }
    }

    private fun isMainThread() = Looper.getMainLooper().thread === Thread.currentThread()

    private inner class BindingLifecycleObserver : DefaultLifecycleObserver {

        @MainThread
        override fun onDestroy(owner: LifecycleOwner) {
            viewBinding = null
        }
    }
}
