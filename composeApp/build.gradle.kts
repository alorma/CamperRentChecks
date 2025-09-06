import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    // alias(libs.plugins.androidApplication)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.composeHotReload)
    // alias(libs.plugins.ksp)
}

kotlin {
    // androidTarget {
    //     compilerOptions {
    //         jvmTarget.set(JvmTarget.JVM_17)
    //     }
    // }
    
    jvm()
    
    sourceSets {
        // androidMain.dependencies {
        //     implementation(compose.preview)
        //     implementation(libs.androidx.activity.compose)
        // }
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(libs.compose.material3.expressive)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodelCompose)
            implementation(libs.androidx.lifecycle.runtimeCompose)
        }
        jvmMain.dependencies {
            implementation(compose.desktop.currentOs)
            implementation(libs.kotlinx.coroutinesSwing)
        }
    }
}

// android {
//     namespace = "com.alorma.camperrent"
//     compileSdk = libs.versions.android.compileSdk.get().toInt()
// 
//     defaultConfig {
//         applicationId = "com.alorma.camperrent"
//         minSdk = libs.versions.android.minSdk.get().toInt()
//         targetSdk = libs.versions.android.targetSdk.get().toInt()
//         versionCode = 1
//         versionName = "1.0"
//     }
//     packaging {
//         resources {
//             excludes += "/META-INF/{AL2.0,LGPL2.1}"
//         }
//     }
//     buildTypes {
//         getByName("release") {
//             isMinifyEnabled = false
//         }
//     }
//     compileOptions {
//         sourceCompatibility = JavaVersion.VERSION_17
//         targetCompatibility = JavaVersion.VERSION_17
//     }
// }

// dependencies {
//     debugImplementation(compose.uiTooling)
// }

compose.desktop {
    application {
        mainClass = "com.alorma.camperrent.MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "com.alorma.camperrent"
            packageVersion = "1.0.0"
        }
    }
}
