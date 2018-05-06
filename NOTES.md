Links
=====

Language
========

Naming
------
* Public classes do not need to be in a file with the same name
* Packages do not need to be in corresponding directories although that's recommended

Visibility
----------
* See <https://kotlinlang.org/docs/reference/visibility-modifiers.html>
* default is "public"
* there is no "package level", only "internal" for access within the same Kotlin module

Compagnion Object
-----------------

* See <https://kotlinlang.org/docs/reference/object-declarations.html#companion-objects>
* Instead of Java's "public static" methods, Kotlin uses a compagnion object.
* Can optionally be declared with @JvmStatic to be accessible in Java like a static method 
and not via `MyClass.Companion.create()`.
```
class MyClass {
  companion object Factory {
    @JvmStatic
    fun create(): MyClass = MyClass()
  }
}

val instance = MyClass.create()
```

Reflection
----------
* Referring to the class like ".class" via the "class literal" operator "::",
  e.g. `Exception::class`
