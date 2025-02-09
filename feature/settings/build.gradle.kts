import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.jetbrains.kotlin.serialization)
    alias(libs.plugins.ksp)
}

kotlin {
    androidTarget {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "Settings"
            isStatic = true
        }
    }

    jvm("desktop")

    sourceSets {
        commonMain.dependencies {
            api(compose.components.resources)
            api(libs.androidx.lifecycle.viewmodel)
            api(libs.androidx.lifecycle.runtime.compose)

            api(libs.lyricist)

            api(libs.voyager.navigator)

            api(libs.koin.compose)
            api(libs.koin.compose.viewmodel)
            api(libs.koin.core)

            api(projects.core)
        }
    }
}

dependencies {
    add("kspCommonMainMetadata", libs.lyricist.processor)
    add("kspAndroid", libs.lyricist.processor)
    add("kspIosX64", libs.lyricist.processor)
    add("kspIosArm64", libs.lyricist.processor)
    add("kspIosSimulatorArm64", libs.lyricist.processor)
}

ksp {
    arg("lyricist.packageName", "ru.syndicate.atmosphere.feature.settings")
    arg("lyricist.moduleName", project.name)
    arg("lyricist.internalVisibility", "true")
}

compose.resources {
    publicResClass = true
    packageOfResClass = "ru.syndicate.atmosphere.feature.settings.resources"
    generateResClass = auto
}

android {
    namespace = "ru.syndicate.atmosphere.feature.settings"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}
