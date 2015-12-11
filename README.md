# Robert Torgov Project 2
#Description:
In my game the objective is to doge obstacles and to avoid touching the boundaries of the board. Doing either results in
game over. The twist is, the players get a random speed boost and must maintain their accuracy as the game progresses. The
two player mode forces the first player to control moving up and down, while the second player controls moving left and right.

#Controls:

#Player 1
Up Arrow - Move up

Down Arrow - Move down
#Player 2
Right Arrow - Move Right

Left Arrow - Move Left

#Works Cited:
http://zetcode.com/tutorials/javagamestutorial/collision/ - taught me how to check for collision
http://zetcode.com/tutorials/javagamestutorial/snake/ - taught me how to check for keyboard events

#Methods Changed:

The only core methods I changed were the go() method, the GameOver related methods, and the
KeyListener method in GameControlelr. There weren't any changes made to the core mechanics of the game.


#Classes Added:

I had to add a few messages along with their encoders to the project to handle the game synchronization
This consists of: SetPlayerControllerMessage, StartGameMessage, EndGameMessage

Also, I included the core compontents from the websocket lab to create the server

#Methods Added:

In my game controller I added methods receivePoke, and sendDirections to handle messages. I also added the onOpen, onMessage, onClose
methods where appropriate. A lot of my websocket calculations took place in the main method of the game where these methods are located. Additionally, thanks to the help of auto-generated fucntions, I added many static setters and getters to work with the static member variables

Read instructions [here](http://bc-cisc3120-f15.github.io/project2)
