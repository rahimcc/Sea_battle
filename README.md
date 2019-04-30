# Sea_battle
# Software Engineering Course Project 

# Objective 
Objective of this project is to create Naval Battleship game with different versions using software development technique Extreme Programming. Project constains two versions.First version is played using console, another version is Graphical User Interface Application.


## N.Battle.V1

![Screenshot from 2019-04-30 03-07-58](https://user-images.githubusercontent.com/43667122/56936242-5a926f00-6b07-11e9-92e1-09fe55bccab0.png)
 
 It is a single player game against Computer. Game start with user placing his ships ,   
 
 
![Screenshot from 2019-04-30 05-22-32](https://user-images.githubusercontent.com/43667122/56936378-253a5100-6b08-11e9-8db8-94e0cb3cb6a1.png)

 Program ask user to place his ships in a format:   [Column] [Row] [Orientation]

Where column is a leter on the top of the map, Row is a number that is on the left of the map. Given column , row is initial    point to indicate where to begin placing ships, since size of ship is given by default by program, Orientation is a character given by user to indicate in which direction ship should be placed. 'V' for vertically down , 'H' for horizontally right.
 
 ![Screenshot from 2019-04-30 05-22-46](https://user-images.githubusercontent.com/43667122/56936617-7860d380-6b09-11e9-9994-6212b0334a3d.png)
 
After placing all ships. Program places Computer's ships random. Then, ask user to shoot a position. 

![Screenshot from 2019-04-30 05-42-44](https://user-images.githubusercontent.com/43667122/56936892-f4a7e680-6b0a-11e9-8f31-0bf983f06d7d.png)

Program accepts position in format: [column] [row] 

If shooting position is a miss position changes its state to '-', if it is a hit it becames '/', it becomes 'X' after destroying ship completely. Game ends, if ships of either one of maps is destroyed completely. 


## N.Battle.V2

Graphical User Interface application using JavaFX. 


![Screenshot from 2019-04-30 05-58-25](https://user-images.githubusercontent.com/43667122/56937451-ca0b5d00-6b0d-11e9-8006-60a420ed35fa.png)

Single Player Graphical User Interface Battleship game. Player's map is on the right , Computer's map is on the left.

![Screenshot from 2019-04-30 08-00-48](https://user-images.githubusercontent.com/43667122/56940257-4017c000-6b1e-11e9-9af9-cd87dcabe205.png)

Game starts with placing ship on User's map. Size of ships is ordered 5 to 2. Right Click to cell places ship vertically  starting from that point. Left click places the ship horizontally. After placing ships ,program organizes computer's map randomly.

![Screenshot from 2019-04-30 08-25-41](https://user-images.githubusercontent.com/43667122/56940797-a2be8b00-6b21-11e9-8234-5efda2c80b14.png)

Computer and Player take turns to hit the ships. Cell becomes red when it is a hit, becomes black when it is miss. Game ends when ships of either map destroyed completely


## Development 
This project was developed by Rahim Sharifov, Sara Shamilova , Sabina Hadjimuradova. Only one name can appear in commits, because we used mainly one computer.  

