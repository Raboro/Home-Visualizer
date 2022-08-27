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
     > - **`Diagrams`**
     >   - **`class diagrams`**
     >      - [ActionListenerClassDiagram.md]
     >      - [DatabaseClassDiagram.md]
     >      - [EncryptionClassDiagram.md]
     >      - [Graphics(2d)ClassDiagram.md]
     >      - [GuiClassDiagram.md]
     >      - [LogicClassDiagram.md]
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
     >       - [AddActionListener.java]
     >       - [AddActionListenerLogin.java]
     >       - [AddActionListenerStartVisualize.java]
     >       - [LoginActionListener.java]
     >       - [StartVisualizeActionListener.java]
     >   - **`Database`**
     >       - [Database.java]
     >       - [InitializeDatabase.java]
     >       - [LoginDatabase.java]
     >   - **`Encryption`**
     >       - [Hash.java]
     >       - [RsaEncryption.java]
     >   - **`Graphics`**
     >       - [CreateRoomNamesGraphics.java]
     >       - [Point2d.java]
     >   - **`Gui`**
     >       - **`Login`**
     >         - [LoginGui.java]
     >       - **`VisualizeMain`**
     >         - **`GuiElements`**
     >           - [Colors.java]
     >           - [ColorState.java]
     >           - [NewProjectElementsGui.java]
     >           - [StartVisualizeElementsGui.java]
     >           - [StepStates.java]
     >         - **`StepsGui`**
     >           - **`StepOne`**
     >               - [CreateApartmentGui.java]
     >               - [CreateApartmentGuiElements.java]
     >           - **`StepThree`**
     >               - [CreateRoomNamesGui.java]
     >               - [CreateRoomNamesGuiElements.java]
     >           - **`StepTwo`**
     >               - [CreateRoomsGui.java]
     >               - [CreateRoomsGuiElements.java]
     >           - [StepGui.java]
     >         - [StartVisualizeGui.java]
     >       - [Frame.java]
     >   - **`Logic`**
     >       - **`StartVisualizeStepsLogic`**
     >         - [CreateApartmentLogic.java]
     >         - [CreateRoomNamesLogicGraphics.java]
     >         - [CreateRoomNamesLogicGui.java]
     >         - [CreateRoomsLogic.java]
     >         - [RoomNames.java]
     >       - [Logic.java]  
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
     >   - **`Encryption`**
     >       - [HashTest.java]
     >       - [RsaEncryptionTest.java]
<br/>

[settings.json]:https://github.com/Raboro/Home-Visualizer/blob/master/.vscode/settings.json 

[ActionListenerClassDiagram.md]:https://github.com/Raboro/Home-Visualizer/blob/master/doc/Diagrams/ClassDiagrams/ActionListenerClassDiagram.md
[DatabaseClassDiagram.md]:https://github.com/Raboro/Home-Visualizer/blob/master/doc/Diagrams/ClassDiagrams/DatabaseClassDiagram.md
[EncryptionClassDiagram.md]:https://github.com/Raboro/Home-Visualizer/blob/master/doc/Diagrams/ClassDiagrams/EncryptionClassDiagram.md
[Graphics(2d)ClassDiagram.md]:https://github.com/Raboro/Home-Visualizer/blob/master/doc/Diagrams/ClassDiagrams/Graphics(2d)ClassDiagram.md
[GuiClassDiagram.md]:https://github.com/Raboro/Home-Visualizer/blob/master/doc/Diagrams/ClassDiagrams/GuiClassDiagram.md
[LogicClassDiagram.md]:https://github.com/Raboro/Home-Visualizer/blob/master/doc/Diagrams/ClassDiagrams/LogicClassDiagram.md
[documentation.md]:https://github.com/Raboro/Home-Visualizer/blob/master/doc/documentation.md

[loginButton.png]:https://github.com/Raboro/Home-Visualizer/blob/master/Images/loginButton.png
[signUpButton.png]:https://github.com/Raboro/Home-Visualizer/blob/master/Images/signUpButton.png

[hamcrest-core-1.3.jar]:https://github.com/Raboro/Home-Visualizer/blob/master/lib/hamcrest-core-1.3.jar
[junit-4.13.2.jar]:https://github.com/Raboro/Home-Visualizer/blob/master/lib/junit-4.13.2.jar

[AddActionListener.java]:https://github.com/Raboro/Home-Visualizer/blob/master/src/HomeVisualizer/ActionListener/AddActionListener.java
[AddActionListenerLogin.java]:https://github.com/Raboro/Home-Visualizer/blob/master/src/HomeVisualizer/ActionListener/AddActionListenerLogin.java
[AddActionListenerStartVisualize.java]:https://github.com/Raboro/Home-Visualizer/blob/master/src/HomeVisualizer/ActionListener/AddActionListenerStartVisualize.java
[LoginActionListener.java]:https://github.com/Raboro/Home-Visualizer/blob/master/src/HomeVisualizer/ActionListener/LoginActionListener.java
[StartVisualizeActionListener.java]:https://github.com/Raboro/Home-Visualizer/blob/master/src/HomeVisualizer/ActionListener/StartVisualizerActionListener.java

[Database.java]:https://github.com/Raboro/Home-Visualizer/blob/master/src/HomeVisualizer/Database/Database.java
[InitializeDatabase.java]:https://github.com/Raboro/Home-Visualizer/blob/master/src/HomeVisualizer/Database/InitializeDatabase.java
[LoginDatabase.java]:https://github.com/Raboro/Home-Visualizer/blob/master/src/HomeVisualizer/Database/LoginDatabase.java

[Hash.java]:https://github.com/Raboro/Home-Visualizer/blob/master/src/HomeVisualizer/Encryption/Hash.java
[RsaEncryption.java]:https://github.com/Raboro/Home-Visualizer/blob/master/src/HomeVisualizer/Encryption/RsaEncryption.java

[CreateRoomNamesGraphics.java]:https://github.com/Raboro/Home-Visualizer/blob/master/src/HomeVisualizer/Graphics/CreateRoomNamesGraphics.java
[Point2d.java]:https://github.com/Raboro/Home-Visualizer/blob/master/src/HomeVisualizer/Graphics/Point2d.java

[Frame.java]:https://github.com/Raboro/Home-Visualizer/blob/master/src/HomeVisualizer/Gui/Frame.java
[LoginGui.java]:https://github.com/Raboro/Home-Visualizer/blob/master/src/HomeVisualizer/Gui/Login/LoginGui.java
[Colors.java]:https://github.com/Raboro/Home-Visualizer/blob/master/src/HomeVisualizer/Gui/VisualizeMain/GuiElements/ColorState.java
[ColorState.java]:https://github.com/Raboro/Home-Visualizer/blob/master/src/HomeVisualizer/Gui/VisualizeMain/GuiElements/ColorState.java
[StepGui.java]:https://github.com/Raboro/Home-Visualizer/blob/master/src/HomeVisualizer/Gui/VisualizeMain/StepGui.java
[NewProjectElementsGui.java]:https://github.com/Raboro/Home-Visualizer/blob/master/src/HomeVisualizer/Gui/VisualizeMain/GuiElements/NewProjectElementsGui.java
[StartVisualizeElementsGui.java]:https://github.com/Raboro/Home-Visualizer/blob/master/src/HomeVisualizer/Gui/VisualizeMain/GuiElements/StartVisualizeElementsGui.java
[StepStates.java]:https://github.com/Raboro/Home-Visualizer/blob/master/src/HomeVisualizer/Gui/VisualizeMain/GuiElements/StepStates.java
[CreateApartmentGui.java]:https://github.com/Raboro/Home-Visualizer/blob/master/src/HomeVisualizer/Gui/VisualizeMain/StepsGui/StepOne/CreateApartmentGui.java
[CreateApartmentGuiElements.java]:https://github.com/Raboro/Home-Visualizer/blob/master/src/HomeVisualizer/Gui/VisualizeMain/StepsGui/StepOne/CreateApartmentGuiElements.java
[CreateRoomsGui.java]:https://github.com/Raboro/Home-Visualizer/blob/master/src/HomeVisualizer/Gui/VisualizeMain/StepsGui/StepTwo/CreateRoomsGui.java
[CreateRoomsGuiElements.java]:https://github.com/Raboro/Home-Visualizer/blob/master/src/HomeVisualizer/Gui/VisualizeMain/StepsGui/StepTwo/CreateRoomsGuiElements.java
[CreateRoomNamesGui.java]:https://github.com/Raboro/Home-Visualizer/blob/master/src/HomeVisualizer/Gui/VisualizeMain/StepsGui/StepThree/CreateRoomNamesGui.java
[CreateRoomNamesGuiElements.java]:https://github.com/Raboro/Home-Visualizer/blob/master/src/HomeVisualizer/Gui/VisualizeMain/StepsGui/StepThree/CreateRoomNamesGuiElements.java
[RoomNames.java]:https://github.com/Raboro/Home-Visualizer/blob/master/src/HomeVisualizer/Gui/VisualizeMain/StepsGui/StepThree/RoomNames.java
[StartVisualizeGui.java]:https://github.com/Raboro/Home-Visualizer/blob/master/src/HomeVisualizer/Gui/VisualizeMain/StartVisualizeGui.java

[CreateApartmentLogic.java]:https://github.com/Raboro/Home-Visualizer/blob/master/src/HomeVisualizer/Logic/StartVisualizerStepsLogic/CreateApartmentLogic.java
[CreateRoomsLogic.java]:https://github.com/Raboro/Home-Visualizer/blob/master/src/HomeVisualizer/Logic/StartVisualizerStepsLogic/CreateRoomsLogic.java
[CreateRoomNamesLogicGui.java]:https://github.com/Raboro/Home-Visualizer/blob/master/src/HomeVisualizer/Logic/StartVisualizerStepsLogic/CreateRoomNamesLogicGui.java
[CreateRoomNamesLogicGraphics.java]:https://github.com/Raboro/Home-Visualizer/blob/master/src/HomeVisualizer/Logic/StartVisualizerStepsLogiGraphics.java
[Logic.java]:https://github.com/Raboro/Home-Visualizer/blob/master/src/HomeVisualizer/Logic/Logic.java
[LoginLogic.java]:https://github.com/Raboro/Home-Visualizer/blob/master/src/HomeVisualizer/Logic/LoginLogic.java
[StartVisualizeLogic.java]:https://github.com/Raboro/Home-Visualizer/blob/master/src/HomeVisualizer/Logic/StartVisualizeLogic.java

[BasicEntityBuilder.java]:https://github.com/Raboro/Home-Visualizer/blob/master/src/HomeVisualizer/VisualizeRenderer/Entity/Builder/BasicEntityBuilder.java
[ComplexEntityBuilder.java]:https://github.com/Raboro/Home-Visualizer/blob/master/src/HomeVisualizer/VisualizeRenderer/Entity/Builder/ComplexEntitiyBuilder.java
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
[Tetrahedon.java]:https://github.com/Raboro/Home-Visualizer/blob/master/src/HomeVisualizer/VisualizeRenderer/Shapes/Tetrahedron.java
[Camera.java]:https://github.com/Raboro/Home-Visualizer/blob/master/src/HomeVisualizer/VisualizeRenderer/World/Camera.java
[Display.java]:https://github.com/Raboro/Home-Visualizer/blob/master/src/HomeVisualizer/VisualizeRenderer/Display.java

[Main.java]:https://github.com/Raboro/Home-Visualizer/blob/master/src/HomeVisualizer/Main.java

[HashTest.java]: https://github.com/Raboro/Home-Visualizer/blob/master/src/Test/Encryption/HashTest.java
[RsaEncryptionTest.java]: https://github.com/Raboro/Home-Visualizer/blob/master/src/Test/Encryption/RsaEncryptionTest.java