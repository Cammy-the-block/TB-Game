#Text Based Game
TB_Game also known as Text Based Game is a basic old school collection of text based programs and games I have developed. It includes Gangup, an encryption and decryption program using my own algorithm, and Alchemy.

## Table of Contents
 
* [Framework](#framework)
* [Gangup](#gangup)
* [Encryption and Decryption] (#crypt)
* [Alchemy] (#alchemy)
 
## <a name="framework"></a>Framework 
All framework files are stored either in utils package and TB_Game.java
### To Do List 
* Change from displaying text on console to displaying in a new window.

## <a name="gangup"></a>Gangup
Gangup is tic tack toe with four players trying to get three in a row. The array starts out with only zeros. A player will enter the coordinates of there next move. If there are no errors the game will continue in the manner until a player has gotten four pieces in a row. Currently players are only able to make moves, there is no win checking. All of the Gangup files are stored in the gangup package.
    
### To Do List 
* ~~Add Win Checking~~
* Make an image version containing a board and pieces.
* Allow the player to choose how many players there are, how big the array is, and how many they have to get in a row.
        
## <a name="crypt"></a>Encryption and Decryption
A basic encryption and decryption program with to separate keys per encrypt/decrypt. Probably not very strong.
    
### To Do List
* Configure to use one key instead of two
* Auto key generator
* Support for longer keys
* Test strength of encryption
            
## <a name="alchemy"></a> Alchemy
A simple text based game where you add elements together to make new elements. Elements are configurable.

### To Do List
* Change elements from a few different letters and numbers to actual elements that make sense
* Create a image version.