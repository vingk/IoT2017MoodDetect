# IoT2017MoodDetect
#### - by Vinaykumar Kulkarni
project on Mood detection using Heart rate from smart watch.


The repository contains the follwoing:

  -- [Root](https://github.com/vingk/IoT2017MoodDetect)
      
      
   --> [Datasets](https://github.com/vingk/IoT2017MoodDetect/tree/master/dataset) [with all the datasets that was used to build the model]
      
   --> [Server](https://github.com/vingk/IoT2017MoodDetect/tree/master/Server/MoodDetect/src/com/cmput660/mooddetect) [code for the cloud server]
      
   --> [MoodDetectApp](https://github.com/vingk/IoT2017MoodDetect/tree/master/MoodDetectApp/app/src/main/java/com/mooddetect/mooddetectapp)[ Android application ]

# Architecture
![System Architecture](https://github.com/vingk/IoT2017MoodDetect/blob/master/docs/architecture.jpg)

# Installation Instructions
  - Use android studio 3.0.1 to compile the latest code from [MoodDetectApp](https://github.com/vingk/IoT2017MoodDetect/tree/master/MoodDetectApp).
  - Use Tomcat9 or Glassfish4 for the cloud web application.

# Working
Register the user.
<img src="https://github.com/vingk/IoT2017MoodDetect/blob/master/docs/Register.png" width="200" height="300" />

Setup Bluetooth Device.
<img src="https://github.com/vingk/IoT2017MoodDetect/blob/master/docs/DeviceSetup.png" width="200" height="300" />

Read HR value and Detect Mood.
<img src="https://github.com/vingk/IoT2017MoodDetect/blob/master/docs/ReadHR.png" width="200" height="300" />

Give Feed back on Mood.
<img src="https://github.com/vingk/IoT2017MoodDetect/blob/master/docs/FeedBack.png" width="200" height="300" />
<img src="https://github.com/vingk/IoT2017MoodDetect/blob/master/docs/FeedBackResposne.png" width="200" height="300" />

Database Update, collection of user values as ground truth.

<img src="https://github.com/vingk/IoT2017MoodDetect/blob/master/docs/Database.PNG" width="500" height="300" />
