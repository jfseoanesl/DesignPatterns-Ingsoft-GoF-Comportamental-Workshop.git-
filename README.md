# Actividad 3 · Casos de estudio integradores: patrones de comportamiento, estructurales y creacionales

[![build](../../actions/workflows/build.yml/badge.svg)](../../actions/workflows/build.yml)

Este repositorio contiene cinco casos de estudio integradores. Cada sistema acumuló deuda técnica en la forma en que **distribuye responsabilidades y algoritmos** entre sus objetos y, además, en cómo se integra con otros sistemas y cómo crea sus objetos. Cada caso incluye el contexto, la problemática, el diagrama de clases inicial y código Java ejecutable. Su grupo debe decidir qué combinación de patrones incorporar y refactorizar el código.

## Objetivo

Evaluar la capacidad de diseñar soluciones integrales que combinen patrones de comportamiento con patrones estructurales y creacionales, justificando cómo colaboran entre sí, y de evidenciarlas con UML y código.

## Competencias que se evalúan

- Identifica problemas de asignación de responsabilidades, flujo de control, acoplamiento entre objetos y extensibilidad de algoritmos.
- Diseña soluciones que combinan patrones de las tres categorías y explica cómo colaboran.
- Modela la solución con diagramas de clases UML de calidad profesional (y, opcionalmente, diagramas de secuencia o de estados).
- Refactoriza código Java preservando su comportamiento correcto.
- Evalúa las consecuencias de la solución y argumenta frente a alternativas.

## Patrones de referencia

Cada caso se resuelve combinando **al menos un patrón de comportamiento, uno estructural y uno creacional**.

| Categoría | Patrones |
|---|---|
| Comportamiento | Chain of Responsibility, Command, Interpreter, Iterator, Mediator, Memento, Observer, State, Strategy, Template Method, Visitor |
| Estructurales | Adapter, Bridge, Composite, Decorator, Facade, Flyweight, Proxy |
| Creacionales | Abstract Factory, Builder, Factory Method, Prototype, Singleton |

> Los casos **no** indican qué patrones aplicar. Decidirlo a partir del contexto es parte de la evaluación.

## Casos de estudio

| Caso | Título | Dominio |
|---|---|---|
| 01 | [Comercio electrónico: ciclo de vida de los pedidos](casos/caso-01-ciclo-de-vida-pedidos/README.md) | Comercio electrónico y logística |
| 02 | [Editor de diagramas para clases virtuales](casos/caso-02-editor-diagramas/README.md) | Herramientas educativas colaborativas |
| 03 | [Supermercado: motor de promociones y elegibilidad](casos/caso-03-motor-promociones/README.md) | Comercio minorista |
| 04 | [Universidad: trámite de solicitudes académicas](casos/caso-04-solicitudes-academicas/README.md) | Gestión académica universitaria |
| 05 | [Hogar inteligente: central de automatización](casos/caso-05-hogar-inteligente/README.md) | Internet de las cosas (IoT) |

## Dinámica de la actividad

1. Formen grupos de 3 o 4 estudiantes. El docente asigna los casos (sugerido: un caso por grupo, por su complejidad).
2. Hagan *fork* de este repositorio y creen una rama por caso (`caso-NN`).
3. Lean el enunciado, ejecuten `scripts/ejecutar.sh casoNN` y estudien el código inicial.
4. Identifiquen los síntomas de deuda técnica y registren la evidencia en el informe.
5. Decidan qué patrones aplicar, cómo colaboran y por qué; diseñen el diagrama de clases (y, si aplica, de estados o de secuencia) antes de programar.
6. Refactoricen en el paquete `solucion` del caso y verifiquen con `scripts/verificar.sh`.
7. Implementen los nuevos requerimientos y sustenten la solución ante el curso.

## Entregables

- Un informe por caso (`casos/<caso>/INFORME.md`) basado en [`PLANTILLA_INFORME.md`](PLANTILLA_INFORME.md).
- Diagrama de clases de la solución (`diagrama-solucion.puml` y su PNG) en la carpeta del caso.
- Código refactorizado en el subpaquete `solucion` de cada caso y la clase `DemoNuevosRequerimientos`.
- Pull request hacia la rama `main` del repositorio del grupo con la integración continua en verde.
- Sustentación oral de 10 minutos por caso.

## Estructura del repositorio

```text
actividad-patrones-comportamiento/
├── README.md                 esta guía
├── PLANTILLA_INFORME.md      plantilla del informe por caso
├── casos/caso-NN-<nombre>/   enunciado, diagrama inicial y salida esperada
├── src/main/java/edu/ingsoft/actividad/comportamiento/casoNN/   código inicial
├── scripts/ejecutar.sh       compila y ejecuta demos
└── scripts/verificar.sh      comprueba que la salida de Demo no cambió
```

## Cómo compilar y ejecutar

Requisitos: JDK 17 o superior. Maven es opcional.

```bash
scripts/ejecutar.sh             # compila y ejecuta todas las demos
scripts/ejecutar.sh caso03      # solo el caso 03
scripts/verificar.sh            # compara las salidas de Demo con salida-esperada.txt
mvn -q compile                  # alternativa con Maven
```

## Reglas

- `salida-esperada.txt` es una prueba de caracterización: la refactorización debe conservar el comportamiento correcto (`scripts/verificar.sh`). Si su solución corrige un defecto del código inicial (por ejemplo, un dato inconsistente), la diferencia es válida solo si la documenta en el informe.
- Se puede reorganizar libremente el código dentro del paquete `solucion` del caso; no modifique el código inicial.
- Toda decisión de diseño debe justificarse en el informe; un patrón sin justificación no suma puntos.
- No se permiten bibliotecas externas: solo el JDK.
- Cite cualquier fuente consultada. El uso de asistentes de IA debe declararse en el informe.

## Rúbrica de evaluación (por caso)

| Criterio | Peso | Excelente (4.5–5.0) | Bueno (3.5–4.4) | Aceptable (3.0–3.4) | Insuficiente (< 3.0) |
|---|---|---|---|---|---|
| Análisis del problema | 15 % | Identifica todos los síntomas de deuda técnica, los relaciona con el código y con los principios de diseño que se violan. | Identifica la mayoría de los síntomas, con referencias parciales al código. | Identifica síntomas generales sin evidencia en el código. | No identifica la problemática o la describe de forma incorrecta. |
| Selección y combinación de patrones | 25 % | Elige una combinación adecuada que responde a cada síntoma y justifica por qué cada patrón es la mejor opción frente a alternativas. | Combinación adecuada con justificación incompleta o sin analizar alternativas. | Selecciona un solo patrón pertinente o incluye patrones innecesarios. | Patrones no pertinentes o sin justificación. |
| Diagrama de clases de la solución | 15 % | UML correcto y completo (relaciones, multiplicidades, visibilidad, estereotipos); los roles de los patrones son identificables. | UML correcto con omisiones menores. | Diagrama incompleto o con errores de notación que dificultan la lectura. | No entrega diagrama o no corresponde al código. |
| Implementación y refactorización | 25 % | Compila, conserva el comportamiento correcto (diferencias documentadas), el código es limpio y los patrones están bien implementados. | Compila y conserva el comportamiento, con detalles de implementación mejorables. | Compila pero cambia el comportamiento o implementa los patrones de forma parcial. | No compila o no aplica los patrones. |
| Nuevos requerimientos | 10 % | Implementa todos los requerimientos sin modificar las clases existentes (extensión). | Implementa la mayoría con cambios menores en clases existentes. | Implementa algunos, con modificaciones extensas. | No implementa los requerimientos. |
| Consecuencias y sustentación | 10 % | Analiza ventajas, desventajas y costos de la solución; sustenta con dominio del tema. | Analiza consecuencias de forma general; sustentación adecuada. | Análisis superficial. | No analiza consecuencias ni sustenta. |

## Bibliografía

- Gamma, E., Helm, R., Johnson, R. y Vlissides, J. (1994). *Design Patterns*. Addison-Wesley.
- Kerievsky, J. (2004). *Refactoring to Patterns*. Addison-Wesley.
- Fowler, M. (2018). *Refactoring* (2.ª ed.). Addison-Wesley.
- Bloch, J. (2018). *Effective Java* (3.ª ed.). Addison-Wesley.
