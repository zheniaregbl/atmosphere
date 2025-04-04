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
            baseName = "Widget"
            isStatic = true
        }
    }

    jvm("desktop")

    sourceSets {

        androidMain.dependencies {
            api(libs.ui.tooling.preview)

            api(libs.androidx.work.runtime.ktx)

            api(libs.glance.appwidget)
            api(libs.glance.preview)
            api(libs.glance.appwidget.preview)
            api(libs.glance.material3)
        }
        commonMain.dependencies {
            api(compose.components.resources)
            api(libs.androidx.lifecycle.viewmodel)
            api(libs.androidx.lifecycle.runtime.compose)

            api(libs.kotlinx.datetime)

            api(libs.lyricist)

            api(libs.calf.ui)

            api(libs.kotlinx.serialization.json)

            api(libs.koin.compose)
            api(libs.koin.compose.viewmodel)
            api(libs.koin.core)

            api(libs.bundles.ktor)

            api(libs.sandwich)
            api(libs.sandwich.ktor)

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
    arg("lyricist.packageName", "ru.syndicate.atmosphere.widget")
    arg("lyricist.moduleName", project.name)
    arg("lyricist.internalVisibility", "true")
}

android {
    namespace = "ru.syndicate.atmosphere.widget"
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