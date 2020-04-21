# Numerology


This is an Android app using a restful API and an SQL database hosted in Azure.
## About Numerology

Numerology is any belief in the divine or mystical relationship between a number and one or more coinciding events. It is also the study of the numerical value of the letters in words, names, and ideas. It is often associated with the paranormal, alongside astrology and similar divinatory arts.

## About The app
An app where users can input their date of birth and their birth number will be displayed back to them with a description of the different aspects of their personality. The app hasfeatures such as scrollable text view and a splash screen
The app has two get methods, get all and get a unique description. The app is hosted in azure.
using API 16 4.1 (Jelly Bean) which will run on approximatley 99.6% of devices.    


### Great Features
1. Internationalisation to Romanian.
2. Get all function.
3. Update heading.
4. Share button.
5. Add permision for internet in src/main/AndroidManifest (line 4).
6. There has been a lot of logging added to the project so that we can clearly see what any issues are by looking at the custom logs.
 
### Libraries
We have used *Android volley* and *Gson library* for the main page and get requests to the API.
We have used the *Retrofit2* library for the get all method on the next page.



## Getting Started
![Architectue](/pic.png)
### Clone the Repository

As usual, you get started by cloning the project to your local machine:

```
$ https://github.com/x00141559/Numerology.git
```

**Note** The app may at first produce an error message if the API is sleeping, it takes a few seconds to wake up. It will also 
produce an error message if you press submit without choosing a birth date.
## Prerequisites
- Android Studio
- Basic Knowlegde of Java


### Open and Run Project in Android

Now that you have cloned the repo:

1. Open the project up in Android Studio.

2. Go to the project and press green button to play




### Special Features

- Change your local language to Romanian on your Android device to experience internationalization.
- Click view all numbers, to see all of the numbers we provide descriptions for.



## Android Version Targeting

- Jellybean





### Having Trouble?


Please feel free to submit issues with any bugs or other unforseen issues you experience. We work diligently to ensure that the ```master``` branch is always bug-free and easy to clone and run from Android Studio. If you experience problems, open an issue describing the problem and how to reproduce it, and we'll be sure to take a look at it.
