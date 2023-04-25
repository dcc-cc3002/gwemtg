# Gwen't por hugodiazroa

Esta entrga tiene como objetivo implementar y probar los elementos básicos de un clon del juego de cartas Gwen, implementando parte de las clases Jugador y Carta.

En el juego, las cartas son el ente basico a travez del cual se desarrollan todas las reglas y que permite encontrar el ganador. Hay dos tipos principales de cartas: cartas de unidad y cartas de clima. Las cartas de unidad se dividen en tres clasificaciones basado en el tipo de combate que usan: mele, rango y asedio. Cada subtipo de carta solo puede ser lanzada en la zona que le corresponde. Por otro lado, las cartas de clima son cartas especiales que pueden colocarse en una o mas zonas del tablero y tienen el poder de afectar a todas las unidades de una o mas zonas simultaneamente.

De acuerdo a lo visto en el curso se utilizo herencia para implementar las diferentes clases como clases abstractas. Para hacer esto correctamente metodologicamente se implementaron y sobreescibieron los métodos Equals, canEqual y hashCode para realizar pruebas unitarias en cada subclase de la clase abstracta.

## Funcionalidades implementadas

Implementación de la clase Jugador con los parametros: name y deck.
Implementación de la clase Jugador con los atributos: side, hand, gems e initialDeckSize.
Implementación de la clase Carta con el parametro name.
Implementación de las subclases de Carta: UnitCard y ClimateCard.
UnitCard tiene como parametros: nombre, fuerza, tipo, coste y efectos
ClimateCard tiene como parametros:nombre: nombre, coste y efectos
Sobrescritura de los métodos Equals, canEqual y hashCode para las clases AbstractPlayer y AbstractCard, junto con todas las clases que heredan de ellas.
Pruebas usando MUnit para las funcionalidades implementadas.

## Archivos nuevos
|-- src
|   |-- main
|   |   |-- scala
|   |   |   |-- gwent
|   |   |   |   |-- Card
|   |   |   |   |   |-- AbstractCard.scala
|   |   |   |   |-- Player
|   |   |   |   |   |-- AbstractPlayer.scala
|   |   |-- test
|   |   |   |-- gwent
|   |   |   |   |-- Card
|   |   |   |   |   |-- AbstractCardTest.scala
|   |   |   |   |-- Player
|   |   |   |   |   |-- AbstractPlayerTest.scala
|-- pendientes
|   |-- enunciado.txt
|   |-- todo.txt
|-- README.md

src/main/scala/gwent/Card/AbstractCard.scala: Clase que representa una carta en el juego.
src/main/scala/gwent/Player/AbstractPlayer.scala: Clase abstracta que representa un jugador en el juego.
src/test/scala/gwent: Directorio contenedor de los tests del juego.
pendientes/enunciado.txt: Archivo que contiene el enunciado del proyecto.
pendientes/todo.txt: Archivo que contiene las tareas pendientes para la proxima entrega.

## Licencia

![http://creativecommons.org/licenses/by/4.0/](https://i.creativecommons.org/l/by/4.0/88x31.png)
Este trabajo esta licenciado bajo una licencia Creative Commons:
[Creative Commons Attribution 4.0 International License](http://creativecommons.org/licenses/by/4.0/)


## Contexto

La finalidad del proyecto es trabajar en un clon de TCG: [_Gwent_](https://www.playgwent.com/en) el juego de cartas, desarrollado por [_CD PROJEKT RED_](https://cdprojektred.com/en/)


