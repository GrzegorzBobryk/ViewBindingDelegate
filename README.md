# ViewBindingDelegate

[![](https://jitpack.io/v/GrzegorzBobryk/ViewBindingDelegate.svg)](https://jitpack.io/#GrzegorzBobryk/ViewBindingDelegate)

## What is it?

_Library created to enable easy to use, reflection free, lazy initialisation with auto destruction on lifecycle of [data]
and [view] binders._
You probably seen already similar approaches in some tutorials. I can not find ready to use lib like that.

## Setup

Add it in root `build.gradle`

```gradle
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

and the dependency itself

```gradle
	dependencies {
	        implementation 'com.github.GrzegorzBobryk:ViewBindingDelegate:1.0.8'
	}
```

## Warning

Remember to **not** call binder object from `onDestroyView()` event because it will cause recreation and memory leak.

## Examples

You can find them in sample module. Here you have quick usage:

```kotlin
class ExampleFragment : Fragment(R.layout.fragment_example) {
    //simple binding
    private val binding by viewBinding(FragmentExampleBinding::bind)

    //binding with setting up DataBinding variables
    private val binding by viewBinding {
        FragmentExampleBinding.bind(it).also { binding ->
            binding.text = getString(R.string.example)
        }
    }
}
```

You can also use `safeSetAdapter` to automatically clean adapter reference from fragment. Do **not** call it from pagers.

```kotlin
class ExampleFragment1 : Fragment(R.layout.fragment_example) {
    private val binding by viewBinding(FragmentExampleBinding::bind)
    private val adapter by lazy { ExampleAdapter(::handleExampleClick) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //calling extension function
        binding.list.safeSetAdapter(adapter)
        adapter.submitList(list)
    }
}
```

[//]: # (variable definitions)

[data]: <https://developer.android.com/topic/libraries/data-binding>

[view]: <https://developer.android.com/topic/libraries/view-binding>
