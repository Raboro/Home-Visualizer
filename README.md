## **_\~Home Visualizer\~_**

<p align="center">
<img src="https://img.shields.io/github/last-commit/Raboro/Home-Visualizer">
</p>

This project contains a software, which visualize your home. You can login and create and load your apartment or house. Your home will be 3d rendered. You can design your appartment, costumize the size and add facility to it.

<br />

## **Folder Structure**
<br/>

- **`.vscode`: settings for vscode**
     > - [settings.json] 
- **`bin`: the folder with compiled output files**
- **`doc`: the folder contains the documentation and diagrams**
     > - [classdiagram.md]
     > - [documentation.md]
- **`Images`: the folter to maintain images**
     > - [loginButton.png] 
     > - [signUpButton.png]
- **`lib`: the folder to maintain dependencies**
     > - [BaseClasses.jar]
     > - [hamcrest-core-1.3.jar]
     > - [junit-4.13.2.jar]
     > - [mariadb-java-client-2.7.3.jar]
- **`src`: the folder to maintain sources**
     > - **`HomeVisualizer`**
     >   - **`ActionListener`**
     >       - [StartVisualizeActionListener.java]
     >   - **`Database`**
     >       - [Database.java]
     >       - [InitializeDatabase.java]
     >       - [LoginDatabase.java]
     >   - **`Encryption`**
     >       - [Hash.java]
     >       - [RsaEncryption.java]
     >   - **`Gui`**
     >       - **`Login`**
     >         - [LoginGui.java]
     >       - **`VisualizeMain`**
     >       - [Frame.java]
     >   - **`Logic`**
     >       - [LoginLogic.java]
     >       - [StartVisualizeLogic.java]
     >   - [Main.java]
     > - **`Tests`**

<br/>

[settings.json]:https://github.com/Raboro/Home-Visualizer/blob/master/.vscode/settings.json 
[classdiagram.md]:https://github.com/Raboro/Home-Visualizer/blob/master/doc/classdiagram.md
[documentation.md]:https://github.com/Raboro/Home-Visualizer/blob/master/doc/documentation.md
[loginButton.png]:https://github.com/Raboro/Home-Visualizer/blob/master/Images/loginButton.png
[signUpButton.png]:https://github.com/Raboro/Home-Visualizer/blob/master/Images/signUpButton.png
[BaseClasses.jar]:https://github.com/Raboro/Home-Visualizer/blob/master/lib/BaseClasses.jar
[hamcrest-core-1.3.jar]:https://github.com/Raboro/Home-Visualizer/blob/master/lib/hamcrest-core-1.3.jar
[junit-4.13.2.jar]:https://github.com/Raboro/Home-Visualizer/blob/master/lib/junit-4.13.2.jar
[mariadb-java-client-2.7.3.jar.jar]:https://github.com/Raboro/Home-Visualizer/blob/master/lib/mariadb-java-client-2.7.3.jar.jar
[StartVisualizeActionListener.java]:https://github.com/Raboro/Home-Visualizer/blob/master/src/HomeVisualizer/ActionListener/StartVisualizerActionListener.java
[Database.java]:https://github.com/Raboro/Home-Visualizer/blob/master/src/HomeVisualizer/Database/Database.java
[InitializeDatabase.java]:https://github.com/Raboro/Home-Visualizer/blob/master/src/HomeVisualizer/Database/InitializeDatabase.java
[LoginDatabase.java]:https://github.com/Raboro/Home-Visualizer/blob/master/src/HomeVisualizer/Database/LoginDatabase.java
[Hash.java]:https://github.com/Raboro/Home-Visualizer/blob/master/src/HomeVisualizer/Encryption/Hash.java
[RsaEncryption.java]:https://github.com/Raboro/Home-Visualizer/blob/master/src/HomeVisualizer/Encryption/RsaEncryption.java
[Frame.java]:https://github.com/Raboro/Home-Visualizer/blob/master/src/HomeVisualizer/Gui/Frame.java
[LoginGui.java]:https://github.com/Raboro/Home-Visualizer/blob/master/src/HomeVisualizer/Gui/Login/LoginGui.java
[LoginLogic.java]:https://github.com/Raboro/Home-Visualizer/blob/master/src/HomeVisualizer/Logic/LoginLogic.java
[StartVisualizeLogic.java]:https://github.com/Raboro/Home-Visualizer/blob/master/src/HomeVisualizer/Logic/StartVisualizeLogic.java
[Main.java]:https://github.com/Raboro/Home-Visualizer/blob/master/src/HomeVisualizer/Main.java