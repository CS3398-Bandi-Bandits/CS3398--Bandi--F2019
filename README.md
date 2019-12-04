# Fit Warriors
![Fit Warriors Logo](https://github.com/CS3398-Bandi-Bandits/CS3398--Bandi--F2019/blob/master/ic_launcher-web.png)

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
Andriod Studio <br>
Android Phone <br>

## Features
 <b>Personal character:</b> <br> 
 Have a virtual character that represents the real you. This character will level up as you workout.<br>
  I, Devon as a gamer, want a game that provides some real world benefit, so that i can feel productive about playing video games. <br>
  
 - Completed by Dakota<BR>
 The Unity Project files can be unpacked from UnityGame.zip (Requires Unity installed) The scripts for game objects are in a separate folder called Script. The Unity project will be our battle module for the game. When players want to battle with their trained skills they will enter this battle module and fight eachother using Unity's Game Engine. The Battle Module should populate the Hero with all the stats and attriubutes tracked by the backend java source code. 
 
 <b>Updated Animations for your personal character:</b> <br>
 The personal character has been updated to real spartan warrior models and has added animations when attacking, defending, moving, idling, and when defeated.<br> 
 
- Completed by Dakota during Sprint 3<BR> 
 The new character models and animations can be found inside the battle module for the application. Once the application is running, click battle to enter the Unity Game module. In there you will see the new spartan warrior character models and their animations for attacking, defending, walking, idling, and death. 
 
<b>View Stats:</b> <br>
  View your real life stats in the game and how they correspond to your character's progression level. All users can use this. <br>
  I, Victor, as a highly-competitive gamer, want a mobile game that can display workout data between friends so that I can push myself to   be the very best (that no one ever was).<br>
-  Completed by Devon Tyson during Sprint 1<BR>
 Source code can be found in the src file on Github. Files include Player, Skill and related Skill classes, the 2 interfaces - Fightable and Trainable, Controller, MainApp and View. The main frame runs the app, while the player class represents the user. The user has skills and is able to train them. The stats are saved into a database that will load if a player already exists and will create one if it doesn't. My code is used throughout the game as it drives everything and connects everything together.
 
<b>Support for Multiple Workout</b><BR>
 I, Kenny, as a person who goes to the gym, want an app that supports multiple workouts.<br>
 
- Completed by Jose Herrera.  I created the java classes ExersizeActivity, AddSetActivity, and highly refactored the classes.    MainActivity, TrainingActivity and LoginActivity.  Previous implementations did not allow for returning to a parent activity.    TrainingActivity supports the different workout buttons passing their names to the ExcersizeActivity as arguments to construct Excersize  objects and level up with the AddSetActivity class.<br>
 My code is found in CS3398--Bandi--F2019/GUIPrototype/app/src/main/.  I have edited both XML and Java files.
  
<b>Real Life Levelling:</b> <br>
 Level up your character by increasing your steps and logging workouts each day. As you progress your workouts in real life, you character will progress as well. <br>
I, Jose, as an intermediate weightlifter want an app that organizes workout schedule in a way that allows me to track my improvements over time.<br><br>
- Completed by Jose Herrera.<BR>
 Source code can be found under src/WOPackage.  A WorkoutLog class is created when training mode is selected.  Users enter workouts and then the WorkoutLog class calculates an experience number.  Victor's Gui sends the number to Devon's Player object, which then potentially levels up.  This code is currently used during training mode.
  
<b>Graphical User Interface:</b> <br>
  View a user interface that displays your progression in the game that will reflect your real life progression. <br>
I, Jose, as a user with little computer know-how I want an intuitive GUI so that I can seamlessly navigate the software.<br><br>
- Completed by Victor Hernandez<br>
Source code can be found under "Victor's Updated src" and can be accessed by Android Studio.
This code is the graphical user interface for the application. This code is used throughout the application as it is the face of the app. The GUI uses buttons to navigate between different activities within the app, such as displaying the Training Page or adding reps to a workout. Screenshots of my GUI can be found in the "GUI Screenshots" folder.


<b>Biometrics:</b> <br>
Built in pedometer used to track steps right from your phone. <br>
I, Kenny, as a person who walks to campus from really far away, would like to keep track of how many
steps it takes to get to my class.<br><br>
- Completed By Kenneth Omo<br>
Source code is under Pedometer folder on GitHub and can be accessed by Andriod Studio.
This code is used for tracking the number of steps a person can take while the application is open. It is used in training mode.


<b>Fully Connected Application: </b><BR>
The GUI will sit on top of the backend and allow users to navigate the app seamlessly.<BR>
I, Jose, as a user who enjoys simplicity, want a single contained app where I don't have to keep track of multiple applications.
<BR>
- Completed by Devon Tyson during Sprint 2<BR>
Integrated the back end driver into the Login, View Stats and Training Mode screens. My code was written into GUI java and XML files, with a few modifications in the driver back end. Logic was reworked to fit into the Android application. Modifications can be found throughout the application GUI.

I, Devon, as person who likes uniformity, wants the player from my Fit Warriors application to be used inside the game.<BR>
- Completed by Devon Tyson, Dakota Ruhl and Kenneth Omo during Sprint 3<BR>
Allows users to open the game from the Fit Warriors application. The GUI calls a reference to the Battle Module when the Battle mode button is pressed and the game is shown on the user's phone. We attempted to get our player information into the game but ran into problems with converting code between Android Studio Java based and Unity C# based platforms. Our code can be found under the GUI prototype. The module called FitWarriorsBattleModule is a reference to the game in the Prototype. The code to call the game can be found in the BattleActivity in the GUI. Programming was done in paired fashion and therefore most commits are from Kenneth Omo's GitHub account.
 
 
 <b>Settings Page: </b><BR>
The Main page has a Settings page that allows the user to change their information or reset their account.<BR>
I, Devon, as a person who values customization, want to be able to edit my account settings after I have created it.
<BR>
- Completed by Victor Hernandez during Sprint 3<BR>
Implemented a Settings button within the Main page that, once clicked, allows the user to enter the Settings page. Within this page, the user is able to change their username in case they don't like their current username. In addition, the user is given the option to delete their account if they click on the Delete Account button, which is also implemented within the Settings page.


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
- status: GUI prototype completed, finished working relevant code into GUI, Settings page complete
- next step: Make GUI more user friendly, implement character customization

Dakota:
- status: Battle module prototype completed with character models and animations. 
- next step: improvements to the Battle Module scenery & background, additionals like music/damage popups. 

Kenny:
- status: Pedometer completed, built temporary testing methods
- next step: integrate with Victor's GUI

Devon:
- status: Built application driver, built player with all applicable skills, integrated workout package into driver, fully integrated GUI with driver, added Speed skill, refactored code, added Battle Module connectivity to GUI.
- next step: Finsih getting player stats into the Unity game.

## Inspiration
Credits here

## Contact
Contact info
