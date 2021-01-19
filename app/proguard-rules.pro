# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile


-ignorewarnings
-keep class com.google.* { *; }
-keep class org.apache.* { *; }
-keepnames class com.fasterxml.jackson.* { *; }
-keepnames class javax.servlet.* { *; }
-keepnames class org.ietf.jgss.* { *; }

-keep class android.support.v7.* { *; }
-keep interface android.support.v7.* { *; }

-dontwarn org.apache.**
-dontwarn org.w3c.dom.**

# autovalue
-dontwarn android.arch.**
-dontwarn javax.lang.**
-dontwarn javax.tools.**
-dontwarn javax.annotation.**
-dontwarn autovalue.shaded.com.**
-dontwarn com.google.auto.value.**

-dontwarn okio.**
-dontwarn sun.misc.Unsafe
-dontwarn org.w3c.dom.bootstrap.DOMImplementationRegistry

-keep public class * extends android.app.Activity
-keep public class * extends android.app.Application
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.app.backup.BackupAgentHelper
-keep public class * extends android.preference.Preference

-dontnote com.android.vending.licensing.ILicensingService


-keepclassmembers class * implements java.io.Serializable {
    static final long serialVersionUID;
    private static final java.io.ObjectStreamField[] serialPersistentFields;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}


-keep class android.support.v4.app.* { *; }
-keep interface android.support.v4.app.* { *; }
-keep class com.actionbarsherlock.* { *; }
-keep interface com.actionbarsherlock.* { *; }

#Androidx
-dontwarn com.google.android.material.**
-keep class com.google.android.material.*{ *; }

-dontwarn androidx.**
-keep class androidx.* { *; }
-keep interface androidx.* { *; }

# Preserve all native method names and the names of their classes.
-keepclasseswithmembernames class * {
    native <methods>;
}

-keepclasseswithmembernames class * {
    public <init>(android.content.Context, android.util.AttributeSet);
}

-keepclasseswithmembernames class * {
    public <init>(android.content.Context, android.util.AttributeSet, int);
}


-keep class com.forbitbd.myplayer.models** { *; }





# Remove All Logs
-assumenosideeffects class android.util.Log {
    public static int v(...);
}

-keepattributes SourceFile,LineNumberTable
-keep class com.parse.*{ *; }
-dontwarn com.parse.**
-dontwarn com.squareup.picasso.**
-keepclasseswithmembernames class * {
    native <methods>;
}

-keep class rx.internal.util.unsafe.*{
    *;
 }


 # Retrofit
 -dontwarn okio.**
 -dontwarn javax.annotation.**
 -dontwarn retrofit2.Platform$Java8
