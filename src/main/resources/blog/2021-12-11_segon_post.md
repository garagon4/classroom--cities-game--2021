---
writer: drpicox
coder: drpicox
---

# Segon Post

We have to load potatoes to the ship, also create a potatoe plantatio building.

## Playing game

### We need to create a game and join

Start playing with penny.

 * Given that "penny" is playing.
 * Go to the next player "leonard"
 <!-- SNAPSHOT status=200 -->
 * You should be at the "game" screen.
 * "leonard" should be the current player.

And you can see your cities:

 * "leonard" should have 1 "city".
 * "leonard" should have the "Capital" "city".

### Load Ship with potatoes
- Si el test comença de 0 asssegurar que existeix
 * Go to the next player "leonard"
 <!-- SNAPSHOT status=200 -->
 * Go to the "leonard" "ship" "Beagle"
 * Go to the contained "deck" "Builder".
 * Build the "Potato store".
 <!-- SNAPSHOT status=200 -->
- Posar un cost: ex, 2 steel
 * Given that the "leonard" "city" "Capital" has resource "steel" count 2.

- Afegir el leveledComponent al Potato store
 * Go to the contained "deck" "Potato store".
 * The _level_ number should be 1.

- Crear el PotatoStoreUpgrader
 * The resource modifier for "potato" maximum should be 5.
 * Upgrade the level.
 <!-- SNAPSHOT status=200 -->
 * The _level_ number should be 2.
 * The resource modifier for "potato" maximum should be 10.
 * Go back to the previous screen.
 * The resource "potato" maximum should be 10.
 * The dock resource "steel" count should be 0.
