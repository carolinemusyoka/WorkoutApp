# README


## Pre-requisites
I used Android Studio Bumblebee (2021.1.1). In case of any issues, do let me know because I understand that issues might vary for different users. 

## The App
- I loaded the exercises from a local database, by populating it using Room. 
- I used XML for the UI layouts. 
- I used Kotlin

## Tech Stack
* [Android Architecture Components](https://developer.android.com/topic/libraries/architecture) - A collections of libraries that help you design rebust, testable and maintainable apps.
    * [Room](https://developer.android.com/training/data-storage/room)
    * [ViewModel](https://developer.android.com/reference/androidx/lifecycle/ViewModel) 
    * [LiveData](https://developer.android.com/topic/libraries/architecture/livedata)
    * [Navigation component](https://developer.android.com/guide/navigation) 
    * [Coroutine](https://developer.android.com/kotlin/coroutines)

## Tests
To run HomeFragmentTest run ` ./gradlew app:connectedAndroidTest -P android.testInstrumentationRunnerArguments.class=com.carolmusyoka.virtuagymtest.HomeFragmentTest`
To run DetailScreenTest run ` ./gradlew app:connectedAndroidTest -P android.testInstrumentationRunnerArguments.class=com.carolmusyoka.virtuagymtest.ExerciseDetailTest`
To run RoomDbTest run ` ./gradlew app:connectedAndroidTest -P android.testInstrumentationRunnerArguments.class=com.carolmusyoka.virtuagymtest.RoomDBTest`

## Run the app

Run `./gradlew assembleDebug`
Install apk `./gradlew installDebug  `

## Screenshots of the app
<img src="https://user-images.githubusercontent.com/44951692/152505255-2ca8ae4a-7b53-453f-8c84-35284cf1df54.jpg" width=30% height=30%> <img src="https://user-images.githubusercontent.com/44951692/152505622-fb08ef8d-8348-4cc3-a695-b7ef99f66cba.jpg" width=30% height=30%> <img src="https://user-images.githubusercontent.com/44951692/152505644-0fac9e3a-8d9f-4b8c-a2f9-49bc8840b7c9.jpg" width=30% height=30%> <img src="https://user-images.githubusercontent.com/44951692/152505808-636d3be8-e8e9-4f4e-aaa6-8f8ac589c705.jpg" width=30% height=30%> <img src="https://user-images.githubusercontent.com/44951692/152506077-5b6d2aee-5a19-4451-abef-b9a9ff5e5176.jpg" width=30% height=30%> <img src="https://user-images.githubusercontent.com/44951692/152506105-4f3c4983-1bcb-4be0-819e-110df9f81a50.jpg" width=30% height=30%> 

