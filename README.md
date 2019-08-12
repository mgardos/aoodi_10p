# aoodi_10p
Advanced Object Oriented Design I

Notas del Dia 1 (1/8/2019)
--------------------------

Von Newman -> imperativo <> Declarativo -> funcional, logico, oo
               -> prog. estructurada, procedural

Realidad -> Dominio (lenguaje especifico) <------ Observador (programador)

Dominio -> natural
        -> de negocio (creado por el hombre, cosas con proposito especifico, lucrativo)

Programa: representacion ejecutable de conocimento, el cual resulta luego de un proceso (iterativo, incremental) de aprendizaje
  -> flexibilidad (cambio el dominio, el programa lo detecto y cambio, programacion automtica)
  -> robustez

Paradigma (o enfoque): marco conceptual, compartido por una comunidad, por el cual el dominio es percibido de la misma manera (reduce la subjetividad)

Distancia o gap semantico: mide cuan facil o dificil es determinar a que dominio corresponde un programa (con oo la brecha se puede reducir significativamente).

Modelo: representacion de conocimiento

Cosa, varios significados -> condensacion de significados segun el contexto.
                          -> desplazamiento (encadenamiento de significados)

Identificacion de objetos: buscar el proposito de las cosas en el dominio

Modelo -> No hay problema o limitaciones tecnologicas
       -> eje funcional
          - componentes separados, maxima cohesion, minimo acoplamiento (naturalmente provisto por oo)

Java -> resolver gramaticalmente
Smalltalk -> paradigmaticamente


DNotas del Dia 2 (2/8/2019)
---------------------------

Programa: conjunto de objetos que colaboran entre si enviandose mensajes

Relacion 1 a 1 entre cosa de la realidad y objeto
Objetos: ladrillos computacionales, represetacion esencial de una cosa del dominio

Esencial -> proposito
         -> rol
         -> utilidad

Objeto tiene comportamiento definido, mensajes que sabe interpretar
MNU message not undertood <---- Smalltalk
objeto mensaje <---- definicion de colaboracion, envio de mensaje, declarativo (Smalltalk)
objeto.metodo <---- imperativo (C++)

mensajes: protocolo o interfaz, que se le puede solicitar al objeto (que puede hacer o contestar), es lo unico publico del objeto

Protocolo: conjunto cohesivo (tiene sentido que esten juntos) de mensajes con sus especificaciones

Comportamiento -> protocolo (mensajes)
               -> implementacion (metodos)

Metodo: objeto que representa un conjunto de colaboraciones con otros objetos (o colaboradores)

Colaboradores -> externos (objetos que acompañan a un mensaje)
              -> internos 
              -> globales 

Colaboracion: comunicacion entre objetos por medio de mensajes, es dirigida, sincronica, receptor desconoce emisor, siempre hay un retorno (aunque sea vacio)
-> emisor
-> receptor
-> colaboradores (externos, internos, globales)
-> retorno

Identidad (del objeto): caracteristica intrinseca a la cosa, no es lo mismo que igualdad

Asignacion: asociacion de nombre contextual con identidad (variable, no implica reserva de memoria), relacion de conocimiento, es la unica que existe entre objetos

Polimorfismo: entre dos o mas objetos, respecto de un conjunto de mensajes, si responden a los mismos de manera semantica equivalente
semanticamente equivalente -> hacen lo mismo, se usan de la misma manera, aunque la implementacion sea diferente
                           -> reciben objetos polimorficos
                           -> retornan objetos polimorficos

Resumen de vocabulario en oo
-> objeto.mensaje
-> asignacion
-> return
-> polimorfismo

Recursos en oo
-> crear y destruir objetos
-> representacion de conocimiento complejo y organzacion
-> magnitudes
-> logica (booleana por ejemplo)
-> colecciones (diccionarios, conjuntos, listas...)
-> persistencia

Los objetos que representan conocimiento se designan con nombre en mayusculas (CuentaCorriente)
Cada instancia de CuentaCorriente le pide al creador el metodo que se ejecuta al recibir un mensaje, aqui aparece el method lookup
El concepto de CuentaCorriente se alcanza luego de adquirir el conocimiento necesario
De no haber suficiente conocimiento se puede trabajar con un esquema de prototipado, que trabaja con prototipos, se clonan o crear objetos a partir de objetos ya existentes (ver self)
El esquema de prototipado no provee la representacion de conocimiento complejo, justamente porque no se dispone de dicho conocimiento

Objeto de abstraccion <---------------------- (relacion es-un)
                            \                \
                         Obj concreto 1   Obj concreto 2

El objeto de abstraccion define el protocolo y los objetos concretos respetan el protocolo (polimorfismo) pero pueden cambiar la implementacion

Las abstracciones se descubren, es un proceso inductivo.
Las especializaciones son parte de un proceso deductivo.


Notas del Dia 3 (5/8/2019)
--------------------------
tinyurl.com/c1-10pines
objetosparatodas

www.cuisuniversity.com
https://sites.google.com/view/cuis-university

tinyurl.com/Objetos1Ejercicio3

Objeto -> comportamiento => protocolo
       -> implementacion => metodos
                         => colaboradores (internos, externos)

Lenguaje de objetos -> objeto.mensaje
                    -> operador asignacion (=)
                    -> operador retorno (return)

Lambda -> funcion anonima o sin nombre
Closure (bloque) -> lambda ligada a contexto particular
                 -> objeto
                 -> conjunto de colaboraciones
                 -> parametrizan comportamiento


Notas del Dia 4 (8/8/2019)
--------------------------

if -> implica diversas implementaciones
   -> implica ausencia de polimorfismo, ausencia de objetos que tomen la decision sobre la implementacion
   -> no es obligatorio evitarlo, pequeños usos se pueden abstraer en metodos


Notas del Dia 5 (9/8/2019)
--------------------------

Cada rama del if es una implementacion, se trata de objetos polimorficos.
Utilizar doble despacho para proveer acceso a cada implementacion.

clave de la solucion numeros: 01numeros


Notas del Dia 6 (12/8/2019)
---------------------------

clave de la solucion idiom: idiom01
clave de la solucion stack: epa!
clave de la solucion packman: legustanlasvitaminas

