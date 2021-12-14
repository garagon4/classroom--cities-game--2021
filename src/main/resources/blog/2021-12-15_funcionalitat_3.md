---
writer: examen
coder: examen
---
# Funcionalitat 3

Escriu aquí el post de la funcionalitat descrita a l'enunciat.
No canviïs el nom del fitxer ni el títol del post.

## Que afegeixes?

Què necessites per començar? Quina acció fas? Quin resultat trobes?

 * Given that "leonard" is playing.
 * Go to the next player "leonard"
 <!-- SNAPSHOT status=200 -->
 * Go to the "leonard" "city" "Capital".

## Carregar patates

 * Go to the next player "leonard"
 <!-- SNAPSHOT status=200 -->
 * The "potato" icon is not in the "leonard" "ship" "Beagle".
 * Go to the "leonard" "city" "Capital".



### Crear una fabrica de patates costa 5 patates
 * Given that the "leonard" "city" "Capital" has resource "banana" count 5.
 * Go to the contained "building" "Builder"
 * Build the "Potato plantation".
 <!-- SNAPSHOT status=200 -->
 * There should contain the "building" "Potato plantation".
 * The resource "potato" round increment should be 1.
 * The resource "potato" count should be 0.
 * End the round.
 <!-- SNAPSHOT status=200 -->

 * Go to the "leonard" "city" "Capital".
 * The resource "potato" count should be 1.


### Anar al vaixell
 * Go to see the docked "leonard" "ship" "Beagle".
 * Given that the "leonard" "city" "Capital" has resource "wood" count 4.
 * Given that the "leonard" "city" "Capital" has resource "potato" count 5.


### Afegir un decks factories BananaStoreFactory de tipus deck

 * The resource "potato" maximum should be 0.
 * Go to the contained "deck" "Builder".
 * Build the "Potato store".
 <!-- SNAPSHOT status=200 -->

### Comprovar que ha funcionat

 * There should contain the "deck" "Potato store".
 * The resource "potato" maximum should be 5.
 * The resource "potato" count should be 0.
 * Load 5 of "potato"
 <!-- SNAPSHOT status=200 -->
 * The resource "potato" count should be 5.
 * The dock resource "potato" count should be 0.
 * End the round.
 <!-- SNAPSHOT status=200 -->
 * The "potato" icon is in the "leonard" "ship" "Beagle".
