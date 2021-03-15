# game_server

The Database Model in file UML into project <br>
card <br>
card_in_deck <br>
deck <br>
game <br>
game_card <br>
game_player <br>
player <br>
session <br>
transaction <br>

<b>The Spring Boot project<b><br>
The configuration package contains the HTTP Security configuration.<br>
The controller package contains classes that handle HTTP requests.<br>
The model package contains the entity classes.<br>
The DTO package contains the classes used to map request parameters.<br>
The enums package contains the enums used in entity classes and that are mapped to appropriate columns in the game table. In this case, the enums are GameStatus (possible game<br> statuses), GameType (possible game types) and Piece (pieces available in the game).<br>
The game package contains the classes games and factory, and allows you to add new games, implement interface GameLogic<br>
The repository package contains the repository interfaces that provide CRUD functionality to the entity classes.<br>
The security package contains the classes responsible for user authentication.<br>
The service package identifies the application layer that encapsulates the business logic, controls transactions, etc.<br>
The tools package contains halper tools<br>
The validators package contains the tolls for different validate<br>
<br>
PS: <br>
The project not finished<br>
I delved deeper into the design thinking about the actual game and it took time, although I had to follow a simple assignment. To test the main functionality, I plan to write<br>
unit tests, for testing API - Postman, the entire client will be written in React.<br>
  Thank.
