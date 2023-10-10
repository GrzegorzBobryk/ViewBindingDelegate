package pl.beavercoding.viewBinder

@RequiresOptIn(message = "Do not use it outside of internal binder api")
@Retention(AnnotationRetention.BINARY)
@Target(AnnotationTarget.CLASS)
internal annotation class BinderInternalApi
