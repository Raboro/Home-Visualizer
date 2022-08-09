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
     > - [hamcrest-core-1.3.jar]
     > - [junit-4.13.2.jar]
- **`src`: the folder to maintain sources**
     > - **`HomeVisualizer`**
     >   - **`ActionListener`**
     >       - [LoginActionListener.java]
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
     >         - **`GuiElements`**
     >           - [ColorState.java]
     >           - [NewProjectElementsGui.java]
     >           - [StartVisualizeElementsGui.java]
     >           - [StepStates.java]
     >         - **`StepsGui`**
     >           - [CreateApartmentGui.java]
     >           - [CreateRoomsGui.java]
     >         - [StartVisualizeGui.java]
     >       - [Frame.java]
     >   - **`Logic`**
     >       - **`StartVisualizeStepsLogic`**
     >         - [CreateApartmentLogic.java]
     >         - [CreateRoomsLogic.java]
     >       - [LoginLogic.java]
     >       - [StartVisualizeLogic.java]
     >   - **`VisualizeRenderer`**
     >       - **`Entity`**
     >         - **`Builder`**
     >           - [BasicEntityBuilder.java]
     >           - [ComplexEntityBuilder.java]
     >         - [Entity.java]
     >         - [EntityManager.java]
     >         - [IEntity.java]
     >       - **`Input`**
     >         - [ClickType.java]
     >         - [Keyboard.java]
     >         - [Mouse.java]
     >         - [UserInput.java]
     >       - **`Point`**
     >         - [MyPoint.java]
     >         - [MyVector.java]
     >         - [PointConverter.java]
     >       - **`Shapes`**
     >         - [MyPolygon.java]
     >         - [Tetrahedon.java]
     >       - **`World`**
     >         - [Camera.java]
     >       - [Display.java]
     >   - [Main.java]
     > - **`Tests`**

<br/>

[settings.json]:https://github.com/Raboro/Home-Visualizer/blob/master/.vscode/settings.json 
[classdiagram.md]:https://github.com/Raboro/Home-Visualizer/blob/master/doc/classdiagram.md
[documentation.md]:https://github.com/Raboro/Home-Visualizer/blob/master/doc/documentation.md
[loginButton.png]:https://github.com/Raboro/Home-Visualizer/blob/master/Images/loginButton.png
[signUpButton.png]:https://github.com/Raboro/Home-Visualizer/blob/master/Images/signUpButton.png
[hamcrest-core-1.3.jar]:https://github.com/Raboro/Home-Visualizer/blob/master/lib/hamcrest-core-1.3.jar
[junit-4.13.2.jar]:https://github.com/Raboro/Home-Visualizer/blob/master/lib/junit-4.13.2.jar
[LoginActionListener.java]:https://github.com/Raboro/Home-Visualizer/blob/master/src/HomeVisualizer/ActionListener/LoginActionListener.java
[StartVisualizeActionListener.java]:https://github.com/Raboro/Home-Visualizer/blob/master/src/HomeVisualizer/ActionListener/StartVisualizerActionListener.java
[Database.java]:https://github.com/Raboro/Home-Visualizer/blob/master/src/HomeVisualizer/Database/Database.java
[InitializeDatabase.java]:https://github.com/Raboro/Home-Visualizer/blob/master/src/HomeVisualizer/Database/InitializeDatabase.java
[LoginDatabase.java]:https://github.com/Raboro/Home-Visualizer/blob/master/src/HomeVisualizer/Database/LoginDatabase.java
[Hash.java]:https://github.com/Raboro/Home-Visualizer/blob/master/src/HomeVisualizer/Encryption/Hash.java
[RsaEncryption.java]:https://github.com/Raboro/Home-Visualizer/blob/master/src/HomeVisualizer/Encryption/RsaEncryption.java
[Frame.java]:https://github.com/Raboro/Home-Visualizer/blob/master/src/HomeVisualizer/Gui/Frame.java
[LoginGui.java]:https://github.com/Raboro/Home-Visualizer/blob/master/src/HomeVisualizer/Gui/Login/LoginGui.java
[ColorState.java]:https://github.com/Raboro/Home-Visualizer/blob/master/src/HomeVisualizer/Gui/VisualizeMain/GuiElements/ColorState.java
[NewProjectElementsGui.java]:https://github.com/Raboro/Home-Visualizer/blob/master/src/HomeVisualizer/Gui/VisualizeMain/GuiElements/NewProjectElementsGui.java
[StartVisualizeElementsGui.java]:https://github.com/Raboro/Home-Visualizer/blob/master/src/HomeVisualizer/Gui/VisualizeMain/GuiElements/StartVisualizeElementsGui.java
[StepStates.java]:https://github.com/Raboro/Home-Visualizer/blob/master/src/HomeVisualizer/Gui/VisualizeMain/GuiElements/StepStates.java
[CreateApartmentGui.java]:https://github.com/Raboro/Home-Visualizer/blob/master/src/HomeVisualizer/Gui/VisualizeMain/StepsGui/CreateApartmentGui.java
[CreateRoomsGui.java]:https://github.com/Raboro/Home-Visualizer/blob/master/src/HomeVisualizer/Gui/VisualizeMain/StepsGui/CreateRoomsGui.java
[StartVisualizeGui.java]:https://github.com/Raboro/Home-Visualizer/blob/master/src/HomeVisualizer/Gui/VisualizeMain/StartVisualizeGui.java
[CreateApartmentLogic.java]:https://github.com/Raboro/Home-Visualizer/blob/master/src/HomeVisualizer/StartVisualizeStepsLogic/CreateApartmentLogic.java
[CreateRoomsLogic.java]:https://github.com/Raboro/Home-Visualizer/blob/master/src/HomeVisualizer/StartVisualizeStepsLogic/CreateRoomsLogic.java
[LoginLogic.java]:https://github.com/Raboro/Home-Visualizer/blob/master/src/HomeVisualizer/Logic/LoginLogic.java
[StartVisualizeLogic.java]:https://github.com/Raboro/Home-Visualizer/blob/master/src/HomeVisualizer/Logic/StartVisualizeLogic.java
[BasicEntityBuilder.java]:https://github.com/Raboro/Home-Visualizer/blob/master/src/HomeVisualizer/VisualizeRenderer/Entity/Builder/BasicEntityBuilder.java
[ComplexEntityBuilder.java]:https://github.com/Raboro/Home-Visualizer/blob/master/src/HomeVisualizer/VisualizeRenderer/Entity/Builder/ComplexEntityBuilder.java
[Entity.java]:https://github.com/Raboro/Home-Visualizer/blob/master/src/HomeVisualizer/VisualizeRenderer/Entity/Entity.java
[EntityManager.java]:https://github.com/Raboro/Home-Visualizer/blob/master/src/HomeVisualizer/VisualizeRenderer/Entity/EntityManager.java
[IEntity.java]:https://github.com/Raboro/Home-Visualizer/blob/master/src/HomeVisualizer/VisualizeRenderer/Entity/IEntity.java
[ClickType.java]:https://github.com/Raboro/Home-Visualizer/blob/master/src/HomeVisualizer/VisualizeRenderer/Input/ClickType.java
[Keyboard.java]:https://github.com/Raboro/Home-Visualizer/blob/master/src/HomeVisualizer/VisualizeRenderer/Input/Keyboard.java
[Mouse.java]:https://github.com/Raboro/Home-Visualizer/blob/master/src/HomeVisualizer/VisualizeRenderer/Input/Mouse.java
[UserInput.java]:https://github.com/Raboro/Home-Visualizer/blob/master/src/HomeVisualizer/VisualizeRenderer/Input/UserInput.java
[MyPoint.java]:https://github.com/Raboro/Home-Visualizer/blob/master/src/HomeVisualizer/VisualizeRenderer/Point/MyPoint.java
[MyVector.java]:https://github.com/Raboro/Home-Visualizer/blob/master/src/HomeVisualizer/VisualizeRenderer/Point/MyVector.java
[PointConverter.java]:https://github.com/Raboro/Home-Visualizer/blob/master/src/HomeVisualizer/VisualizeRenderer/Point/PointConverter.java
[MyPolygon.java]:https://github.com/Raboro/Home-Visualizer/blob/master/src/HomeVisualizer/VisualizeRenderer/Shapes/MyPolygon.java
[Tetrahedon.java]:https://github.com/RaboroShapes/Home-Visualizer/blob/master/src/HomeVisualizer/VisualizeRenderer/Shapes/Tetrahedon.java
[Camera.java]:https://github.com/RaboroShapes/Home-Visualizer/blob/master/src/HomeVisualizer/VisualizeRenderer/World/Camera.java
[Display.java]:https://github.com/RaboroShapes/Home-Visualizer/blob/master/src/HomeVisualizer/VisualizeRenderer/Display.java
[Main.java]:https://github.com/Raboro/Home-Visualizer/blob/master/src/HomeVisualizer/Main.java