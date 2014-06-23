callgraphite
============

Android Studio project that integrates SILGraphite smart font for Android.

Here are my configurations:
Android Studio 0.6
Gradle plugin 0.11

test device:  Samsung Galaxy 7 inch tablet running on armeabi.
min sdk version 14
compile sdk version 19
build tools version 19.1.0

Currently, the graphite library loads but failed on the first call to addFontResource.
Error message:
06-17 11:25:09.950  13114-13114/test.example.callgraphite.app A/libc﹕ Fatal signal 11 (SIGSEGV) at 0x00000000 (code=1)
