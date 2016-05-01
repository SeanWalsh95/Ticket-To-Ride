Project: CSIS225 Project 5 Ticket To Ride: UK Edition
Authors: Nolan Tunny, Sean Walsh, Tristan Canova, Jordan Cartwright, Tim Saxe

CONTENTS OF FILE
----------------

    *Introduction
    *Requirements/Config
    *Troubleshooting
    *FAQ


INTRODUCTION
------------

Ticket To Ride UK edition is an expansion module for the board game Ticket To Ride the purpose of this
project is to simulate the game.  The game runs in JFrames and works according to the rules of Ticket To
Ride UK edition.  The primary feature of this version of Ticket To Ride is the presence of technologies.


REQUIREMENTS/CONFIG
-------------------

Due to the resolution and file size of some of the premium images and sounds we use Ticket To Ride UK Edition
requires more than the standard JVM memory allocation, we recommend running the program with the -Xmx1024m
paramater to give the JVM access to enough memory in order for it to load all of our images dynamically and
properly.


TROUBLESHOOTING
---------------

    *Screen doesn't update after buying a route with Thermocompressor
    -Fix: hit the clear button and the panel will repaint


FAQ
---

Q:How do I purchase a route?
A:Click on two connected cities then the purchase button at the top of your screen, then simply follow
the prompts on screen!

Q:How does the train select panel work when buying routes/tech?
A:The left half of the panel is your hand, while the right half of the panel is the cards you want to spend
if you click on a card on the left half it moves to the right and if you click on the right it moves to
the left.

Q:Why can't I pick new cities?
A:At the top of your screen the last valid route that you selected is displayed, if that space is not 
blank then you currently have a route selected, in order to select a new route you must click the clear
button then select 2 new cities.

Q:Why is the buy technology screen flashing like crazy?
A:Your JVM is not configured to run our version of Ticket To Ride please reference the REQUIREMENTS/CONFIG
section for further details

Q:Why doesn't Right of Way appear in my technologies after I bought it?
A:The technology Right of Way is handled differently from the rest of the techs if you received the positive
confirmation after trying to purchase Right of Way proceed with your purchase of whichever route you want.
DO NOT PURCHASE RIGHT OF WAY AGAIN.