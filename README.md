# Fit Warriors
![Fit Warriors Logo](https://cdn1.imggmi.com/uploads/2019/9/16/5a06c81970fb6e951a290ce9ba9742af-full.png)

## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Features](#features)
* [Screenshots](#screenshots)
* [Setup](#setup)
* [Status](#status)
* [Inspiration](#inspiration)
* [Contact](#contact)

## General info
<u>Developers:</u> Dakota Ruhl, Kenneth Omo, Jose Herrera, Victor Hernandez, Devon Tyson

<center>The purpose of this project is to create an application that tracks exercise data to level up a character. The intended audience is for people who would like to get fit in a fun way. We hope that this application impacts the well-being of our users by inspiring them to go to the gym. </center>

## Technologies
Unity game engine <br>
Pedometer <br>
Java SDK <br>
Andriod App builder <br>
Andriod Studio <br>
Android Phone <br>

## Features
 <b>Personal character:</b> <br> 
 Have a virtual character that represents the real you. This character will level up as you workout.<br>
  I, Devon as a gamer, want a game that provides some real world benefit, so that i can feel productive about playing video games. <br><BR>
  Completed by Dakota<BR>
 The Unity Project files can be unpacked from UnityGame.zip (Requires Unity installed) The scripts for game objects are in a separate folder called Script. The Unity project will be our battle module for the game. When players want to battle with their trained skills they will enter this battle module and fight eachother using Unity's Game Engine. The Battle Module should populate the Hero with all the stats and attriubutes tracked by the backend java source code. 
  
<b>View Stats:</b> <br>
  View your real life stats in the game and how they correspond to your character's progression level. All users can use this. <br>
  I, Victor, as a highly-competitive gamer, want a mobile game that can display workout data between friends so that I can push myself to   be the very best (that no one ever was).<br><br>
  Completed by Devon Tyson.<BR>
 Source code can be found in the src file on Github. Files include Player, Skill and related Skill classes, the 2 interfaces - Fightable and Trainable, Controller, MainApp and View. The main frame runs the app, while the player class represents the user. The user has skills and is able to train them. The stats are saved into a database that will load if a player already exists and will create one if it doesn't. My code is used throughout the game as it drives everything and connects everything together.
 
  
<b>Real Life Levelling:</b> <br>
 Level up your character by increasing your steps and logging workouts each day. As you progress your workouts in real life, you character will progress as well. <br>
I, Jose, as an intermediate weightlifter want an app that organizes workout schedule in a way that allows me to track my improvements over time.<br><br>
Completed by Jose Herrera.<BR>
 Source code can be found under src/WOPackage.  A WorkoutLog class is created when training mode is selected.  Users enter workouts and then the WorkoutLog class calculates an experience number.  Victor's Gui sends the number to Devon's Player object, which then potentially levels up.  This code is currently used during training mode.
  
<b>Graphical User Interface:</b> <br>
  View a user interface that displays your progression in the game that will reflect your real life progression. <br>
I, Jose, as a user with little computer know-how I want an intuitive GUI so that I can seamlessly navigate the software.<br><br>
Completed by Victor Hernandez<br>
Source code can be found under "Victor's Updated src" and can be accessed by Android Studio.
This code is the graphical user interface for the application. This code is used throughout the application as it is the face of the app. The GUI uses buttons to navigate between different activities within the app, such as displaying the Training Page or adding reps to a workout. Screenshots of my GUI can be found in the "GUI Screenshots" folder.


<b>Biometrics:</b> <br>
Built in pedometer used to track steps right from your phone. <br>
I, Kenny, as a person who walks to campus from really far away, would like to keep track of how many
steps it takes to get to my class.<br><br>
Completed By Kenneth Omo<br>
Source code is under Pedometer folder on GitHub and can be accessed by Andriod Studio.
This code is used for tracking the number of steps a person can take while the application is open. It is used in training mode.
<br><br>
Sprint 2<br>
Completed by Kenneth Omo
Integrated Pedometer to the GUIPrototype. Source code can be found under GUIProtoype.




## Screenshots
"GUI Screenshots" contains screenshots of each screen in the GUI.

## Setup
How to install / setup your local environement / add link to demo version

## Code Examples
Usage:
`put-your-code-here`

## Status
Project is in progress

Jose:
- status: Workout package completed, integrated code into main frame
- next step: improve the code, add more workouts, increase functionality

Victor:
- status: GUI prototype completed, currently working relevant code into GUI
- next step: integrate code fully, fix bugs, connect battle mode

Dakota:
- status: Battle module prototype completed, created base game setup with players and skills/health
- next step: build onto the game, add attack animations, implement actual battle

Kenny:
- status: Pedometer completed, built temporary testing methods
- next step: integrate with Victor's GUI

Devon:
- status: Built main frame, built player with all applicable skills, integrated workout package and part of GUI
- next step: learn how to send jar files as plug-ins to unity, add more skills

## Inspiration
Credits here

## Contact
Contact info
