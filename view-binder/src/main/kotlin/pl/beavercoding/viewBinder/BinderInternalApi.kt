package pl.beavercoding.viewBinder

@RequiresOptIn(message = "Do not use it outside internal binder api")
@Retention(AnnotationRetention.BINARY)
@Target(AnnotationTarget.CLASS)
internal annotation class BinderInternalApi
