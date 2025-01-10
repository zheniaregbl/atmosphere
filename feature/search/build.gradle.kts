import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.jetbrains.kotlin.serialization)
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
            baseName = "Search"
            isStatic = true
        }
    }

    jvm("desktop")

    sourceSets {
        commonMain.dependencies {
            api(compose.components.resources)
            api(libs.androidx.lifecycle.viewmodel)
            api(libs.androidx.lifecycle.runtime.compose)

            api(libs.calf.ui)

            api(libs.shimmer)

            api(libs.bundles.coil)

            api(libs.voyager.navigator)
            api(libs.voyager.screenmodel)

            api(libs.kotlinx.serialization.json)

            api(libs.koin.compose)
            api(libs.koin.compose.viewmodel)
            api(libs.koin.core)

            api(libs.bundles.ktor)

            implementation(projects.core)
        }
    }
}

compose.resources {
    publicResClass = true
    packageOfResClass = "ru.syndicate.atmosphere.feature.search.resources"
    generateResClass = auto
}

android {
    namespace = "ru.syndicate.atmosphere.feature.search"
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
