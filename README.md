# game_server

The Database Model in file UML into project
card
card_in_deck
deck
game
game_card
game_player
player
session
transaction

The Spring Boot project
The configuration package contains the HTTP Security configuration.
The controller package contains classes that handle HTTP requests.
The model package contains the entity classes.
The DTO package contains the classes used to map request parameters.
The enums package contains the enums used in entity classes and that are mapped to appropriate columns in the game table. In this case, the enums are GameStatus (possible game statuses), GameType (possible game types) and Piece (pieces available in the game).
The game package contains the classes games and factory, and allows you to add new games, implement interface GameLogic
The repository package contains the repository interfaces that provide CRUD functionality to the entity classes.
The security package contains the classes responsible for user authentication.
The service package identifies the application layer that encapsulates the business logic, controls transactions, etc.
The tools package contains halper tools
The validators package contains the tolls for different validate

PS: 
The project not finished
I delved deeper into the design thinking about the actual game and it took time, although I had to follow a simple assignment. To test the main functionality, I plan to write unit tests, for testing API - Postman, the entire client will be written in React. Thank.
