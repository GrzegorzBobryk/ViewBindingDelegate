# ViewBindingDelegate

## What is it?

_Library created to enable easy to use, reflection free, lazy initialisation with auto destruction on lifecycle of [data] and [view] binders._
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
	        implementation 'com.github.GrzegorzBobryk:ViewBindingDelegate:1.0'
	}
```

## Warning

Remember to **not** call binder object from `onDestroyView()` event because it will cause recreation and memory leak.

## Examples

You can find them in app module

[//]: # (variable definitions)

[data]: <https://developer.android.com/topic/libraries/data-binding>

[view]: <https://developer.android.com/topic/libraries/view-binding>
